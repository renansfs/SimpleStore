/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Galaxy
 */
public class RemoverProduto implements Command {

    Cadastro slot;

    /**
     *
     * @param slot
     */
    public RemoverProduto(Cadastro slot) {
        this.slot = slot;
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     */
    @Override
    public void execute() throws IOException, InputMismatchException {
        if (slot.getFile() == null) {
            throw new IOException();
        }
        RandomAccessFile file = new RandomAccessFile(slot.getFile(), "rw");
        Scanner in = new Scanner(System.in);
        int cod = 0;
        while (true) {
            try {
                System.out.println("\nDigite o codigo:");
                cod = in.nextInt();
                file.seek(cod * slot.size());
                file.writeBoolean(false);
                System.out.println("Removido com sucesso.");
                break;
            } catch (InputMismatchException e) {
                System.err.println("Apenas numeros. Tente novamente. \n");
            }
        }
        try {
            file.close();
        } catch (IOException e) {
            System.err.printf("Erro irreparável.");
        }
    }
}
