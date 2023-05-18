/*
* Projeto de Programação Orientada a Objetos
* AUTOR: Henrique Almeida de Oliveira
 */
package cih;

import cgt.App;
import cgt.imageRender.ImageGetter;
import cgt.imageRender.PathImageGetter;

/**
 *
 * @author almei
 */
public class Login extends javax.swing.JFrame {

    private final App gerenteUI;
    
    /**
     * Creates new form Login
     * @param gerenteUI
     */
    public Login(App gerenteUI) {
        initComponents();
        ImageGetter p = new PathImageGetter();
        this.gerenteUI = gerenteUI;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtEntrar = new javax.swing.JButton();
        jTextLogin = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jLabUser = new javax.swing.JLabel();
        jLabPass = new javax.swing.JLabel();
        jLabNovo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("War of Spark");
        setBackground(new java.awt.Color(249, 249, 249));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setName("Login"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1080, 720));
        setSize(new java.awt.Dimension(1080, 720));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LOGIN\n"));
        jPanel1.setPreferredSize(new java.awt.Dimension(290, 323));

        jPanel3.setPreferredSize(new java.awt.Dimension(200, 150));

        jButtEntrar.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        jButtEntrar.setText("ENTRAR");
        jButtEntrar.setAlignmentX(15.0F);
        jButtEntrar.setAlignmentY(5.0F);
        jButtEntrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtEntrarActionPerformed(evt);
            }
        });

        jLabUser.setText("Usuário");

        jLabPass.setText("Senha");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtEntrar)
                .addGap(64, 64, 64))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabUser)
                    .addComponent(jLabPass)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextLogin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtEntrar)
                .addContainerGap())
        );

        jLabNovo.setText("Novo cadastro");
        jLabNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleClickjLabNovo(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabNovo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabNovo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtEntrarActionPerformed
        // TODO add your handling code here:
        gerenteUI.janelaHome();
    }//GEN-LAST:event_jButtEntrarActionPerformed

    private void handleClickjLabNovo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handleClickjLabNovo
        // TODO add your handling code here:
        gerenteUI.janelaCadastro();
    }//GEN-LAST:event_handleClickjLabNovo


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtEntrar;
    private javax.swing.JLabel jLabNovo;
    private javax.swing.JLabel jLabPass;
    private javax.swing.JLabel jLabUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextLogin;
    // End of variables declaration//GEN-END:variables
}