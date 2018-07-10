/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import Cadastro.Exceptions.ProdutoEsgotadoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;

/**
 * Classe auxiliar para decrementar produtos do estoque
 *
 * @author Galaxy
 * @see interface Command
 */
public class DecrementaProduto implements Command {

    Cadastro slot;
    int i, cod;

    DecrementaProduto(Cadastro slot, int i) {
        this.i = i;
        this.slot = slot;
        cod = slot.getCodigo();
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     */
    @Override
    public void execute() throws IOException, InputMismatchException {
        RandomAccessFile gravar = null;
        try {
            if (slot.getFile() == null) {
                throw new FileNotFoundException();
            }
            gravar = new RandomAccessFile(slot.getFile(), "rw");
            gravar.seek((slot.size() * cod) + (1 + (Integer.SIZE / 8) + 25 * 2));
            if (gravar.readInt() < i) {
                throw new ProdutoEsgotadoException();
            }
            gravar.seek((slot.size() * cod) + (1 + (Integer.SIZE / 8) + 25 * 2));
            int a = gravar.readInt() - i;
            gravar.seek((slot.size() * cod) + (1 + (Integer.SIZE / 8) + 25 * 2));
            gravar.writeInt(a);

        } catch (ProdutoEsgotadoException e) {
            System.err.println("Produto esgotado.");
        } finally {
            try {
                gravar.close();
            } catch (IOException e) {
                System.err.println("Impossivel fechar arquivo.");
            }
        }
    }
}
