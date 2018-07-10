/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
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
