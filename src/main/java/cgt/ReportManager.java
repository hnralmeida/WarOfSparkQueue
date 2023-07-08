/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author 1547816
 */
public class ReportManager {

    public void relComLista(List lista, String nome) {
        try {
            System.out.println("get Resource");
            // PASSO 1 - Caminho do relatório
            InputStream rel = getClass().getResourceAsStream("../relatorios/" + nome);

            // COMPILAR
            //JasperReport rel = JasperCompileManager.compileReport(relArq);
            
            // PASSO 2 - Criar parâmetros de Pesquisa 
            Map parametros = new HashMap();

            System.out.println("setCollection");
            // PASSO 3 - Carregar o relatório com os dados
            JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(lista);
            JasperPrint print;
            print = JasperFillManager.fillReport(rel, parametros, dados);

            if (!print.getPages().isEmpty()) {
                // PASSO 4 - Mostrat em uma JANELA

                // Cria o JasperViewer
                JasperViewer jrViewer = new JasperViewer(print, true);
                //jrViewer.setVisible(true);

                // Criar uma janela MODAL e colocar o JasperView dentro dela
                System.out.println("Passo 4");
                JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
                viewer.setSize(800, 600);
                viewer.setLocationRelativeTo(null);
                viewer.getContentPane().add(jrViewer.getContentPane());
                viewer.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Relatório vazio.");
            }

        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "ERRO ao abrir relatório de clientes. " + erro.getMessage());

        }

    }

}
