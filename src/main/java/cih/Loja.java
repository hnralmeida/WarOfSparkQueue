/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cih;

import cdp.*;
import cgt.App;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author almei
 */
public class Loja extends javax.swing.JDialog {

    private final App gerenteUI;
    private final Toolkit tk = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = tk.getScreenSize();

    /**
     * Creates new form Loja
     *
     * @param parent
     * @param modal
     * @param gerenteUI
     */
    public Loja(java.awt.Frame parent, boolean modal, App gerenteUI) {
        super(parent, modal);
        this.gerenteUI = gerenteUI;
        initComponents();
    }

    public void checkScreen() {
        this.setSize(screenSize);

        JLabel label = new JLabel(gerenteUI.PathImageGetter("app-bg-no"));
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.getContentPane().add(label);

        jLabelBack.setIcon(gerenteUI.PathImageGetter("app-back-50"));
        jLabelBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelTitle.setVerticalAlignment((int) CENTER_ALIGNMENT);
        Player player = gerenteUI.getPlayer();
        jLabelValor.setText(player.getCurrency() + " PO");

        Color transp = new Color(200, 200, 200, 1);
        Topbar.setBackground(transp);
        jTableLoja.sizeColumnsToFit(EXIT_ON_CLOSE);
        this.dispose();

        try {
            Player p = gerenteUI.getPlayer();
            loadLoja(p);
            this.dispose();
        } catch (ParseException error) {
            Logger.getLogger(Campanha.class.getName()).log(Level.SEVERE, null, error);
            System.out.println(error.getCause());
        }

    }

    private void loadLoja(Player p) throws ParseException {
        List<Creature> lista;

        ((DefaultTableModel) jTableLoja.getModel()).setNumRows(0);
        lista = gerenteUI.getGerDominio().findAllCreatures(p.getId());

        // Criar Botão de Compra
        int max = lista.size() - 1;
        for (int c = max; c >= 0; c--) {
            if (lista.get(c).getPrice() == 0) {
                lista.remove(c);
            }
        }

        Action buy = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String index = e.getActionCommand();
                Creature obj = lista.get(Integer.parseInt(index));
                int price = obj.getPrice();
                int newCurrency = p.getCurrency() - price;
                if (newCurrency >= 0) {
                    p.setCurrency(newCurrency);
                    jLabelValor.setText(p.getCurrency() + " PO");
                    System.out.println("Valor: " + price);
                    
                    Team team = gerenteUI.getGerDominio().findTeam(p.getId()).get(0);
                    team.getTeamA().add(obj);
                    try {
                        gerenteUI.getGerDominio().insertCreature(obj.getWeight(), obj.getAge(), obj.getName(), obj.getIdInterface(), 0, team);
                        gerenteUI.getGerDominio().updatePlayer(p);
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(Loja.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    StringBuilder mensagem = new StringBuilder();
                    String output = "Saldo Insuficiente para comprar " + obj.getName() + "!";
                    mensagem.append(output);
                    JOptionPane.showMessageDialog(null, mensagem);
                }
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(jTableLoja, buy, 4);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        // Preencher coluna com Preço e adicionar valores na tabela
        for (Creature camp : lista) {

            if (camp.getPrice() != 0) {

                List<Object> line = new ArrayList<>(Arrays.asList(camp.toArray()));
                line.add(camp.getPrice() + " PO");

                ((DefaultTableModel) jTableLoja.getModel()).addRow(line.toArray());
                System.out.println(camp);
            }
        }

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
        Topbar = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jPanelLoja = new javax.swing.JPanel();
        jScrollPanelLoja = new javax.swing.JScrollPane();
        jTableLoja = new javax.swing.JTable();
        jLabelSaldo = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabelTitle.setText("Comprar Personagens");

        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TopbarLayout = new javax.swing.GroupLayout(Topbar);
        Topbar.setLayout(TopbarLayout);
        TopbarLayout.setHorizontalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTitle)
                .addContainerGap(683, Short.MAX_VALUE))
        );
        TopbarLayout.setVerticalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopbarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTableLoja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Peso", "Idade", "Tipo", "Comprar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPanelLoja.setViewportView(jTableLoja);

        jLabelSaldo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelSaldo.setText("Saldo: ");

        javax.swing.GroupLayout jPanelLojaLayout = new javax.swing.GroupLayout(jPanelLoja);
        jPanelLoja.setLayout(jPanelLojaLayout);
        jPanelLojaLayout.setHorizontalGroup(
            jPanelLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLojaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanelLoja, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLojaLayout.createSequentialGroup()
                        .addComponent(jLabelSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelLojaLayout.setVerticalGroup(
            jPanelLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLojaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSaldo)
                    .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPanelLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Topbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelLoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jLabelBackMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Topbar;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelLoja;
    private javax.swing.JScrollPane jScrollPanelLoja;
    private javax.swing.JTable jTableLoja;
    // End of variables declaration//GEN-END:variables
}
