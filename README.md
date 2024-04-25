# Conversor de Moedas em Java

Este é um Conversor de Moedas desenvolvido em Java como parte de um desafio de programação. O programa permite converter valores entre diferentes moedas com base nas taxas de câmbio obtidas de uma API externa.

## Pré-requisitos

- **Java JDK**: versão 11 ou superior. [Download do Java LTS mais recente](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Biblioteca Gson**: versão 2.10.1 ou superior. [Maven Central Repository Search](https://search.maven.org/artifact/com.google.code.gson/gson)
- **Postman**: para explorar e entender melhor a API de taxas de câmbio. [Download do Postman](https://www.postman.com/downloads/)
- **IDE (Ambiente de Desenvolvimento Integrado)**: Opcional. Recomenda-se o IntelliJ IDEA. [Baixe o IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

## Configuração da API de Taxas de Câmbio

- Acesse [ExchangeRate-API](https://www.exchangerate-api.com/) para obter sua chave de API gratuita.
- Siga as instruções fornecidas no site para registrar-se e obter sua chave de API.
- Certifique-se de revisar a documentação da API para entender como fazer solicitações e interpretar as respostas.

## Configuração do Programa

1. Certifique-se de ter instalado o Java JDK e o Maven em seu sistema.
2. Clone ou faça o download deste repositório para o seu ambiente de desenvolvimento.
3. Adicione a biblioteca Gson ao seu projeto Java. Você pode baixar o JAR diretamente do [Maven Central Repository](https://search.maven.org/artifact/com.google.code.gson/gson) ou adicionar a dependência ao seu arquivo pom.xml se estiver utilizando o Maven.
4. Abra o projeto em sua IDE de preferência (recomenda-se o IntelliJ IDEA).
5. Configure sua chave de API da ExchangeRate-API no arquivo `APICliente.java`.
6. Execute o programa e comece a converter moedas!

## Como Usar

1. Execute o programa e siga as instruções apresentadas no console.
2. Escolha uma das opções de conversão disponíveis.
3. Insira o valor a ser convertido quando solicitado.
4. O programa irá calcular e exibir o valor convertido com base nas taxas de câmbio atuais.

Divirta-se convertendo moedas!

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema, ou deseja melhorar o código, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [`LICENSE`](https://github.com/marcostulliosouza/APITaxasCambio/blob/master/LICENSE) para obter mais detalhes.
