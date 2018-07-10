/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import java.io.File;

/**
 * Objeto com todos os dados do cliente
 *
 * @author Galaxy
 */
public class Cadastro {

    private File banco;
    private int codigo;
    private String nome;
    private long cartaoDeCredito;
    private boolean possui = false;

    /**
     * Variável de controle interno
     *
     * @return
     */
    public boolean get() {
        return possui;
    }

    /**
     * Variável de controle interno
     *
     * @param possui
     */
    public void set(boolean possui) {
        this.possui = possui;
    }

    /**
     * Retorna o cartao de credito
     *
     * @return
     */
    public long getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    /**
     * seta o cartao de credito
     *
     * @param cartaoDeCredito
     */
    public void setCartaoDeCredito(long cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }

    /**
     *
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Insere um arquivo para gravação dos dados
     *
     * @param banco
     */
    public void setFile(File banco) {
        this.banco = banco;
    }

    /**
     * Retorna o arquivo relacionado com a gravação dos dados
     *
     * @return
     */
    public File getFile() {
        return banco;
    }

    /**
     * Retorna o tamanho do registro
     *
     * @return
     */
    public static int size() {
        return (Long.SIZE / 8) + 25 * Character.SIZE + (Integer.SIZE / 8);
    }
}
