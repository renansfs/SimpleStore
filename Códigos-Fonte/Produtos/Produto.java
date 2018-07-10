/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import Cadastro.Exceptions.ProdutoNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe que reune as operações do produto.
 *
 * @author Galaxy
 */
public class Produto {

    Cadastro produto;
    Controle principal;

    /**
     *
     */
    public Produto() {
        produto = new Cadastro();
    }

    /**
     *
     * @param cod
     * @param i
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     */
    public void decrementa(Produtos.Cadastro p, int i) throws IOException, InputMismatchException, FileNotFoundException {
        DecrementaProduto decrementa = new DecrementaProduto(p, i);
        principal = new Controle(decrementa);
        principal.pressButton();
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     */
    public void registrar() throws IOException, InputMismatchException, FileNotFoundException {
        EscreverProduto um = new EscreverProduto(produto);
        principal = new Controle(um);
        principal.pressButton();
    }

    public Cadastro ler() throws IOException, InputMismatchException, FileNotFoundException {
        LeProduto ler = new LeProduto(produto);
        principal = new Controle(ler);
        principal.pressButton();
        Scanner in = new Scanner(System.in);
        int pronto = 0;
        System.out.printf("Você deseja fazer a compra de %s ? "
                + "Digite '1' para sim ou '2' para nao:\n", produto.getDescricao());
        while (true) {
            try {
                pronto = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.printf("\nApenas numeros.\n");
            }
        }
        if (pronto == 1) {
            // decrementa(produto, 1);
            return produto;
        }
        return null;
    }

    public Cadastro ler(int cod) throws FileNotFoundException, ProdutoNotFoundException, IOException {
        LeProduto le = new LeProduto(produto);
        le.execute(cod);
        return produto;
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     */
    public void abrir() throws IOException, InputMismatchException, FileNotFoundException {
        Abrir novo = new Abrir(produto);
        novo.execute();
    }

    /**
     *
     * @throws IOException
     */
    public void removerProduto() throws IOException {
        RemoverProduto um = new RemoverProduto(produto);
        principal = new Controle(um);
        principal.pressButton();
    }
}
