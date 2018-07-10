/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * @author Galaxy
 */
public interface Command {

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     * @throws EOFException
     */
    public void execute() throws IOException, InputMismatchException, FileNotFoundException, EOFException;
}
