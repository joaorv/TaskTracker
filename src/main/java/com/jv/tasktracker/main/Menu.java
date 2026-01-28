package com.jv.tasktracker.main;

import java.util.Scanner;

import com.jv.tasktracker.service.TaskService;
import com.jv.tasktracker.model.Status;

public class Menu {
    private final TaskService taskService;
    private final Scanner scanner;

    public Menu(TaskService taskService) {
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 0;
        do {
            mostrarMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> adicionarTask();
                case 2 -> atualizarDescricao();
                case 3 -> atualizarStatus();
                case 4 -> removerTask();
                case 5 -> listarTasks();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

    }

    private void mostrarMenu() {
        System.out.println("\n=== TASK TRACKER ===");
        System.out.println("1 - Adicionar task");
        System.out.println("2 - Atualizar descrição");
        System.out.println("3 - Atualizar status");
        System.out.println("4 - Remover task");
        System.out.println("5 - Listar tasks");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private int lerOpcao() {
        return Integer.parseInt(scanner.nextLine());
    }

    private void adicionarTask() {
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        taskService.addTask(descricao);
        System.out.println("Task adicionada com sucesso!");
    }

    private void atualizarDescricao() {
        System.out.print("ID da task: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();

        taskService.atualizarDescricaoTask(id, descricao);
        System.out.println("Descrição atualizada!");
    }

    private void atualizarStatus() {
        System.out.print("ID da task: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("\nSelecione um status para atualizar a task!");
        System.out.println("1- TODO");
        System.out.println("2- IN PROGRESS");
        System.out.println("3- DONE");
        int escolha = Integer.parseInt(scanner.nextLine());
        Status status;
        switch (escolha) {
            case 1:
                status = Status.TODO;
                taskService.atualizarStatusTask(id, status);
                System.out.println("Status atualizado!");
                break;
            case 2:
                status = Status.IN_PROGRESS;
                taskService.atualizarStatusTask(id, status);
                System.out.println("Status atualizado!");
                break;
            case 3:
                status = Status.DONE;
                taskService.atualizarStatusTask(id, status);
                System.out.println("Status atualizado!");
                break;
            default:
                System.out.println("Opção inválida!");
        }

        /*
        Alternativa para o uso do swich:

        System.out.print("Status (TODO, IN_PROGRESS, DONE): ");
        Status status = Status.valueOf(scanner.nextLine().toUpperCase());
        taskService.atualizarStatusTask(id, status);
        System.out.println("Status atualizado!");

        */
    }

    private void removerTask() {
        System.out.print("ID da task: ");
        int id = Integer.parseInt(scanner.nextLine());

        taskService.deleteTask(id);
        System.out.println("Task removida!");
    }

    private void listarTasks() {
        System.out.println("\n=== LISTA DE TASKS ===");
        taskService.getAllTasksToString();
    }

}
