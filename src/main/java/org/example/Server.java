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
import java.util.Map;


public class Server {
    static ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String[] args) {

            try {
                ObjectMapper objectMapper = new ObjectMapper();

                Map<String, List<Livro>> objetoLivros = objectMapper.readValue(new File("livros.json"), new TypeReference<Map<String, List<Livro>>>(){});
                List<Livro> listaDeLivros = objetoLivros.get("livros");

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
                            adicionarLivro(listaDeLivros, entrada, saida, objetoLivros);

                            break;
                        case 2:
                            listarLivros(listaDeLivros, saida);

                            break;
                        case 3:
                            devolverOuAlugar("alugar", listaDeLivros, entrada, saida, objetoLivros);

                            break;
                        case 4:
                            devolverOuAlugar("devolver", listaDeLivros, entrada, saida, objetoLivros);

                            break;
                        case 5:
                            mensagem = "Encerrando ...";
                            saida.writeObject(mensagem);
                            return;
                        default:
                            mensagem = "Opção invalida, tente novamente ...";
                            saida.writeObject(mensagem);

                            break;
                    }

                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    private static void adicionarLivro(List<Livro> listaDeLivros, ObjectInputStream entrada, ObjectOutputStream saida, Map<String, List<Livro>> objetoLivros) throws IOException, ClassNotFoundException {
        // Ler informações do livro do cliente
        String autor = (String) entrada.readObject();
        String titulo = (String) entrada.readObject();
        String genero = (String) entrada.readObject();
        int exemplares  = (Integer) entrada.readObject();


        Livro novoLivro = new Livro(autor, titulo, genero, exemplares);
        listaDeLivros.add(novoLivro);

        objetoLivros.put("livros", listaDeLivros);
        objectMapper.writeValue(new File("livros.json"), objetoLivros);

        saida.writeObject("Livro adicionado com sucesso.");
        saida.writeObject(null);
    }

    public static void listarLivros(List<Livro> livros, ObjectOutputStream saida) throws IOException {

        for (Livro livro : livros) {
            saida.writeObject(livro.toString());
        }
        saida.writeObject(null);
    }

    public static void devolverOuAlugar(String acao, List<Livro> livros, ObjectInputStream entrada,ObjectOutputStream saida, Map<String, List<Livro>> objetoLivros) throws IOException, ClassNotFoundException {

        String titulo = (String)  entrada.readObject();
        boolean encontrado = false;

        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                if (livro.getExemplares() > 0 ){
                    if (acao ==  "alugar") {
                        livro.setExemplares(livro.getExemplares() - 1);
                    } else {
                        livro.setExemplares(livro.getExemplares() + 1);
                    }
                    objetoLivros.put("livros", livros);
                    objectMapper.writeValue(new File("livros.json"), objetoLivros);
                    saida.writeObject("Livro alugado com sucesso: " + livro);

                }else {

                    saida.writeObject("Livro não tem exemplares disponiveis");
                }
                encontrado = true;

                break;
            }
        }
        if(!encontrado){
            saida.writeObject("Livro não existe na lista");
        }
        saida.writeObject(null);
    }


}
