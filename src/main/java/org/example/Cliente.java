package org.example;

import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String mensagem;
        try {

            Socket conexao = new Socket("localhost", 12345);
            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

            while(true) {

                System.out.println("Selecione uma opção:");
                System.out.println("1. Adicionar livro");
                System.out.println("2. Alugar livro");
                System.out.println("3. Listar livros");
                System.out.println("4. Devolver livros");
                System.out.println("5. Sair");
                int escolha = Integer.parseInt(reader.readLine());

                switch (escolha) {
                    case 1:

                        saida.writeObject(escolha);
                        System.out.println((String) entrada.readObject());

                        break;
                    case 2:

                        saida.writeObject(escolha);
                        while ((mensagem = (String) entrada.readObject()) != null){
                            System.out.println("Livro: " + mensagem);
                        }

                        break;
                    case 3:

                        saida.writeObject(escolha);
                        System.out.println((String) entrada.readObject());
                        break;
                    case 4:

                        saida.writeObject(escolha);
                        System.out.println((String) entrada.readObject());
                        return;
                    case 5:

                        saida.writeObject(escolha);
                        System.out.println((String) entrada.readObject());
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
