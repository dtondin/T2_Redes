/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

/**
 *
 * @author Douglas, Patricia, Priscila
 */
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExecutaAgendamento implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        //Simula validações
        System.out.println("Validando dados duplicados no banco. At " + new Date());
        System.out.println("Deletando registros com mais de 10 dias sem uso. At " + new Date());

//        Conexao conexao = new Conexao();
//        conexao.get(null, null, null);
        
//        if (metrica.equals("Utilizacao do link")) {
//            indice = jtfIndice.getText();
//
//            String ifInOctes = conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.2.2.1.10." + indice);
//            String ifOutOctes = conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.2.2.1.16." + indice);
//            String ifSpeed = conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.2.2.1.5." + indice);
//
//            resultadoIn = Integer.parseInt(ifInOctes);
//            resultadoOut = Integer.parseInt(ifOutOctes);
//        } else if (metrica.equals("Datagramas IP")) {
//            resultadoIn = Integer.parseInt(conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.4.3.0"));
//            resultadoOut = Integer.parseInt(conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.4.10.0"));
//        } else if (metrica.equals("Pacotes TCP")) {
//            resultadoIn = Integer.parseInt(conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.6.10.0"));
//            resultadoOut = Integer.parseInt(conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.6.11.0"));
//        } else if (metrica.equals("Pacotes UDP")) {
//            resultadoIn = Integer.parseInt(conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.7.1.0"));
//            resultadoOut = Integer.parseInt(conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.7.4.0"));
//        } else if (metrica.equals("Pacotes SNMP")) {
//            resultadoIn = Integer.parseInt(conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.11.1.0"));
//            resultadoOut = Integer.parseInt(conexao.get(ip, comunidade,
//                    ".1.3.6.1.2.1.11.2.0"));
//        }
//
//        conexao.atualizaGrafico(metrica, tempoNum, resultadoIn, tempoNum,
//                resultadoOut);

    }

}
