/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Galaxy
 */
public class Run {

    Carrinho carrinho;
    Controle principal;
    private Command Command;

    /**
     *
     * @param e
     */
    public Run(Clientes.Cadastro e) {
        carrinho = new Carrinho(e);
    }

    /**
     *
     * @param p
     * @throws IOException
     */
    public HashMap<Integer, Integer> getCarrinho() {
        return carrinho.getCarrinho();
    }

    public String stringCarrinho() throws IOException {
        return carrinho.stringCarrinho();
    }

    public int getCliente() {
        return carrinho.getCliente();
    }

    public void addProduto(Produtos.Cadastro p) throws IOException {
        AdicionaProduto add = new AdicionaProduto(carrinho, p);
        principal = new Controle((Loja.Carrinho.Command) add);
        principal.pressButton();
    }

    /**
     *
     * @param p
     * @throws IOException
     */
    public void setRemoverProduto(Produtos.Cadastro p) throws IOException {
        removerProduto remover = new removerProduto(carrinho, p);
        principal = new Controle((Command) remover);
        principal.pressButton();
    }

    /**
     *
     * @throws IOException
     */
    public void finalizar() throws IOException {
        Encerrar fim = new Encerrar(carrinho);
        principal = new Controle(fim);
        principal.pressButton();
    }

    /**
     *
     * @throws IOException
     */
    public void ImprimirCarrinho() throws IOException {
        ImprimirCarrinho imprimir = new ImprimirCarrinho(carrinho);
        principal = new Controle((Command) imprimir);
        principal.pressButton();
    }
}
