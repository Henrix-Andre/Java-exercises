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
public class UsuarioBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContaBanco c1 = new ContaBanco();
        c1.ativarConta("cp",50,"Robisvaldo",225);
        c1.checarConta();
        c1.fecharConta();
        c1.sacar(180);
        c1.pagarMensalidade();
        c1.checarConta();
        c1.fecharConta();
        System.out.println("Status da conta: " + c1.isStatusConta());
    }
    
}
