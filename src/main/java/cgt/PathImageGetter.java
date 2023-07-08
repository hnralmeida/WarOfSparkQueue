/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cgt;

import cgt.imageRender.ImageGetter;
import cgt.imageRender.PathImage;
import javax.swing.ImageIcon;

/**
 *
 * @author almei
 */
public class PathImageGetter extends PathImage implements ImageGetter {

    /**
     *
     * @param nomeDoArquivo
     * @return
     */
    @Override
    public ImageIcon loadImage(String nomeDoArquivo) {
        System.out.println(nomeDoArquivo);
        return pathImageLoad(nomeDoArquivo);
    }

    /**
     *
     * @param posX
     * @param posY
     * @param largura
     * @param altura
     */
    @Override
    public void drawImage(int posX, int posY, int largura, int altura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
