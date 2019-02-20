/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuariobanco;

/**
 *
 * @author User
 */
public class ContaBanco {
    public int numconta;
    protected String tipo;
    private boolean statusConta;
    private float saldo;
    private String donoConta;

    public ContaBanco() {
        setSaldo(0);
        setStatusConta(true);
    }
    public void ativarConta(String t, float s, String n, int num){
        setTipo(t);
        setNumconta(num);
        setDonoConta(n);
        setStatusConta(true);
        setSaldo(s);
        if(t == "cc"){
            this.saldo += 50;
        }
        else if(t == "cp"){
            this.saldo += 150;
        }
    }
    public void fecharConta(){
        if(getSaldo() > 0){
            System.out.println("Ainda existem " + this.saldo + " reais na conta. É necessário saca-los antes de poder fechar a conta.");
        }
        else if(getSaldo() == 0){
            System.out.println("Conta fechada.");
            this.setStatusConta(false);
        }
        else{
            System.out.println("Conta com débito, quite tais débitos antes de fechar.");
        }
    }
    public void depositar(float n){
        if(this.isStatusConta() == true){
            this.setSaldo(getSaldo() + n);
        }
        else{
            System.out.println("Conta fechada, não foi possível completar o depósito.");
        }
    }
    public void sacar(float n){
        if(this.isStatusConta() == true && getSaldo() >= n){
            this.setSaldo(getSaldo() - n);
        }
        else if(isStatusConta() == true && getSaldo() < n){
            System.out.println("Saldo insuficiente.");
        }
        else if(isStatusConta() == true && getSaldo() <= 0){
            System.out.println("Conta vazia e/ou em débito.");
        }
        else if(isStatusConta() == false){
            System.out.println("Conta fechada.");
        }
    }
    public void pagarMensalidade(){
        if(this.statusConta == true){
            if(this.tipo.equals("cc")){
                if(getSaldo() >= 12){
                    this.setSaldo(getSaldo() - 12);
                }
                else{
                    System.out.println("Saldo insuficiente");
                }
            }
            else if(this.tipo.equals("cp")){
                if(getSaldo() >= 20){
                    this.setSaldo(getSaldo()-20);
                }
                else{
                    System.out.println("Saldo insuficiente");
                }
            }
        }
        else{
            System.out.println("Conta fechada.");
        }
    }
    private void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }
    
    private void setDonoConta(String donoConta) {
        this.donoConta = donoConta;
    }

    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    private void setNumconta(int numconta) {
        this.numconta = numconta;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }
    private float getSaldo() {
        return saldo;
    }

    public int getNumconta() {
        return numconta;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isStatusConta() {
        return statusConta;
    }

    public String getDonoConta() {
        return donoConta;
    }
    public void checarConta(){
        System.out.println("Status da conta: ");
        System.out.println(this.getDonoConta());
        System.out.println(this.getNumconta());
        if(getTipo().equals("cc")){
            System.out.println("Tipo: conta corrente.");
        }
        else if(getTipo().equals("cp")){
            System.out.println("Tipo: conta poupança.");
        }
        System.out.println("Dono da conta: " + getDonoConta());
        if(getSaldo() > 0){
            System.out.println("Saldo de R$ " + getSaldo());
        }
        else if(getSaldo() < 0){
            System.out.println("Débito de R$ " + getSaldo());
        }
        else{
            System.out.println("Conta vazia.");
        }
        if(isStatusConta()){
            System.out.println("Conta ativa.");
        }
        else{
            System.out.println("Conta inativa.");
        }
    }
}
