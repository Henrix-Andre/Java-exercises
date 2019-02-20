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
public interface Publicacao {
    public abstract void abrir();
    public abstract void fechar();
    public abstract void avancar();
    public abstract void retroceder();
    public abstract void folhear(int p);
    
}
