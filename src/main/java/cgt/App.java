/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cgt;

import cdp.*;
import cih.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import org.hibernate.HibernateException;

/**
 *
 * @author almei
 */
public class App {

    // GERENCIADORES de DOMINIO
    //GerenciadorDominio gerDominioj
    DAOManager gerDominio;

    // Janelas
    private Login janLogin = null;
    private Cadastrar dlgCadastro = null;
    private Home janHome = null;
    private Loja dlgLoja = null;
    private Time dlgTime = null;
    private Campanha janCampanha = null;
    private Partida dlgPartida = null;
    
    //Relatorios
    private ReportManager gerReport;

    // Personagem em sesão
    private Player player = null;

    // Próxima partida
    private int idCampaign;

    // Controle de Tamanho de Tela
    private final Toolkit tk = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = tk.getScreenSize();

    /*
    * Construtor da classe
    *
     */
    public App() {
        try {
            gerDominio = new DAOManager();
            gerReport = new ReportManager();
            gerDominio.insertPlayer("Teste", "teste@teste", "02/04/1998", "a", 500, null);
        } catch (ClassNotFoundException | SQLException | HibernateException ex) {
            JOptionPane.showMessageDialog(janLogin, "Erro de conexão com o banco. " + ex.getMessage());
            System.exit(-1);
        }
    }

    /*
    * Gerenciador de domínio que deve ser utilizado na cih
    *
    * @return gerDominio
     */
    public DAOManager getGerDominio() {
        return gerDominio;
    }

