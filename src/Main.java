import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedas conversor;
        try {
            conversor = new ConversorMoedas();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            System.out.println("Erro ao inicializar o Conversor de Moedas: " + e.getMessage());
            return;
        }

        boolean sair = false;
        while (!sair) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            try {
                switch (opcao) {
                    case 1:
                        converterBRLparaUSD(scanner, conversor);
                        break;
                    case 2:
                        converterUSDparaBRL(scanner, conversor);
                        break;
                    case 3:
                        converterBRLparaEUR(scanner, conversor);
                        break;
                    case 4:
                        converterEURparaBRL(scanner, conversor);
                        break;
                    case 0:
                        sair = true;
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (IOException | InterruptedException | URISyntaxException e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Menu de Opções:");
        System.out.println("1. Converter BRL para USD");
        System.out.println("2. Converter USD para BRL");
        System.out.println("3. Converter BRL para EUR");
        System.out.println("4. Converter EUR para BRL");
        System.out.println("0. Sair do Programa");
        System.out.print("Escolha uma opção: ");
    }

    private static void converterBRLparaUSD(Scanner scanner, ConversorMoedas conversor) throws IOException, InterruptedException, URISyntaxException {
        System.out.print("Digite o valor em BRL: ");
        double valorBRL = scanner.nextDouble();
        double valorConvertidoParaUSD = conversor.converterBRLParaUSD(valorBRL);
        System.out.println("Valor convertido para USD: " + valorConvertidoParaUSD);
    }

    private static void converterUSDparaBRL(Scanner scanner, ConversorMoedas conversor) throws IOException, InterruptedException, URISyntaxException {
        System.out.print("Digite o valor em USD: ");
        double valorUSD = scanner.nextDouble();
        double valorConvertidoParaBRL = conversor.converterUSDParaBRL(valorUSD);
        System.out.println("Valor convertido para BRL: " + valorConvertidoParaBRL);
    }

    private static void converterBRLparaEUR(Scanner scanner, ConversorMoedas conversor) throws IOException, InterruptedException, URISyntaxException {
        System.out.print("Digite o valor em BRL: ");
        double valorBRL = scanner.nextDouble();
        double valorConvertidoParaEUR = conversor.converterBRLParaEUR(valorBRL);
        System.out.println("Valor convertido para EUR: " + valorConvertidoParaEUR);
    }

    private static void converterEURparaBRL(Scanner scanner, ConversorMoedas conversor) throws IOException, InterruptedException, URISyntaxException {
        System.out.print("Digite o valor em EUR: ");
        double valorEUR = scanner.nextDouble();
        double valorConvertidoParaBRL = conversor.converterEURParaBRL(valorEUR);
        System.out.println("Valor convertido para BRL: " + valorConvertidoParaBRL);
    }
}
