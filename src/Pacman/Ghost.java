/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author angioletti
 */
public class Ghost implements Runnable{
    
    private int iCod;
    private int iPos = 1;
    private String sCor;

    public int getiCod() {
        return iCod;
    }

    public void setiCod(int iCod) {
        this.iCod = iCod;
    }

    public int getiPos() {
        return iPos;
    }

    public void setiPos(int iPos) {
        this.iPos = iPos;
    }

    public String getsCor() {
        return sCor;
    }

    public void setsCor(String sCor) {
        this.sCor = sCor;
    }
    
    public Ghost(int iCod, String sCor) {
        this.iCod = iCod;
        this.sCor = sCor;
    }
    
    
    private void Animation(){
        
        String sNameImage = "/Pacman/images/ghost"+this.getsCor()+this.getiPos()+".png";
        
        {//TROCA POSIÇÃO
            switch (this.getiPos()){
                case 1:
                    this.setiPos(2);
                    break;
                case 2:
                    this.setiPos(1);
                    break;
                default:
                    break;
            }
        }
        
        ImageIcon oIcon = new ImageIcon(getClass().getResource(sNameImage));
        Run.animateGhost(this.getiCod(), oIcon);
        
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
