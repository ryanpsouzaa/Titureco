package application;

import entitites.AtrativoTuristico;
import entitites.Praia;
import entitites.TiturecoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaTitureco {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner resp = new Scanner(System.in);

        TiturecoList listaAtrativo = new TiturecoList();

        boolean repetidor = true;

        while (repetidor) {
            System.out.println();
            System.out.println("1.Cadastrar Atrativo\n" + "2.Pesquisar Atrativos da Cidade\n" + "3.Listar Todos os Atrativos\n" + "4.Apagar Atrativo\n" + "5.Sair\n");
            int opcao = Integer.parseInt(resp.nextLine());
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = resp.nextLine();

                    System.out.print("Digite a latitude: ");
                    double latitude = Double.parseDouble(resp.nextLine());

                    System.out.print("Digite a longitude: ");
                    double longitude = Double.parseDouble(resp.nextLine());

                    System.out.print("Descreva como chegar: ");
                    String comoChegar = resp.nextLine();

                    System.out.print("Digite a cidade: ");
                    String cidade = resp.nextLine();

                    System.out.print("Digite o estado: ");
                    String estado = resp.nextLine();

                    System.out.print("Esse atrativo possui praia? (S ou N) ");
                    char praia = resp.nextLine().charAt(0);

                    if (praia == 'S') {
                        System.out.print("Essa praia é apropriada para o banho? (S ou N) ");
                        boolean apropriadaParaBanho;
                        char validacaoApropriadaParaBanho = resp.nextLine().charAt(0);
                        if (validacaoApropriadaParaBanho == 'S') {
                            apropriadaParaBanho = true;
                        } else {
                            apropriadaParaBanho = false;
                        }

                        System.out.print("Essa praia possui perigo com tubarões? (S ou N) ");
                        boolean perigoTubaroes;
                        char validacaoPerigoTubaroes = resp.nextLine().charAt(0);
                        if (validacaoPerigoTubaroes == 'S') {
                            perigoTubaroes = true;
                        } else {
                            perigoTubaroes = false;
                        }

                        System.out.print("Digite o tipo de orla: ");
                        String tipoOrla = resp.nextLine();

                        AtrativoTuristico atrativoElemento = new Praia(nome, latitude, longitude, comoChegar, cidade, estado, apropriadaParaBanho, perigoTubaroes, tipoOrla);
                        listaAtrativo.cadastrarAtrativo(atrativoElemento);

                    } else {
                        AtrativoTuristico atrativoElemento = new AtrativoTuristico(nome, latitude, longitude, comoChegar, cidade, estado);
                        listaAtrativo.cadastrarAtrativo(atrativoElemento);

                    }
                    System.out.println("Atrativo cadastrado.");
                    break;
                case 2:
                    System.out.print("Digite a cidade: ");
                    String cidadePesquisa = resp.nextLine();

                    System.out.print("Digite o estado: ");
                    String estadoPesquisa = resp.nextLine();

                    List<AtrativoTuristico> listaAtrativosPesquisados = listaAtrativo.pesquisaAtrativosDaCidade(cidadePesquisa, estadoPesquisa);
                    if (listaAtrativosPesquisados.isEmpty()) {
                        System.out.println("Não foram encontrados atrativos com a cidade e estado correspondentes.");
                        break;
                    } else {
                        System.out.println("Atrativos da cidade e estado correspondentes: ");
                        for (AtrativoTuristico a : listaAtrativosPesquisados) {
                            System.out.println(a.toString());
                        }
                        break;
                    }
                case 3:
                    List<AtrativoTuristico> listaTodosAtrativos = listaAtrativo.getAtrativos();
                    for (AtrativoTuristico a : listaTodosAtrativos) {
                        System.out.println(a.toString());
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do atrativo que deseja remover: ");
                    String nomeAtrativo = resp.nextLine();

                    System.out.print("Digite a cidade do atrativo: ");
                    String cidadeAtrativo = resp.nextLine();

                    System.out.print("Digite o estado do atrativo: ");
                    String estadoAtrativo = resp.nextLine();

                    boolean confirmacao = listaAtrativo.apagarAtrativo(nomeAtrativo, cidadeAtrativo, estadoAtrativo);
                     if (confirmacao) {
                        System.out.println("Atrativo deletado");
                        break;
                    } else {
                        System.out.print("Erro ao deletar o atrativo");
                        break;
                    }
                case 5:
                    repetidor = false;
                    break;

                default:
                    System.out.println("Opção incorreta!");
                    break;
            }
        }
        System.out.println("Programa encerrado.");
        resp.close();
    }
}
