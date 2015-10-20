package trabalho2;

/**
 *
 * @author Douglas, Patricia, Priscila
 */
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Agendador {

    //http://www.devmedia.com.br/agendando-tarefas-em-java-com-quartz-scheduler-e-timertask/32466
    public void agendamento(String ip, String comunidade, String metrica, String indice, String tempo) {
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {
            Scheduler scheduler = shedFact.getScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(ExecutaAgendamento.class)
                    .withIdentity("agendamentoJOB", "grupo01")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("validadorTRIGGER", "grupo01")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/" + tempo + " * * * * ?"))
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
