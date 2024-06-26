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
                String autor;
                String titulo;
                String genero;
                int exemplares;

                System.out.println("Selecione uma opção:");
                System.out.println("1. Cadastrar livro");
                System.out.println("2. Listar livros");
                System.out.println("3. Alugar livro");
                System.out.println("4. Devolver livros");
                System.out.println("5. Sair");
                int escolha = Integer.parseInt(reader.readLine());

                switch (escolha) {
                    case 1:
                        System.out.println("Digite o autor do livro que voce vai cadastrar:");
                        autor = reader.readLine();

                        System.out.println("Digite o titulo do livro que voce vai cadastrar:");
                        titulo = reader.readLine();

                        System.out.println("Digite o genero do livro que voce vai cadastrar:");
                        genero = reader.readLine();

                        System.out.println("Digite quantos exemplares do livro que voce vai cadastrar:");
                        exemplares = Integer.parseInt(reader.readLine());

                        saida.writeObject(escolha);
                        saida.writeObject(autor);
                        saida.writeObject(titulo);
                        saida.writeObject(genero);
                        saida.writeObject(exemplares);

                        while ((mensagem = (String) entrada.readObject()) != null){
                            System.out.println(mensagem);
                        }

                        break;
                    case 2:
                        saida.writeObject(escolha);
                        while ((mensagem = (String) entrada.readObject()) != null){
                            System.out.println(mensagem);
                        }

                        break;
                    case 3:
                        System.out.println("Digite o titulo do livro que voce quer alugar:");
                        titulo = reader.readLine();

                        saida.writeObject(escolha);
                        saida.writeObject(titulo);
                        while ((mensagem = (String) entrada.readObject()) != null){
                            System.out.println(mensagem);
                        }

                        break;
                    case 4:
                        System.out.println("Digite o titulo do livro que voce quer devolver:");
                        titulo = reader.readLine();

                        saida.writeObject(escolha);
                        saida.writeObject(titulo);
                        while ((mensagem = (String) entrada.readObject()) != null){
                            System.out.println(mensagem);
                        }
                        break;
                    case 5:
                        saida.writeObject(escolha);
                        System.out.println((String) entrada.readObject());

                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");

                        break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
