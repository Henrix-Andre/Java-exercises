/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicarlivros;
import static java.lang.Math.random;
import java.util.Random;
/**
 *
 * @author User
 */
public class Livro implements Publicacao{
    private String nome;
    private int paginas;
    private int pAtual;
    private String autor;
    private boolean aberto;
    private Pessoa leitor;

    public String detalhes() {
        return "Livro{" + "nome=" + nome + ",\n paginas=" + paginas + ",\n pAtual=" + pAtual + ",\n autor=" + autor + ",\n aberto=" + aberto + ",\n leitor=" + this.leitor.getNome() + '}';
    }

    public Livro(String nome, int paginas, String autor, Pessoa leitor) {
        this.nome = nome;
        this.paginas = paginas;
        this.autor = autor;
        this.leitor = leitor;
        this.aberto = false;
        this.pAtual = 1;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public int getPaginas() {
        return paginas;
    }

    private void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getpAtual() {
        return pAtual;
    }

    private void setpAtual(int pAtual) {
        this.pAtual = pAtual;
    }

    public String getAutor() {
        return autor;
    }

    private void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isAberto() {
        return aberto;
    }

    private void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }
    @Override
    public void abrir() {
        if(this.aberto){
            System.out.println("Já está aberto.");
        }
        else{
            this.setAberto(true);
        }
    }

    @Override
    public void fechar() {
        if(!this.aberto){
            System.out.println("Já está fechado.");
        }
        else{
            this.setAberto(false);
        }
    }

    @Override
    public void avancar() {
        if(this.aberto){
            if(this.getpAtual() < this.getPaginas()){
                this.setpAtual(this.getpAtual() + 1);
            }
            else if(this.getpAtual() >= this.getPaginas()){
                System.out.println("Já está no final do livro!");
            }
        }
        else{
            System.out.println("Livro fechado");
        }
    }

    @Override
    public void retroceder() {
        if(this.aberto){
            if(this.getpAtual() > 1){
                this.setpAtual(this.getpAtual() + 1);
            }
            else if(this.getpAtual() == 1){
                System.out.println("Já está no começo do livro!");
            }
        }
        else{
            System.out.println("Livro fechado");
        }
    }

    @Override
    public void folhear(int P) {
        if(this.aberto){
            if(P > this.getPaginas() || P < 1){
                System.out.println("Página inexistente!");
            }
            else{
                this.setpAtual(P);
                System.out.println("foi a pagina " + P);
            }
        }
        else{
            System.out.println("Livro fechado");
        }
    }
}
