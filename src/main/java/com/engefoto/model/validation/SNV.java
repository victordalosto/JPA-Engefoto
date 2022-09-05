package com.engefoto.model.validation;

public class SNV {

    private final String snv;


    public SNV(String snv) {
        this.snv = validate(snv);
    }

    public String getSnv() {
        return snv;
    }

    public static String validate(String snv) {
        if (snv.length() != 10)
            throw new RuntimeException("Invalid SNV name");
        Integer.valueOf(snv.substring(0, 3));
        Integer.valueOf(snv.substring(6));
        return snv;
    }
}
