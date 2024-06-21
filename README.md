<h1 align="center">Servidor Biblioteca (AT3-N2)</h1>

## Descrição do Projeto

<p id="sobre">Projeto da matéria de programação concorrente e distribuída feito em Java que implementa um servidor utilizando sockets com função de controlar o registro/cadastro e aluguel e devolução de livros de uma biblioteca. Esse projeto também possui um cliente que se conecta com o servidor para solicitar e enviar dados através da conexão via socket. Além disso, os livros da biblioteca estão armazenados em um arquivo JSON e a manipulação dos dados dos livros fica or conta do servidor. </p>

<p align="center">
 <a href="#sobre">Sobre</a> •
 <a href="#roadmap">Roadmap</a> • 
 <a href="#tecnologias">Tecnologias</a> • 
 <a href="#contribuicao">Contribuição</a> • 
 <a href="#licenc-a">Licença</a> • 
 <a href="#autor">Autor</a>
</p>

<h4 align="center"> 
    Projeto Servidor Biblioteca Concluído ✅
</h4>


### Pré-requisitos

Antes de começar, você vai precisar ter em sua máquina as seguintes ferramentas:
[Java 17](https://www.oracle.com/br/java/technologies/downloads/#java17) e talvez o gerenciador de dependências do Java que é o [Maven](https://maven.apache.org/) dependendo de sua IDE.
Além disto é bom ter um editor para trabalhar com o código Java como o [VSCode](https://code.visualstudio.com/), [Intellij](https://www.jetbrains.com/idea/) ou a IDE de Java de sua preferência.

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/tgmarinho/nlw1>

# Acesse a pasta do projeto no terminal/cmd
$ cd nlw1

# Vá para a pasta server
$ cd server

# Instale as dependências
$ npm install

# Execute a aplicação em modo de desenvolvimento
$ npm run dev:server

# O servidor inciará na porta:3333 - acesse <http://localhost:3333>