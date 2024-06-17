package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


public class Server {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

            try {
                JsonNode rootNode = objectMapper.readTree(new File("livros.json"));

                // Obtém o nó "livros" do JsonNode
                JsonNode livrosNode = rootNode.path("livros");
                List<Livro> listaDeLivros = objectMapper.convertValue(livrosNode, new TypeReference<List<Livro>>() {});

                ServerSocket conexao = new ServerSocket(12345);
                System.out.println("Esperando cliente conectar");
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
                            listarLivros(listaDeLivros, saida);
                            break;
                        case 3:

                            mensagem = "Teste 3";
                            saida.writeObject(mensagem);

                            break;
                        case 4:
                            mensagem = "Teste 4";
                            saida.writeObject(mensagem);
                            break;
                        case 5:
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

    public static void listarLivros(List<Livro> livros, ObjectOutputStream saida) throws IOException {

        for (Livro livro : livros) {
            saida.writeObject(livro.toString());
        }
        saida.writeObject(null);
    }
    public static void alugarLivro(){

    }
    public static void devolverLivro(){

    }
}
