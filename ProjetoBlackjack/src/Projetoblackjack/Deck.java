/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetoblackjack;

/**
 *
 * @author User
 */
public class Deck {
    public Card[] c = new Card[52];
    public Deck(){ //construtor
        this.setBaralho();
    }
    public Card getBar(int i) { //getter
        return this.c[i];
    }
    //Gerando o baralho do jeito mais ferrado possível.
    //até tentei fazer loops for em nest pra fazer isso mas não consegui fazer funcionar.
    public void setBaralho(){
        //paus
        this.setBar(0,0,1); //as
        this.setBar(1,0,2);
        this.setBar(2,0,3);
        this.setBar(3,0,4);
        this.setBar(4,0,5);
        this.setBar(5,0,6);
        this.setBar(6,0,7);
        this.setBar(7,0,8);
        this.setBar(8,0,9);
        this.setBar(9,0,10);
        this.setBar(10,0,11); //valete
        this.setBar(11,0,12); //rainha
        this.setBar(12,0,13); //rei
        
        //espadas
        this.setBar(13,1,1); //as
        this.setBar(14,1,2);
        this.setBar(15,1,3);
        this.setBar(16,1,4);
        this.setBar(17,1,5);
        this.setBar(18,1,6);
        this.setBar(19,0,7);
        this.setBar(20,1,8);
        this.setBar(21,1,9);
        this.setBar(22,1,10);
        this.setBar(23,1,11); //valete
        this.setBar(24,1,12); //rainha
        this.setBar(25,1,13); //rei
        
        //copas
        this.setBar(26,2,1); //as
        this.setBar(27,2,2);
        this.setBar(28,2,3);
        this.setBar(29,2,4);
        this.setBar(30,2,5);
        this.setBar(31,2,6);
        this.setBar(32,0,7);
        this.setBar(33,2,8);
        this.setBar(34,2,9);
        this.setBar(35,2,10);
        this.setBar(36,2,11); //valete
        this.setBar(37,2,12); //rainha
        this.setBar(38,2,13); //rei
        
        //ouros
        this.setBar(39,3,1); //as
        this.setBar(40,3,2);
        this.setBar(41,3,3);
        this.setBar(42,3,4);
        this.setBar(43,3,5);
        this.setBar(44,3,6);
        this.setBar(45,0,7);
        this.setBar(46,3,8);
        this.setBar(47,3,9);
        this.setBar(48,3,10);
        this.setBar(49,3,11); //valete
        this.setBar(50,3,12); //rainha
        this.setBar(51,3,13); //rei
    }
    public void setBar(int i, int naipe, int valor) {
        this.c[i] = new Card(naipe, valor); //define uma carta no índice i.
    }
    public void embaralhar(){
        //índices temporários
        int randoA;
        int randoB;
        //cartas temporárias
        Card tempA;
        Card tempB;
        for(int index = 0; index < 52; index++){
            //gera dois índices aleatórios
            randoA = (int) (Math.random() * 52 + 0);
            randoB = (int) (Math.random() * 52 + 0);
            //copia as cartas nos índices gerados dentro do baralho
            tempA = this.getBar(randoA);
            tempB = this.getBar(randoB);
            //sobreescreve os valores das cartas no baralho
            this.c[randoA] = tempB; //A fica com o valor do índice B
            this.c[randoB] = tempA; //B fica com o valor do índice A
            //repete 52 vezes.
        }
    }
}
