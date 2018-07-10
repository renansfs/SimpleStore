/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import Cliente.Exceptions.ClienteNotFoundException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Set;

/**
 *
 * @author Galaxy
 */
public class Encerrar implements Command {

    Carrinho slot;

    /**
     *
     * @param slot
     */
    public Encerrar(Carrinho slot) {
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
        if (slot.getCliente() == -1) {
            throw new ClienteNotFoundException();
        }
        Set<Integer> codigos = slot.getCarrinho().keySet();
        Relatorio.adicionarAoRelatorio(slot);
    }
}
