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
    
    private int iDirection;

    public int getiDirection() {
        return iDirection;
    }

    public void setiDirection(int iDirection) {
        this.iDirection = iDirection;
    }

    public Pacman(int iDirection) {
        this.iDirection = iDirection;
    }        
    
    private void Animation(){
                
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
        String sNameImage = "/Pacman/images/"+sSide+".gif";        
        
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
