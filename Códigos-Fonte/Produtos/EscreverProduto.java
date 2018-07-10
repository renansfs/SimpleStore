/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe que grava um produto no arquivo a partir dos dados inseridos pelo
 * usuário
 *
 * @author Galaxy
 */
public class EscreverProduto implements Command {

    Cadastro slot;

    EscreverProduto(Cadastro slot) {
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
        if (slot.getFile() == null) {
            throw new FileNotFoundException();
        }
        RandomAccessFile gravar = new RandomAccessFile(slot.getFile(), "rw");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\nDigite o codigo para cadastro do produto: ");
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
                        System.out.printf("Código já cadastrado em: \n Codigo: %d \n "
                                + "Descrição: %s \n Quantidade: %d \n Preco: %f ",
                                gravar.readInt(), padName(gravar), gravar.readInt(), gravar.readDouble());
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

        while (true) {
            try {
                in.nextLine();
                System.out.println("\nDigite a descrição: ");
                slot.setDescricao(in.next());
                break;
            } catch (InputMismatchException e) {
                System.err.printf("\nDescricao invalida, tente novamente.");
            }
        }

        while (true) {
            in.nextLine();
            System.out.println("\nDigite a quantidade: ");
            slot.setQuantidade(in.nextInt());
            if (slot.getQuantidade() < 0) {
                continue;
            }
            break;
        }

        while (true) {
            in.nextLine();
            System.out.println("\nDigite o preco: ");
            slot.setPreco(in.nextDouble());
            if (slot.getPreco() < 0) {
                continue;
            }
            break;
        }

        gravar.seek(slot.getCodigo() * slot.size());
        gravar.writeBoolean(true);
        gravar.writeInt(slot.getCodigo());
        escreverDescricao(gravar, slot.getDescricao());
        gravar.writeInt(slot.getQuantidade());
        gravar.writeDouble(slot.getPreco());
        gravar.seek(slot.getCodigo() * slot.size() + 1);
        System.out.printf("Cadastrado com sucesso: \n Codigo: %d \n "
                + "Descrição: %s \n Quantidade: %d \n Preco: %f ",
                gravar.readInt(), padName(gravar), gravar.readInt(), gravar.readDouble());
        try {
            gravar.close();
        } catch (IOException e) {
            System.err.printf("Erro irreparável.");
        }

    }

    private static void escreverDescricao(RandomAccessFile file, String desc) throws IOException {
        StringBuffer buffer = null;
        if (desc != null) {
            buffer = new StringBuffer(desc);
        } else {
            buffer = new StringBuffer(25);
        }
        buffer.setLength(25);
        file.writeChars(buffer.toString());
    }

    private String padName(RandomAccessFile file) throws IOException {
        char descricao[] = new char[25], temp;
        for (int count = 0; count < descricao.length; count++) {
            temp = file.readChar();
            descricao[count] = temp;
        }
        return new String(descricao).replace('\0', ' ');
    }
}
