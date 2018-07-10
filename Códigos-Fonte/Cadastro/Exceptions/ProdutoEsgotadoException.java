package Cadastro.Exceptions;

import java.io.FileNotFoundException;

/**
 * Exceção do tipo produto esgotado
 *
 * @author LMDS
 */
public class ProdutoEsgotadoException extends FileNotFoundException {

    /**
     * Informa a exceção ocorrida.
     *
     */
    public ProdutoEsgotadoException() {
        super("Não Há quantidade suficiente no estoque");
    }

    /**
     * Oferece a opção de sobrepor a mensagem de erro
     *
     * @param msg
     *
     */
    public ProdutoEsgotadoException(String msg) {
        super(msg);
    }
}
