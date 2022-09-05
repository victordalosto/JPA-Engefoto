package com.engefoto.model.validation;


public enum UF {
    
    AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, 
    MT, MS, MG, PA, PB, PR, PE, PI, RJ, 
    RN, RS, RO, RR, SC, SP, SE, TO;


    public static String validate(String inputUF) {
        for (UF uf : UF.values()) {
            if (inputUF.toLowerCase().equals(uf.toString().toLowerCase()))
                return inputUF;
        }
        throw new RuntimeException("Not a valid UF");
    }
    
}