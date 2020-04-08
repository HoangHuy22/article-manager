package com.articlemanager;

import com.articlemanager.view.ConsoleView;

public class MainThread {
    public static void main(String[] args) {
        System.out.println("Start program!");
        ConsoleView view = new ConsoleView();
        view.generateMenu();
    }
}
