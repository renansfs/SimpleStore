package Cliente.Exceptions;

import java.io.FileNotFoundException;

/**
 * Ocorre quando o cliente não foi encontrado
 *
 * @author LMDS
 *
 */
public class ClienteNotFoundException extends FileNotFoundException {

    /**
     * Notifica que o cliente não foi encontrado
     */
    public ClienteNotFoundException() {
        super("Cliente nÃo encontrado.");
    }

    /**
     * Oferece a opção de especificar a mensagem do erro
     *
     * @param msg
     */
    public ClienteNotFoundException(String msg) {
        super(msg);
    }
}
