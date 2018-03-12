/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman;

import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author angioletti
 */
public class Pacman implements Runnable{
    
    private int iOpen;
    private int iDirection;

    public int getiOpen() {
        return iOpen;
    }

    public void setiOpen(int iOpen) {
        this.iOpen = iOpen;
    }

    public int getiDirection() {
        return iDirection;
    }

    public void setiDirection(int iDirection) {
        this.iDirection = iDirection;
    }

    public Pacman(int iOpen, int iDirection) {
        this.iOpen = iOpen;
        this.iDirection = iDirection;
    }        
    
    private void Animation(){
        
        String sNameImage = "/Pacman/images/pac-";
        String sSide = "";
        
        {//DIREÇÃO
            switch (this.getiDirection()){
                case 1: //Direira
                    sSide = "right";
                    break;
                case 2: //Esquerda
                    sSide = "left";
                    break;
                case 3: //Cima
                    sSide = "top";
                    break;
                case 4: //Baixo
                    sSide = "bottom";
                    break;

                default:
                    break;                
            }
        }

        {//Aberto ou fechado
            switch (this.getiOpen()){
                case 1: //Boca Aberta
                    sNameImage += "open-"+sSide;                                                    
                    break;
                case 2: //Boca Aberta
                    sNameImage += "opening-"+sSide;                                                    
                    break;
                case 3: //Boca fechada
                    sNameImage += "close";
                    break;
                default:
                    break;                
            }
        }
        
        {//TROCA POSIÇÃO DE ABERTO E FECHADO
            switch (this.getiOpen()){
                case 1:
                    this.setiOpen(2);
                    break;
                case 2:
                    this.setiOpen(3);
                    break;
                case 3:
                    this.setiOpen(1);
                    break;
                default:
                    break;
            }
        }
        
        sNameImage+=".png";
        
        ImageIcon oIcon = new ImageIcon(getClass().getResource(sNameImage));
        Run.Pacman.setIcon(oIcon);
        
    }
    
    public void run(){
    
        while (true) {
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pacman.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.Animation();                       
            
        }
    }
    
}
