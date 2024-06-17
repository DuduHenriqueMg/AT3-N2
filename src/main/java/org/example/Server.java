package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {


            try {

                ServerSocket conexao = new ServerSocket(12345);
                System.out.println("Esperando");
                Socket socket = conexao.accept();
                ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

                while(true) {
                    String mensagem;
                    Integer escolha = (Integer) entrada.readObject();
                    switch (escolha) {
                        case 1:
                            mensagem = "Teste 1";
                                saida.writeObject(mensagem);
                            break;
                        case 2:
                            mensagem = "Teste 2";
                            saida.writeObject(mensagem);
                            break;
                        case 3:

                            mensagem = "Teste 3";
                            saida.writeObject(mensagem);

                            break;
                        case 4:
                            mensagem = "Encerrando programa";
                            saida.writeObject(mensagem);
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


    public static void adicionarLivro(){

    }

    public static void listarLivros(){

    }
    public static void alugarLivro(){

    }
    public static void devolverLivro(){

    }
}
