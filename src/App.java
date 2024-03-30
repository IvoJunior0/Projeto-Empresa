// EMPRESA SUCÃO - IVO E CARLOS
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    // VARIÁVEIS GLOBAIS
    public static Scanner input = new Scanner(System.in);
    public static int estoqueMorango = 10, estoqueGoiaba = 10, estoqueAbacaxi = 10, estoqueKiwi = 10, estoqueLaranja = 10, estoqueCaja = 10, estoqueCupuacu = 10, estoqueBacuri = 10, estoqueMelancia = 10, estoqueAcerola = 10;
    public static void main(String[] args) throws Exception {
        // VARIÁVEIS LOCAIS
        int login, senha;
        int novoPedido = 1;
        int i = 1; // Index da venda
        int relatorio = 1;
        boolean pedidoCancelado = false;
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
            int qtdSabores = 0;
            System.out.printf("\n\n-> Cliente %d\n", i);
            // MENU PRINCIPAL
            showMenu();
            // Repetir a quantidade de sabores enquanto a opção for inválida
            do {
                // Variáveis do pedido
                int valorSabores = 0; // Valor total dos sabores na compra
                int qtdCopos = 0;
                int valorPedido = 0;
                int confirmacaoPedido = 1;
                boolean estoqueVazio = false;
                System.out.println("Quantos sabores você deseja pedir? (Máximo de 3 sabores)");
                qtdSabores = input.nextInt();
                if (qtdSabores >= 1 && qtdSabores <= 3) {
                    ArrayList<String> saboresPedidos = new ArrayList<String>();
                    // Quais sabores
                    for (int s = 1; s <= qtdSabores; s++) {
                        if (!estoqueVazio) {
                            System.out.printf("%dº Sabor do cliente %d\n", s, i);
                            int sabor = input.nextInt();
                            switch(sabor){
                                case 1:
                                    valorSabores = calcularValorSabores(estoqueMorango, estoqueVazio, valorSabores, "Morango");
                                    break;
                                case 2:
                                    valorSabores = calcularValorSabores(estoqueGoiaba, estoqueVazio, valorSabores, "Goiaba");
                                    break;
                                case 3:
                                    valorSabores = calcularValorSabores(estoqueAbacaxi, estoqueVazio, valorSabores, "Abacaxi");
                                    break;
                                case 4:
                                    valorSabores = calcularValorSabores(estoqueKiwi, estoqueVazio, valorSabores, "Kiwi");
                                    break;
                                case 5:
                                    valorSabores = calcularValorSabores(estoqueLaranja, estoqueVazio, valorSabores, "Laranja");
                                    break;
                                case 6:
                                    valorSabores = calcularValorSabores(estoqueCaja, estoqueVazio, valorSabores, "Caja");
                                    break;
                                case 7:
                                    valorSabores = calcularValorSabores(estoqueCupuacu, estoqueVazio, valorSabores, "Cupuacu");
                                    break;
                                case 8:
                                    valorSabores = calcularValorSabores(estoqueBacuri, estoqueVazio, valorSabores, "Bacuri");
                                    break;
                                case 9:
                                    valorSabores = calcularValorSabores(estoqueMelancia, estoqueVazio, valorSabores, "Melancia");
                                    break;
                                case 10:
                                    valorSabores = calcularValorSabores(estoqueAcerola, estoqueVazio, valorSabores, "Acerola");
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                        }
                    }
                    // Quantidade de copos
                    if (!estoqueVazio) {
                        System.out.println("Quantidade de copos desejados");
                        qtdCopos = input.nextInt();
                        valorPedido = valorSabores * qtdCopos;
                    }
                    // Confirmação de pedido
                    do {
                        System.out.println("!- Confirme o pedido: (1. Confirmar - 2. Cancelar)");
                        confirmacaoPedido = input.nextInt();
                        switch(confirmacaoPedido){
                            case 1:
                                pedidoCancelado = false;
                                System.out.println("Pedido confirmado com sucesso!");
                                break;
                            case 2:
                                pedidoCancelado = true;
                                saboresPedidos.clear();
                                qtdCopos = 0;
                                valorPedido = 0;
                                System.out.println("Seu pedido foi cancelado!");
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    } while(confirmacaoPedido != 1 && confirmacaoPedido != 2); // Repetir enquanto o input for inválido
                } else {
                    System.out.println("-> Por favor, digite uma quantidade válida");
                }
            } while (qtdSabores < 1 || qtdSabores > 3);
            // Gerar relatório
            if (!pedidoCancelado) {
                do {
                    System.out.println("Deseja imprimir um relatório da compra? (1. Sim - 2. Não)");
                    relatorio = input.nextInt();
                    switch(relatorio){
                        case 1:
                            System.out.println("* Relatório");
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Opção inválida");
                            relatorio = 3;
                            break;
                    }
                } while(relatorio == 3);
            }
            // Opção de fazer mais um pedido"
            do {
                System.out.println("Deseja fazer um novo pedido? 1. Sim - 2. Não");
                novoPedido = input.nextInt();
                if (novoPedido != 1 && novoPedido != 2) {
                    System.out.println("\n= ! Por favor, escolha uma opção válida\n");
                }
            } while (novoPedido != 1 && novoPedido != 2);
            i++;
        } while (novoPedido == 1);
        System.out.println("Obrigado por usar nosso sistema! :)");
    }
    // MÉTODOS
    public static void showMenu() {
        System.out.println("\n=== SUCÃO ===");
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
    }
    public static int calcularValorSabores(int estoque, boolean vazio, int valor, String sabor) {
        if (estoque == 0) {
            vazio = true;
        } else {
            if (estoque == 0) { // Feedback para o usuário
                System.out.println("O estoque acabou de ser zerado");
            }
            valor += 10;
        }
        return valor;
    }
    public static String trocarSabor(String sabor, boolean vazio) {
        if (vazio) {
            System.out.println("O estoque desse sabor está indisponível");
            int trocar = 2;
            do {
                System.out.println("Deseja trocar o sabor? (1. Sim - 2. Não)");
                trocar = input.nextInt();
                switch(trocar){
                    case 1:
                        showMenu();
                        System.out.println("Novo sabor: ");
                        int novoSabor = input.nextInt();
                        switch(novoSabor){
                            case 1:
                                sabor = "Morango";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 2:
                                sabor = "Goiaba";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 3:
                                sabor = "Abacaxi com hortelã";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 4:
                                sabor = "Kiwi";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 5:
                                sabor = "Laranja";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 6:
                                sabor = "Cajá";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 7:
                                sabor = "Cupuaçu";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 8:
                                sabor = "Bacuri";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 9:
                                sabor = "Melancia";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                            case 10:
                                sabor = "Acerola";
                                System.out.printf("Sabor escolhido: %s", sabor);
                                break;
                        }
                        break;
                    case 2:
                        return null;
                    default:
                        System.out.println("Opção inválida");
                        trocar = 3;
                        break;
                }
            } while(trocar == 3);
        }
        return sabor;
    }
}