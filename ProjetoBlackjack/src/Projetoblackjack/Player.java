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
public class Player {
    private String nome; //nome do jogador
    private int saldo; //seu saldo
    protected Card mao[] = new Card[11]; //a mão do jogador
    private int ncards = 0; //Numero de cartas na mao do jogador
    

    public Player(String nome, int saldo) {
        this.nome = nome; //nome do jogador
        this.saldo = saldo; //saldo do jogador
        this.ncards = 0; //numero de cartas na mao
    }
    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getSaldo() {
        return saldo;
    }
    private void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public Card[] getMao() {
        return mao;
    }
    public void setMao(Card mao, int i) {
        this.mao[i] = mao;
    }
    public int getNcards() {
        return ncards;
    }
    public void setNcards(int ncards) {
        this.ncards = ncards;
    }
    public boolean estourou(){ //retorna true ou false dependendo se a pontuação estourou
        return pontos() > 21;
    }
    public void sacarCarta(Card c){ //adiciona uma carta na mao, e atualiza a contagem
        mao[ncards] = c;
        ncards++;
    }
    public boolean isBroke(){
        if(this.getSaldo() <= 0){ //checa se ainda tem algum saldo.
            return true;
        }
        else{
            return false;
        }
    }
    public int pontos(){
        int pontos = 0;
        for(int i = 0; i < this.ncards; i++){
            if(this.mao[i].getNome().equalsIgnoreCase("as")){ //checa se é um ás
                if(pontos <= 10){ //checa a pontuação p/ definir o valor do ás.
                    pontos += 11;
                }
                else{
                    pontos++;
                }
            }
            else{
                pontos += this.mao[i].getValor(); //se não for ás, só adiciona o valor.
            }
        }
        return pontos;
    }
    //funções pra ajustar o saldo.
    public void contabilizar(int i){
        this.setSaldo(this.getSaldo() + i);
    }
    public void debitar(int i){
        this.setSaldo(this.getSaldo() - i);
    }
    //função para 'esvaziar' a mão do jogador.
    public void clearHand(){ 
        Card cc = new Card(-1,0); //cria uma carta 'nula'
        for(int i = 0; i < this.ncards; i++){ //vai colocando a mão inteira do jogador pra ser esse valor
            this.setMao(cc,0);
        }
        this.ncards = 0; //reseta o nº de cartas na mçao dele
    }
    //função pra sacar uma carta.
    public void sacarCarta(Deck b1){ 
        this.setMao(b1.getBar(this.ncards),this.ncards);
        this.ncards++;
    }
}