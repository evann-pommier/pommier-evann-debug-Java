package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe chargée de lire la liste des symptômes depuis un fichier texte.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filePath; // Chemin vers le fichier de symptômes
    private static final Logger logger = LogManager.getLogger(ReadSymptomDataFromFile.class);

    /**
     * Constructeur.
     * @param filePath chemin du fichier à lire
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<>();

        if (filePath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line = reader.readLine();
             // Lecture ligne par ligne
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                logger.info("Le fichier " + filePath + " a été lu avec succès");
            } catch (IOException e) {
                logger.error("Le fichier " + filePath + " n’existe pas ou n’est pas accessible");
            }
        }
        return result;
    }
}
