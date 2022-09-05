package com.engefoto.dao;

import com.engefoto.controller.ControllerDao;
import com.engefoto.model.Avaliador;
import com.engefoto.model.Empresa;
import com.engefoto.model.Entrega;
import com.engefoto.model.EntregaTrecho;
import com.engefoto.model.Plano;
import com.engefoto.model.Problema;
import com.engefoto.model.Producao;
import com.engefoto.model.Trecho;
import com.engefoto.model.TrechoProblema;
import com.engefoto.model.validation.StatusEntrega;

public class PopulateDB {

    private ControllerDao controller;

    public PopulateDB (ControllerDao controller) {
        this.controller = controller;
    }

    public void empresa() {
        controller.begin();
        controller.persist(new Empresa(1, "Strata", "1@gmail.com", "Edwin"));
        controller.persist(new Empresa(2, "Paveys", "2@gmail.com", "Leticia"));
        controller.persist(new Empresa(3, "Dynatest-VER", "3@gmail.com", "Keishi"));
        controller.commit();
    }


    public void registra() {
        Empresa strata = controller.findEmpresa("Strata");
        Empresa paveys = controller.findEmpresa(2);
        Empresa dynatest = controller.findEmpresa(3);
        controller.begin();
        controller.persist(new Entrega(strata, 3100, "20/7/2022", StatusEntrega.EM_ANALISE));
        controller.persist(new Entrega(paveys, 3201, "12/7/2022", StatusEntrega.EM_ANALISE));
        controller.persist(new Entrega(paveys, 3202, "20/7/2022", StatusEntrega.EM_ANALISE));
        controller.persist(new Entrega(paveys, 3203, "01/8/2022", StatusEntrega.EM_ANALISE));
        controller.persist(new Entrega(dynatest, 3300, "12/7/2022", StatusEntrega.RECUSADO));
        controller.commit();
    }



    public void plano() {
        Empresa pavesys = controller.findEmpresa(2);
        controller.begin();
        controller.persist(new Plano(pavesys, "101AES2005", 101, "ES", 0.0, 0.7, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "259BES0010", 259, "ES", 0.0, 49.1, "15/7/2022", "15/7/2022", ""));
        controller.persist(new Plano(pavesys, "259BES0030", 259, "ES", 49.1, 49.8, "15/7/2022", "15/7/2022", ""));
        controller.persist(new Plano(pavesys, "285BSC0050", 285, "SC", 33.8, 37.7, "11/5/2022", "", ""));
        controller.persist(new Plano(pavesys, "285BSC0055", 285, "SC", 37.7, 42.6, "11/5/2022", "", ""));
        controller.persist(new Plano(pavesys, "101ASC1005", 101, "SC", 0.0, 3.9, "25/11/2022", "", ""));
        controller.persist(new Plano(pavesys, "259BES0060", 259, "ES", 49.8, 53.1, "15/7/2022", "15/7/2022", ""));
        controller.persist(new Plano(pavesys, "259BES0070", 259, "ES", 53.1, 57.7, "15/7/2022", "15/7/2022", ""));
        controller.persist(new Plano(pavesys, "259BES0075", 259, "ES", 57.7, 83.1, "16/7/2022", "16/7/2022", ""));
        controller.persist(new Plano(pavesys, "259BES0080", 259, "ES", 83.1, 101.1, "16/7/2022", "16/7/2022", ""));
        controller.persist(new Plano(pavesys, "259BES0085", 259, "ES", 101.1, 102.3, "16/7/2022", "16/7/2022", ""));
        controller.persist(new Plano(pavesys, "259BES0095", 259, "ES", 102.3, 106.3, "16/7/2022", "16/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0010", 262, "ES", 0.0, 1.3, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0015", 262, "ES", 0.0, 1.3, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0020", 262, "ES", 1.3, 3.7, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0025", 262, "ES", 1.3, 3.7, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0030", 262, "ES", 3.7, 6.4, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0035", 262, "ES", 3.7, 6.4, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0070", 262, "ES", 15.9, 40.4, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0090", 262, "ES", 40.4, 43.7, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0100", 262, "ES", 43.7, 56.2, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0110", 262, "ES", 56.2, 87.1, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0130", 262, "ES", 87.1, 93.8, "24/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0150", 262, "ES", 93.8, 95.1, "23/7/2022", "24/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0155", 262, "ES", 95.1, 103.7, "23/7/2022", "23/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0170", 262, "ES", 103.7, 115.5, "23/7/2022", "23/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0190", 262, "ES", 115.5, 120.5, "23/7/2022", "23/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0195", 262, "ES", 120.5, 139.1, "23/7/2022", "23/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0200", 262, "ES", 139.1, 166.4, "23/7/2022", "23/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0205", 262, "ES", 166.4, 169.3, "23/7/2022", "23/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0210", 262, "ES", 169.3, 196.3, "22/7/2022", "22/7/2022", ""));
        controller.persist(new Plano(pavesys, "262BES0220", 262, "ES", 196.3, 196.5, "22/7/2022", "22/7/2022", ""));
        controller.persist(new Plano(pavesys, "342BES0260", 342, "ES", 49.6, 51.6, "13/7/2022", "13/7/2022", ""));
        controller.persist(new Plano(pavesys, "342BES0265", 342, "ES", 53.5, 82.8, "13/7/2022", "13/7/2022", ""));
        controller.persist(new Plano(pavesys, "342BES0290", 342, "ES", 105.9, 121.4, "13/7/2022", "13/7/2022", ""));
        controller.persist(new Plano(pavesys, "342BES0300", 342, "ES", 121.4, 125.9, "13/7/2022", "13/7/2022", ""));
        controller.commit();
    }



