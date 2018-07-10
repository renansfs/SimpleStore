/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja.Carrinho;

import Cadastro.Exceptions.ProdutoEsgotadoException;
import Cadastro.Exceptions.ProdutoNotFoundException;
import Produtos.Produto;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


/**
 *
 * @author LMDS
 */
public class Carrinho{
    //Produtos.Cadastro p;
    private int codigoCliente=-1;  
    HashMap<Integer, Integer> carrinho;

   /* void setProduto(Produtos.Cadastro p){
        this.p = p;
    }*/
    /**
     *
     * @param c
     */
    public Carrinho(Clientes.Cadastro c){     
        carrinho = new HashMap< Integer, Integer >();
        // hashMap que mapeia os produtos por codigo no carrinho
        if(c!=null)codigoCliente=c.getCodigo();     
    }
    
    /**
     *
     * @return
     */
    public int getCliente(){
        return codigoCliente;
    }
    
    /**
     *
     * @return
     */
    public int getCodigo(){
        return codigoCliente;
    }
   public HashMap<Integer, Integer> getCarrinho(){
        return carrinho;
    }
    void setCarrinho(HashMap<Integer, Integer> carrinho){
        this.carrinho = carrinho;
    }
    
     /**
     *
     * @return
     * @throws IOException
     */
    public String stringCarrinho() throws IOException{
        Set<Integer> chaves= getCarrinho().keySet();
        Double precoTotal=0.0;
        String Relatorio= ("Cliente:"+getCliente()+"\nCódigo:\tDescrição:\t\t\tQuantidade:\tPreço:\tTotal\t\n");
        for ( Integer i : chaves ){
           Produto prod= new Produto();
           prod.abrir();
           Produtos.Cadastro p =prod.ler(i);
         
        Relatorio+=(i+"\t"+p.getDescricao()+"\t"+carrinho.get(i)+"\t\t"+ p.getPreco()+"\t"+carrinho.get(i)*p.getPreco()+"\n" );
         precoTotal+=p.getPreco()*carrinho.get(i);
        }
        Relatorio+=("Total:\t"+precoTotal+"\n");
        return Relatorio;  

    }
    //insuficiente
    public void addProduto(Produtos.Cadastro p){
       try{
        AdicionaProduto a= new AdicionaProduto(this, p);
        a.execute();
       }catch (ProdutoEsgotadoException e){
           System.err.println(e.getMessage());
       } catch (ProdutoNotFoundException ex) {
            System.out.println("Produto não encontrado.");
        }catch (IOException ex) {
           
        } 
    }
    
    public void removeProduto(Produtos.Cadastro p){
        try{
            removerProduto a= new removerProduto(this, p);
            a.execute();
           }catch (ProdutoEsgotadoException e){
               System.err.println(e.getMessage());
           } catch (ProdutoNotFoundException ex) {
                System.out.println("Produto não está no carrinho.");
            }catch (IOException ex) {

            } 
    }
}
