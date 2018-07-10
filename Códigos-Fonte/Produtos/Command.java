/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Interface command
 *
 * @author Galaxy
 */
public interface Command {

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     */
    public void execute() throws IOException, InputMismatchException;
}
