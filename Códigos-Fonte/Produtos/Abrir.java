package Produtos;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Classe que abre o arquivo de produtos
 *
 * @author Galaxy
 */
public class Abrir implements Command {

    Cadastro slot;

    Abrir(Cadastro slot) {
        this.slot = slot;
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     */
    @Override
    public void execute() throws IOException, InputMismatchException {
        File file = new File("Produto.bin");
        slot.setFile(file);
    }
}
