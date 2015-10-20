package trabalho2;

/**
 *
 * @author Douglas, Patricia, Priscila
 */
import java.util.Timer;
import java.util.TimerTask;

public class Agendador {

    private String ip;
    private String comunidade;
    private String metrica;
    private String indice;
    private int tempo;

    public Agendador(String ip, String comunidade, String metrica, String indice, int tempo) {
        this.ip = ip;
        this.comunidade = comunidade;
        this.metrica = metrica;
        this.indice = indice;
        this.tempo = tempo;
    }

    public void agendamento() {
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            private Conexao conexao = new Conexao();
            @Override
            public void run() {
                executaGet(ip, comunidade, metrica, indice, tempo);
//                new Execucoes().tabuada(count);
//                if (count == 5) {
//                    t.cancel();
//                }
            }

            private void executaGet(String ip, String comunidade, String metrica, String indice, int tempo) {
                tempo = tempo;
                int resultadoIn = -1;
                int resultadoOut = -1;

                if (metrica.equals("Utilizacao do link")) {
                    String ifInOctes = conexao.get(ip, comunidade, ".1.3.6.1.2.1.2.2.1.10." + indice);
                    String ifOutOctes = conexao.get(ip, comunidade, ".1.3.6.1.2.1.2.2.1.16." + indice);
                    String ifSpeed = conexao.get(ip, comunidade, ".1.3.6.1.2.1.2.2.1.5." + indice);

                    resultadoIn = Integer.parseInt(ifInOctes);
                    resultadoOut = Integer.parseInt(ifOutOctes);
                } else if (metrica.equals("Datagramas IP")) {
                    resultadoIn = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.4.3.0"));
                    resultadoOut = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.4.10.0"));
                } else if (metrica.equals("Pacotes TCP")) {
                    resultadoIn = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.6.10.0"));
                    resultadoOut = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.6.11.0"));
                } else if (metrica.equals("Pacotes UDP")) {
                    resultadoIn = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.7.1.0"));
                    resultadoOut = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.7.4.0"));
                } else if (metrica.equals("Pacotes SNMP")) {
                    resultadoIn = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.11.1.0"));
                    resultadoOut = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.11.2.0"));
                }

                conexao.atualizaGrafico(metrica, tempo, resultadoIn, tempo, resultadoOut);
                tempo = tempo + tempo;
            }

        }, tempo, tempo);
    }

}