    public void entregaTrecho() {
        controller.begin();
        Entrega hd = controller.findHD(3201);
        controller.persist(new EntregaTrecho(hd, 5));
        controller.persist(new EntregaTrecho(hd, 4));
        controller.persist(new EntregaTrecho(hd, 3));
        controller.persist(new EntregaTrecho(hd, 1));
        controller.persist(new EntregaTrecho(hd, 2));
        controller.commit();
    }



    public void trecho() {
        Plano snv1 = controller.findSNV("101AES2005");
        Plano snv2 = controller.findSNV("259BES0010");
        Plano snv3 = controller.findSNV("342BES0260");
        EntregaTrecho et1 = controller.findEntregaTrecho(3201, 2);
        EntregaTrecho et2 = controller.findEntregaTrecho(3201, 4);
        EntregaTrecho et3 = controller.findEntregaTrecho(3201, 5);
        controller.begin();
        controller.persist(new Trecho(et1, snv1, 10841, 5.55, 6.52));
        controller.persist(new Trecho(et2, snv2, 10842, 6.52, 25.31));
        controller.persist(new Trecho(et3, snv3, 10843, 25.31, 45.11));
        controller.commit();
    }


    public void producao() {
        Avaliador victor = controller.findAvaliador("Victor");
        Producao p1 = new Producao(controller.findTrecho(2));
        Producao p2 = new Producao(controller.findTrecho(3));
        p1.setAptidao(true);
        p1.setAvaliadorPavimento(victor);
        p1.setAvaliadorAcostamento(victor);
        p2.setAvaliadorSinalizacao(victor);
        controller.begin();
        controller.persist(p1);
        controller.persist(p2);
        controller.commit();
    }


    public void avaliador() {
        controller.begin();
        controller.persist(new Avaliador("Claudiana", false));
        controller.persist(new Avaliador("Giulia", false));
        controller.persist(new Avaliador("Maira", false));
        controller.persist(new Avaliador("Salles", false));
        controller.persist(new Avaliador("Pedro", false));
        controller.persist(new Avaliador("Leandro", false));
        controller.persist(new Avaliador("Juliana", true));
        controller.persist(new Avaliador("Victor", true));
        controller.commit();
    }


    public void problema() {
        controller.begin();
        controller.persist(new Problema("Camera Dessincronizada"));
        controller.persist(new Problema("Video Dessincronizada"));
        controller.persist(new Problema("Trecho travando"));
        controller.persist(new Problema("Problema no Log"));
        controller.persist(new Problema("Problema no Index"));
        controller.commit();
    }


    public void trechoProblema() {
        controller.begin();
        controller.persist(new TrechoProblema(controller.findTrecho(1), controller.findProblema(4), "22/08/2022"));
        controller.persist(new TrechoProblema(controller.findTrecho(2), controller.findProblema(4), "22/08/2022"));
        controller.persist(new TrechoProblema(controller.findTrecho(3), controller.findProblema(4), "22/08/2022"));
        controller.persist(new TrechoProblema(controller.findTrecho(1), controller.findProblema(5), "22/08/2022"));
        controller.commit();
    }
    
}
