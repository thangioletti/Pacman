/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author angioletti
 */
public class Tabuleiro implements Runnable {

    public final int iLinha = 7;
    public final int iColuna = 20;

    public int[][] aMatriz = new int[iLinha][iColuna];
    public JLabel Black[][] = new JLabel[iLinha][iColuna];

    public int iPontos = 0;
    public int iMovimentoPac = 0;
    
    public Random oRand = new Random();
    
    public Tabuleiro() {

        /*VALORES
        * 1 - Parede
        * 2 - Espaço preto
        * 3 - Espaço com semente
        * 4 - Pacman
        * 5 - Ghost
        * 6 - Ghost
         */
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
        aMatriz[0][12] = 1;
        aMatriz[1][7] = 1;
        aMatriz[1][8] = 2;
        aMatriz[1][9] = 5;
        aMatriz[1][10] = 2;
        aMatriz[1][11] = 1;
        aMatriz[1][12] = 2;
        aMatriz[2][7] = 1;
        aMatriz[2][8] = 1;
        aMatriz[2][9] = 2;
        aMatriz[2][10] = 1;
        aMatriz[2][11] = 1;
        aMatriz[2][12] = 2;
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
        aMatriz[4][12] = 3;
        aMatriz[5][7] = 2;
        aMatriz[5][8] = 2;
        aMatriz[5][9] = 2;
        aMatriz[5][10] = 3;
        aMatriz[5][11] = 3;
        aMatriz[5][12] = 3;
        aMatriz[6][7] = 1;
        aMatriz[6][8] = 1;
        aMatriz[6][9] = 1;
        aMatriz[6][10] = 1;
        aMatriz[6][11] = 1;
        aMatriz[6][12] = 1;

        aMatriz[0][13] = 1;
        aMatriz[0][14] = 1;
        aMatriz[0][15] = 1;
        aMatriz[0][16] = 1;
        aMatriz[0][17] = 1;
        aMatriz[0][18] = 1;
        aMatriz[1][13] = 3;
        aMatriz[1][14] = 3;
        aMatriz[1][15] = 3;
        aMatriz[1][16] = 3;
        aMatriz[1][17] = 3;
        aMatriz[1][18] = 1;
        aMatriz[2][13] = 2;
        aMatriz[2][14] = 2;
        aMatriz[2][15] = 1;
        aMatriz[2][16] = 1;
        aMatriz[2][17] = 3;
        aMatriz[2][18] = 1;
        aMatriz[3][13] = 1;
        aMatriz[3][14] = 2;
        aMatriz[3][15] = 2;
        aMatriz[3][16] = 1;
        aMatriz[3][17] = 3;
        aMatriz[3][18] = 1;
        aMatriz[4][13] = 1;
        aMatriz[4][14] = 3;
        aMatriz[4][15] = 1;
        aMatriz[4][16] = 1;
        aMatriz[4][17] = 3;
        aMatriz[4][18] = 1;
        aMatriz[5][13] = 3;
        aMatriz[5][14] = 3;
        aMatriz[5][15] = 3;
        aMatriz[5][16] = 3;
        aMatriz[5][17] = 3;
        aMatriz[5][18] = 1;
        aMatriz[6][13] = 1;
        aMatriz[6][14] = 1;
        aMatriz[6][15] = 1;
        aMatriz[6][16] = 1;
        aMatriz[6][17] = 1;
        aMatriz[6][18] = 1;

        redo();

    }

    public void run() {
        while (true) {

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tabuleiro.class.getName()).log(Level.SEVERE, null, ex);
            }

