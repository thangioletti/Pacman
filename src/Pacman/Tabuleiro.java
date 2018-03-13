/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman;

import javax.swing.JLabel;

/**
 *
 * @author angioletti
 */
public class Tabuleiro {

    public final int iLinha = 7;
    public final int iColuna = 20;

    public int[][] aMatriz = new int[iLinha][iColuna];

    public Tabuleiro() {
        
        /*VALORES
        * 1 - Parede
        * 2 - Espaço preto
        * 3 - Espaço com semente
        * 4 - Pacman
        * 5 - Ghost
        */
        
        int iGhost = 0;
        
        aMatriz[0][0] = 1;
        aMatriz[0][1] = 1;
        aMatriz[0][2] = 1;
        aMatriz[0][3] = 1;
        aMatriz[0][4] = 1;
        aMatriz[0][5] = 1;
        aMatriz[0][6] = 1;
        aMatriz[1][0] = 1;
        aMatriz[1][1] = 2;
        aMatriz[1][2] = 2;
        aMatriz[1][3] = 2;
        aMatriz[1][4] = 2;
        aMatriz[1][5] = 3;
        aMatriz[1][6] = 3;
        aMatriz[2][0] = 1;
        aMatriz[2][1] = 2;
        aMatriz[2][2] = 1;
        aMatriz[2][3] = 1;
        aMatriz[2][4] = 2;
        aMatriz[2][5] = 2;
        aMatriz[2][6] = 2;
        aMatriz[3][0] = 1;
        aMatriz[3][1] = 2;
        aMatriz[3][2] = 1;
        aMatriz[3][3] = 2;
        aMatriz[3][4] = 2;
        aMatriz[3][5] = 1;
        aMatriz[3][6] = 2;
        aMatriz[4][0] = 1;
        aMatriz[4][1] = 2;
        aMatriz[4][2] = 1;
        aMatriz[4][3] = 1;
        aMatriz[4][4] = 2;
        aMatriz[4][5] = 1;
        aMatriz[4][6] = 3;
        aMatriz[5][0] = 1;
        aMatriz[5][1] = 2;
        aMatriz[5][2] = 2;
        aMatriz[5][3] = 2;
        aMatriz[5][4] = 2;
        aMatriz[5][5] = 2;
        aMatriz[5][6] = 2;
        aMatriz[6][0] = 1;
        aMatriz[6][1] = 1;
        aMatriz[6][2] = 1;
        aMatriz[6][3] = 1;
        aMatriz[6][4] = 1;
        aMatriz[6][5] = 1;
        aMatriz[6][6] = 1;

        aMatriz[0][7] = 1;
        aMatriz[0][8] = 1;
        aMatriz[0][9] = 1;
        aMatriz[0][10] = 1;
        aMatriz[0][11] = 1;
        aMatriz[0][11] = 1;
        aMatriz[0][12] = 1;
        aMatriz[1][7] = 1;
        aMatriz[1][8] = 2;
        aMatriz[1][9] = 2;
        aMatriz[1][10] = 5;
        aMatriz[1][11] = 5;
        aMatriz[1][12] = 1;
        aMatriz[2][7] = 1;
        aMatriz[2][8] = 1;
        aMatriz[2][9] = 2;
        aMatriz[2][10] = 2;
        aMatriz[2][11] = 1;
        aMatriz[2][12] = 1;
        aMatriz[3][7] = 2;
        aMatriz[3][8] = 2;
        aMatriz[3][9] = 2;
        aMatriz[3][10] = 4;
        aMatriz[3][11] = 2;
        aMatriz[3][12] = 2;
        aMatriz[4][7] = 1;
        aMatriz[4][8] = 1;
        aMatriz[4][9] = 1;
        aMatriz[4][10] = 1;
        aMatriz[4][11] = 1;
        aMatriz[4][11] = 1;
        aMatriz[4][12] = 1;
        aMatriz[5][7] = 2;
        aMatriz[5][8] = 2;
        aMatriz[5][9] = 2;
        aMatriz[5][10] = 3;
        aMatriz[5][11] = 3;
        aMatriz[5][11] = 3;
        aMatriz[5][12] = 3;
        aMatriz[6][7] = 1;
        aMatriz[6][8] = 1;
        aMatriz[6][9] = 1;
        aMatriz[6][10] = 1;
        aMatriz[6][11] = 1;
        aMatriz[6][11] = 1;
        aMatriz[6][12] = 1;

        aMatriz[0][13] = 1;
        aMatriz[0][14] = 1;
        aMatriz[0][15] = 1;
        aMatriz[0][16] = 1;
        aMatriz[0][17] = 1;
        aMatriz[0][18] = 1;
        aMatriz[0][19] = 1;
        aMatriz[1][13] = 3;
        aMatriz[1][14] = 3;
        aMatriz[1][15] = 3;
        aMatriz[1][16] = 3;
        aMatriz[1][17] = 3;
        aMatriz[1][18] = 3;
        aMatriz[1][19] = 1;
        aMatriz[2][13] = 2;
        aMatriz[2][14] = 2;
        aMatriz[2][15] = 2;
        aMatriz[2][16] = 1;
        aMatriz[2][17] = 1;
        aMatriz[2][18] = 3;
        aMatriz[2][19] = 1;
        aMatriz[3][13] = 2;
        aMatriz[3][14] = 1;
        aMatriz[3][15] = 2;
        aMatriz[3][16] = 2;
        aMatriz[3][17] = 1;
        aMatriz[3][18] = 3;
        aMatriz[3][19] = 1;
        aMatriz[4][13] = 3;
        aMatriz[4][14] = 1;
        aMatriz[4][15] = 3;
        aMatriz[4][16] = 1;
        aMatriz[4][17] = 1;
        aMatriz[4][18] = 3;
        aMatriz[4][19] = 1;
        aMatriz[5][13] = 3;
        aMatriz[5][14] = 3;
        aMatriz[5][15] = 3;
        aMatriz[5][16] = 3;
        aMatriz[5][17] = 3;
        aMatriz[5][18] = 3;
        aMatriz[5][19] = 1;
        aMatriz[6][13] = 1;
        aMatriz[6][14] = 1;
        aMatriz[6][15] = 1;
        aMatriz[6][16] = 1;
        aMatriz[6][17] = 1;
        aMatriz[6][18] = 1;
        aMatriz[6][19] = 1;

        int iTop = 0;
        for (int iLine = 0; iLine < iLinha; iLine++) {

            int iLeft = 0;
            for (int iCol = 0; iCol < iColuna; iCol++) {
                String sImg = "";
                if (aMatriz[iLine][iCol] == 1) {
                    sImg = "azul";
                    JLabel Black = new javax.swing.JLabel();
                    Black.setSize(26, 26);
                    Black.setLocation(iLeft, iTop);
                    Run.Fundo.add(Black);
                    Black.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/" + sImg + ".png")));
                } else if (aMatriz[iLine][iCol] == 2) {
                    sImg = "preto";
                    JLabel Black = new javax.swing.JLabel();
                    Black.setSize(26, 26);
                    Black.setLocation(iLeft, iTop);
                    Run.Fundo.add(Black);
                    Black.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/" + sImg + ".png")));
                } else if (aMatriz[iLine][iCol] == 3) {
                    sImg = "semente";
                    JLabel Black = new javax.swing.JLabel();
                    Black.setSize(26, 26);
                    Black.setLocation(iLeft, iTop);
                    Run.Fundo.add(Black);
                    Black.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/" + sImg + ".png")));
                } else if (aMatriz[iLine][iCol] == 4) {
                    sImg = "pac-close";
                    Run.Pacman = new javax.swing.JLabel();
                    Run.Pacman.setSize(26, 26);
                    Run.Pacman.setLocation(iLeft, iTop);
                    Run.Fundo.add(Run.Pacman);
                    Run.Pacman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/" + sImg + ".png")));
                } else if (aMatriz[iLine][iCol] == 5) {
                    Run.Ghost[iGhost] = new javax.swing.JLabel();
                    Run.Ghost[iGhost].setSize(26, 26);
                    Run.Ghost[iGhost].setLocation(iLeft, iTop);
                    Run.Fundo.add(Run.Ghost[iGhost]);
                    Run.Ghost[iGhost].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/ghostpink1.png")));
                    iGhost++;
                }

                

                iLeft += 26;
            }
            iTop += 26;
        }

    }

}
