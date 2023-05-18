/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cgt.imageRender;

import javax.swing.ImageIcon;

/**
 *
 * @author almei
 */
public interface ImageGetter {

    /**
     *
     * @param nomeDoArquivo
     * @return
     */
    ImageIcon loadImage(String nomeDoArquivo);

    /**
     *
     * @param posX
     * @param posY
     * @param largura
     * @param altura
     */
    void drawImage(int posX, int posY, int largura, int altura);
}
