// EMPRESA SUCÃO - IVO E CARLOS
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    // VARIÁVEIS GLOBAIS
    public static Scanner input = new Scanner(System.in);
    public static int estoqueMorango = 2, estoqueGoiaba = 10, estoqueAbacaxi = 10, estoqueKiwi = 10, estoqueLaranja = 10, estoqueCaja = 10, estoqueCupuacu = 10, estoqueBacuri = 10, estoqueMelancia = 10, estoqueAcerola = 10;
    public static void main(String[] args) throws Exception {
        // VARIÁVEIS LOCAIS
        int login, senha;
        int novoPedido = 1;
        int i = 1; // Index da venda
        int relatorio = 1;
        boolean pedidoCancelado = false;
        ArrayList<String> saboresPedidos = new ArrayList<String>();
        int qtdCopos = 0;
        int valorPedido = 0;
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
        while (novoPedido == 1) {
            int qtdSabores = 0;
            System.out.printf("\n\n-> Cliente %d\n", i);
            // MENU PRINCIPAL
            showMenu();
            // Repetir a quantidade de sabores enquanto a opção for inválida
            do {
                // Variáveis do pedido
                int valorSabores = 0; // Valor total dos sabores na compra
                int confirmacaoPedido = 1;
                boolean estoqueVazioMorango = false, estoqueVazioGoiaba = false, estoqueVazioAbacaxi = false, estoqueVazioKiwi = false, estoqueVazioLaranja = false, estoqueVazioCaja = false, estoqueVazioCupuacu = false, estoqueVazioBacuri = false, estoqueVazioMelancia = false, estoqueVazioAcerola = false; // Estado de todos os estoques
                boolean estoqueVazio = false; // Estado do estoque total
                boolean[] todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Lista de todos os estoques
                saboresPedidos.clear();
                System.out.println("\nQuantos sabores você deseja pedir? (Máximo de 3 sabores)");
                qtdSabores = input.nextInt();
                if (qtdSabores >= 1 && qtdSabores <= 3) {
                    String resultadoTroca; // Novo sabor depois que o usuário fizer a troca ou não
                    // Quais sabores
                    for (int s = 1; s <= qtdSabores; s++) {
                        estoqueVazio = checarTodosEstoques(todosEstoques);
                        if (!estoqueVazio) {
                            System.out.printf("\n%dº Sabor do cliente %d\n", s, i);
                            int sabor = input.nextInt();
                            switch(sabor){
                                case 1: // Morango
                                    estoqueMorango = calcularEstoque(estoqueVazioMorango, estoqueMorango, 1);
                                    estoqueVazioMorango = retornarEstadoEstoque(estoqueMorango);
                                    valorSabores = calcularValorSabores(estoqueMorango, estoqueVazioMorango, valorSabores, "Morango");
                                    resultadoTroca = trocarSabor("Morango", estoqueVazioMorango, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 2: // Goiaba
                                    estoqueGoiaba = calcularEstoque(estoqueVazioGoiaba, estoqueGoiaba, 1);
                                    estoqueVazioGoiaba = retornarEstadoEstoque(estoqueGoiaba);
                                    valorSabores = calcularValorSabores(estoqueGoiaba, estoqueVazioGoiaba, valorSabores, "Goiaba");
                                    resultadoTroca = trocarSabor("Goiaba", estoqueVazioGoiaba, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 3: // Abacaxi
                                    estoqueAbacaxi = calcularEstoque(estoqueVazioGoiaba, estoqueAbacaxi, 1);
                                    estoqueVazioGoiaba = retornarEstadoEstoque(estoqueAbacaxi);
                                    valorSabores = calcularValorSabores(estoqueAbacaxi, estoqueVazioGoiaba, valorSabores, "Abacaxi");
                                    resultadoTroca = trocarSabor("Abacaxi", estoqueVazioGoiaba, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 4: // Kiwi
                                    estoqueKiwi = calcularEstoque(estoqueVazioGoiaba, estoqueKiwi, 1);
                                    estoqueVazioKiwi = retornarEstadoEstoque(estoqueKiwi);
                                    valorSabores = calcularValorSabores(estoqueKiwi, estoqueVazioKiwi, valorSabores, "Kiwi");
                                    resultadoTroca = trocarSabor("Kiwi", estoqueVazioKiwi, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 5: // Laranja
                                    estoqueLaranja = calcularEstoque(estoqueVazioGoiaba, estoqueLaranja, 1);
                                    estoqueVazioLaranja = retornarEstadoEstoque(estoqueLaranja);
                                    valorSabores = calcularValorSabores(estoqueLaranja, estoqueVazioLaranja, valorSabores, "Laranja");
                                    resultadoTroca = trocarSabor("Laranja", estoqueVazioLaranja, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 6: // Caja
                                    estoqueCaja = calcularEstoque(estoqueVazioGoiaba, estoqueCaja, 1);
                                    estoqueVazioCaja = retornarEstadoEstoque(estoqueCaja);
                                    valorSabores = calcularValorSabores(estoqueCaja, estoqueVazioCaja, valorSabores, "Caja");
                                    resultadoTroca = trocarSabor("Caja", estoqueVazioCaja, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 7: // Cupuacu
                                    estoqueCupuacu = calcularEstoque(estoqueVazioGoiaba, estoqueCupuacu, 1);
                                    estoqueVazioCupuacu = retornarEstadoEstoque(estoqueCupuacu);
                                    valorSabores = calcularValorSabores(estoqueCupuacu, estoqueVazioCupuacu, valorSabores, "Cupuacu");
                                    resultadoTroca = trocarSabor("Cupuacu", estoqueVazioCupuacu, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 8: // Bacuri
                                    estoqueBacuri = calcularEstoque(estoqueVazioGoiaba, estoqueBacuri, 1);
                                    estoqueVazioBacuri = retornarEstadoEstoque(estoqueBacuri);
                                    valorSabores = calcularValorSabores(estoqueBacuri, estoqueVazioBacuri, valorSabores, "Bacuri");
                                    resultadoTroca = trocarSabor("Bacuri", estoqueVazioBacuri, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 9: // Melancia
                                    estoqueMelancia = calcularEstoque(estoqueVazioGoiaba, estoqueMelancia, 1);
                                    estoqueVazioMelancia = retornarEstadoEstoque(estoqueMelancia);
                                    valorSabores = calcularValorSabores(estoqueMelancia, estoqueVazioMelancia, valorSabores, "Melancia");
                                    resultadoTroca = trocarSabor("Melancia", estoqueVazioMelancia, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 10: // Acerola
                                    estoqueAcerola = calcularEstoque(estoqueVazioGoiaba, estoqueAcerola, 1);
                                    estoqueVazioAcerola = retornarEstadoEstoque(estoqueAcerola);
                                    valorSabores = calcularValorSabores(estoqueAcerola, estoqueVazioAcerola, valorSabores, "Acerola");
                                    resultadoTroca = trocarSabor("Acerola", estoqueVazioAcerola, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                        }
                    }
                    // Quantidade de copos
                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atualizando os valores do array
                    estoqueVazio = checarTodosEstoques(todosEstoques);
                    if (!estoqueVazio) {
                        System.out.println("\nQuantidade de copos desejados");
                        qtdCopos = input.nextInt();
                        valorPedido = valorSabores * qtdCopos;
                    }
                    // Confirmação de pedido
                    do {
                        System.out.println("\n!- Confirme o pedido: (1. Confirmar - 2. Cancelar)");
                        confirmacaoPedido = input.nextInt();
                        switch(confirmacaoPedido){
                            case 1:
                                pedidoCancelado = false;
                                System.out.println("\nPedido confirmado com sucesso!");
                                break;
                            case 2:
                                pedidoCancelado = true;
                                saboresPedidos.clear();
                                qtdCopos = 0;
                                valorPedido = 0;
                                System.out.println("\nSeu pedido foi cancelado!");
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
                    System.out.println("\nDeseja imprimir um relatório da compra? (1. Sim - 2. Não)");
                    relatorio = input.nextInt();
                    switch(relatorio){
                        case 1:
                            System.out.println("\n===== Relatório =====");
                            System.out.println("Sabores pedidos: " + saboresPedidos);
                            System.out.println("Quantidade: " + qtdCopos);
                            System.out.println("Valor do pedido: R$" + valorPedido);
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
                System.out.println("\nDeseja fazer um novo pedido? 1. Sim - 2. Não");
                novoPedido = input.nextInt();
                if (novoPedido != 1 && novoPedido != 2) {
                    System.out.println("\n= ! Por favor, escolha uma opção válida\n");
                }
            } while (novoPedido != 1 && novoPedido != 2);
            i++;
        }
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
    public static boolean retornarEstadoEstoque(int estoque) {
        boolean resultado = (estoque == 0) ? true : false;
        return resultado;
    }
    public static int calcularValorSabores(int estoque, boolean vazio, int valor, String sabor) {
        if (vazio) {
            return valor;
        }
        if (estoque == 0) { // Feedback para o usuário
            System.out.println("O estoque acabou de ser zerado");
        }
        valor += 10;
        return valor;
    }
    public static String trocarSabor(String sabor, boolean vazio, boolean[] todosEstoques) {
        if (!vazio) {
            return sabor; // Retornar o mesmo sabor
        }
        System.out.println("\nO estoque desse sabor está indisponível");
        int trocar = 2;
        do {
            System.out.println("\nDeseja trocar o sabor? (1. Sim - 2. Não)");
            trocar = input.nextInt();
            switch(trocar){
                case 1:
                    showMenu();
                    System.out.println("\nNovo sabor: ");
                    int novoSabor = input.nextInt();
                    while(novoSabor >= 1 && novoSabor <= 10) {
                        switch(novoSabor){
                            case 1:
                                sabor = checarEstoqueNovoSabor(sabor, "Morango", todosEstoques, 0);
                                novoSabor = 11; // Sair do while
                                break;
                            case 2:
                                sabor = checarEstoqueNovoSabor(sabor, "Goiaba", todosEstoques, 1);
                                novoSabor = 11;
                                break;
                            case 3:
                                sabor = checarEstoqueNovoSabor(sabor, "Abacaxi com hortelã", todosEstoques, 2);
                                novoSabor = 11;
                                break;
                            case 4:
                                sabor = checarEstoqueNovoSabor(sabor, "Kiwi", todosEstoques, 3);
                                novoSabor = 11;
                                break;
                            case 5:
                                sabor = checarEstoqueNovoSabor(sabor, "Laranja", todosEstoques, 4);
                                novoSabor = 11;
                                break;
                            case 6:
                                sabor = checarEstoqueNovoSabor(sabor, "Cajá", todosEstoques, 5);
                                novoSabor = 11;
                                break;
                            case 7:
                                sabor = checarEstoqueNovoSabor(sabor, "Cupuaçu", todosEstoques, 6);
                                novoSabor = 11;
                                break;
                            case 8:
                                sabor = checarEstoqueNovoSabor(sabor, "Bacuri", todosEstoques, 7);
                                novoSabor = 11;
                                break;
                            case 9:
                                sabor = checarEstoqueNovoSabor(sabor, "Melancia", todosEstoques, 8);
                                novoSabor = 11;
                                break;
                            case 10:
                                sabor = checarEstoqueNovoSabor(sabor, "Acerola", todosEstoques, 9);
                                novoSabor = 11;
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    }
                    break;
                case 2:
                    return null; // Retornar nada 
                default:
                    System.out.println("Opção inválida");
                    trocar = 3;
                    break;
            }
        } while(trocar == 3);
        return sabor; // Vai retornar o novo sabor
    }
    public static String checarEstoqueNovoSabor(String sabor, String novoSabor, boolean[] todosEstoques, int index) {
        if (!todosEstoques[index]) { // Se o estoque em especifico estiver vazio
            System.out.println("* Este sabor está indisponível");
            int opcaoNovoSabor = 1;
            while (opcaoNovoSabor >= 1 && opcaoNovoSabor <= 10) {
                System.out.println("! Por favor, selecione outra opção");
                opcaoNovoSabor = input.nextInt();
                switch (opcaoNovoSabor) {
                    case 1:
                        if (todosEstoques[0]) {
                            novoSabor = "Morango";
                            opcaoNovoSabor = 11; // Sair do while
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 2:
                        if (todosEstoques[1]) {
                            novoSabor = "Goiaba";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 3:
                        if (todosEstoques[2]) {
                            novoSabor = "Abacaxi com hortelã";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 4:
                        if (todosEstoques[3]) {
                            novoSabor = "Kiwi";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 5:
                        if (todosEstoques[4]) {
                            novoSabor = "Laranja";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 6:
                        if (todosEstoques[5]) {
                            novoSabor = "Cajá";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 7:
                        if (todosEstoques[6]) {
                            novoSabor = "Cupuaçu";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 8:
                        if (todosEstoques[7]) {
                            novoSabor = "Bacuri";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 9:
                        if (todosEstoques[8]) {
                            novoSabor = "Melancia";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    case 10:
                        if (todosEstoques[9]) {
                            novoSabor = "Acerola";
                            opcaoNovoSabor = 11;
                        } else {
                            System.out.println("* Este sabor está indisponível");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
            return novoSabor;
        }
        sabor = novoSabor;
        System.out.printf("Sabor escolhido: %s", sabor);
        return sabor;
    }
    public static int calcularEstoque(boolean vazio, int estoque, int quantidadeDiminuida) {
        if (estoque <= 0) {
            return 0;
        }
        estoque -= quantidadeDiminuida;
        return estoque;
    }
    public static boolean checarTodosEstoques(boolean[] array) {
        for(int i = 0; i < array.length; i++) {
            if (array[i]) {
                return true;
            }
         }
         return false;
    }
}