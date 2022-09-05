package com.engefoto;

import com.engefoto.controller.ControllerDao;
import com.engefoto.dao.PopulateDB;

public class Main {
    public static void main(String[] args) {
        ControllerDao controller = new ControllerDao();

        PopulateDB populate = new PopulateDB(controller);
        populate.empresa();
        populate.registra();
        populate.plano();
        populate.entregaTrecho();
        populate.trecho();
        populate.avaliador();
        populate.producao();
        populate.problema();
        populate.trechoProblema();
    }
}
