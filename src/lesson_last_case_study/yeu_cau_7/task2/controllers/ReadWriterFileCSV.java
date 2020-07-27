package lesson_last_case_study.yeu_cau_7.task2.controllers;

import lesson_last_case_study.yeu_cau_7.task1.models.Villa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriterFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static void readWriterFileVilla(List<Villa> villas, Villa villa) {

        final String FILE_VILLA = "Name Services,Area Use ,RentalCost, Maximum People, Type Of Rent, ID, " +
                "Room StanDard, Comfort Descriptiom, Pool Area, Number OF Floors";


        villas.add(villa);
        String fileName = "src/lesson_last_case_study/yeu_cau_7/data/Villa.csv";
        FileWriter fileWriterVilla = null;

        try {
            fileWriterVilla = new FileWriter(fileName);

            // Write the CSV file header
            fileWriterVilla.append(FILE_VILLA);

            // Add a new line separator after the header
            fileWriterVilla.append(NEW_LINE_SEPARATOR);

            // Write a new Villa object list to the CSV file
            for (Villa villa1 : villas) {
                fileWriterVilla.append(String.valueOf(villa1.getNameServices()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getAreaUse()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getRentalCost()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getMaximumPeople()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(villa.getTypeOfRent());
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getId()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getRoomStanDard()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getComfortDescription()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getPoolArea()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getNumberOfFloors()));
                fileWriterVilla.append(NEW_LINE_SEPARATOR);

            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriterVilla.flush();
                fileWriterVilla.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriterVilla !!!");
                e.printStackTrace();
            }
        }
    }



}
