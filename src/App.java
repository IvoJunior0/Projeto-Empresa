// EMPRESA SUCÃO - IVO E CARLOS
import java.util.Scanner;
public class App {
    // VARIÁVEIS GLOBAIS
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // VARIÁVEIS LOCAIS
        int login, senha;
        int estoqueMorango, estoqueGoiaba, estoqueAbacaxi, estoqueKiwi, estoqueLaranja, estoqueCaja, estoqueCupuacu, estoqueBacuri, estoqueMelancia, estoqueAcerola;
        estoqueMorango = estoqueGoiaba = estoqueAbacaxi = estoqueKiwi = estoqueLaranja = estoqueCaja = estoqueCupuacu = estoqueBacuri = estoqueMelancia = estoqueAcerola = 10;
        int continuarPedindo = 1;
        int i = 1; // Index da venda
        // SISTEMA DE LOGIN
        do {
            System.out.println("\nDigite o seu login: ");
            login = input.nextInt();
            System.out.println("Digite a sua senha: ");
            senha = input.nextInt();
            if (login != 111 || senha != 111) {
                System.out.println("\nLogin ou senha inválidos");
            }
        } while (login != 111 || senha != 111);
        // PROGRAMA PRINCIPAL
        do {
            // MENU PRINCIPAL
            System.out.println("\n\n=== SUCÃO ===");
            System.out.println("1. Morango - R$10,00");
            System.out.println("2. Goiaba - R$10,00");
            System.out.println("3. Abacaxi com hortelã - R$10,00");
            System.out.println("4. Kiwi - R$10,00");
            System.out.println("5. Laranja - R$10,00");
            System.out.println("6. Cajá - R$10,00");
            System.out.println("7. Cupuaçu - R$10,00");
            System.out.println("8. Bacuri - R$10,00");
            System.out.println("9. Melancia - R$10,00");
            System.out.println("10. Acerola - R$10,00");
            System.out.println("\nSuco desejado:");
            int op = input.nextInt();
            switch (op) {
                case 1:
                    estoqueMorango = calcularEstoque(estoqueMorango, i, "Morango");
                    break;
                case 2:
                    estoqueGoiaba = calcularEstoque(estoqueGoiaba, i, "Goiaba");
                    break;
                case 3:
                    estoqueAbacaxi = calcularEstoque(estoqueAbacaxi, i, "Abacaxi");
                    break;
                case 4:
                    estoqueKiwi = calcularEstoque(estoqueKiwi, i, "Kiwi");
                    break;
                case 5:
                    estoqueLaranja = calcularEstoque(estoqueLaranja, i, "Laranja");
                    break;
                case 6:
                    estoqueCaja = calcularEstoque(estoqueCaja, i, "Caja");
                    break;
                case 7:
                    estoqueCupuacu = calcularEstoque(estoqueCupuacu, i, "Cupuacu");
                    break;
                case 8:
                    estoqueBacuri = calcularEstoque(estoqueBacuri, i, "Bacuri");
                    break;
                case 9:
                    estoqueMelancia = calcularEstoque(estoqueMelancia, i, "Melancia");
                    break;
                case 10:
                    estoqueAcerola = calcularEstoque(estoqueAcerola, i, "Acerola");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            i++;
            // MENU "DESEJA CONTINUAR?"
            do {
                System.out.println("Deseja fazer um novo pedido? 1. Sim - 2. Não");
                continuarPedindo = input.nextInt();
                if (continuarPedindo != 1 && continuarPedindo != 2) {
                    System.out.println("\n= ! Por favor, escolha uma opção válida\n");
                }
            } while (continuarPedindo != 1 && continuarPedindo != 2);
        } while (continuarPedindo == 1);
        System.out.println("Obrigado por usar nosso sistema! :)");
    }
    // MÉTODOS
    static int calcularEstoque(int estoque, int index, String sabor) {
        if (estoque == 0) {
            System.out.println("\nEstoque indisponível\n");
        } else {
            System.out.println("Quantidade de suco desejada: ");
            int qtd = input.nextInt();
            if (estoque < qtd) { // Faz com que não seja necessário checar números negativos na linha 88
                System.out.println("\nNão temos estoque suficiente para essa quantidade\n");
            } else {
                estoque -= qtd;
                if (estoque == 0) {
                    System.out.println("\nO estoque acabou de ser zerado");
                }
                double valorTotal = qtd * 10;
                // INFORMAÇÕES DA VENDA
                System.out.printf("\n=== DADOS DA COMPRA %d ===\n", index);
                System.out.printf("Sabor do suco: %s\n", sabor);
                System.out.printf("Quantidade: %d\n", qtd);
                System.out.printf("Valor total: R$%.2f\n\n", valorTotal);
            }
        }
        return estoque; // Valor default de retorno
    }
}