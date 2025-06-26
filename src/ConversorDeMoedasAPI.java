import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

public class ConversorDeMoedasAPI {

    static final String API_KEY = "b476456b2030d9ca074a3e53"; // <- coloque sua chave aqui
    static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        double valor;
        String fromCurrency = "BRL";
        String toCurrency = "";
        Map<String, Double> taxas = null;

        while (true) {
            System.out.println("\n       Seja bem-vindo/a ao Conversor de Moedas :)");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("|                C O N V E R S O R  D E  M O E D A S               |");
            System.out.println("|                                                                  |");
            System.out.println("| 1 - Real --> Dólar (USD)                                         |");
            System.out.println("| 2 - Dólar (USD) --> Real                                         |");
            System.out.println("| 3 - Real --> Euro (EUR)                                          |");
            System.out.println("| 4 - Euro --> Real                                                |");
            System.out.println("| 5 - Real --> Peso Argentino (ARS)                                |");
            System.out.println("| 6 - Peso Argentino (ARS) --> Real                                |");
            System.out.println("| 7 - Real --> Renminbi (CNY)                                      |");
            System.out.println("| 8 - Renminbi (CNY) --> Real                                      |");
            System.out.println("| 9 - Sair                                                         |");
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 9) {
                System.out.println("Programa encerrado.");
                break;
            }

            switch (opcao) {
                case 1: fromCurrency = "BRL"; toCurrency = "USD"; break;
                case 2: fromCurrency = "USD"; toCurrency = "BRL"; break;
                case 3: fromCurrency = "BRL"; toCurrency = "EUR"; break;
                case 4: fromCurrency = "EUR"; toCurrency = "BRL"; break;
                case 5: fromCurrency = "BRL"; toCurrency = "ARS"; break;
                case 6: fromCurrency = "ARS"; toCurrency = "BRL"; break;
                case 7: fromCurrency = "BRL"; toCurrency = "CNY"; break;
                case 8: fromCurrency = "CNY"; toCurrency = "BRL"; break;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            valor = scanner.nextDouble();

            try {
                taxas = buscarTaxas(fromCurrency);
                if (taxas.containsKey(toCurrency)) {
                    double taxa = taxas.get(toCurrency);
                    double resultado = valor * taxa;
                    System.out.printf("Resultado: %.2f %s\n", resultado, toCurrency);
                } else {
                    System.out.println("Moeda de destino não encontrada.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao acessar a API: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Método que busca taxas de câmbio
    public static Map<String, Double> buscarTaxas(String baseCurrency) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + baseCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ExchangeResponse exchange = gson.fromJson(response.body(), ExchangeResponse.class);

        return exchange.conversion_rates;
    }

    // Classe para mapear o JSON
    static class ExchangeResponse {
        Map<String, Double> conversion_rates;
    }
}
