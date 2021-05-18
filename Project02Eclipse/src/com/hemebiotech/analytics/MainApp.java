package com.hemebiotech.analytics;

import java.io.IOException;





public class MainApp {



	public static void main(String[] args)throws IOException {
		
		ISymptomReader symptoms = new ReadSymptomDataFromFile("symptoms.txt"); /* Instantiate new object from "symptoms.txt" */
		ISymptomWriter writer = new WriteDataFromFile();
		
		
		AnalyticsCounter counter = new AnalyticsCounter(symptoms,writer); /* Instantiate AnalyticsCounter*/ 
	
		counter.countSymptoms(); /** Counter */
		counter.alphabeticalOrder(); /** Order */
		counter.writer(counter.alphabeticalOrder()); /** Writer */
		
		
	}
}
	