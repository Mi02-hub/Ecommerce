# 🛒 Ecommerce API - Back-end

Back-end completo para um sistema de e-commerce, desenvolvido com **Java + Spring Boot**. A API expõe endpoints RESTful para gerenciamento de produtos, pedidos, usuários, pagamentos e relatórios, com segurança baseada em autenticação JWT.

---

## ✅ Tecnologias e Ferramentas

- Java 21 
- Spring Boot  
- Spring Security (com JWT)  
- Spring Data JPA  
- MySQL (adaptável)  
- Lombok  
- Maven  

---

## 📂 Estrutura do Projeto

com.senai.ecommerce

│

├── config/ # Configurações de segurança (JWT)

│ ├── SecurityConfig.java

│ ├── SecurityFilter.java

│ └── TokenService.java

│

├── controllers/ # Camada de controle (REST Controllers)

│ ├── ProdutoController.java

│ ├── PedidoController.java

│ ├── UsuarioController.java

│ ├── PagamentoController.java

│ └── RelatorioController.java

│

├── dto/ # Data Transfer Objects

│ ├── ProdutoDTO.java

│ ├── PedidoDTO.java

│ ├── UsuarioDTO.java

│ ├── CategoriaDTO.java

│ ├── ItemDoPedidoDTO.java

│ └── RelatorioPedidoDTO.java

│

├── entities/ # Entidades JPA

│ ├── Produto.java

│ ├── Pedido.java

│ ├── Usuario.java

│ ├── Categoria.java

│ ├── Pagamento.java

│ ├── ItemDoPedido.java

│ ├── ItemDoPedidoPK.java

│ ├── StatusDoPedido.java

│ └── Role.java

│

├── repositories/ # Interfaces de acesso ao banco

│ ├── ProdutoRepository.java

│ ├── PedidoRepository.java

│ ├── UsuarioRepository.java

│ ├── CategoriaRepository.java

│ ├── PagamentoRepository.java

│ └── ItemDoPedidoRepository.java

│

└── services/ # Lógica de negócio

├── ProdutoService.java

├── PedidoService.java

├── UsuarioService.java

├── PagamentoService.java

└── RelatorioService.java


---

## 📌 Principais Funcionalidades

- ✅ CRUD de produtos, usuários e categorias
- 🧾 Cadastro e consulta de pedidos e pagamentos
- 📊 Geração de relatórios por pedidos
- 🔐 Autenticação com JWT
- 🛡️ Controle de acesso baseado em perfis (Role)
- 🌐 API RESTful organizada em camadas

---
🔐 Segurança (JWT)
Autenticação por token JWT usando SecurityFilter e TokenService

Apenas usuários autenticados podem acessar rotas protegidas

Papel de usuário definido pela entidade Role.java

---
🧪 Testes
(Recomenda-se adicionar testes unitários/integrados futuramente com JUnit e MockMvc)

---
👤 Autor
Desenvolvido por Mi02-hub 💻
