/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loja;

import Cadastro.Exceptions.ProdutoEsgotadoException;
import Cadastro.Exceptions.ProdutoNotFoundException;
import Clientes.Cliente;
import Loja.Carrinho.Carrinho;
import Loja.Carrinho.Run;
import Produtos.Cadastro;
import Produtos.Produto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe mediadora
 *
 * @author Galaxy
 */
public class Store {

    Produtos.Cadastro produto;
    Clientes.Cadastro cliente;
    Carrinho carrinho;
    Run car;
    Produto p;
    Cliente c;
    private static Store INSPACE;

    private Store() {
        p = new Produto();
        c = new Cliente();
    }

    /**
     *
     * @throws IOException
     * @throws Exception
     */
    public void mostraMenu() throws IOException, Exception {
        Scanner in = new Scanner(System.in);
        int remover = 0, aux = 0;
        System.out.println("MENU");
        System.out.println("Escolha a opção: \n 1- Cadastro ou Atualizar Cliente "
                + "\n 2- Cadastro ou Atualização de produtos"
                + " \n 3- Remover Produto\n 4- Remover Cliente"
                + "\n 5- Vender Produto \n 6- Gerar Relatorio \n Digite: ");
        while (true) {
            try {
                aux = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Numero Invalido, tente novamente");
                in.nextLine();
            }
            System.out.println("\n");
        }
        /*
         * switch do menu
         */
        switch (aux) {
            case 1: {
                try {
                    c.abrir();
                    c.adicionar();
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Tentativa de inserir invalida, tente novamente.");
                } catch (FileNotFoundException e) {
                    System.err.println("Erro ao ler arquivo.");
                } catch (IOException e) {
                    System.err.println("Erro de arquivo.");
                } catch (Exception e) {
                    System.err.println("Erro irreparavel.");
                }
            }

            case 2:
                while (true) {
                    try {
                        p.abrir();
                        p.registrar();
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Tentativa de inserir invalida, tente novamente.");
                    } catch (FileNotFoundException e) {
                        System.err.println("Erro ao ler arquivo.");
                    } catch (IOException e) {
                        System.err.println("Erro de arquivo.");
                    } catch (Exception e) {
                        System.err.println("Erro irreparavel.");
                    }
                }
                break;

            case 3: {
                while (true) {
                    try {
                        p.abrir();
                        p.removerProduto();
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Tentativa de inserir invalida, tente novamente.");
                    } catch (FileNotFoundException e) {
                        System.err.println("Erro ao ler arquivo.");
                    } catch (IOException e) {
                        System.err.println("Erro de arquivo.");
                    } catch (Exception e) {
                        System.err.println("Erro irreparavel.");
                    }
                }
                break;

            }
            case 4: {
                while (true) {
                    try {
                        c.abrir();
                        c.removerCliente();
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Tentativa de inserir invalida, tente novamente.");
                    } catch (FileNotFoundException e) {
                        System.err.println("Erro ao ler arquivo.");
                    } catch (IOException e) {
                        System.err.println("Erro de arquivo.");
                    } catch (Exception e) {
                        System.err.println("Erro irreparavel.");
                    }
                }
                break;
            }
            case 5: {
                try {
                    Cliente c = new Cliente();
                    c.abrir();
                    Produto p = new Produto();
                    p.abrir();
                    Clientes.Cadastro cliente = c.ler();
                    Run car = new Run(cliente);
                    //Scanner in=new Scanner(System.in);
                    do {
                        System.out.println(
                                "'1' Adicionar produto ao carrinho\n"
                                + "'2' Remover produto do carrinho\n"
                                + "'3' Fechar a compra,\n"
                                + "'4' Ver carrinho\n"
                                + "'0' Cancelar a compra.");
                        int controle = in.nextInt();
                        switch (controle) {
                            case 0:
                                return;
                            case 1: {
                                try {
                                    System.out.println("Digite o codigo do produto a ser adicionado");
                                    int cod = in.nextInt();
                                    //Produto prod = new Produto();

                                    Produtos.Cadastro cad = p.ler(cod);
                                    car.addProduto(cad);
                                } catch (ProdutoNotFoundException e) {
                                    System.err.println("Produto não encontrado");
                                } catch (ProdutoEsgotadoException e) {
                                    System.err.println("Produto esgotado");
                                } catch (Exception e) {
                                    System.err.println("Não encontrado.");
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Digite o codigo do produto a ser removido.");
                                int cod = in.nextInt();
                                try {
                                    Produto prod = new Produto();
                                    Produtos.Cadastro cad = p.ler(cod);
                                    car.setRemoverProduto(cad);
                                } catch (ProdutoNotFoundException e) {
                                    System.err.println("Produto não está no carrinho");
                                } catch (Exception e) {
                                    System.err.println("Erro");
                                }
                                break;
                            }
                            case 3: {
                                try {
                                    HashMap<Integer, Integer> hash = car.getCarrinho();
                                    Set<Integer> codigos = hash.keySet();
                                    for (Integer i : codigos) {
                                        Produto x = new Produto();
                                        x.abrir();
                                        Produtos.Cadastro z = x.ler(i);
                                        x.decrementa(z, hash.get(i));

                                    }

                                    System.out.println(car.stringCarrinho());
                                    FileWriter relatorio = new FileWriter("Relatorio.txt", true);
                                    relatorio.write(car.stringCarrinho() + "\n Código do cliente:\t" + car.getCliente() + "\n");
                                    relatorio.close();
                                    return;
                                } catch (Exception ex) {
                                    System.err.println("Erro");
                                }


                            }
                            case 4: {
                                try {
                                    System.out.println(car.stringCarrinho());
                                } catch (IOException ex) {
                                    System.err.println("Verifique se inicializou um carrinho.");
                                }
                            }

                            default:
                                System.out.println("Digite uma opção válida.");

                        }
                    } while (true);
                } catch (Exception ex) {
                }
            }


            case 6: {
                try {
                    geraRelatorio();
                } catch (Exception e) {
                    System.err.println("Erro irreparável.");
                }
                break;
            }
            default: {
                System.out.println("Opcao Inválido");
                break;
            }
        }
    }

    /**
     *
     * @param cod
     * @return
     * @throws IOException
     */
    /*   public static Cadastro retornaProduto(int cod) throws IOException{
     Produtos.Produto p = new Produtos.Produto();
     return p.lerDaLara(cod); 
     }*/
    /**
     * geraRelatorio
     */
    public void geraRelatorio() {
        try {
            FileReader f = new FileReader("Relatorio.txt");
            BufferedReader in = new BufferedReader(f);
            String linha = in.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     *
     * @return
     */
    public static synchronized Store inSpace() {
        INSPACE = new Store();
        return INSPACE;
    }
}
