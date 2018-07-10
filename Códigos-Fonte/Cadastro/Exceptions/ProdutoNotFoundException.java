package Cadastro.Exceptions;

import java.io.FileNotFoundException;

/**
 * Exceção do tipo produto esgotado<br/>
 * Ocorre quando não há itens no estoque
 *
 * @author LMDS
 */
public class ProdutoNotFoundException extends FileNotFoundException {

    /**
     * <p>Notifica que o produto não foi encontrado</p>
     */
    public ProdutoNotFoundException() {
        super("Produto não encontrado");
    }

    /**
     * <p>Oferece a opção de sobrepor a mensagem da exceção</p>
     *
     * @param msg
     */
    public ProdutoNotFoundException(String msg) {
        super(msg);
    }
}
