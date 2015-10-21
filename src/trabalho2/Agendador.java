package trabalho2;

/**
 *
 * @author Douglas, Patricia, Priscila, Tamires
 */
import java.util.Timer;
import java.util.TimerTask;

public class Agendador {

    private String ip;
    private String comunidade;
    private String metrica;
    private String indice;
    private int tempo;
    private int count;

    public Agendador(String ip, String comunidade, String metrica, String indice, int tempo) {
        this.ip = ip;
        this.comunidade = comunidade;
        this.metrica = metrica;
        this.indice = indice;
        this.tempo = tempo;
        count = tempo;
    }

    public void agendamento() {
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            private Conexao conexao = new Conexao();

            private int ifInOctesAnterior = 0;
            private int ifOutOctesAnterior = 0;

            private int ifInOctesPosterior = 0;
            private int ifOutOctesPosterior = 0;

            private int ifSpeed = 0;
            private double ifOctesResultado = 0;

            int resultadoIn = 0;
            int resultadoOut = 0;

            @Override
            public void run() {
                executaGet();
            }

            private void executaGet() {
                if (metrica.equals("Utilizacao do link")) {
                    String get = conexao.get(ip, comunidade, ".1.3.6.1.2.1.2.2.1.10." + indice);
                    ifInOctesPosterior = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.2.2.1.10." + indice));
                    ifOutOctesPosterior = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.2.2.1.16." + indice));
                    ifSpeed = Integer.parseInt(conexao.get(ip, comunidade, ".1.3.6.1.2.1.2.2.1.5." + indice));

                    int taxaBytes = (ifInOctesPosterior - ifInOctesAnterior) + (ifOutOctesPosterior - ifOutOctesAnterior);
                    int taxaBytesSeg = taxaBytes / (tempo);

                    ifOctesResultado = (taxaBytesSeg * 8) / ifSpeed;

                    ifInOctesAnterior = ifInOctesPosterior;
                    ifOutOctesAnterior = ifOutOctesPosterior;

                    conexao.atualizaGrafico(metrica, ((tempo - count) / 1000), ifOctesResultado);
                } else {
                    if (metrica.equals("Datagramas IP")) {
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
                    conexao.atualizaGrafico(metrica, ((tempo - count) / 1000), resultadoIn, ((tempo - count) / 1000), resultadoOut);
                }
                tempo += count;
            }

        }, 0, tempo);
    }

}
