package trabalho2;

import java.util.ArrayList;

/**
 *
 * @author Douglas, Patricia, Priscila, Tamires
 */
public class TelaInicial extends javax.swing.JFrame {

    private Conexao conexao;

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        jlInfo.setVisible(false);
        jlIndice.setVisible(false);
        jtfIndice.setVisible(false);
        conexao = new Conexao();
        //conexao.agentes();
        inicializaComboIpsDestino(conexao.getListaAgentes());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtftempo = new javax.swing.JTextField();
        jbget = new javax.swing.JButton();
        jcbMetrica = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfIP = new javax.swing.JTextField();
        jtfComunidade = new javax.swing.JTextField();
        jcbIps = new javax.swing.JComboBox();
        jlInfo = new javax.swing.JLabel();
        jlIndice = new javax.swing.JLabel();
        jtfIndice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SNMP");

        jLabel2.setText("Comunidade");

        jLabel4.setText("Período de atualização");

        jbget.setText("OK");
        jbget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbgetActionPerformed(evt);
            }
        });

        jcbMetrica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione item", "Utilizacao do link", "Datagramas IP", "Pacotes TCP", "Pacotes UDP", "Pacotes SNMP" }));
        jcbMetrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMetricaActionPerformed(evt);
            }
        });

        jLabel5.setText("Métrica ");

        jLabel1.setText("IP");

        jcbIps.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlInfo.setText("Informações não foram buscadas! Tente novamente!");

        jlIndice.setText("Indice");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jbget, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbIps, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfIP, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtftempo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfComunidade, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbMetrica, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlIndice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfComunidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbIps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtftempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMetrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jlIndice)
                    .addComponent(jtfIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlInfo)
                    .addComponent(jbget))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbgetActionPerformed
        if (camposOk()) {
            jlInfo.setVisible(false);

            int tempo = Integer.parseInt(jtftempo.getText()) * 1000;
            String comunidade = jtfComunidade.getText();
            String metrica = jcbMetrica.getSelectedItem().toString();
            String ip = "";
            String indice = "";

            if (!jtfIP.getText().equals("")) {
                ip = jtfIP.getText();
            } else {
                ip = jcbIps.getSelectedItem().toString();
            }

            if (metrica.equals("Utilizacao do link")) {
                indice = jtfIndice.getText();
            }

            conexao.chamaAgendador(ip, comunidade, metrica, indice, tempo);
        } else {
            jlInfo.setVisible(true);
        }
    }//GEN-LAST:event_jbgetActionPerformed

    private void jcbMetricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMetricaActionPerformed
        if (jcbMetrica.getSelectedItem().toString().equals("Utilizacao do link")) {
            jlIndice.setVisible(true);
            jtfIndice.setVisible(true);
        } else {
            jlIndice.setVisible(false);
            jtfIndice.setVisible(false);
        }
    }//GEN-LAST:event_jcbMetricaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    public void inicializaComboIpsDestino(ArrayList<String> ips) {
        jcbIps.removeAllItems();
        jcbIps.addItem("Selecione IP");
        for (int i = 0; i < ips.size(); i++) {
            jcbIps.addItem(ips.get(i));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbget;
    private javax.swing.JComboBox jcbIps;
    private javax.swing.JComboBox jcbMetrica;
    private javax.swing.JLabel jlIndice;
    private javax.swing.JLabel jlInfo;
    private javax.swing.JTextField jtfComunidade;
    private javax.swing.JTextField jtfIP;
    private javax.swing.JTextField jtfIndice;
    private javax.swing.JTextField jtftempo;
    // End of variables declaration//GEN-END:variables

    private boolean camposOk() {
        if (!jtftempo.getText().equals("")
                && (!(jtfIP.getText().equals("")) || !jcbIps.getSelectedItem().equals("Selecione IP"))
                && !jcbMetrica.getSelectedItem().toString().equals("Selecione item")) {
            if (jcbMetrica.getSelectedItem().toString().equals("Utilizacao do link") && jtfIndice.getText().equals("")) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}
