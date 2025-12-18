# AnalyticsCounter

## Description

**AnalyticsCounter** est un projet Java qui permet de lire un fichier texte contenant des symptômes, de compter les occurrences de chaque symptôme, de trier les résultats par ordre alphabétique et de les écrire dans un fichier de sortie.  

Le projet est conçu de manière **modulaire et orientée objet**, avec une séparation claire des responsabilités :  
- Lecture des symptômes (`ISymptomReader` / `ReadSymptomDataFromFile`)  
- Comptage et tri (`AnalyticsCounter`)  
- Écriture des résultats (`ISymptomWriter` / `WriteSymptomDataToFile`)  

Il utilise **Log4j2** pour la journalisation des événements, offrant un suivi clair et professionnel de l’exécution.

---

## Fonctionnalités

- Lecture des symptômes depuis un fichier texte (`symptoms.txt`)  
- Comptage dynamique de tous les symptômes présents  
- Tri alphabétique des symptômes  
- Écriture des résultats dans un fichier de sortie (`result.out`)  
- Gestion des erreurs de lecture/écriture avec logs détaillés  
- Architecture modulaire et extensible  

---

## Organisation du projet

Project02Eclipse
│
├─ symptoms.txt                   # Fichier de symptômes
└─ src
  │
  ├─ log4j2.properties            # Configuration Log4j2
  └─ com.hemebiotech.analytics
    │
    ├─ AnalyticsCounter.java      # Classe principale
    ├─ ISymptomReader.java        # Interface pour la lecture
    ├─ ISymptomWriter.java        # Interface pour l’écriture
    ├─ ReadSymptomDataFromFile.java # Lecture depuis un fichier
    └─ WriteSymptomDataToFile.java  # Écriture dans un fichier


---

## Installation et exécution

1. Cloner le dépôt :  
`git clone <URL_DU_DEPOT>`

2. Placer un fichier symptoms.txt à la racine du projet.
3. Compiler et exécuter le projet depuis Eclipse ou en ligne de commande :
   `javac -d bin src/com/hemebiotech/analytics/*.java
    java -cp bin com.hemebiotech.analytics.AnalyticsCounter`
4. Vérifier le fichier result.out généré avec le comptage des symptômes.


## **Journalisation avec Log4j2**

Le projet utilise Log4j2 pour la journalisation :
Configuration : log4j2.properties définit le niveau de log et le format des messages.

Niveaux utilisés :
INFO : succès de la lecture et écriture des fichiers
ERROR : fichiers manquants ou erreurs d’écriture

Exemple de log produit :
  `[INFO] 2025-12-18 14:23:45 ReadSymptomDataFromFile - Le fichier symptoms.txt a été lu avec succès
   [INFO] 2025-12-18 14:23:46 WriteSymptomDataToFile - Écriture réussie dans le fichier : result.out
   [ERROR] 2025-12-18 14:24:00 ReadSymptomDataFromFile - Erreur : le fichier symptoms.txt n’existe pas ou n’est pas accessible`
Avantages :
- Traçabilité des opérations
- Débogage simplifié
- Séparation de la console et des logs, facilement configurable
