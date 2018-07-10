/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import Cadastro.Exceptions.ProdutoEsgotadoException;
import Cadastro.Exceptions.ProdutoNotFoundException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Classe que adiciona um produto ao carrinho, o carrinho e o cadastro de
 * produtos são passados pelo construtor
 *
 * @author Galaxy
 */
public class AdicionaProduto implements Command {

    Carrinho slot;
    Produtos.Cadastro p;

    public AdicionaProduto(Carrinho slot, Produtos.Cadastro p) {
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
        if (p == null) {
            throw new ProdutoNotFoundException();
        }
        if (p.getQuantidade() == 0) {
            throw new ProdutoEsgotadoException();//lancar produto esgotado
        }
        if (slot.getCarrinho().containsKey(p.getCodigo())) {
            int count = slot.getCarrinho().get(p.getCodigo());
            if (p.getQuantidade() - count > 0) {
                slot.getCarrinho().put(p.getCodigo(), count + 1);
            } else {
                throw new ProdutoEsgotadoException();
            }
        } else {
            slot.getCarrinho().put(p.getCodigo(), 1); // produto novo        
        }
    }
}
