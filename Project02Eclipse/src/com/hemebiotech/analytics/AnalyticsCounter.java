package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;
    
    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public List<String> getSymptoms() {
    	return this.reader.GetSymptoms();
    }
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
    	Map<String, Integer> countMap = new HashMap<>();
        for (String symptom : symptoms) {
            countMap.put(symptom, countMap.getOrDefault(symptom, 0) + 1);
        }
        return countMap;
    }
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    	return new TreeMap<>(symptoms);
    }
    public void writeSymptoms(Map<String, Integer> symptoms) { 
    	this.writer.writeSymptoms(symptoms);
    }
    
    
    
    
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> counted = counter.countSymptoms(symptoms);
        Map<String, Integer> sorted = counter.sortSymptoms(counted);
        counter.writeSymptoms(sorted);
    }
}