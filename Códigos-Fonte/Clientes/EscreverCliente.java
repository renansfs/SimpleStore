/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Armazena o cadastro do cliente
 *
 * @author Galaxy
 */
public class EscreverCliente implements Command {

    Cadastro slot;

    EscreverCliente(Cadastro slot) {
        this.slot = slot;
    }

    /**
     * Interage com o usuário e cria um cliente
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     * @throws EOFException
     */
    @Override
    public void execute() throws IOException, InputMismatchException, FileNotFoundException, EOFException {
        if (slot.getFile() == null) {
            throw new FileNotFoundException();
        }
        RandomAccessFile gravar = new RandomAccessFile(slot.getFile(), "rw");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\nDigite o codigo para cadastro: ");
            do {
                try {
                    slot.setCodigo(in.nextInt());
                } catch (InputMismatchException e) {
                    System.err.println("\nApenas numeros, tente novamente.");
                    in.nextLine();
                }
            } while (slot.getCodigo() < 0);
            gravar.seek(slot.getCodigo() * slot.size());
            try {
                if (gravar.readBoolean() == true) {
                    try {

                        System.out.printf("Código já cadastrado em: \n Codigo: %d \n Nome: %s \n Cartao de credito: %d \n ",
                                gravar.readInt(), EscreverCliente.padName(gravar), gravar.readLong());
                        System.err.printf("\nDigite '1' para atualizar ou '2' para retornar ao menu'");
                        int i = in.nextInt();
                        if (i == 1) {
                            break;
                        } else {
                            return;
                        }
                    } catch (InputMismatchException e) {
                    }
                }
            } catch (EOFException e) {
                break;
            }
            break;
        }
        System.out.println("\nDigite o nome do cliente: ");
        slot.setNome(in.next());

        while (true) {
            try {
                System.out.println("\nDigite o Numero do cartao: ");
                slot.setCartaoDeCredito(in.nextLong());
                break;
            } catch (InputMismatchException e) {
                System.err.println("Apenas números, tente novamente");
                in.nextLine();
            }
        }
        gravar.seek(slot.getCodigo() * slot.size());
        gravar.writeBoolean(true);
        gravar.writeInt(slot.getCodigo());
        escreverNome(gravar, slot.getNome());
        gravar.writeLong(slot.getCartaoDeCredito());
        gravar.seek(slot.getCodigo() * slot.size() + 1);
        System.out.printf("Cadastro feito com sucesso. \n Dados: \n Codigo: %d \n Nome: %s \n Cartao de credito: %d \n ",
                gravar.readInt(), padName(gravar), gravar.readLong());
        try {
            gravar.close();
        } catch (IOException e) {
            System.err.printf("Erro irreparável.");
        }
    }

    private void escreverNome(RandomAccessFile file, String desc) throws IOException {
        StringBuffer buffer = null;
        if (desc != null) {
            buffer = new StringBuffer(desc);
        } else {
            buffer = new StringBuffer(25);
        }
        buffer.setLength(25);
        file.writeChars(buffer.toString());
    }

    private static String padName(RandomAccessFile file) throws IOException {
        char descricao[] = new char[25], temp;
        for (int count = 0; count < descricao.length; count++) {
            temp = file.readChar();
            descricao[count] = temp;
        }
        return new String(descricao).replace('\0', ' ');
    }
}
