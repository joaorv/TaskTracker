package com.jv.tasktracker.main;

import com.jv.tasktracker.service.TaskService;

public class Main {

    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Menu menu = new Menu(taskService);
        menu.iniciar();
    }
}
