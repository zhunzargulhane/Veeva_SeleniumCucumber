package com.org.awesomecucumber.utils;

import com.opencsv.CSVWriter;

import java.io.*;

public class CSVWriterUtils {
    public static void writeDataToCSV(String fileName, String[] data) throws IOException {
        File file = new File("src\\test\\resources\\" + fileName + ".csv");
        BufferedWriter outputFile = null;
        try {
            outputFile = new BufferedWriter(new FileWriter(file));
            CSVWriter csvWriter = new CSVWriter(outputFile, ',');
            csvWriter.writeNext(data, true);
        } catch (IOException ioException) {
            throw new RuntimeException("Unable to write the data to the file " + file.getName());
        } finally {
            outputFile.close();
        }
    }
}
