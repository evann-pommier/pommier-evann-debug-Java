package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe principale qui coordonne les différentes étapes du traitement :
 * lecture des symptômes, comptage, tri et écriture des résultats.
 */
public class AnalyticsCounter {
    
    private final ISymptomReader reader; // Objet responsable de la lecture des symptômes
    private final ISymptomWriter writer; // Objet responsable de l’écriture des résultats
    
    /**
     * Constructeur permettant d’injecter l'ecriture et la lecture.
     * @param reader objet implémentant ISymptomReader
     * @param writer objet implémentant ISymptomWriter
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    
    /**
     * Récupère la liste brute des symptômes depuis la source de données.
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }
    
    /**
     * Compte le nombre d’occurrences de chaque symptôme dans la liste.
     * @param symptoms liste brute des symptômes
     * @return une map contenant le nom du symptôme et son nombre d’occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String symptom : symptoms) {
        	// Incrémente le compteur pour chaque symptôme rencontré
            countMap.put(symptom, countMap.getOrDefault(symptom, 0) + 1);
        }
        return countMap;
    }

    /**
     * Trie les symptômes par ordre alphabétique.
     * @param symptoms map non triée
     * @return une map triée (TreeMap)
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
        return new TreeMap<>(symptoms);
    }

    /**
     * Écrit la liste des symptômes triés et comptés dans le fichier de sortie.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) { 
        writer.writeSymptoms(symptoms);
    }
    
    /**
     * Point d’entrée du programme.
     * Initialise le lecteur, le compteur et l’écrivain.
     */
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);
        counter.writeSymptoms(sortedSymptoms);
    }
}
