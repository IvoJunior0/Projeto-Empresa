// EMPRESA SUCÃO - IVO E CARLOS
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    // VARIÁVEIS GLOBAIS
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // VARIÁVEIS LOCAIS
        int login, senha;
        int estoqueMorango, estoqueGoiaba, estoqueAbacaxi, estoqueKiwi, estoqueLaranja, estoqueCaja, estoqueCupuacu, estoqueBacuri, estoqueMelancia, estoqueAcerola;
        estoqueMorango = estoqueGoiaba = estoqueAbacaxi = estoqueKiwi = estoqueLaranja = estoqueCaja = estoqueCupuacu = estoqueBacuri = estoqueMelancia = estoqueAcerola = 10;
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
            System.out.printf("\n\n-> Cliente %d\n\n", i);
            // MENU PRINCIPAL
            System.out.println("=== SUCÃO ===");
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
                                    if (estoqueMorango == 0) {
                                        estoqueVazio = true;
                                        System.out.println("O estoque desse sabor está indisponível");
                                        int trocar = 2;
                                        do {
                                            System.out.println("Deseja trocar o sabor? (1. Sim - 2. Não)");
                                            trocar = input.nextInt();
                                            switch(trocar){
                                                case 1:
                                                    break;
                                                case 2:
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida");
                                                    trocar = 3;
                                                    break;
                                            }
                                        } while(trocar == 3);
                                    } else {
                                        if (estoqueMorango == 0) { // Feedback para o usuário
                                            System.out.println("O estoque acabou de ser zerado");
                                        }
                                        saboresPedidos.add("Morango");
                                        estoqueMorango--;
                                        valorSabores += 10;
                                    }
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
            // MENU "DESEJA CONTINUAR?"
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
    public static ArrayList<Object> calcularSabor(int estoque, boolean vazio, ArrayList<String> sabores, int valor) {
        ArrayList<Object> retorno = new ArrayList <>();
        if (estoque == 0) {
            vazio = true;
            System.out.println("O estoque desse sabor está indisponível");
            int trocar = 2;
            do {
                System.out.println("Deseja trocar o sabor? (1. Sim - 2. Não)");
                trocar = input.nextInt();
                switch(trocar){
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        trocar = 3;
                        break;
                }
            } while(trocar == 3);
        } else {
            if (estoque == 0) { // Feedback para o usuário
                System.out.println("O estoque acabou de ser zerado");
            }
            sabores.add("Morango");
            estoque--;
            valor += 10;
        }
        return retorno;
    }
    public static void adicionarSabor(boolean vazio, int numeroSabor, int cliente) {
        if (!vazio) {
            System.out.printf("%dº Sabor do cliente %d\n", numeroSabor, cliente);
            int sabor = input.nextInt();
            switch(sabor){
                case 1:
                    break;
            }
        }
    }
}