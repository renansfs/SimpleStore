/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import Cadastro.Exceptions.ProdutoNotFoundException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * @author Galaxy
 */
public class removerProduto implements Command {

    Carrinho slot;
    Produtos.Cadastro p;

    removerProduto(Carrinho slot, Produtos.Cadastro p) {
        this.slot = slot;
        this.p = p;
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     * @throws EOFException
     * @throws ProdutoNotFoundException
     */
    @Override
    public void execute() throws IOException, InputMismatchException, FileNotFoundException, EOFException, ProdutoNotFoundException {
        if (slot.getCarrinho().containsKey(p.getCodigo())) {// o produto esta no carrinho?
            int count = slot.getCarrinho().get(p.getCodigo());
            if (count == 1) {
                slot.getCarrinho().remove(p.getCodigo());
            } else {
                slot.getCarrinho().put(p.getCodigo(), count - 1);
            }
        } else {
            throw new ProdutoNotFoundException();
        }
    }
}
