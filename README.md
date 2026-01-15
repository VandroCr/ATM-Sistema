# Sistema ATM - Caixa Automático

Sistema de ATM (Caixa Automático) desenvolvido em Java com arquitetura MVC, utilizando HTML, CSS e JSP para a interface web.

## 📋 Descrição

Este projeto implementa um sistema completo de ATM que permite simular operações bancárias básicas, seguindo os princípios da arquitetura Model-View-Controller (MVC).

## 🏗️ Arquitetura MVC

### Model (Modelo)
- **Conta.java**: Entidade que representa uma conta bancária
- **ContaDAO.java**: Data Access Object para gestão de dados das contas
- **ContaService.java**: Camada de serviço com regras de negócio

### View (Visualização)
- **HTML/CSS**: Interface web moderna e responsiva
- **JSP**: Páginas dinâmicas para interação com o usuário
- Páginas disponíveis:
  - `index.html`: Página inicial
  - `login.jsp`: Login do usuário
  - `registro.jsp`: Criação de nova conta
  - `dashboard.jsp`: Painel principal após login
  - `saldo.jsp`: Consulta de saldo
  - `deposito.jsp`: Realização de depósitos
  - `levantamento.jsp`: Realização de levantamentos

### Controller (Controlador)
- **RegistroServlet**: Controla criação de contas
- **LoginServlet**: Controla autenticação de usuários
- **DashboardServlet**: Controla acesso ao painel principal
- **SaldoServlet**: Controla consulta de saldo
- **DepositoServlet**: Controla operações de depósito
- **LevantamentoServlet**: Controla operações de levantamento
- **LogoutServlet**: Controla encerramento de sessão

## ✨ Funcionalidades

- ✅ Criação de conta bancária
- ✅ Login do utilizador
- ✅ Consulta de saldo
- ✅ Depósito
- ✅ Levantamento
- ✅ Encerramento de sessão (logout)

## 🛠️ Tecnologias Utilizadas

- **Java 17**: Linguagem de programação
- **Jakarta EE 11**: Framework para aplicações web
- **HTML5**: Estrutura das páginas
- **CSS3**: Estilização moderna e responsiva
- **JSP**: Páginas dinâmicas
- **Maven**: Gerenciamento de dependências

## 📦 Estrutura do Projeto

```
ATM-Sistema/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── atm/
│   │   │           └── sistema/
│   │   │               ├── model/
│   │   │               │   ├── Conta.java
│   │   │               │   ├── ContaDAO.java
│   │   │               │   └── ContaService.java
│   │   │               └── controller/
│   │   │                   ├── RegistroServlet.java
│   │   │                   ├── LoginServlet.java
│   │   │                   ├── DashboardServlet.java
│   │   │                   ├── SaldoServlet.java
│   │   │                   ├── DepositoServlet.java
│   │   │                   ├── LevantamentoServlet.java
│   │   │                   └── LogoutServlet.java
│   │   ├── resources/
│   │   │   └── META-INF/
│   │   │       └── persistence.xml
│   │   └── webapp/
│   │       ├── css/
│   │       │   └── style.css
│   │       ├── index.html
│   │       ├── login.jsp
│   │       ├── registro.jsp
│   │       ├── dashboard.jsp
│   │       ├── saldo.jsp
│   │       ├── deposito.jsp
│   │       ├── levantamento.jsp
│   │       └── WEB-INF/
│   │           └── web.xml
│   └── pom.xml
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior
- Servidor de aplicação compatível com Jakarta EE 11 (ex: Apache Tomcat 10+, GlassFish, Payara)

### Passos para Execução

1. Clone o repositório:
```bash
git clone <url-do-repositório>
cd ATM-Sistema
```

2. Compile o projeto:
```bash
mvn clean compile
```

3. Crie o pacote WAR:
```bash
mvn package
```

4. Implante o arquivo `target/ATM-Sistema-1.0-SNAPSHOT.war` no seu servidor de aplicação

5. Acesse a aplicação através do navegador:
```
http://localhost:8080/ATM-Sistema-1.0-SNAPSHOT/
```

## 📝 Como Usar

1. **Criar Conta**: Acesse a opção "Criar nova conta" na página inicial
2. **Login**: Faça login com número da conta e PIN
3. **Operações**: Após o login, você pode:
   - Consultar saldo
   - Realizar depósitos
   - Realizar levantamentos
4. **Logout**: Clique em "Sair" para encerrar a sessão

## 🔒 Segurança

- As senhas (PIN) são armazenadas em texto simples (para fins educacionais)
- Em produção, recomenda-se usar hash de senhas
- As sessões são gerenciadas pelo servidor de aplicação

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais.

## 👨‍💻 Autor

Desenvolvido como trabalho prático de desenvolvimento de sistemas.

---

**Nota**: Este sistema utiliza armazenamento em memória. Os dados são perdidos quando o servidor é reiniciado. Para persistência permanente, seria necessário integrar com um banco de dados.
