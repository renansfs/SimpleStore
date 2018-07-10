/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import Cadastro.Exceptions.ProdutoNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe que le o arquivo de produtos e salva os dados no parametro do
 * construtor o produto é lido conforme o código digitado pelo usuário
 *
 * @author Galaxy
 */
public class LeProduto implements Command {

    Cadastro slot;
    int cod;

    /**
     * Recebe um cadastro de produtos para os dados
     *
     * @param slot
     */
    LeProduto(Cadastro slot) {
        this.slot = slot;
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     */
    @Override
    public void execute() throws IOException, InputMismatchException, FileNotFoundException {
        if (slot.getFile() == null) {
            throw new FileNotFoundException();
        }
        RandomAccessFile ler = new RandomAccessFile(slot.getFile(), "r");
        Scanner in = new Scanner(System.in);
        System.out.println("\n\n Digite o código do produto: \n");
        long cod = in.nextInt();
        if (cod > 0) {
            ler.seek(cod * slot.size());
        }
        if (ler.readBoolean() == false) {
            throw new ProdutoNotFoundException();
        }
        slot.setCodigo(ler.readInt());
        if (slot.getCodigo() != cod) {
            throw new ProdutoNotFoundException();
        }
        slot.setDescricao(padDesc(ler));
        slot.setQuantidade(ler.readInt());
        slot.setPreco(ler.readDouble());
        try {
            ler.close();
        } catch (IOException e) {
            System.err.printf("Erro irreparável.");
        }


    }

    private static String padDesc(RandomAccessFile file) throws IOException {
        char descricao[] = new char[25], temp;
        for (int count = 0; count < descricao.length; count++) {
            temp = file.readChar();
            descricao[count] = temp;
        }
        return new String(descricao).replace('\0', ' ');
    }

    /**
     *
     * @param cod
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ProdutoNotFoundException
     */
    public void execute(int cod) throws FileNotFoundException, IOException, ProdutoNotFoundException {
        if (slot.getFile() == null) {
            throw new FileNotFoundException();
        }
        RandomAccessFile ler = new RandomAccessFile(slot.getFile(), "r");
        if (cod > 0) {
            ler.seek(cod * slot.size() + 1);
        }
        slot.setCodigo(ler.readInt());
        if (slot.getCodigo() != cod) {
            throw new ProdutoNotFoundException();
        }
        slot.setDescricao(padDesc(ler));
        slot.setQuantidade(ler.readInt());
        slot.setPreco(ler.readDouble());
        try {
            ler.close();
        } catch (IOException e) {
            System.err.printf("Erro irreparável.");
        }
    }
}
