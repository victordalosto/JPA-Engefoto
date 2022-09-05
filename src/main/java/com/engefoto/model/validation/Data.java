package com.engefoto.model.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Data {

    private final static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ofPattern("d/M/yyyy")).appendOptional(DateTimeFormatter.ofPattern("d/MM/yyyy"))
            .appendOptional(DateTimeFormatter.ofPattern("dd/M/yyyy")).appendOptional(DateTimeFormatter.ofPattern(("dd/MM/yyyy")))
            .appendOptional(DateTimeFormatter.ofPattern("d/M/yy")).appendOptional(DateTimeFormatter.ofPattern("d/MM/yy"))
            .appendOptional(DateTimeFormatter.ofPattern("dd/M/yy")).appendOptional(DateTimeFormatter.ofPattern(("dd/MM/yy")))
            .toFormatter();

    private final LocalDate data;


    public Data(String stringData) throws Exception {
        this.data = convertToDate(stringData);
    }

    public LocalDate getData() {
        return this.data;
    }


    public static LocalDate convertToDate(String stringData) {
        if (stringData == null || stringData.isEmpty())
            return null;
        LocalDate data = LocalDate.parse(stringData, formatter);
        if (data.getYear() > 2022 || data.getYear() < 2020)
            throw new RuntimeException("Invalid value for year");
        return data;
    }


    
}
