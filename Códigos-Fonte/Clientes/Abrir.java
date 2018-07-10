package Clientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Classe que implementa a função de abrir o arquivo de cadastro de clientes
 *
 * @author Galaxy
 */
public class Abrir implements Command {

    Cadastro slot;

    Abrir(Cadastro slot) {
        this.slot = slot;
    }

    /**
     * Método que abre o arquivo e envia para o Cadastro
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     */
    @Override
    public void execute() throws IOException, InputMismatchException, FileNotFoundException {
        slot.setFile(new File("Cliente.txt"));
    }
}
