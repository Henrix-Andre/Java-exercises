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
public class Card {
    //1 = ace, 11 = valete, 12 = rainha, 13 = rei.
    public String nome; //nome da carta
    public String naipe; //0 = paus, 1 = espadas, 2 = copas, 3 = ouros.
    public int valor; //considerar a ideia do ernesto de ter o naipe como número
    //construtor
    public Card(int naipe, int valor) {
        this.setNaipe(naipe);
        this.setValor(valor);
        this.setNome(valor);
    }
    //getters
    public String getNome() {
        return this.nome;
    }
    public String getNaipe() {
        return this.naipe;
    }
    //setters
    public void setNaipe(int naipe) {
        //naipe pede um int como parâmetro
        //mas dá set como string
        if(naipe == 0){
            this.naipe = "Paus";
        }
        else if(naipe == 1){
            this.naipe = "Espadas";
        }
        else if(naipe == 2){
            this.naipe = "Copas";
        }
        else if(naipe == -1){
            //empty serve pra caso de algum erro na contagem da mão do jogador na partida
            //é uma carta nula que não tem valor, serve só pra ocupar espaço caso necessário.
            this.naipe = "empty";
        }
        else{
            this.naipe = "Ouros";
        }
    }
    //aqui pega o 'código' do naipe, caso necessário.
    public int getNaipeCode(){
        int i = 0;
        if(this.getNaipe().equalsIgnoreCase("paus")){
            i = 0;
        }
        else if(this.getNaipe().equalsIgnoreCase("espadas")){
            i = 1;
        }
        else if(this.getNaipe().equalsIgnoreCase("copas")){
            i = 2;
        }
        else if(this.getNaipe().equalsIgnoreCase("ouros")){
            i = 3;
        }
        return i;
    }
    //get e set do valor da carta.
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void setNome(int valor){
        if(this.valor == 1){ //dependendo do valor retorna o nome da carta.
            this.nome = "As";
        }
        else if(this.valor == 11){
            this.nome = "Valete";
        }
        else if(this.valor == 12){
            this.nome = "Rainha";
        }
        else if(this.valor == 13){
            this.nome = "Rei";
        }
        else if(this.valor == 0){
            this.nome = "Carta vazia";
        }
        else{
            //se for de 2 a 10, transforma o valor da carta num string e manda pro nome.
            this.nome = Integer.toString(this.valor); 
        }
    }
}
