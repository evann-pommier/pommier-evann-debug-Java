package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface définissant le contrat de lecture des symptômes.
 * Une implémentation concrète peut lire depuis un fichier, une base de données, etc.
 */
public interface ISymptomReader {
	/**
     * Retourne une liste brute des symptômes lus depuis une source de données.
     * @return liste des symptômes (peut contenir des doublons)
     */
    List<String> getSymptoms();
}
