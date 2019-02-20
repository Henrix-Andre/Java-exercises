/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetoblackjack;

import java.util.Scanner;
public class Dealer {
    //vai controlar o jogo
    //mostra as cartas de cada jogador
    //mostra os valores das maõs deles
    //faz as comparações necessárias e/ou se alguem deu bust.
    private boolean p1Turn; //true: é o turno do jogador 1 | false: não é o turno do jogador 1.
    private boolean p2Turn; //mesma coisa que o p1Turn, mas pro player 2.
    private boolean partida; //define se a partida ainda está continuando.
                             //true: partida terminou | false: partida em andamento.
    public Deck baralho = new Deck();
    //getters e setters
    public boolean isP1Turn() {
        return p1Turn;
    }
    private void setP1Turn(boolean p1Turn) {
        this.p1Turn = p1Turn;
    }
    public boolean isP2Turn() {
        return p2Turn;
    }
    private void setP2Turn(boolean p2Turn) {
        this.p2Turn = p2Turn;
    }
    public boolean isPartida() {
        return partida;
    }
    private void setPartida(boolean partida) {
        this.partida = partida;
    }
    //loop básico p/mostrar a mão do jogador
    //serve mais pra não ter que ficar repetindo essa linha de código
    public void mostrarMao(Player p2){
        int j = p2.getNcards();
        for(int i = 0; i < j; i++){
           System.out.print("[" + p2.mao[i].getNome()+ " de " + p2.mao[i].getNaipe() + "] ");
        }
    }
    //método que inicia a partida.
    public void partida(Player p1, Player p2, int aposta){
        this.baralho.embaralhar(); //embaralha o baralho
        //pra poder pegar as opções dos jogadores
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        //a variável contagem define a 'posição' que estamos no baralho, ou seja: qual índice é o topo.
        //a váriavel opt só serve pra definir a opção do jogador.
        int contagem = 0, opt;
        //esvazia as mãos dos jogadores
        //aqui nesse caso pode até ser redundante, mas é por segurança
        p1.clearHand();
        p2.clearHand();
        boolean roundEnd = false; //define se o round como um todo acabou para partir para a checagem do vencedor. 
                                  //true: acabou | false: ainda em andamento.
        this.setPartida(false);   //define se a partida acabou, os dois servem pra controlar o loop de partida.  
        p1Turn = true; //define se é o turno do jogador 1, true: sim | false: não.
        p2Turn = false; //mesma coisa que o p1Turn, mas pro segundo jogador.
        System.out.println("*--------------------Turno do " + p1.getNome() + "--------------------*");
        while(!this.isPartida()){
            //cada jogador começa com duas cartas
            p1.sacarCarta(this.baralho.c[contagem]); //saca uma carta
            contagem++; //avança no índice
            //repete o processo mais uma vez.
            p1.sacarCarta(this.baralho.c[contagem]);
            contagem++;
            mostrarMao(p1); //mostra a mão do jogador
            if(p1.pontos() == 21 || p1.estourou()){ //checa se 
                roundEnd = true;
            }
            else{
                while(!p1.estourou() && this.isP1Turn()){ //se o jogador 1 não estourou, e ainda é o turno dele:
                    //pergunta se ele quer sacar mais uma carta
                    System.out.println("Sacar nova carta? (1)Sim, (2)Não/terminar turno");
                    opt = s1.nextInt();
                    switch(opt){ //switch case pra checar a opção do jogador
                        case 1:
                            p1.sacarCarta(this.baralho.c[contagem]); //saca uma carta do baralho no índice definido
                            contagem++; //avança o índice.
                            break;
                        case 2:
                            System.out.println("Encerrando turno.");
                            this.setP1Turn(false);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    mostrarMao(p1); //mostra a mão do jogador 1.
                    System.out.println("");
                }
            }
            this.setP2Turn(true);
            System.out.println("*--------------------Turno do " + p2.getNome() + "--------------------*");
            //se o round ainda está em andamento, e é o turno do jogador 2, e o jogador 1 não estourou
            //segue a mesma lógica do turno do player 1.
            if(roundEnd == false && this.isP2Turn() && !p1.estourou()){ 
                p2.sacarCarta(this.baralho.c[contagem]);
                contagem++;
                p2.sacarCarta(this.baralho.c[contagem]);
                contagem++;
                mostrarMao(p2);
                if(p2.pontos() == 21 || p2.estourou()){
                    roundEnd = true;
                }
                else{
                    while(!p2.estourou() && this.isP2Turn()){
                        System.out.println("Sacar nova carta? (1)Sim, (2)Não/terminar turno");
                        opt = s2.nextInt();
                        switch(opt){
                            case 1:
                                p2.sacarCarta(this.baralho.c[contagem]);
                                contagem++;
                                break;
                            case 2:
                                System.out.println("Encerrando turno.");
                                this.setP2Turn(false);
                                roundEnd = true;
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        mostrarMao(p2);
                        
                    }
                }
                //se acabou o turno, checa o vencedor.
                if(roundEnd = true){
                    if(p1.estourou()){ //se o p1 estourou
                        System.out.println("Jogador 1 estourou! Jogador 2 vence!");
                        System.out.println("P2 ganhou: " + aposta + " creditos.");
                        System.out.println("P1 perdeu: " + aposta + " creditos.");
                        p2.contabilizar(aposta); //p2 recebe a aposta
                        p1.debitar(aposta); //p1 perde o dinheiro da aposta
                        this.setPartida(true);
                    }
                    else if(p2.estourou()){ //se o p2 estourou
                        //segue a mesma lógica de antes.
                        System.out.println("Jogador 2 estourou! Jogador 1 vence!");
                        System.out.println("P1 ganhou: " + aposta + " creditos.");
                        System.out.println("P2 perdeu: " + aposta + " creditos.");
                        p1.contabilizar(aposta);
                        p2.debitar(aposta);
                        this.setPartida(true);
                    }
                    //aqui é para ver quem tem a maior pontuação.
                    //o jogador com a pontuação mais alta ganha.
                    else if(p2.pontos() > p1.pontos()){
                        System.out.println("Jogador 2 tem a maior pontuação, Jogador 2 vence!");
                        System.out.println("P2 ganhou: " + aposta + " creditos.");
                        System.out.println("P1 perdeu: " + aposta + " creditos.");
                        p2.contabilizar(aposta);
                        p1.debitar(aposta);
                        this.setPartida(true);
                    }
                    else if(p1.pontos() > p2.pontos()){
                        System.out.println("Jogador 1 tem a maior pontuação, Jogador 1 vence!");
                        System.out.println("P1 ganhou: " + aposta + " creditos.");
                        System.out.println("P2 perdeu: " + aposta + " creditos.");
                        p1.contabilizar(aposta);
                        p2.debitar(aposta);
                        this.setPartida(true);
                    }
                    //aqui é no caso de empatarem.
                    else if(p1.pontos() == p2.pontos()){
                        System.out.println("Empate! Ambos os jogadores tem a mesma pontuação.");
                        System.out.println("Ninguém recebe ou perde nada!");
                        this.setPartida(true);
                    }
                }
            }
        }
    }
}
