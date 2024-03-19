// EMPRESA SUCÃO - IVO E CARLOS
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        // VARIÁVEIS
        Scanner input = new Scanner(System.in);
        int login, senha;
        int estoqueMorango, estoqueGoiaba, estoqueAbacaxi, estoqueKiwi, estoqueLaranja, estoqueCaja, estoqueCupuacu, estoqueBacuri, estoqueMelancia, estoqueAcerola;
        estoqueMorango = estoqueGoiaba = estoqueAbacaxi = estoqueKiwi = estoqueLaranja = estoqueCaja = estoqueCupuacu = estoqueBacuri = estoqueMelancia = estoqueAcerola = 10;
        int continuarPedindo = 1;
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
                    if (estoqueMorango == 0) {
                        System.out.println("Estoque indisponível");
                        break;
                    } else {
                        System.out.println("Quantidade de suco desejada: ");
                        int qtd = input.nextInt();
                        if (estoqueMorango < qtd) {
                            System.out.println("Não temos estoque suficiente para essa quantidade");
                        }
                        else {
                            estoqueMorango -= qtd;
                            System.out.println(estoqueMorango);
                        }
                        break;
                    }
            
                default:
                    break;
            }
        } while (continuarPedindo == 1);
    }
}