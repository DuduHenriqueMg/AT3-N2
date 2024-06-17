package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        String mensagem;
        try {


            Socket conexao = new Socket("localhost", 12345);
            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
            saida.writeObject(1);
            while ((mensagem = (String) entrada.readObject()) != null) {
                System.out.println(mensagem);

            }
            entrada.close();
            saida.close();
            conexao.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
