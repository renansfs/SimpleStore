package Clientes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Classe invocadora no padrão Command
 *
 * @author Galaxy
 */
public class Controle {

    Command slot;

    Controle(Command slot) {
        this.slot = slot;
    }

    /**
     * Aciona o método de determinado Command
     *
     */
    void pressButton() throws IOException, InputMismatchException, FileNotFoundException {
        slot.execute();
    }
}