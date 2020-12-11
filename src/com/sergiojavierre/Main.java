package com.sergiojavierre;

import com.sergiojavierre.application.ConcursoController;

public class Main {

    public static void main(String[] args) {
        ConcursoController concursoController = new ConcursoController();
        concursoController.start();
        concursoController.lista();
        concursoController.busca();
    }
}
