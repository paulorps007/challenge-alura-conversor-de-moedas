# 💱 Conversor de Moedas - Java + ExchangeRate API

Este é um projeto de console em **Java** que permite ao usuário converter valores entre diferentes moedas, utilizando dados **atualizados em tempo real** da API [ExchangeRate-API](https://www.exchangerate-api.com/).

## 🚀 Funcionalidades

- Menu interativo no console
- Conversão entre as seguintes moedas:
  - Real Brasileiro (BRL)
  - Dólar Americano (USD)
  - Euro (EUR)
  - Peso Argentino (ARS)
  - Renminbi Chinês (CNY)
- Atualização de taxas de câmbio via API
- Execução contínua até o usuário decidir sair

## 🛠 Requisitos

- Java 11 ou superior
- Conexão com a internet
- Biblioteca [Gson](https://github.com/google/gson) para tratamento de JSON

📦 Instalação

1. Clone este repositório:

git clone https://github.com/seu-usuario/conversor-moedas-java.git
cd conversor-moedas-java
Obtenha uma chave de API gratuita no site da ExchangeRate-API.

Substitua "SUA_API_KEY_AQUI" no código pelo valor real da sua chave:
static final String API_KEY = "SUA_API_KEY_AQUI";
Adicione a biblioteca Gson ao seu projeto:

Via Maven:
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
Ou baixe manualmente o .jar:
https://repo1.maven.org/maven2/com/google/code/gson/gson/

▶️ Como usar
Execute o programa em um terminal ou via IDE (como IntelliJ IDEA):

Escolha a opção desejada no menu

Digite o valor a ser convertido

O valor será convertido em tempo real com base nas cotações atualizadas

📷 Exemplo de uso

Escolha uma opção:
1 - Real --> Dólar (USD)
...
Digite o valor a ser convertido: 100
Resultado: 18.87 USD

📌 Observações
As taxas de câmbio são fornecidas em tempo real pela ExchangeRate-API.

Em caso de erro na conexão ou chave inválida, o programa exibirá uma mensagem de erro amigável.

📄 Licença
Este projeto é de livre uso para fins educacionais e está sob a licença MIT.

Desenvolvido com 💻 por Paulo Roberto Pereira
