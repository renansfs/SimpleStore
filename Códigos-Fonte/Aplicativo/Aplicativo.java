/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicativo;

import Loja.Store;
import java.io.IOException;
import java.util.Scanner;

/**
 * <p>Classe Aplicativo</p>
 * <p>(cliente)</p>
 *
 */
public class Aplicativo {

    /**
     *
     * @param args
     * @throws IOException
     * @throws Exception
     */
    public static void main(String[] args) throws IOException, Exception {
        Store inspace = Store.inSpace();
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (true) {
            inspace.mostraMenu();
            System.out.println("\n Opção: \n Sair '1' ou Voltar ao menu '2' \n;");
            i = in.nextInt();

            if (i != 1) {
                continue;
            }
            break;
        }
    }
}