    public ReportManager getReportController() {
        return gerReport;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void firstRun() throws ClassNotFoundException, SQLException {
        List list;
        list = (ArrayList<CampaignMatch>) gerDominio.findCampaigns();
        if (list == null || list.isEmpty()) {
            createRoom(player);
            System.out.println("Criaturas Criadas");
        }
    }

    @SuppressWarnings("empty-statement")
    private void createRoom(Player p) throws ClassNotFoundException, SQLException {

        // ======================================= //
        /* Empty List*/
        List<CampaignMatch> list = (ArrayList<CampaignMatch>) gerDominio.findCampaigns( );
        if (list == null || list.isEmpty()) {
            List<Creature> nlist = new LinkedList<>();

            gerDominio.insertCampaign("Teste de Fogo", 1, p, nlist);
            gerDominio.insertCampaign("Fogo em Dobro", 2, p, nlist);
            gerDominio.insertCampaign("Sorte de Principiante", 3, p, nlist);
            gerDominio.insertCampaign("Teste de Reistência", 4, p, nlist);
            gerDominio.insertCampaign("Avaliação de Força", 5, p, nlist);

            List<CampaignMatch> listCampaignMatchs = gerDominio.findCampaigns();

            // ======================================= //
            /* Get a Zombie for first room*/
            gerDominio.insertCreature(50, 0, "Zombie", 2, 0, listCampaignMatchs.get(0));

            /* Get a 3 Zombies for second room*/
            gerDominio.insertCreature(55, 0, "Zombie", 2, 0, listCampaignMatchs.get(1));
            gerDominio.insertCreature(60, 0, "Zombie", 2, 0, listCampaignMatchs.get(1));
            gerDominio.insertCreature(65, 0, "Zombie", 2, 0, listCampaignMatchs.get(1));

            /* Get a 1 Worm for third room*/
            gerDominio.insertCreature(750, 25, "Worm", 4, 0, listCampaignMatchs.get(2));

            /* Get a 3 Zombies Warriors for forth room*/
            gerDominio.insertCreature(75, 10, "Zombie", 3, 0, listCampaignMatchs.get(3));
            gerDominio.insertCreature(80, 10, "Zombie", 3, 0, listCampaignMatchs.get(3));
            gerDominio.insertCreature(85, 10, "Zombie", 3, 0, listCampaignMatchs.get(3));

            /* Get a 1 Worm and 3 Zombies Warriors for fifth room*/
            gerDominio.insertCreature(75, 10, "Zombie", 3, 0, listCampaignMatchs.get(4));
            gerDominio.insertCreature(80, 10, "Zombie", 3, 0, listCampaignMatchs.get(4));
            gerDominio.insertCreature(85, 10, "Zombie", 3, 0, listCampaignMatchs.get(4));
            gerDominio.insertCreature(750, 150, "Ancientet Worm", 4, 0, listCampaignMatchs.get(4));

            /* Get creatures for shop */
            gerDominio.insertCreature(60, 25, "Liliana Vess", 7, 250);
            gerDominio.insertCreature(70, 35, "Jace Vrynn", 5, 250);
            gerDominio.insertCreature(90, 27, "Gideon Jura", 8, 250);
            gerDominio.insertCreature(60, 18, "Soldier", 1, 100);
        }

    }

    /*
    * Torna visível a janela principal
    *
     */
    public void janelaPrincipal() {
        if (this.player == null) {
            janHome = null;
            janLogin = Login.getInstance(this);
            janLogin.checkScreen();
            janLogin.setVisible(true);
            janLogin.setTitle("Bem-Vindo");
        } else {
            janLogin.setVisible(false);
            janLogin = null;
            janHome = Home.getInstance(this);
            janHome.checkScreen();
            janHome.setVisible(true);
        }

    }

    /*
    * Torna visível a janela de cadastro
    *
     */
    public void janelaCadastro() {
        dlgCadastro = (Cadastrar) abrirJanela(janLogin, dlgCadastro, Cadastrar.class);
        dlgCadastro.checkScreen();
        dlgCadastro.setVisible(true);
    }

    /*
    * Torna visível a janela home
    *
     */
    public void janelaHome() {
        janHome = Home.getInstance(this);
        janHome.checkScreen();
        janHome.setVisible(true);

    }

    /*
    * Torna visível a janela de Loja
    *
     */
    public void janelaLoja() {
        dlgLoja = (Loja) abrirJanela(janHome, dlgLoja, Loja.class);
        dlgLoja.checkScreen();
        dlgLoja.setVisible(true);
    }

    /*
    * Torna visível a janela time
    *
     */
    public void janelaTime() {
        dlgTime = (Time) abrirJanela(janHome, dlgTime, Time.class);
        dlgTime.checkScreen();
        dlgTime.setVisible(true);
    }

    /*
    * Torna visível a janela campanha
    *
     */
    public void janelaCampanha() {
        janCampanha = Campanha.getInstance(janHome, this);
        janCampanha.checkScreen();
        janCampanha.setVisible(true);
    }

    /*
    * Torna visível a janela partida
    *
     */
    public void janelaPartida() {
        dlgPartida = (Partida) abrirJanela(janHome, dlgPartida, Partida.class);
        dlgPartida.checkScreen();
        dlgPartida.setVisible(true);

    }

    /*
    * Torna visível a janela fechar
    *
     */
    public void janelaFechar() {
        System.exit(0);
    }

    /*
    * Função genérica para abrir Dialog
    *
     */
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, App.class).newInstance(parent, true, this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName());
            }
        }
        if (dlg != null) {
            //dlg.setLocationRelativeTo(null);
            dlg.setSize(screenSize.width, screenSize.height * 19 / 20);
            dlg.setTitle("War of Spark");
        }
        return dlg;
    }

    /*
    * Função genérica para trocar de JFrame
    *
     */
    private JFrame trocarJanela(java.awt.Frame parent, JFrame jan, Class classe) {
        if (jan == null) {
            try {
                jan = (JFrame) classe.getConstructor(Frame.class, boolean.class, App.class).newInstance(parent, true, this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName());
                System.out.println(ex.getCause());
            }
        }
        if (jan != null) {
            jan.setVisible(true);
            //jan.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jan.setTitle("War of the Spark");
        }
        parent.setVisible(false);
        return jan;
    }

    public int getIdCampaign() {
        return idCampaign;
    }

    public void setIdCampaign(int idCampaign) {
        this.idCampaign = idCampaign;
    }

    /**
     *
     * @param f (FontUIResource)
     */
    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = javax.swing.UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = javax.swing.UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                javax.swing.UIManager.put(key, f);
            }
        }
    }

    public ImageIcon PathImageGetter(String src) {
        return new PathImageGetter().loadImage(src);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                // System.out.println( info.getName() );
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // TRADUÇÃO
        javax.swing.UIManager.put(
                "OptionPane.yesButtonText", "Sim");
        javax.swing.UIManager.put(
                "OptionPane.noButtonText", "Não");

        setUIFont(new javax.swing.plaf.FontUIResource("Yu Gothic UI", Font.PLAIN, 12));

        App gerUI = new App();

        gerUI.janelaPrincipal();

    }

}
