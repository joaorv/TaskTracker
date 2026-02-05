package com.jv.tasktracker.service;

import com.jv.tasktracker.model.Task;
import com.jv.tasktracker.model.Status;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.util.ArrayList;

public class TaskService {
    private static final String FILE_PATH = "tasks.json";
    private ObjectMapper mapper;

    private List<Task> tasks;
    private int nextId;

    public TaskService() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        this.tasks = new ArrayList<>();
        carregarTasks();
    }


    private void salvarTasks() {
        try {
            mapper.writeValue(new File(FILE_PATH), tasks);
        } catch (IOException e) {
            System.out.println("Erro ao salvar tasks: " + e.getMessage());
        }
    }

    private void carregarTasks() {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) {
                System.out.println("Arquivo JSON não existe.");
                tasks = new ArrayList<>();
                nextId = 1;
                return;
            }

            tasks = mapper.readValue(
                    file,
                    new TypeReference<List<Task>>() {}
            );

            nextId = tasks.stream()
                    .mapToInt(Task::getId)
                    .max()
                    .orElse(0) + 1;

            System.out.println("Tasks carregadas: " + tasks.size());

        } catch (Exception e) {
            System.out.println("Erro ao carregar tasks:");
            e.printStackTrace();
            tasks = new ArrayList<>();
            nextId = 1;
        }
    }



    public void addTask(String descricao) {
        Task task = new Task(nextId++, descricao);
        tasks.add(task);
        salvarTasks();
    }

    public void atualizarDescricaoTask(int id, String novaDescricao) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescricao(novaDescricao);
                salvarTasks();
                break;
            }
        }
    }

    public void atualizarStatusTask(int id, Status novoStatus) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(novoStatus);
                salvarTasks();
                break;
            }
        }
    }


    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        salvarTasks();
    }

    public void getAllTasksToString() {
        for (Task task : tasks) {
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("ID: " + task.getId() + "| DESCRIÇÃO: " + task.getDescricao() + "| STATUS: " + task.getStatus() + "| DATA CRIACAO: " + task.getDataCriacao() + "| DATA ATUALIZACAO: " + task.getDataAtualizacao());
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    public void getTaskToDo() {
        for (Task task : tasks) {
            if (task.getStatus().equals(Status.TODO)) {
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("ID: " + task.getId() + "| DESCRIÇÃO: " + task.getDescricao() + "| STATUS: " + task.getStatus() + "| DATA CRIACAO: " + task.getDataCriacao() + "| DATA ATUALIZACAO: " + task.getDataAtualizacao());
            }
        }
    }

    public void getTaskInProgress() {
        for (Task task : tasks) {
            if (task.getStatus().equals(Status.IN_PROGRESS)) {
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("ID: " + task.getId() + "| DESCRIÇÃO: " + task.getDescricao() + "| STATUS: " + task.getStatus() + "| DATA CRIACAO: " + task.getDataCriacao() + "| DATA ATUALIZACAO: " + task.getDataAtualizacao());
            }
        }
    }

    public void getTaskDone(){
        for (Task task : tasks) {
            if (task.getStatus().equals(Status.DONE)) {
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("ID: " + task.getId() + "| DESCRIÇÃO: " + task.getDescricao() + "| STATUS: " + task.getStatus() + "| DATA CRIACAO: " + task.getDataCriacao() + "| DATA ATUALIZACAO: " + task.getDataAtualizacao());
            }
        }
    }


}