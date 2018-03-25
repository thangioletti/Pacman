/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.player.Player;

public class Jlayer implements Runnable{    
    
    public static boolean bStart = true;
    
    public static void musicaInicio() {
        String path = "src/Pacman/sound/beginning.mp3";
        File mp3File = new File(path);
        MP3Musica musica = new MP3Musica();
        musica.tocar(mp3File);
        musica.start();
    }

    public static void musicaFundo() {
        String path = "src/Pacman/sound/chomp.mp3";
        File mp3File = new File(path);
        MP3Musica musica = new MP3Musica();
        musica.tocar(mp3File);
        musica.start();
    }
    
    public static void musicaComer() {
        String path = "src/Pacman/sound/eatfruit.mp3";
        File mp3File = new File(path);
        MP3Musica musica = new MP3Musica();
        musica.tocar(mp3File);
        musica.start();
    }
    
    public static void musicaPerdeu(){
        Jlayer.bStart = false;
        String path = "src/Pacman/sound/death.mp3";
        File mp3File = new File(path);
        MP3Musica musica = new MP3Musica();
        musica.tocar(mp3File);
        musica.start();
    }
    
    public static void musicaVenceu(){
        Jlayer.bStart = false;
        String path = "src/Pacman/sound/intermission.mp3";
        File mp3File = new File(path);
        MP3Musica musica = new MP3Musica();
        musica.tocar(mp3File);
        musica.start();
    }
    

    public void run() {
        musicaInicio();
        try {
            Thread.sleep(4200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Jlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (this.bStart) {
            musicaFundo();
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * ====================================================================
     * CLASS INTERNA MP3 MUSICA QUE EXTENDE DE THREAD PARA TRABALHAR
     * PERFEITAMENTE NA APLICAÇÂO SEM TRAVAMENTO NA EXECUÇÃO
     * ====================================================================
     */
    public static class MP3Musica extends Thread {

        // OBJETO PARA O ARQUIVO MP3 A SER TOCADO
        private File mp3;

        // OBJETO PLAYER DA BIBLIOTECA JLAYER QUE TOCA O ARQUIVO MP3
        private Player player;

        /**
         * CONSTRUTOR RECEBE O OBJETO FILE REFERECIANDO O ARQUIVO MP3 A SER
         * TOCADO E ATRIBUI AO ATRIBUTO DA CLASS
         *
         * @param mp3
         */
        public void tocar(File mp3) {
            this.mp3 = mp3;
        }

        /**
         * ===============================================================
         * ======================================METODO RUN QUE TOCA O MP3
         * ===============================================================
         */
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(mp3);
                BufferedInputStream bis = new BufferedInputStream(fis);

                this.player = new Player(bis);
               // System.out.println("Tocando Musica!");

                this.player.play();
               // System.out.println("Terminado Musica!");

            } catch (Exception e) {
                System.out.println("Problema ao tocar Musica" + mp3);
                e.printStackTrace();
            }
        }
    }

}
