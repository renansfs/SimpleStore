/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Classe que reune as operações do cliente
 *
 * @author Galaxy
 *
 */
public class Cliente {

    private Cadastro cliente;
    private Controle principal;

    /**
     * inicializa o cadastro
     */
    public Cliente() {
        cliente = new Cadastro();
    }

    /**
     * @see LerCliente Solicita a leitura do cliente
     *
     */
    public Cadastro ler() throws IOException, InputMismatchException, FileNotFoundException {
        LerCliente um = new LerCliente(cliente);
        principal = new Controle(um);
        principal.pressButton();
        return cliente;
    }

    /**
     * @see Abrir
     *
     * Solicita a abertura do arquivo
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     */
    public void abrir() throws IOException, InputMismatchException, FileNotFoundException {
        Abrir um = new Abrir(cliente);
        principal = new Controle(um);
        principal.pressButton();
    }

    /**
     * <p>Escreve um novo cliente</p>
     *
     * @see EscreverCliente
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     */
    public void adicionar() throws IOException, InputMismatchException, FileNotFoundException {
        EscreverCliente um = new EscreverCliente(cliente);
        principal = new Controle(um);
        principal.pressButton();
    }

    /**
     * Remove um cliente
     *
     * @throws IOException
     */
    public void removerCliente() throws IOException {
        RemoverCliente um = new RemoverCliente(cliente);
        principal = new Controle(um);
        principal.pressButton();
    }
}
