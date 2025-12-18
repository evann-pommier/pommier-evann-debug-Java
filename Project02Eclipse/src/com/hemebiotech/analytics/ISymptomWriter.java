package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface définissant le contrat d’écriture des résultats.
 * Permet de sauvegarder les symptômes et leur nombre d’occurrences.
 */
public interface ISymptomWriter {
	 /**
     * Écrit les symptômes et leur fréquence dans un fichier ou autre support.
     * @param symptoms Map contenant les symptômes et leur nombre d’occurrences
     */
	public void writeSymptoms(Map<String, Integer> symptoms) ;
}
