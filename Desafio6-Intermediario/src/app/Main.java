package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Priority;
import model.entities.Tarefa;
import model.entities.TaskStatus;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Tarefa> list = new ArrayList<>();

        try {

            while (true) {
                System.out.println("1 - Criar tarefa");//
                System.out.println("2 - Visualizar tarefas");//
                System.out.println("3 - Editar tarefas");//
                System.out.println("4 - Excluir tarefas");//
                System.out.println("5 - Marcar tarefas como concluidas");//
                System.out.println("6 - Adicionar notas a uma tarefa");
                System.out.println("7 - Sair do programa");

                System.out.println();
                System.out.print("Escolha uma das opções acima: ");
                int escolha = scanner.nextInt();

                // variaveis da tarefa
                String title;
                String desc;
                String dueDateStr;
                LocalDateTime dueDate;
                int priorityTask;
                Priority priority;
                Tarefa task;

                switch (escolha) {
                    case 1:

                        System.out.print("Informe o titulo dessa tarefa: ");
                        scanner.nextLine();
                        title = scanner.nextLine();

                        System.out.println();

                        System.out.print("Informe a descrição dessa tarefa: ");
                        desc = scanner.nextLine();

                        System.out.println();

                        System.out.print(
                                "Digite a data limite para a realização desta tarefa (formato: dd/MM/yyyy HH:mm): ");
                        dueDateStr = scanner.nextLine();
                        dueDate = LocalDateTime.parse(dueDateStr,
                                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

                        System.out.print("Qual a prioridade dessa tarefa: (1/BAIXA, 2/MEDIA e 3/ALTA): ");
                        priorityTask = scanner.nextInt();

                        switch (priorityTask) {
                            case 1:
                                priority = Priority.BAIXA;
                                break;
                            case 2:
                                priority = Priority.MEDIA;
                                break;
                            case 3:
                                priority = Priority.ALTA;
                                break;
                            default:
                                System.out.println("Prioridade inválida, definindo como BAIXA.");
                                priority = Priority.BAIXA;
                        }

                        System.out.println();
                        Tarefa tarefa = new Tarefa(title, desc, dueDate, priority);
                        list.add(tarefa);
                        System.out.println("Tarefa criada com sucesso!");
                        break;

                    case 2:

                        if (list.isEmpty()) {
                            System.out.println("Não existe tarefas cadastradas!");
                        }

                        System.out.println("Lista de tarefas cadastradas");
                        list.forEach(System.out::println);

                        break;

                    case 3:
                        if (list.isEmpty()) {
                            System.out.println("Não existe tarefas cadastradas!");
                        } else {
                            System.out.println("Informe o titulo da tarefa que deseja editar: ");
                            title = scanner.nextLine();

                            for (Tarefa t : list) {
                                if (title.equals(t.getTitle())) {
                                    System.out.println("O que voce deseja mudar na tarefa?\n (1/Titulo 2/Descricao " +
                                            "3/Data para realização 4/Prioridade)");

                                    int editTask = scanner.nextInt();

                                    switch (editTask) {
                                        case 1:
                                            System.out.println("Informe o novo titulo da tarefa: ");
                                            title = scanner.nextLine();
                                            t.setTitle(title);
                                            break;
                                        case 2:
                                            System.out.println("Informe o novo titulo da tarefa: ");
                                            desc = scanner.nextLine();
                                            t.setDescription(desc);
                                            break;
                                        case 3:
                                            System.out.print(
                                                    "Digite a data limite para a realização desta tarefa (formato: dd/MM/yyyy HH:mm): ");
                                            dueDateStr = scanner.nextLine();
                                            dueDate = LocalDateTime.parse(dueDateStr,
                                                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                                            t.setDueDate(dueDate);
                                            break;
                                        case 4:
                                            System.out
                                                    .print("Qual a prioridade dessa tarefa: (1/BAIXA, 2/MEDIA e 3/ALTA): ");
                                            priorityTask = scanner.nextInt();

                                            switch (priorityTask) {
                                                case 1:
                                                    priority = Priority.BAIXA;
                                                    break;
                                                case 2:
                                                    priority = Priority.MEDIA;
                                                    break;
                                                case 3:
                                                    priority = Priority.ALTA;
                                                    break;
                                                default:
                                                    System.out.println("Prioridade inválida, definindo como BAIXA.");
                                                    priority = Priority.BAIXA;
                                            }
                                        default:
                                            System.out.println("Digite um valor válido!");
                                            priority = Priority.BAIXA;
                                            break;
                                    }
                                }

                            }
                        }

                        break;

                    case 4:

                        if (list.isEmpty()) {
                            System.out.println("Não existe tarefas cadastradas!");
                        }
                        System.out.println("Informe o titulo da tarefa que deseja excluir: ");
                        title = scanner.nextLine();

                        for (Tarefa t : list) {
                            if (title.equals(t.getTitle())) {
                                list.remove(t);
                            }
                        }

                        System.out.println("Tarefa excluida com sucesso!");

                        break;

                    case 5:
                        if (list.isEmpty()) {
                            System.out.println("Não existe tarefas cadastradas!");
                        } else {
                            System.out.println("Lista de tarefas ");
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println("Tarefa " + (i + 1) + ", " + list.get(i).getTitle());
                            }
                            System.out.println("Escolha a tarefa a ser marcada como concluida: ");
                            escolha = scanner.nextInt();

                            if (escolha < 0 || escolha > list.size()) {
                                System.out.println("Opção inválida!");
                            } else {
                                task = list.get(escolha - 1);
                                task.setTs(TaskStatus.CONCLUIDO);
                                System.out.println("Tarefa marcado como conluido com sucesso!");
                            }
                        }

                        break;

                    case 6:
                        if (list.isEmpty()) {
                            System.out.println("Não existe tarefas cadastradas!");
                        } else {
                            System.out.println("Lista de tarefas:");
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println((i + 1) + ". " + list.get(i).getTitle());
                            }
                            System.out.println("Informe a tarefa que voce deseja adicionar uma nota: ");
                            escolha = scanner.nextInt();

                            if (escolha < 0 || escolha > list.size()) {
                                System.out.println("Opção inválida!");
                            } else {
                                String notes = scanner.nextLine();
                                task = list.get(escolha - 1);
                                task.setNotes(notes);System.out.println("Notas adicionadas à tarefa com sucesso!");
                                System.out.println("Notas adicionadas à tarefa com sucesso!");
                            }
                        }
                        break;

                    case 7:
                        System.out.println("Saindo do programa...");
                        return;

                    default:
                        System.out.println("Número inválido digite novamente!");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
