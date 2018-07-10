/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Interface
 *
 * @author Galaxy
 */
public interface Command {

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     */
    void execute() throws IOException, InputMismatchException, FileNotFoundException;
}
