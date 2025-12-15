package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {
	private final String filepath;
	
	public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		if (filepath == null || symptoms == null) return;

        try (FileWriter writer = new FileWriter(filepath)) {
            // TreeMap to ensure alphabetical order
            Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
            for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erreur d'écriture  dans le fichier : " + filepath);
            e.printStackTrace();
        }
    }	
}