            Run.Pontuacao.setText(iPontos - contaPontos() + " pontos");
            finish();
            movingPac(); //Move pacman
            movingGhost(5);
        }
        

    }

    public void movePac(int iDirection) {
        this.iMovimentoPac = iDirection;
    }

    public void finish() {
        System.out.println(iPontos);
        if (contaPontos() == 0) {
            Run.Pontuacao.setText("Win");
            Run.Die();
        };
    }

    public void movingPac() {
        this.moving(4, this.iMovimentoPac);
    }

    public void movingGhost(int iGhost) {
        this.moving(iGhost, (oRand.nextInt(4)+1));
    }

    public void moving(int iPersonagem, int iDirection) {
        int[] iPos = this.findPersonagem(iPersonagem);

        /* 1 - Direita
        * 2 - Esquerda
        * 3 - Cima
        * 4 - Baixo */
        switch (iDirection) {
            case 1:
                this.moveRight(iPersonagem, iPos);
                break;
            case 2:
                this.moveLeft(iPersonagem, iPos);
                break;
            case 3:
                this.moveUp(iPersonagem, iPos);
                break;
            case 4:
                this.moveDown(iPersonagem, iPos);
                break;
            default:
                break;
        }

    }

    public void moveRight(int iPersonagem, int[] iPos) {

        int iLine = iPos[0];
        int iCol = iPos[1];

        int iNewLine = iLine;
        int iNewCol = iCol + 1;

        int iElementoNoCaminho = aMatriz[iNewLine][iNewCol];
        /* 1 - Parede
        * 2 - Espaço preto
        * 3 - Espaço com semente
        * 4 - Pacman*/
        switch (iElementoNoCaminho) {
            case 1:
                //Não meche
                break;
            case 2:
                this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x - 26, Black[iLine][iCol].getLocation().y);
                if (iPersonagem == 4) {
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x + 26, Run.Pacman.getLocation().y);
                } else if (iPersonagem == 5) {
                    Run.Ghost[0].setLocation(Run.Ghost[0].getLocation().x + 26, Run.Ghost[0].getLocation().y);
                }
                break;
            case 3:
                if (iPersonagem == 4) {
                    Run.Musica.musicaComer();
                    this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                    this.aMatriz[iLine][iCol] = 2;
                    Black[iLine][iCol] = Black[iNewLine][iNewCol];
                    Black[iNewLine][iNewCol] = null;
                    Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
                    Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x - 26, Black[iLine][iCol].getLocation().y);
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x + 26, Run.Pacman.getLocation().y);
                }
                break;
            default:
                break;
        }
    }

    public void moveLeft(int iPersonagem, int[] iPos) {
        int iLine = iPos[0];
        int iCol = iPos[1];

        int iNewLine = iLine;
        int iNewCol = iCol - 1;

        int iElementoNoCaminho = aMatriz[iNewLine][iNewCol];
        /* 1 - Parede
        * 2 - Espaço preto
        * 3 - Espaço com semente
        * 4 - Pacman*/
        switch (iElementoNoCaminho) {
            case 1:
                //Não meche
                break;
            case 2:
                this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x + 26, Black[iLine][iCol].getLocation().y);
                if (iPersonagem == 4) {
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x - 26, Run.Pacman.getLocation().y);
                } else if (iPersonagem == 5) {
                    Run.Ghost[0].setLocation(Run.Ghost[0].getLocation().x - 26, Run.Ghost[0].getLocation().y);
                }
                break;
            case 3:
                Run.Musica.musicaComer();
                this.aMatriz[iNewLine][iNewCol] = 4;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x + 26, Black[iLine][iCol].getLocation().y);
                Run.Pacman.setLocation(Run.Pacman.getLocation().x - 26, Run.Pacman.getLocation().y);
                break;
            default:
                break;
        }

    }

    public void moveUp(int iPersonagem, int[] iPos) {
        int iLine = iPos[0];
        int iCol = iPos[1];

        int iNewLine = iLine - 1;
        int iNewCol = iCol;

        int iElementoNoCaminho = aMatriz[iNewLine][iNewCol];
        /* 1 - Parede
        * 2 - Espaço preto
        * 3 - Espaço com semente
        * 4 - Pacman*/
        switch (iElementoNoCaminho) {
            case 1:
                //Não meche
                break;
            case 2:
                this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x, Black[iLine][iCol].getLocation().y + 26);
                if (iPersonagem == 4) {
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x, Run.Pacman.getLocation().y - 26);
                } else if (iPersonagem == 5) {
                    Run.Ghost[0].setLocation(Run.Ghost[0].getLocation().x, Run.Ghost[0].getLocation().y - 26);
                }
                
                break;
            case 3:
                Run.Musica.musicaComer();
                this.aMatriz[iNewLine][iNewCol] = 4;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x, Black[iLine][iCol].getLocation().y + 26);
                Run.Pacman.setLocation(Run.Pacman.getLocation().x, Run.Pacman.getLocation().y - 26);
                break;
            default:
                break;
        }

    }

    public void moveDown(int iPersonagem, int[] iPos) {
        int iLine = iPos[0];
        int iCol = iPos[1];

        int iNewLine = iLine + 1;
        int iNewCol = iCol;

        int iElementoNoCaminho = aMatriz[iNewLine][iNewCol];
        /* 1 - Parede
        * 2 - Espaço preto
        * 3 - Espaço com semente
        * 4 - Pacman*/
        switch (iElementoNoCaminho) {
            case 1:
                //Não meche
                break;
            case 2:
                this.aMatriz[iNewLine][iNewCol] = 4;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x, Black[iLine][iCol].getLocation().y - 26);
                if (iPersonagem == 4) {
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x, Run.Pacman.getLocation().y + 26);
                } else if (iPersonagem == 5) {
                    Run.Ghost[0].setLocation(Run.Ghost[0].getLocation().x, Run.Ghost[0].getLocation().y + 26);
                }                
                break;
            case 3:
                Run.Musica.musicaComer();
                this.aMatriz[iNewLine][iNewCol] = 4;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x, Black[iLine][iCol].getLocation().y - 26);
                Run.Pacman.setLocation(Run.Pacman.getLocation().x, Run.Pacman.getLocation().y + 26);
                break;
            default:
                break;
        }

    }

    public int[] findPersonagem(int iPersonagem) {
        int[] iPos = new int[2];

        for (int iLine = 0; iLine < iLinha; iLine++) {
            for (int iCol = 0; iCol < iColuna; iCol++) {
                if (aMatriz[iLine][iCol] == iPersonagem) {
                    iPos[0] = iLine;
                    iPos[1] = iCol;
                    return iPos;
                }
            }
        }

        return iPos;
    }

    public int contaPontos() {

        int iPontos = 0;
        for (int iLine = 0; iLine < iLinha; iLine++) {
            for (int iCol = 0; iCol < iColuna; iCol++) {
                if (aMatriz[iLine][iCol] == 3) {
                    iPontos++;
                }
            }
        }

        return iPontos;
    }

    public void redo() {

        this.iPontos = contaPontos();
        int iGhost = 0;
        int iTop = 0;
        for (int iLine = 0; iLine < iLinha; iLine++) {

            int iLeft = 0;
            for (int iCol = 0; iCol < iColuna; iCol++) {
                String sImg = "";
                if (aMatriz[iLine][iCol] == 1) {
                    sImg = "azul";
                    Black[iLine][iCol] = new javax.swing.JLabel();
                    Black[iLine][iCol].setSize(26, 26);
                    Black[iLine][iCol].setLocation(iLeft, iTop);
                    Run.Fundo.add(Black[iLine][iCol]);
                    Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/" + sImg + ".png")));
                } else if (aMatriz[iLine][iCol] == 2) {
                    sImg = "preto";
                    Black[iLine][iCol] = new javax.swing.JLabel();
                    Black[iLine][iCol].setSize(26, 26);
                    Black[iLine][iCol].setLocation(iLeft, iTop);
                    Run.Fundo.add(Black[iLine][iCol]);
                    Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/" + sImg + ".png")));
                } else if (aMatriz[iLine][iCol] == 3) {
                    sImg = "semente";
                    Black[iLine][iCol] = new javax.swing.JLabel();
                    Black[iLine][iCol].setSize(26, 26);
                    Black[iLine][iCol].setLocation(iLeft, iTop);
                    Run.Fundo.add(Black[iLine][iCol]);
                    Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/" + sImg + ".png")));
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
