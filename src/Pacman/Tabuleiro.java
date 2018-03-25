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
import javax.swing.JOptionPane;

/**
 *
 * @author angioletti
 */
public class Tabuleiro implements Runnable {

    public final int iLinha = 7;
    public final int iColuna = 20;

    public int[][] aMatriz = new int[iLinha][iColuna];
    public String[] aMoedas;
    
    public JLabel Black[][] = new JLabel[iLinha][iColuna];

    public int iPontos = 0;
    public int[] iMovimentoGhost;

    public Random oRand = new Random();

    public Tabuleiro() {

        iMovimentoGhost = new int[7];
        iMovimentoGhost[5] = 2;
        iMovimentoGhost[6] = 1;
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
        aMatriz[4][4] = 6;
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
        aMatriz[1][9] = 2;
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
        aMatriz[3][9] = 5;
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
        
        
        this.doArrayMoedas();
        redo();

    }
    
    public boolean hasMoeda(int iLine, int iCol) {       
        String sSearch = iLine+","+iCol;
        
        for(String sPos: this.aMoedas){
            if (sPos.equals(sSearch)) {
                return true;
            }
        }
        
        return false;
    }
    
    public void doArrayMoedas() {
        this.aMoedas = new String[contaPontos()];
        
        int i = 0;
        for (int iLine = 0; iLine < iLinha; iLine++) {           
            for (int iCol = 0; iCol < iColuna; iCol++) {
                if (aMatriz[iLine][iCol] == 3) {
                    this.aMoedas[i] = iLine+","+iCol;
                    i++;
                }
            }
        }        
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
            movingGhost(6);
        }

    }

    public void perdeu(){
        if (contaPontos() > 0) {
            Run.Pontuacao.setText("Perdeu");
            Run.Musica.musicaPerdeu();            
            JOptionPane.showMessageDialog(null, "Você perdeu");
            System.exit(1);
        }
    }
    public void finish() {                
        if (contaPontos() == 0) {
            Run.Pontuacao.setText("Win");            
            Run.Musica.musicaVenceu();
            JOptionPane.showMessageDialog(null, "Você venceu");
            System.exit(1);
        };                
        
    }

    public void movingPac() {
        this.moving(4, Run.oPac.getiDirection());
    }

    public void movingGhost(int iGhost) {
        this.moving(iGhost, this.iMovimentoGhost[iGhost]);
    }

    public void moving(int iPersonagem, int iDirection) {
        int aPos[] = this.findPersonagem(iPersonagem);
        int aPosition[] = this.paramsDirection(iDirection, aPos);
        int iElementoNoCaminho = aMatriz[aPosition[0]][aPosition[1]];
        
        /* 1 - Direita
        * 2 - Esquerda
        * 3 - Cima
        * 4 - Baixo */
        switch (iElementoNoCaminho) {
            case 1:
                if (iPersonagem > 4) {
                    moveGhostRand(iPersonagem);
                }
                break;
            case 2:
                this.movePersonagemBlocoVazio(iPersonagem, aPosition);
                break;
            case 3:
                if (iPersonagem == 4) {
                    this.movePacmanMoeda(aPosition);
                } else {
                    this.moveGhostMoeda(iPersonagem, aPosition);
                }
                break;
            default:
                if (iPersonagem == 4) {
                    this.perdeu();
                } else {
                    moveGhostRand(iPersonagem);
                }
                break;
        }

    }
    
    //RETORNA PARAMETROS DE MOVIMENTO TANTO LABEL QUANTO MATRIZES
    public int[] paramsDirection(int iDirection, int[] aPos) {
        
        int aPosition[] = new int[8]; 
        
        //0 e 1 são do personagem
        aPosition[0] = aPos[0];//LINHA
        aPosition[1] = aPos[1];//COLUNA
        
        //2 e 3 são o label onde ele estava
        aPosition[2] = aPos[0];
        aPosition[3] = aPos[1];
        
        //FATORES
        //4 e 5 são os lugares onde ele vai ir
        aPosition[4] = 0; //X
        aPosition[5] = 0; //Y
                        
        //ABAIXO ALTERA O POSICIONAMENTO
        switch (iDirection) {
            case 1: //Right                        
                aPosition[1] = aPosition[1]+1;
                aPosition[4] = 26;
                break;
            case 2: //Left
                aPosition[1] = aPosition[1]-1;
                aPosition[4] = -26;
                break;
            case 3: //Up
                aPosition[0] = aPosition[0]-1;
                aPosition[5] = -26;
                break;
            case 4: //Down
                aPosition[0] = aPosition[0]+1;
                aPosition[5] = 26;
                break;
        }

        //6 e 7 são o oposto do 4 e 5
        aPosition[6] = aPosition[4]*-1;
        aPosition[7] = aPosition[5]*-1;
                
        return aPosition;
    }
    
    
    
    //Método que faz a movimentação genérica dos personagens
    public void movePersonagem(int iPersonagem, int[] aPosition) {                
        
        int iNewLine = aPosition[0];
        int iNewCol  = aPosition[1];
        int iLine    = aPosition[2];
        int iCol     = aPosition[3];
        
        {
            //Altera a matriz com os personagens
            this.aMatriz[iNewLine][iNewCol] = iPersonagem;
            
            if (iPersonagem == 4) {
                //Caso for o pacman bota um espaço vazio no lugar
                this.aMatriz[iLine][iCol] = 2;
            } else {
                //Caso for um ghost
                if (this.hasMoeda(iLine, iCol)) {
                    this.aMatriz[iLine][iCol] = 3;
                } else {
                    this.aMatriz[iLine][iCol] = 2;
                }
            }

        }
       
        {
            //Altera a matriz com os labels
            Black[iLine][iCol] = Black[iNewLine][iNewCol];
            Black[iNewLine][iNewCol] = null;
            
        }
                
        {
            //Muda posicionamento dos em branco
            int iLocationLabel[] = new int[2];
            iLocationLabel[0] = Black[iLine][iCol].getLocation().x+aPosition[6];//X
            iLocationLabel[1] = Black[iLine][iCol].getLocation().y+aPosition[7];//Y
            Black[iLine][iCol].setLocation(iLocationLabel[0], iLocationLabel[1]);            
        }
        
        {
            //Muda posicionamento do personagem
            int iLocationLabel[] = new int[2];
            
            if (iPersonagem == 4) {
                iLocationLabel[0] = Run.Pacman.getLocation().x+aPosition[4];//X
                iLocationLabel[1] = Run.Pacman.getLocation().y+aPosition[5];//Y
                Run.Pacman.setLocation(iLocationLabel[0], iLocationLabel[1]);
            } else {
                int iPosGhost = iPersonagem-5;
                iLocationLabel[0] = Run.Ghost[iPosGhost].getLocation().x+aPosition[4];//X
                iLocationLabel[1] = Run.Ghost[iPosGhost].getLocation().y+aPosition[5];//Y
                Run.Ghost[iPosGhost].setLocation(iLocationLabel[0], iLocationLabel[1]);
            }
        }
                
    }
    
    //Método que faz a movimentação dos personagens em blocos vazios
    public void movePersonagemBlocoVazio(int iPersonagem, int[] aPosition) {
        this.movePersonagem(iPersonagem, aPosition);
    }
    
    //Método que faz a movimentação do pacman sobre a moeda
    public void movePacmanMoeda(int[] aPosition){
                          
        this.movePersonagem(4, aPosition);//Metodo que faz a movimentação
        
        Run.Musica.musicaComer();//Chama musica
        
        {
          //Troca a imagem da moeda por um campo vazio
          int iLine    = aPosition[2];
          int iCol     = aPosition[3];
          Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));                    
        }
        
        this.doArrayMoedas();//Refaz o array de moedas                
        
    }
    
     //Método que faz a movimentação do Ghost sobre a moeda
    public void moveGhostMoeda(int iGhost, int[] aPosition){
            
        {
          //Troca a imagem da moeda por um campo vazio
          int iNewLine    = aPosition[0];
          int iLine    = aPosition[2];
          int iNewCol     = aPosition[1];
          int iCol     = aPosition[3];
          
          this.movePersonagem(iGhost, aPosition);//Metodo que faz a movimentação

                  
          if (this.hasMoeda(iNewLine, iNewCol) && !this.hasMoeda(iLine, iCol)) {
            Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));                    
          }
          
          if (!this.hasMoeda(iNewLine, iNewCol) && this.hasMoeda(iLine, iCol)) {
            Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/semente.png")));                    
          }
          
          
        }
             
        
            
    }
    
    //Retorna valor random
    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    
    //Muda a direção que um Ghost vai andar de modo randomico
    public void moveGhostRand(int iGhost) {
        
        int aMovimentosPossiveis[] = new int[2];
        
        switch (this.iMovimentoGhost[iGhost]) {
            case 1:
                aMovimentosPossiveis[0] = 3;
                aMovimentosPossiveis[1] = 4;
                break;
            case 2:
                aMovimentosPossiveis[0] = 3;
                aMovimentosPossiveis[1] = 4;
                break;
            case 3:
                aMovimentosPossiveis[0] = 1;
                aMovimentosPossiveis[1] = 2;
                break;
            case 4:
                aMovimentosPossiveis[0] = 1;
                aMovimentosPossiveis[1] = 2;
                break;
        }
        
        this.iMovimentoGhost[iGhost] = getRandom(aMovimentosPossiveis);
    }
    
    /*
    

    public void moveRight(int iPersonagem, int[] iPos) {

        int iLine = iPos[0];
        int iCol = iPos[1];

        int iNewLine = iLine;
        int iNewCol = iCol + 1;

        int iElementoNoCaminho = aMatriz[iNewLine][iNewCol];
        /* 1 - Parede
        * 2 - Espaço preto
        * 3 - Espaço com semente
        * 4 - Pacman
        switch (iElementoNoCaminho) {
            case 1:
                //Não meche
                //Se for um Ghost muda a direção
                if (iPersonagem > 4) {
                    moveGhostRand(iPersonagem);
                }
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
                    this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                    
                    this.aMatriz[iLine][iCol] = 2;
                    this.aMatrizTabuleiro[iLine][iCol] = 2;
                    Black[iLine][iCol] = Black[iNewLine][iNewCol];
                    Black[iNewLine][iNewCol] = null;
                    Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
                    Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x - 26, Black[iLine][iCol].getLocation().y);
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x + 26, Run.Pacman.getLocation().y);
                } else {

                    int[] iPosMatriz = new int[4];
                    int[] iDirection = new int[4];

                    iPosMatriz[0] = iLine;
                    iPosMatriz[1] = iCol;
                    iPosMatriz[2] = iNewLine;
                    iPosMatriz[3] = iNewCol;

                    iDirection[0] = Run.Ghost[iPersonagem - 5].getLocation().x + 26;
                    iDirection[1] = Run.Ghost[iPersonagem - 5].getLocation().y;
                    iDirection[2] = Black[iNewLine][iNewCol].getLocation().x - 26;
                    iDirection[3] = Black[iNewLine][iNewCol].getLocation().y;

                    moverGhost(iPersonagem, iPosMatriz, iDirection);
                }
                break;
            default:
                //ESPERA
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
        * 4 - Pacman
        switch (iElementoNoCaminho) {
            case 1:
                //Não meche
                //Se for um Ghost muda a direção
                if (iPersonagem > 4) {
                    moveGhostRand(iPersonagem);
                }
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
                if (iPersonagem == 4) {
                    this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                    Run.Musica.musicaComer();
                    this.aMatriz[iLine][iCol] = 2;
                    this.aMatrizTabuleiro[iLine][iCol] = 2;
                    Black[iLine][iCol] = Black[iNewLine][iNewCol];
                    Black[iNewLine][iNewCol] = null;
                    Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
                    Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x + 26, Black[iLine][iCol].getLocation().y);
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x - 26, Run.Pacman.getLocation().y);
                } else {
                    int[] iPosMatriz = new int[4];
                    int[] iDirection = new int[4];

                    iPosMatriz[0] = iLine;
                    iPosMatriz[1] = iCol;
                    iPosMatriz[2] = iNewLine;
                    iPosMatriz[3] = iNewCol;

                    iDirection[0] = Run.Ghost[iPersonagem - 5].getLocation().x - 26;
                    iDirection[1] = Run.Ghost[iPersonagem - 5].getLocation().y;
                    iDirection[2] = Black[iNewLine][iNewCol].getLocation().x + 26;
                    iDirection[3] = Black[iNewLine][iNewCol].getLocation().y;

                    moverGhost(iPersonagem, iPosMatriz, iDirection);
                }
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
        * 4 - Pacman
        switch (iElementoNoCaminho) {
            case 1:
                //Não meche
                //Se for um Ghost muda a direção
                if (iPersonagem > 4) {
                    moveGhostRand(iPersonagem);
                }
                break;
            case 2:
                this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x, Black[iLine][iCol].getLocation().y + 26);
                if (iPersonagem == 4) {
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x, Run.Pacman.getLocation().y - 26);
                } else if (iPersonagem >= 5) {
                    Run.Ghost[0].setLocation(Run.Ghost[0].getLocation().x, Run.Ghost[0].getLocation().y - 26);
                }
                break;
            case 3:
                if (iPersonagem == 4) {
                    this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                    Run.Musica.musicaComer();
                    this.aMatriz[iLine][iCol] = 2;
                    this.aMatrizTabuleiro[iLine][iCol] = 2;
                    Black[iLine][iCol] = Black[iNewLine][iNewCol];
                    Black[iNewLine][iNewCol] = null;
                    Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
                    Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x, Black[iLine][iCol].getLocation().y + 26);
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x, Run.Pacman.getLocation().y - 26);
                } else {

                    int[] iPosMatriz = new int[4];
                    int[] iDirection = new int[4];

                    iPosMatriz[0] = iLine;
                    iPosMatriz[1] = iCol;
                    iPosMatriz[2] = iNewLine;
                    iPosMatriz[3] = iNewCol;

                    iDirection[0] = Run.Ghost[iPersonagem - 5].getLocation().x;
                    iDirection[1] = Run.Ghost[iPersonagem - 5].getLocation().y - 26;
                    iDirection[2] = Black[iNewLine][iNewCol].getLocation().x;
                    iDirection[3] = Black[iNewLine][iNewCol].getLocation().y + 26;

                    moverGhost(iPersonagem, iPosMatriz, iDirection);
                }
                break;
            default:
                break;
        }

    }

    public void moverGhost(int iPersonagem, int[] iPosMatriz, int[] iDirection) {
        
        int iLine = iPosMatriz[0];
        int iCol = iPosMatriz[1];
        int iNewLine = iPosMatriz[2];
        int iNewCol = iPosMatriz[3];

        //Operações na matriz
        {
            System.out.println("Matriz Original");           
            printMatriz(this.aMatriz);
            System.out.println("Matriz sem personagens Nova");           
            printMatriz(this.aMatrizTabuleiro);
            
            this.aMatriz[iNewLine][iNewCol] = iPersonagem;
            this.aMatriz[iLine][iCol] = this.aMatrizTabuleiro[iLine][iCol];
            
            System.out.println("Movimentou ["+iLine+" "+iCol+"]["+iNewLine+" "+iNewCol+"]");
            System.out.println("Matriz Original Nova");           
            printMatriz(this.aMatriz);
            System.out.println("Matriz sem personagens Nova");           
            printMatriz(this.aMatrizTabuleiro);
        }
        
        
        //System.out.println("OLD [" + iLine + "][" + iCol + "]");
        //System.out.println("NEW [" + iNewLine + "][" + iNewCol + "]");
        
        /*
        int iXGhost = iDirection[0];
        int iYGhost = iDirection[1];
        int iXLabel = iDirection[2];
        int iYLabel = iDirection[3];

        aMatrizTabuleiro[iNewLine][iNewLine] = aMatriz[iNewLine][iNewLine];
        this.aMatriz[iLine][iCol] = aMatrizTabuleiro[iLine][iCol];
        System.out.println(this.aMatrizTabuleiro[iLine][iCol]);
        
        //COLOCA O PERSONAGEM NA NOVA POSIÇÃO
        this.aMatriz[iNewLine][iNewCol] = iPersonagem;

        //NO LUGAR EM QUE ELE ESTAVA É COLOCADO O ELEMENTO ANTERIOR
        

        //
        if (aMatrizTabuleiro[iLine][iLine] == 2) {
            Black[iNewLine][iNewCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
        } else if (aMatrizTabuleiro[iLine][iCol] == 3) {
            Black[iNewLine][iNewCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
        }

        //SUBSTITUI O LABEL PARA A POSIÇÃO NOVA
        Black[iLine][iCol] = Black[iNewLine][iNewCol];
        Black[iNewLine][iNewCol] = null;

        Black[iLine][iCol].setLocation(iXLabel, iYLabel);
        Run.Ghost[iPersonagem - 5].setLocation(iXGhost, iYGhost);
        //System.exit(1);
        
     

        moveGhostRand(iPersonagem);
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
        * 4 - Pacman
        switch (iElementoNoCaminho) {
            case 1:
                //Não meche
                //Se for um Ghost muda a direção
                if (iPersonagem > 4) {
                    moveGhostRand(iPersonagem);
                }
                break;
            case 2:
                this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                this.aMatriz[iLine][iCol] = 2;
                Black[iLine][iCol] = Black[iNewLine][iNewCol];
                Black[iNewLine][iNewCol] = null;
                Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x, Black[iLine][iCol].getLocation().y - 26);
                if (iPersonagem == 4) {
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x, Run.Pacman.getLocation().y + 26);
                } else if (iPersonagem >= 5) {
                    Run.Ghost[0].setLocation(Run.Ghost[0].getLocation().x, Run.Ghost[0].getLocation().y + 26);
                }
                break;
            case 3:
                if (iPersonagem == 4) {
                    this.aMatriz[iNewLine][iNewCol] = iPersonagem;
                    Run.Musica.musicaComer();
                    this.aMatriz[iLine][iCol] = 2;
                    this.aMatrizTabuleiro[iLine][iCol] = 2;
                    Black[iLine][iCol] = Black[iNewLine][iNewCol];
                    Black[iNewLine][iNewCol] = null;
                    Black[iLine][iCol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacman/images/preto.png")));
                    Black[iLine][iCol].setLocation(Black[iLine][iCol].getLocation().x, Black[iLine][iCol].getLocation().y - 26);
                    Run.Pacman.setLocation(Run.Pacman.getLocation().x, Run.Pacman.getLocation().y + 26);
                } else {
                    int[] iPosMatriz = new int[4];
                    int[] iDirection = new int[4];

                    iPosMatriz[0] = iLine;
                    iPosMatriz[1] = iCol;
                    iPosMatriz[2] = iNewLine;
                    iPosMatriz[3] = iNewCol;

                    iDirection[0] = Run.Ghost[iPersonagem - 5].getLocation().x;
                    iDirection[1] = Run.Ghost[iPersonagem - 5].getLocation().y + 26;
                    iDirection[2] = Black[iNewLine][iNewCol].getLocation().x;
                    iDirection[3] = Black[iNewLine][iNewCol].getLocation().y - 26;

                    moverGhost(iPersonagem, iPosMatriz, iDirection);
                }
                break;
            default:
                break;
        }

    }
    */
    
     public void printMatriz(int[][] aMatrizMostrar){        
        for (int iLine = 0; iLine < iLinha; iLine++) {
            System.out.print("[");
            for (int iCol = 0; iCol < iColuna; iCol++) {
                int iElemento = aMatriz[iLine][iCol];                
                System.out.print(" "+iElemento+" ");
            }
            System.out.println("]");
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
                } else if (aMatriz[iLine][iCol] >= 5) {
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
