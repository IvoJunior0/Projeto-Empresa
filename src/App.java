// EMPRESA SUCÃO - IVO E CARLOS
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    // VARIÁVEIS GLOBAIS
    public static Scanner input = new Scanner(System.in);
    public static int estoqueMorango = 2, estoqueGoiaba = 0, estoqueAbacaxi = 10, estoqueKiwi = 10, estoqueLaranja = 10, estoqueCaja = 10, estoqueCupuacu = 10, estoqueBacuri = 10, estoqueMelancia = 10, estoqueAcerola = 10; // Estoque de cada sabor
    public static boolean estoqueVazioMorango = false, estoqueVazioGoiaba = false, estoqueVazioAbacaxi = false, estoqueVazioKiwi = false, estoqueVazioLaranja = false, estoqueVazioCaja = false, estoqueVazioCupuacu = false, estoqueVazioBacuri = false, estoqueVazioMelancia = false, estoqueVazioAcerola = false; // Estado de todos os estoques
    public static boolean estoqueVazio = false; // Estado do estoque total
    // MÉTODO PRINCIPAL
    public static void main(String[] args) throws Exception {
        // Variáveis principais do método main
        int login, senha;
        int novoCliente = 1;
        int i = 1; // Index da venda
        boolean pedidoCancelado = false;
        ArrayList<String> saboresPedidos = new ArrayList<String>();
        int qtdCopos = 0;
        double valorTotal = 0.0;
        int qtdTotalCopos = 0;
        // Tela inicial
        System.out.println("\033[0;1m=================================");
        System.out.println("| BEM VINDOS A EMPRESA DE SUCOS |");
        System.out.println("|                               |");
        System.out.println("|             SUCÃO             |");
        System.out.println("|                               |");
        System.out.println("|   SISTEMA DESENVOLVIDO POR:   |");
        System.out.println("|          - Ivo Junior         |");
        System.out.println("|       - Carlos Henrique       |");
        System.out.println("=================================");
        // Sistema de login
        do {
            System.out.println("\n\033[0mDigite o seu login: ");
            login = input.nextInt();
            System.out.println("\nDigite a sua senha: ");
            senha = input.nextInt();
            if (login != 111 || senha != 111) {
                System.out.println("\nLogin ou senha inválidos");
            }
        } while (login != 111 || senha != 111);
        // Programa principal
        while (novoCliente == 1) {
            double valorPedido = 0.0;
            int opcaoNovoSabor = 2;
            int qtdSabores = 0;
            System.out.printf("\n\n-> Cliente %d\n", i);
            // Repetir a quantidade de sabores enquanto a opção for inválida
            do {
                // Menu de opções
                showMenu();
                // Variáveis do pedido
                int valorSabores = 0; // Valor total dos sabores na compra
                int confirmacaoPedido = 1;
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
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Morango", estoqueVazioMorango, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 2: // Goiaba
                                    estoqueGoiaba = calcularEstoque(estoqueVazioGoiaba, estoqueGoiaba, 1);
                                    estoqueVazioGoiaba = retornarEstadoEstoque(estoqueGoiaba);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Goiaba", estoqueVazioGoiaba, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 3: // Abacaxi
                                    estoqueAbacaxi = calcularEstoque(estoqueVazioGoiaba, estoqueAbacaxi, 1);
                                    estoqueVazioGoiaba = retornarEstadoEstoque(estoqueAbacaxi);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Abacaxi", estoqueVazioGoiaba, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 4: // Kiwi
                                    estoqueKiwi = calcularEstoque(estoqueVazioGoiaba, estoqueKiwi, 1);
                                    estoqueVazioKiwi = retornarEstadoEstoque(estoqueKiwi);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Kiwi", estoqueVazioKiwi, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 5: // Laranja
                                    estoqueLaranja = calcularEstoque(estoqueVazioGoiaba, estoqueLaranja, 1);
                                    estoqueVazioLaranja = retornarEstadoEstoque(estoqueLaranja);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Laranja", estoqueVazioLaranja, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 6: // Caja
                                    estoqueCaja = calcularEstoque(estoqueVazioGoiaba, estoqueCaja, 1);
                                    estoqueVazioCaja = retornarEstadoEstoque(estoqueCaja);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Caja", estoqueVazioCaja, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 7: // Cupuacu
                                    estoqueCupuacu = calcularEstoque(estoqueVazioGoiaba, estoqueCupuacu, 1);
                                    estoqueVazioCupuacu = retornarEstadoEstoque(estoqueCupuacu);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Cupuacu", estoqueVazioCupuacu, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 8: // Bacuri
                                    estoqueBacuri = calcularEstoque(estoqueVazioGoiaba, estoqueBacuri, 1);
                                    estoqueVazioBacuri = retornarEstadoEstoque(estoqueBacuri);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Bacuri", estoqueVazioBacuri, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 9: // Melancia
                                    estoqueMelancia = calcularEstoque(estoqueVazioGoiaba, estoqueMelancia, 1);
                                    estoqueVazioMelancia = retornarEstadoEstoque(estoqueMelancia);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Melancia", estoqueVazioMelancia, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                case 10: // Acerola
                                    estoqueAcerola = calcularEstoque(estoqueVazioGoiaba, estoqueAcerola, 1);
                                    estoqueVazioAcerola = retornarEstadoEstoque(estoqueAcerola);
                                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atuzalizando o valor
                                    resultadoTroca = trocarSabor("Acerola", estoqueVazioAcerola, todosEstoques);
                                    saboresPedidos.add(resultadoTroca);
                                    break;
                                default:
                                    System.out.println("\n! Opção inválida");
                                    s--; // Ele repete o for mais uma vez
                                    break;
                            }
                        }
                    }
                    // Quantidade de copos
                    todosEstoques = new boolean[]{estoqueVazioMorango, estoqueVazioGoiaba, estoqueVazioAbacaxi, estoqueVazioKiwi, estoqueVazioLaranja, estoqueVazioCaja, estoqueVazioCupuacu, estoqueVazioBacuri, estoqueVazioMelancia, estoqueVazioAcerola}; // Atualizando os valores do array
                    estoqueVazio = checarTodosEstoques(todosEstoques);
                    saboresPedidos.remove(null);
                    if (!estoqueVazio) {
                        do {
                            System.out.println("\nQuantidade de copos desejados");
                            qtdCopos = input.nextInt();
                            if (qtdCopos < 0) {
                                System.out.println("\n-> Números negativos são inválidos!");
                            } else if (qtdCopos == 0) {
                                System.out.println("\n-> Valores nulos são invalidos!");
                            } else if (qtdCopos == 1) { // O estoque não muda se ele pedir somente um copo
                                valorPedido = (saboresPedidos.size() * 10) * qtdCopos;
                            } else {
                                // Contadores de pedidos repetidos
                                int contadorMorango = 0;
                                int contadorGoiaba = 0;
                                int contadorAbacaxi = 0;
                                int contadorKiwi = 0;
                                int contadorLaranja = 0;
                                int contadorCaja = 0;
                                int contadorCupuacu = 0;
                                int contadorBacuri = 0;
                                int contadorMelancia = 0;
                                int contadorAcerola = 0;
                                // Checando se há pedidos repetidos
                                if (saboresPedidos != null) {
                                    for (String item : saboresPedidos) {
                                        switch (item) {
                                            case "Morango":
                                                contadorMorango++;
                                                break;
                                            case "Goiaba":
                                                contadorGoiaba++;
                                                break;
                                            case "Abacaxi":
                                                contadorAbacaxi++;
                                                break;
                                            case "Kiwi":
                                                contadorKiwi++;
                                                break;
                                            case "Laranja":
                                                contadorLaranja++;
                                                break;
                                            case "Caja":
                                                contadorCaja++;
                                                break;
                                            case "Cupuacu":
                                                contadorCupuacu++;
                                                break;
                                            case "Bacuri":
                                                contadorBacuri++;
                                                break;
                                            case "Melancia":
                                                contadorMelancia++;
                                                break;
                                            case "Acerola":
                                                contadorAcerola++;
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                // Mudando os estoques 
                                estoqueMorango -= contadorMorango * qtdCopos;
                                estoqueGoiaba -= contadorGoiaba * qtdCopos;
                                estoqueAbacaxi -= contadorAbacaxi * qtdCopos;
                                estoqueKiwi -= contadorKiwi * qtdCopos;
                                estoqueLaranja -= contadorLaranja * qtdCopos;
                                estoqueCaja -= contadorCaja * qtdCopos;
                                estoqueCupuacu -= contadorCupuacu * qtdCopos;
                                estoqueBacuri -= contadorBacuri * qtdCopos;
                                estoqueMelancia -= contadorMelancia * qtdCopos;
                                estoqueAcerola -= contadorAcerola * qtdCopos;
                                // Valor do pedido
                                valorPedido = (saboresPedidos.size() * 10) * qtdCopos;
                                System.out.println("foi");
                            }
                        } while (qtdCopos <= 0);
                    }
                    // Imprimindo informações do pedido
                    System.out.println("\nInformações do pedido");
                    System.out.println("Sabores: " + saboresPedidos);
                    System.out.println("Quantidade copos: " + qtdCopos);
                    System.out.printf("Valor do pedido: R$%.2f\n", valorPedido);
                    // Confirmação de pedido
                    do {
                        System.out.println("\n!- Confirme o pedido: (1. Confirmar - 2. Cancelar)");
                        confirmacaoPedido = input.nextInt();
                        switch(confirmacaoPedido){
                            case 1: // Confirmado
                                pedidoCancelado = false;
                                valorTotal += valorPedido;
                                qtdTotalCopos += qtdCopos;
                                System.out.println("\nPedido confirmado com sucesso!");
                                break;
                            case 2: // Cancelado
                                pedidoCancelado = true;
                                saboresPedidos.clear();
                                qtdCopos = 0;
                                valorPedido = 0;
                                System.out.println("\nSeu pedido foi cancelado!");
                                break;
                            default:
                                System.out.println("\n-> Opção inválida!");
                                break;
                        }
                    } while(confirmacaoPedido != 1 && confirmacaoPedido != 2); // Repetir enquanto o input for inválido
                    // Novo suco
                    do {
                        System.out.println("\n! Deseja pedir um novo suco? 1. Sim - 2.Não");
                        opcaoNovoSabor = input.nextInt();
                        if (opcaoNovoSabor != 1 && opcaoNovoSabor != 2) {
                            System.out.println("\n> Opção inválida");
                        }
                    } while(opcaoNovoSabor != 1 && opcaoNovoSabor != 2);
                } else {
                    System.out.println("\n-> Por favor, digite uma quantidade válida");
                }
            } while ((qtdSabores < 1 || qtdSabores > 3) || (opcaoNovoSabor == 1));
            // Gerar relatório da compra
            System.out.println("\n\033[0;1m===== Relatório da empresa =====");
            System.out.printf("Quantidade de sucos vendidos: %d\n", qtdTotalCopos);
            System.out.printf("Valor total: R$%.2f\n", valorTotal);
            // Cadastrar novo cliente
            do {
                System.out.println("\n\033[0mDeseja cadastrar um novo cliente? 1. Sim - 2. Não");
                novoCliente = input.nextInt();
                switch(novoCliente) {
                    case 1:
                        i++;
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } while (novoCliente != 1 && novoCliente != 2);
        }
        System.out.println("\nObrigado por usar nosso sistema! :)\n");
    }
    // MÉTODOS
    public static void showMenu() {
        System.out.println("\n\033[0;1m##---------- SUCÃO: MENU ---------##");
        System.out.println("|----------------------------------|");
        System.out.println("| 1. Morango - R$10,00             |");
        System.out.println("| 2. Goiaba - R$10,00              |");
        System.out.println("| 3. Abacaxi com hortelã - R$10,00 |");
        System.out.println("| 4. Kiwi - R$10,00                |");
        System.out.println("| 5. Laranja - R$10,00             |");
        System.out.println("| 6. Cajá - R$10,00                |");
        System.out.println("| 7. Cupuaçu - R$10,00             |");
        System.out.println("| 8. Bacuri - R$10,00              |");
        System.out.println("| 9. Melancia - R$10,00            |");
        System.out.println("| 10. Acerola - R$10,00            |");
        System.out.println("|----------------------------------|\033[0m");
    }
    public static boolean retornarEstadoEstoque(int estoque) {
        boolean resultado = (estoque == 0) ? true : false;
        return resultado;
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
                    int novoSabor = 1;
                    do {
                        System.out.println("\nNovo sabor: ");
                        novoSabor = input.nextInt();
                        switch(novoSabor){
                            case 1: // Morango
                                sabor = validacaoNovoSabor("Morango", todosEstoques[0], 1);
                                break;
                            case 2: // Goiaba
                                sabor = validacaoNovoSabor("Goiaba", todosEstoques[1], 2);
                                break;
                            case 3: // Abacaxi
                                sabor = validacaoNovoSabor("Abacaxi", todosEstoques[2], 3);
                                break;
                            case 4: // Kiwi
                                sabor = validacaoNovoSabor("Kiwi", todosEstoques[3], 4);
                                break;
                            case 5: // Laranja
                                sabor = validacaoNovoSabor("Laranja", todosEstoques[4], 5);
                                break;
                            case 6: // Cajá
                                sabor = validacaoNovoSabor("Cajá", todosEstoques[5], 6);
                                break;
                            case 7: // Cupuaçu
                                sabor = validacaoNovoSabor("Cupuaçu", todosEstoques[6], 7);
                                break;
                            case 8: // Bacuri
                                sabor = validacaoNovoSabor("Bacuri", todosEstoques[7], 8);
                                break;
                            case 9: // Melancia
                                sabor = validacaoNovoSabor("Melancia", todosEstoques[8], 9);
                                break;
                            case 10: // Acerola
                                sabor = validacaoNovoSabor("Acerola", todosEstoques[9], 10);
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    } while(novoSabor < 1 && novoSabor > 10);
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
    public static String validacaoNovoSabor(String novoSabor, boolean estadoAntigoSabor, int opcaoAntiga) {
        int opcaoNovoSabor = 0;
        boolean novoSaborValido = true;
        if (estadoAntigoSabor) { // Se o estoque do antigo sabor estiver esgotado
            do {
                System.out.println("\n! Estoque deste sabor está esgotado");
                System.out.println("-> Por favor, Escolha outro sabor: ");
                opcaoNovoSabor = input.nextInt();
                switch(opcaoNovoSabor){
                    case 1: // Morango
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioMorango);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Morango");
                        estoqueMorango--;
                        break;
                    case 2: // Goiaba
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioGoiaba);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Goiaba");
                        estoqueGoiaba--;
                        break;
                    case 3: // Abacaxi
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioAbacaxi);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Abacaxi");
                        estoqueAbacaxi--;
                        break;
                    case 4: // Kiwi
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioKiwi);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Kiwi");
                        estoqueKiwi--;
                        break;
                    case 5: // Laranja
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioLaranja);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Laranja");
                        estoqueLaranja--;
                        break;
                    case 6: // Cajá
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioCaja);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Cajá");
                        estoqueCaja--;
                        break;
                    case 7: // Cupuaçu
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioCupuacu);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Cupuaçu");
                        estoqueCupuacu--;
                        break;
                    case 8: // Bacuri
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioBacuri);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Bacuri");
                        estoqueBacuri--;
                        break;
                    case 9: // Melancia
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioMelancia);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Melancia");
                        estoqueMelancia--;
                        break;
                    case 10: // Acerola
                        novoSaborValido = testarEstadoNovoSabor(estoqueVazioAcerola);
                        novoSabor = adicionandoNovoSabor(novoSaborValido, "Acerola");
                        estoqueAcerola--;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } while(opcaoNovoSabor == opcaoAntiga || !novoSaborValido);
        }
        return novoSabor;
    }
    public static boolean testarEstadoNovoSabor(boolean estoque) {
        boolean novoEstadoEstoque = (estoque) ? false : true;
        return novoEstadoEstoque;
    }
    public static String adicionandoNovoSabor(boolean saborValido, String novoSabor) { // Retorna o novo sabor se ele estiver disponível
        if (!saborValido) {
            return null;
        }
        return novoSabor;
    }
    public static int calcularEstoque(boolean vazio, int estoque, int quantidadeDiminuida) {
        if (estoque <= 0) {
            return 0;
        }
        estoque -= quantidadeDiminuida;
        return estoque;
    }
    public static boolean checarTodosEstoques(boolean[] array) {
        int total = 0; // Contador de estoques vazios
        for(int i = 0; i < array.length; i++) {
            if (array[i]) { // Testar se algum estoque está vazio
                total++;
            }
            if (total == 10) {
                return true;
            }
         }
         return false;
    }
}