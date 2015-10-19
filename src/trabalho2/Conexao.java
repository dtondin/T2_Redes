package trabalho2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import org.jfree.ui.RefineryUtilities;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**
 *
 * @author Douglas, Patricia, Priscila
 */
public class Conexao {

    public String get(String ip, String comunidade, String OID) {
        String mensagem = "";
        try {
            TransportMapping transport = new DefaultUdpTransportMapping();
            transport.listen();

            CommunityTarget target = new CommunityTarget();
            target.setCommunity(new OctetString(comunidade));
            target.setVersion(SnmpConstants.version2c);
            target.setAddress(new UdpAddress(ip + "/161"));
            target.setRetries(2);
            target.setTimeout(1000);

            PDU pdu = new PDU();
            pdu.add(new VariableBinding(new OID(OID)));
            pdu.setType(PDU.GET);
            pdu.setRequestID(new Integer32(1));

            Snmp snmp = new Snmp(transport);
            ResponseEvent response = snmp.get(pdu, target);

            if (response != null) {
                PDU responsePDU = response.getResponse();

                if (responsePDU != null) {
                    int errorStatus = responsePDU.getErrorStatus();

                    if (errorStatus == PDU.noError) {
                        Vector<? extends VariableBinding> variableBindings = responsePDU.getVariableBindings();

                        for (int i = 0; i < variableBindings.size(); i++) {
                            mensagem += variableBindings.get(i).toValueString();
                        }

                    } else {
                        String errorStatusText = responsePDU.getErrorStatusText();
                        int errorIndex = responsePDU.getErrorIndex();

                        mensagem = "Error: Request Failed\n";
                        mensagem += "Error Status = " + errorStatus + "\n ";
                        mensagem += "Error Index = " + errorIndex + "\n ";
                        mensagem += "Error Status Text = " + errorStatusText + "\n ";
                    }
                } else {
                    mensagem += "Error: Response PDU is null.\n";
                }
            } else {
                mensagem += "Error: Agent Timeout... \n";
            }
            snmp.close();
        } catch (IOException e) {
            mensagem += "Erro não pode ser encontrado o oid solicitado.\n";
        }
        return mensagem;
    }

    public void atualizaGrafico(String titulo, int inX, int inY, int outX, int outY) {
        Grafico chart = new Grafico("Gráfico", titulo, inX, inY, outX, outY);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

    public ArrayList<String> descoberta() {
        String ip;
        ArrayList<String> lista = new ArrayList<String>();
        int lastOctes = 150;

        while (lastOctes < 239) {
            ip = "10.32.143." + Integer.toString(lastOctes) + "/161";
            lista.add(ip);
            lastOctes++;
        }
        return lista;
    }

    public void agentes() {
        ArrayList<String> ips = descoberta();

        for (String ip : ips) {
            if (!get(ip, "public", ".1.3.6.1.2.1.4.3.0").equals("Error: Response PDU is null.\n")) {
                System.out.println(ip);
            }
        }
    }

}
