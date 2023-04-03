/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cgt;

import cih.Cadastrar;
import cih.Campanha;
import cih.Home;
import cih.Login;
import cih.Loja;
import cih.Time;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

/**
 *
 * @author almei
 */
public class App {

    // Construtor
    /*
    public App() {
        try {
            gerDominio = new GerenciadorDominio();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(janLogin, "Erro de conexão com o banco. " + ex.getMessage());
            System.exit(-1);
        }
    }
     */
    // GERENCIADORES de DOMINIO
    //GerenciadorDominio gerDominioj
    // Janelas
    private Login janLogin = null;
    private Cadastrar dlgCadastro = null;
    private Home janHome = null;
    private Loja dlgLoja = null;
    private Time dlgTime = null;
    private Campanha janCampanha = null;
    
    // Controle de Tamanho de Tela
    private final Toolkit tk = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = tk.getScreenSize();

    public void janelaPrincipal() {
        janLogin = new Login(this);
        janLogin.setVisible(true);
        janLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void janelaCadastro() {
        dlgCadastro = (Cadastrar) abrirJanela(janLogin, dlgCadastro, Cadastrar.class);
    }

    public void janelaHome() {
        janHome = (Home) trocarJanela(janLogin, janHome, Home.class);
    }
    
    public void janelaLoja() {
        dlgLoja = (Loja) abrirJanela(janHome, dlgLoja, Loja.class);
    }

    public void janelaTime() {
        dlgTime = (Time) abrirJanela(janHome, dlgTime, Time.class);
    }
    
    public void janelaCampanha() {
        janCampanha = (Campanha) trocarJanela(janHome, janCampanha, Campanha.class);
    }

    // ABRIR JDIALOG
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
            dlg.setSize(screenSize.width, screenSize.height*19/20);
            dlg.setVisible(true);
        }
        return dlg;
    }

    private JFrame trocarJanela(java.awt.Frame parent, JFrame jan, Class classe) {
        if (jan == null) {
            try {
                jan = (JFrame) classe.getConstructor(Frame.class, boolean.class, App.class).newInstance(parent, true, this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName());
            }
        }
        if (jan != null) {
            jan.setVisible(true);
            jan.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jan.setTitle("War of the Spark");
        }
        parent.setVisible(false);
        parent=null;
        return jan;
    }

    /**
     *
     * @param f
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
