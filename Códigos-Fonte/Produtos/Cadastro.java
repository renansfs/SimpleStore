package Produtos;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Classe que contém os dados do produto
 *
 * @author Galaxy
 */
public class Cadastro {

    private File banco;
    private int codigo;
    private String descricao;
    private double preco;
    private int quantidade;
    private boolean possui = false;

    /**
     * Variável para controle interno
     *
     * @return possui
     */
    public boolean get() {
        return possui;
    }

    /**
     * Variável para controle interno
     *
     * @param possui
     */
    public void set(boolean possui) {
        this.possui = possui;
    }

    /**
     * Retorna o arquivo para gravação do cliente
     *
     * @return
     */
    public File getFile() {
        return banco;
    }

    /**
     * Seta o arquivo
     *
     * @param banco
     */
    public void setFile(File banco) {
        this.banco = banco;
    }

    /**
     * retorna o codigo do produto
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Seta o código do produto
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna a descrição do produto
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Seta a descrição do produto
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * getPreco
     *
     * @return
     */
    public double getPreco() {
        return preco;
    }

    /**
     * SetPreco
     *
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * getQuantidade
     *
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * SetQuantidade
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o tamanho fixo da classe.
     *
     * @return
     */
    public static int size() {
        return (Integer.SIZE / 8) * 2 + 1 + (Double.SIZE / 8) + 25 * 2;
    }
}
