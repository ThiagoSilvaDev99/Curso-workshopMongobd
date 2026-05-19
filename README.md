# Workshop Spring Boot com MongoDB

## 💻 Sobre o Projeto
Este projeto é uma API RESTful desenvolvida como parte do curso "Programação Orientada a Objetos com Java", ministrado pelo Prof. Dr. Nelio Alves. O projeto faz parte do capítulo "Projeto MongoDB com Spring Boot" e tem como foco principal a compreensão do paradigma de banco de dados orientado a documentos e suas diferenças práticas em relação ao modelo relacional.

## 🎯 Objetivos de Aprendizagem
* Compreender as diferenças entre os paradigmas orientado a documentos e relacional.
* Implementar operações completas de CRUD (Create, Read, Update, Delete).
* Refletir sobre decisões de design para modelagem em bases de dados NoSQL.
* Implementar e diferenciar associações entre objetos: objetos aninhados e referências.
* Realizar consultas avançadas utilizando Spring Data e Mongo Repository.

## 🛠️ Tecnologias e Ferramentas
* **Linguagem:** Java
* **Framework:** Spring Boot
* **Persistência de Dados:** Spring Data MongoDB
* **Base de Dados:** MongoDB
* **Containerização:** Docker
* **Visualização de Dados:** Mongo Compass

## ⚙️ Arquitetura e Padrões Utilizados
A aplicação foi estruturada seguindo um modelo de camadas claro e definido para separar responsabilidades:
* **Controladores REST:** Responsáveis por receber as requisições da aplicação cliente e devolver as respostas adequadas.
* **Camada de Serviço:** Onde residem as regras de negócio.
* **Camada de Acesso a Dados (Repository):** Interfaces para comunicação e persistência com o MongoDB.
* **Camada de Domínio:** Entidades que representam o domínio do negócio.

### Padrões Implementados
* **Padrão DTO (Data Transfer Object):** Implementado para otimizar o tráfego de rede, evitar a exposição de dados sensíveis e customizar os dados trafegados.
* **Tratamento de Exceções:** Criação de manipuladores de exceções para capturar erros e devolver respostas HTTP padronizadas.

## 🗂️ Modelo de Domínio e Decisões de Design
O sistema possui as seguintes entidades principais e estratégias de relacionamento:

* **Utilizador (User):** A lista de posts associados a um utilizador foi modelada utilizando **Referências** (através da anotação `@DBRef`), o que significa que os posts são armazenados em coleções separadas.
* **Post e Comentário (Comment):** Para otimizar a leitura dos posts e evitar múltiplas consultas à base de dados, tanto os dados resumidos do autor quanto os comentários do post foram modelados como **Objetos Aninhados** diretamente dentro da coleção do Post.

## 🔍 Consultas Implementadas
O projeto explora diferentes formas de realizar buscas no MongoDB:
* **Query Methods:** Consulta simples estruturada pelo próprio nome do método no repositório.
* **@Query:** Implementação alternativa utilizando a anotação `@Query` com sintaxe JSON do MongoDB.
* **Busca com Múltiplos Critérios:** Consulta complexa que procura termos em qualquer lugar (no título, corpo ou comentários) e dentro de um intervalo de datas específico.

## 🚀 Como Executar o Projeto
1. Certifique-se de ter o MongoDB em execução na sua máquina local na porta padrão (`27017`).
   * **Nota:** Este projeto utilizou o **Docker** para rodar o banco de dados. Você pode subir um container do MongoDB rapidamente rodando o seguinte comando no seu terminal:
     ```bash
     docker run -d -p 27017:27017 --name mongo-db mongo
     ```
2. Clone este repositório:
   ```bash
   git clone https://github.com/ThiagoSilvaDev99/Curso-workshopMongobd.git
   
3. Execute a aplicação através da sua IDE preferida. O projeto já conta com uma configuração que realiza uma carga inicial de dados (utilizadores, posts e comentários) automaticamente na base de dados sempre que o sistema é iniciado.