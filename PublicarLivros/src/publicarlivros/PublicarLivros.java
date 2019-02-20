/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicarlivros;

/**
 *
 * @author User
 */
public class PublicarLivros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa c1[] = new Pessoa[2];
        c1[0] = new Pessoa("AAA", 22, 'M');
        c1[1] = new Pessoa("BBB", 23, 'F');
        Livro l1 = new Livro("asdf", 200, "bundesliga", c1[0]);
        System.out.println(l1.detalhes());
        l1.folhear(10);
        l1.abrir();
        l1.folhear(10);
        System.out.println(l1.detalhes());
        l1.folhear(500);
        l1.folhear(1);
        l1.retroceder();
    }
    
}
