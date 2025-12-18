package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Classe chargée d’écrire les symptômes et leurs occurrences dans un fichier.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String filePath;
    private static final Logger logger = LogManager.getLogger(WriteSymptomDataToFile.class);
    
    /**
     * Constructeur.
     * @param filePath chemin du fichier de sortie
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filePath == null || symptoms == null) return;

        try (FileWriter writer = new FileWriter(filePath)) {
            // Utilisation de TreeMap pour l'ordre alphabétique
            Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
            // Écriture des symptômes et de leur nombre d’occurrences
            for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            logger.info("Écriture dans le fichier : " + filePath);
        } catch (IOException e) {
            logger.error("Erreur d'écriture dans le fichier : " + filePath);
        }
    }   
}
