# Atividades L2 - Empacotamento de Produtos

Bem-vindo(a) ao repositório do **Atividades L2**, uma aplicação para empacotamento de produtos em caixas, desenvolvida como parte do processo seletivo da empresa L2.

---

## Sobre o Projeto

O projeto foi desenvolvido para receber pedidos contendo produtos com dimensões específicas e determinar a melhor forma de distribuí-los em caixas disponíveis, respeitando os limites de cada caixa. A lógica de empacotamento prioriza eficiência e simplicidade.

> **Observação:** Devido ao prazo do desafio, optei por implementar a aplicação na linguagem que tenho mais familiaridade: **Java com Spring Boot**.
> Spring Boot foi escolhido ao invés de Node.js + NestJS por permitir o desenvolvimento rápido de APIs robustas e com menos configuração inicial, além de facilitar a exposição da aplicação via Nginx e a integração com Swagger para documentação interativa.

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Maven** para gerenciamento de dependências e build
- **NGINX** como proxy reverso para o backend
- **Cloudflared** (opcional) para exposição segura da API
- **Swagger** para documentação e testes interativos da API

---

## URL Pública

A aplicação está publicada na web via Cloudflare Tunnel:

- **API:** `http://l2.filipixel.com/backend/empacotar`
- **Swagger UI:** `http://l2.filipixel.com/swagger-ui/index.html`

---

## Como Rodar a Aplicação Localmente

1.  **Clone o repositório:**

    ```bash
    git clone [https://github.com/filipe-brito/Atividades-L2.git](https://github.com/filipe-brito/Atividades-L2.git)
    cd Atividades-L2
    ```

2.  **Compile o projeto:**

    ```bash
    mvn clean install
    ```

3.  **Execute a aplicação:**

    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em: `http://localhost:8081/empacotar`

---

## Estrutura da API

### `POST /empacotar`

Recebe um objeto JSON com pedidos e seus produtos, e retorna as caixas ideais para o empacotamento.

**Headers:**

`Content-Type: application/json`

**Exemplo de `Request`:**

```json
{
  "pedidos": [
    {
      "pedido_id": 1,
      "produtos": [
        {"produto_id": "PS5", "dimensoes": {"altura": 40, "largura": 10, "comprimento": 25}},
        {"produto_id": "Volante", "dimensoes": {"altura": 40, "largura": 30, "comprimento": 30}}
      ]
    }
  ]
}
```

## Testando via Swagger

Você pode testar todos os endpoints de forma interativa utilizando o Swagger UI, acessando a URL pública:

`https://l2.filipixel.com/swagger-ui/index.html`

