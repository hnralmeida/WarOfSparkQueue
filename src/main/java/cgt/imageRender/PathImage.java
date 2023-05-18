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
public class PathImage {
    
    public ImageIcon pathImageLoad(String file){
        System.out.println(getClass().getResource("../"));
        return new javax.swing.ImageIcon(getClass().getResource("../images/" + file + ".png") );
    }
    
}
