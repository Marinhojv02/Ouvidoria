package ouvidoria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int deletPosition;
        boolean running = true;

        Scanner sc = new Scanner(System.in);
        Formatter menu = new Formatter();
        ClaimList claims = new ClaimList();
        ComplimentList compliments = new ComplimentList();
        SuggestionList suggestions = new SuggestionList();

        do
        {

            System.out.println("Menu Principal");
            System.out.println(menu.mainMenu());
            System.out.print("\nInsira sua opcao:\n");
            int menuSelection = sc.nextInt();

            switch (menuSelection) {

                case 1 -> {
                    System.out.println("\nAdicionar");
                    System.out.println(menu.menuType());
                    System.out.print("\nQual manifestacao deseja acessar:\n");
                    int typeToAdd = sc.nextInt();
                    sc.nextLine();

                    switch (typeToAdd) {

                        case 1 -> {
                            System.out.print("Digite sua Reclamacao:\n");
                            String newClaim = sc.nextLine();
                            claims.addFeedback(new Claim(newClaim));
                        }

                        case 2 -> {
                            System.out.print("Digite seu Elogio:\n");
                            String newcomplient = sc.nextLine();
                            compliments.addFeedback(new Compliment(newcomplient));
                        }

                        case 3 -> {
                            System.out.print("Digite sua sugestao:\n");
                            String newSuggestion = sc.nextLine();
                            suggestions.addFeedback(new Suggestion(newSuggestion));
                        }

                        default ->
                            System.err.println("Opcao inválida.");
                    }
                }

                case 2 -> {
                    System.out.println("Listar os Feedbacks");
                    System.out.println(menu.menuType());
                    System.out.println("Qual Feedback deseja listar?");
                    int listTypes = sc.nextInt();
                    sc.nextLine();

                    switch (listTypes) {

                        case 1 -> {
                            System.out.println("Reclamacoes:");
                            System.out.println(claims.listFeedback());
                        }


                        case 2 -> {
                            System.out.println("Elogios:");
                            System.out.println(compliments.listFeedback());
                        }

                        case 3 -> {
                            System.out.println("Sugestoes");
                            System.out.println(suggestions.listFeedback());
                        }

                        default -> {
                            System.err.println("Opcao inválida.");
                            System.out.println();
                        }

                    }
                }

                case 3 -> {
                    System.out.println("Escolha a manifestacao:");
                    System.out.println(menu.menuType());
                    System.out.print("\nDeletar ([1] [2] [3] [4--Apagar tudo]):\n");
                    int listToDelet = sc.nextInt();
                    System.out.println();

                    switch (listToDelet) {

                        case 1 -> {
                            System.out.println("Reclamacoes");
                            System.out.println(claims.listFeedback());
                            System.out.print("Qual deseja apagar?");
                            deletPosition = sc.nextInt();
                            sc.nextLine();


                            if (claims.deleteFeedbacks(deletPosition - 1)) {
                                System.out.println("Apagada com sucesso!");

                            } else {
                                System.out.println("Não foi possível apagar essa opcao.");
                            }
                        }

                        case 2 -> {
                            System.out.println("Elogios");
                            System.out.println(compliments.listFeedback());
                            System.out.print("Qual deseja apagar?");
                            deletPosition = sc.nextInt();
                            sc.nextLine();

                            if (compliments.deleteFeedbacks(deletPosition - 1)) {
                                System.out.println("Apagada com sucesso!");

                            } else {
                                System.out.println("Não foi possível apagar essa opcao");
                            }
                        }

                        case 3 -> {
                            System.out.println("Sugestoes");
                            System.out.println(suggestions.listFeedback());
                            System.out.print("Qual deseja apagar?");
                            deletPosition = sc.nextInt();
                            sc.nextLine();

                            if (suggestions.deleteFeedbacks(deletPosition - 1)) {
                                System.out.println("Apagada com sucesso!");

                            } else {
                                System.out.println("Não foi possível apagar essa opcao");
                            }
                        }

                        case 4 -> {
                            claims.deleteAll();
                            compliments.deleteAll();
                            suggestions.deleteAll();

                            System.out.println("\nApagado com sucesso!");
                        }


                        default -> {
                            System.err.println("opcao infalida.");
                            System.out.println();
                        }

                    }
                }


                case 4 -> {
                    running = false;
                    sc.close();
                }

                default ->
                    System.err.println("opcao invalida.");

            }
        }while (running);

        System.out.println("Obrigado por usar o sistema.");
    }

}
