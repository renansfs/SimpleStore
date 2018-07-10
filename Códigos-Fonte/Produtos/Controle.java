/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Classe que aciona o método execute de determinado command
 *
 * @author Galaxy
 */
public class Controle {

    Command slot;

    Controle(Command slot) throws IOException, InputMismatchException, FileNotFoundException {
        this.slot = slot;
    }

    void pressButton() throws IOException {
        slot.execute();
    }
}
