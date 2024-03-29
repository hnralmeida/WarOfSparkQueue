/*
* Projeto de Programação Orientada a Objetos
* AUTOR: Henrique Almeida de Oliveira
 */
package cih;

import cdp.*;
import cgt.App;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author almei
 */
public class Home extends javax.swing.JFrame {

    private final App gerenteUI;

    private static Home instance;

    private final Toolkit tk = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = tk.getScreenSize();

    /**
     * Creates new form Home
     *
     * @param gerenteUI
     */
    private Home(App gerenteUI) {
        initComponents();
        this.gerenteUI = gerenteUI;

        //ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/bg-home.jpg")); // load the image to a imageIcon
        //this.setContentPane(new ImagePanel(imageIcon.getImage()));
    }

    public static Home getInstance(App gerenteUI) {
        if (instance != null) {
            return instance;
        } else {
            instance = new Home(gerenteUI);
            return instance;
        }
    }

    public void checkScreen() {
        // Fundo Colorido
        this.setSize(screenSize);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);

        JLabel label = new JLabel(gerenteUI.PathImageGetter("app-bg-home"));
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // Make the label opaque to show the background color
        this.getContentPane().add(label);
        this.setTitle("War of the Spark");

        defineMenuButtons();

        try {
            Player p = gerenteUI.getPlayer();
            jLabelWelcome.setText("Bem-Vindo, " + p.getName());
            gerenteUI.firstRun();
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println(error.getCause());
        }
    }

    private void defineMenuButtons() {
        // Transparência 
        Color transp = new Color(200, 200, 200, 1);

        // Label de Boas-Vindas
        jLabelWelcome.setForeground(Color.white);
        Topbar.setBackground(transp);
        jLabelWelcome.setBackground(transp);

        // Menu Inferior
        jBottomMenu.setBackground(transp);

        // Botão de Campanha
        jPanelCampanha.setBackground(transp);
        jPanelCampanha.setSize(300, 100);

        jLabelCampanha.setText("");
        jLabelCampanha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelCampanha.setIcon(gerenteUI.PathImageGetter("btcampanha"));

        // Botão de Times
        jPanelTime.setBackground(transp);
        jPanelTime.setSize(300, 100);

        jLabelTime.setText("");
        jLabelTime.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelTime.setIcon(gerenteUI.PathImageGetter("bttime"));

        // Botão de Loja
        jPanelLoja.setBackground(transp);
        jPanelLoja.setSize(300, 100);

        jLabelLoja.setText("");
        jLabelLoja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelLoja.setIcon(gerenteUI.PathImageGetter("btloja"));

        // Botão de Saída
        jPanelSair.setBackground(transp);

        jLabelSair.setText("");
        jLabelSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelSair.setIcon(gerenteUI.PathImageGetter("btsair"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Topbar = new javax.swing.JPanel();
        jLabelWelcome = new javax.swing.JLabel();
        jBottomMenu = new javax.swing.JPanel();
        jPanelCampanha = new javax.swing.JPanel();
        jLabelCampanha = new javax.swing.JLabel();
        jPanelTime = new javax.swing.JPanel();
        jLabelTime = new javax.swing.JLabel();
        jPanelLoja = new javax.swing.JPanel();
        jLabelLoja = new javax.swing.JLabel();
        jPanelSair = new javax.swing.JPanel();
        jLabelSair = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelWelcome.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        jLabelWelcome.setText("Bem-vindo, ");
        jLabelWelcome.setAlignmentY(0.0F);

        javax.swing.GroupLayout TopbarLayout = new javax.swing.GroupLayout(Topbar);
        Topbar.setLayout(TopbarLayout);
        TopbarLayout.setHorizontalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWelcome)
                .addContainerGap(575, Short.MAX_VALUE))
        );
        TopbarLayout.setVerticalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelCampanha.setText("Campanha");
        jLabelCampanha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCampanhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCampanhaLayout = new javax.swing.GroupLayout(jPanelCampanha);
        jPanelCampanha.setLayout(jPanelCampanhaLayout);
        jPanelCampanhaLayout.setHorizontalGroup(
            jPanelCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCampanhaLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabelCampanha)
                .addGap(55, 55, 55))
        );
        jPanelCampanhaLayout.setVerticalGroup(
            jPanelCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCampanhaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCampanha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTime.setPreferredSize(new java.awt.Dimension(175, 80));

        jLabelTime.setText("Time");
        jLabelTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTimeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTimeLayout = new javax.swing.GroupLayout(jPanelTime);
        jPanelTime.setLayout(jPanelTimeLayout);
        jPanelTimeLayout.setHorizontalGroup(
            jPanelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTimeLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jLabelTime)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanelTimeLayout.setVerticalGroup(
            jPanelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTime)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelLoja.setPreferredSize(new java.awt.Dimension(175, 80));
        jPanelLoja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelLojaMouseClicked(evt);
            }
        });

        jLabelLoja.setText("Loja");
        jLabelLoja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLojaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelLojaLayout = new javax.swing.GroupLayout(jPanelLoja);
        jPanelLoja.setLayout(jPanelLojaLayout);
        jPanelLojaLayout.setHorizontalGroup(
            jPanelLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLojaLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabelLoja, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanelLojaLayout.setVerticalGroup(
            jPanelLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLojaLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabelLoja)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabelSair.setText("Sair");
        jLabelSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelSairLayout = new javax.swing.GroupLayout(jPanelSair);
        jPanelSair.setLayout(jPanelSairLayout);
        jPanelSairLayout.setHorizontalGroup(
            jPanelSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSairLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabelSair)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanelSairLayout.setVerticalGroup(
            jPanelSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSairLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabelSair)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jBottomMenuLayout = new javax.swing.GroupLayout(jBottomMenu);
        jBottomMenu.setLayout(jBottomMenuLayout);
        jBottomMenuLayout.setHorizontalGroup(
            jBottomMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBottomMenuLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanelCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanelLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jPanelSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jBottomMenuLayout.setVerticalGroup(
            jBottomMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBottomMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jBottomMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanelCampanha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTime, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jPanelLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(107, Short.MAX_VALUE))
                    .addComponent(jBottomMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(343, 343, 343)
                .addComponent(jBottomMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelLojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelLojaMouseClicked
        // TODO add your handling code here:
        gerenteUI.janelaLoja();
    }//GEN-LAST:event_jPanelLojaMouseClicked

    private void jLabelTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTimeMouseClicked
        gerenteUI.janelaTime();
    }//GEN-LAST:event_jLabelTimeMouseClicked

    private void jLabelSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSairMouseClicked
        gerenteUI.janelaFechar();
    }//GEN-LAST:event_jLabelSairMouseClicked

    private void jLabelLojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLojaMouseClicked
        gerenteUI.janelaLoja();
    }//GEN-LAST:event_jLabelLojaMouseClicked

    private void jLabelCampanhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCampanhaMouseClicked
        gerenteUI.janelaCampanha();
    }//GEN-LAST:event_jLabelCampanhaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Topbar;
    private javax.swing.JPanel jBottomMenu;
    private javax.swing.JLabel jLabelCampanha;
    private javax.swing.JLabel jLabelLoja;
    private javax.swing.JLabel jLabelSair;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JPanel jPanelCampanha;
    private javax.swing.JPanel jPanelLoja;
    private javax.swing.JPanel jPanelSair;
    private javax.swing.JPanel jPanelTime;
    // End of variables declaration//GEN-END:variables
}
