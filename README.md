Sistema de Gerenciamento de Estacionamento

Projeto desktop desenvolvido em Java utilizando Swing, JDBC e MySQL, seguindo o padrão de arquitetura **MVC** e **DAO** para organização de código e acesso a dados.

Tecnologias e Ferramentas
- Java (SE)
- Swing (interface gráfica)
- MySQL (banco de dados relacional)
- JDBC (conexão com banco)
- DAO (padrão de acesso a dados)
- NetBeans (IDE, opcional)



Funcionalidades Implementadas
Este sistema inclui:
- Login de usuários
- Cadastro e gerenciamento de visitantes
- Controle de entrada e saída de veículos
- Exibição e manutenção de registros
- Exportação de tabelas (CSV)
- Manipulação de imagens (fotos de veículos/usuarios)
- Splash screen de abertura



Estrutura do Projeto
- Model → contém classes que representam dados
- Controller/DAO → classes que acessam o banco de dados (CRUD)
- View (telas Swing) → interface do usuário
- Image/ → imagens utilizadas no projeto



 Arquitetura Utilizada
O projeto foi organizado utilizando:
- MVC (Model–View–Controller)**
- DAO para acesso a banco**
Essa arquitetura permite:
✔ Separação de responsabilidades  
✔ Menor acoplamento  
✔ Código modular e de fácil manutenção



 Como Executar
1. Configure o MySQL no seu computador  
2. Crie o banco de dados conforme scripts disponíveis (ou solicite instruções)  
3. Importe o projeto na sua IDE (NetBeans ou similar)  
4. Ajuste a conexão com seu banco em `Conecta_DB.java`  
5. Compile e execute



 Melhorias Futuras
- Migrar para **Spring Boot API REST**
- Implementar **camada de serviços**
- Separar pacotes (`dao`, `service`, `model`, `view`)
- Adicionar testes automatizados



