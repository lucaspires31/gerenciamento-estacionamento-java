# Sistema de Gerenciamento de Estacionamento

Projeto desktop desenvolvido em **Java**, utilizando **Swing**, **JDBC** e **MySQL**, seguindo os padrões de arquitetura **MVC** e **DAO** para melhor organização do código e acesso a dados.

---

## 🛠️ Tecnologias e Ferramentas

- Java SE  
- Swing (Interface Gráfica)  
- MySQL (Banco de Dados Relacional)  
- JDBC (Conectividade com o banco)  
- DAO (Data Access Object)  
- NetBeans (IDE – opcional)

---

## ⚙️ Funcionalidades Implementadas

O sistema possui as seguintes funcionalidades:

- Autenticação de usuários (Login)  
- Cadastro e gerenciamento de visitantes  
- Controle de entrada e saída de veículos  
- Exibição e manutenção de registros  
- Exportação de dados em formato CSV  
- Manipulação de imagens (fotos de veículos e usuários)  
- Tela de abertura (Splash Screen)

---

## 🗂️ Estrutura do Projeto

- **model/** → Classes que representam os dados do sistema  
- **controller/dao/** → Classes responsáveis pelo acesso ao banco de dados (CRUD)  
- **view/** → Interfaces gráficas desenvolvidas com Swing  
- **imagem/** → Recursos visuais utilizados no sistema  

---

## 🧩 Arquitetura Utilizada

O projeto foi desenvolvido utilizando:

- **MVC (Model–View–Controller)**  
- **DAO (Data Access Object)**  

### Benefícios da arquitetura:
✔ Separação de responsabilidades  
✔ Código modular  
✔ Facilidade de manutenção e escalabilidade  

---

## ▶️ Como Executar o Projeto

1. Instale e configure o **MySQL** em sua máquina  
2. Crie o banco de dados conforme os scripts disponíveis (ou solicite instruções)  
3. Importe o projeto em sua IDE (NetBeans ou similar)  
4. Configure a conexão com o banco no arquivo `Conecta_DB.java`  
5. Compile e execute o projeto  

---

## 🚀 Melhorias Futuras

- Migração para **Spring Boot (API REST)**  
- Implementação de camada de serviços  
- Melhor organização de pacotes (`dao`, `service`, `model`, `view`)  
- Adição de testes automatizados  
