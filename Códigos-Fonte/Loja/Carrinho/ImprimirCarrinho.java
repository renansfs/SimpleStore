/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * @author Galaxy
 */
public class ImprimirCarrinho implements Command {

    Carrinho slot;

    public ImprimirCarrinho(Carrinho slot) {
        this.slot = slot;
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     * @throws EOFException
     */
    @Override
    public void execute() throws IOException, InputMismatchException, FileNotFoundException, EOFException {
        try {
            System.out.println(slot.stringCarrinho());
        } catch (IOException ex) {
            System.out.println("Erro inesperado.");
        }
    }
}
