/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMDS
 */
public class Relatorio {

    /**
     *
     * @param c
     */
    public static void adicionarAoRelatorio(Carrinho c) {
        FileWriter relatorio = null;
        try {
            relatorio = new FileWriter("Relatorio.txt", true);
            relatorio.write(c.stringCarrinho() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (relatorio != null) {
                    relatorio.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     *
     */
    public static void gerarRelatorio() {
        try {
            FileReader f = new FileReader("Relatorio.txt");
            BufferedReader in = new BufferedReader(f);
            String linha = in.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
