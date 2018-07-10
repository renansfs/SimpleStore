package Clientes;

import Cliente.Exceptions.ClienteNotFoundException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Le o cliente a partir do arquivo
 *
 * @author LMDS
 */
public class LerCliente implements Command {

    Cadastro slot;

    LerCliente(Cadastro slot) {
        this.slot = slot;
    }

    /**
     *
     * @throws IOException
     * @throws InputMismatchException
     * @throws FileNotFoundException
     * @throws EOFException
     */
    @Override
    public void execute() throws IOException, InputMismatchException, FileNotFoundException, EOFException {
        if (slot.getFile() == null) {
            throw new FileNotFoundException();
        }
        RandomAccessFile ler = new RandomAccessFile(slot.getFile(), "rw");
        Scanner in = new Scanner(System.in);
        long cod;
        while (true) {
            System.out.println("\nDigite o numero do Cliente: ");
            cod = in.nextLong();
            if (cod < 0) {
                continue;
            }
            break;
        }
        ler.seek(cod * slot.size() + 1);
        slot.setCodigo(ler.readInt());
        if (slot.getCodigo() != cod) {
            throw new ClienteNotFoundException();
        }
        slot.setNome(padName(ler));
        slot.setCartaoDeCredito(ler.readLong());
        ler.seek(cod * slot.size() + 1);
        System.out.printf("Cadastro: \n Dados: \n Codigo: %d \n Nome: %s \n Cartao de credito: %d \n ",
                ler.readInt(), padName(ler), ler.readLong());
        try {
            ler.close();
        } catch (IOException e) {
            System.err.printf("Erro irreparável.");
        }
    }

    private String padName(RandomAccessFile file) throws IOException {
        char descricao[] = new char[25], temp;
        for (int count = 0; count < descricao.length; count++) {
            temp = file.readChar();
            descricao[count] = temp;
        }
        return new String(descricao).replace('\0', ' ');
    }
}
