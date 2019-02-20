/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetoblackjack;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class ProjetoBlackjack {
    public static void main(String[] args) {
        Scanner s1; 
        s1 = new Scanner(System.in); 
        Scanner s2 = new Scanner(System.in);
        //nomes dos jogadores
        String nome1;
        String nome2;
        //saldos e valor da aposta dos jogadores
        int saldo1, saldo2, aposta; 
        int opt;
        //gera o dealer, o contador da partida, e embaralha o baralho.
        int roundNo = 1;
        Dealer d1 = new Dealer();
        d1.baralho.embaralhar();
        System.out.println(".------.------.------.------.------.------.------.------.------.");
        System.out.println("|B.--. |L.--. |A.--. |C.--. |K.--. |J.--. |A.--. |C.--. |K.--. |");
        System.out.println("| :(): | :/\\: | (\\/) | :/\\: | :/\\: | :(): | (\\/) | :/\\: | :/\\: |");
        System.out.println("| ()() | (__) | :\\/: | :\\/: | :\\/: | ()() | :\\/: | :\\/: | :\\/: |");
        System.out.println("| '--'B| '--'L| '--'A| '--'C| '--'K| '--'J| '--'A| '--'C| '--'K|");
        System.out.println("`------`------`------`------`------`------`------`------`------'");
        System.out.println("");
        System.out.println("*------------------------------------------------*");
        System.out.println("Digite o nome do primeiro jogador: ");
        nome1 = s1.nextLine();
        System.out.println("Digite o saldo do primeiro jogador: ");
        saldo1 = s1.nextInt();
        System.out.println("*------------------------------------------------*");
        System.out.println("Digite o nome do segundo jogador: ");
        nome2 = s2.nextLine();
        System.out.println("Digite o saldo do segundo jogador: ");
        saldo2 = s1.nextInt();
        System.out.println("*------------------------------------------------*");
        //Cria os novos jogadores, e esvazia as mãos deles inicialmente p/ garantia.
        Player p1 = new Player(nome1, saldo1);
        Player p2 = new Player(nome2, saldo2);
        do{ //enquanto a opção ainda for a de continuar a jogar, fica rodando esse loop.
            //no começo de cada turno limpa as mãos dos jogadores, para não interferir no resto do jogo.
            p1.clearHand();
            p2.clearHand();
            //checa se um dos jogadores está com o saldo zerado
            if(p1.isBroke() || p2.isBroke()){
                //checa qual dos jogadores está sem saldo, e termina o jogo.
                if(p1.isBroke()){
                    System.out.println(p1.getNome() + " está com o saldo zerado, fim de jogo!");
                    System.out.println("Saldo final de " + p2.getNome() + ": " + p2.getSaldo());
                }
                else if(p2.isBroke()){
                    System.out.println(p2.getNome() + " está com o saldo zerado, fim de jogo!");
                    System.out.println("Saldo final de " + p1.getNome() + ": " + p1.getSaldo());
                }
                opt = 0;
            }
            else{ //pergunta se quer iniciar outra partida
                System.out.println("Iniciar nova partida? (1)Sim, (0)Não");
                opt = s1.nextInt();
            }
            switch(opt){ //switch case pra definir a opção.
                case 1: //aqui roda uma nova partida, que é definida dentro do dealer.
                    System.out.println("*----------------*Round " + roundNo + "*----------------*");
                    System.out.println("Digite o valor a ser apostado: ");
                    aposta = s1.nextInt();
                    d1.partida(p1, p2, aposta);
                    roundNo++;
                    break;
                case 0: //mostra os saldos finais e encerra o programa.
                    System.out.println("*----------------*Jogo Encerrado*----------------*");
                    System.out.println("Saldos finais:");
                    System.out.print(p1.getNome() + ": " +  p1.getSaldo() + ", " + p2.getNome() + ": " + p2.getSaldo() + ". ");
                    System.out.println("");
                    System.out.println("*------------------------------------------------*");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opt != 0);
        s1.close(); //fecha o scanner.
    }
}