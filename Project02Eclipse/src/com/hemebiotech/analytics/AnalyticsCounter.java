package com.hemebiotech.analytics;



import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	
	private ISymptomReader reader; 
	private ISymptomWriter writer;
	
	

	
	

	/** 
	 * @param ISymptomReader reader is an ID from ReadSymptomDataFromFile.
	 * 
	 * @return a map with symptoms from file and their occurrences. 
	 */
	
	public  AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) throws IOException {
		
		this.reader = reader;
		this.writer = writer;
		
	}
	
/** 
 * 
 * Method countSymptoms 
 * 
 * @return a map which contain symptoms with occurrences's numbers
 * 
 * 
 */
	public Map<String, Long> countSymptoms() {
		
		Map<String,Long> countSymptomsOccurences =
		reader.GetSymptoms().stream().collect(Collectors.groupingByConcurrent(e->e, Collectors.counting()));
		return countSymptomsOccurences;
	}
	/**
	 * 
	 * Method alphabeticalOrder 
	 * 
	 * @return a TreeMap which contain symptoms order alphabetically
	 * 
	 */
	
	public TreeMap<String,Long> alphabeticalOrder() {
		
		TreeMap<String,Long> order = new TreeMap <String,Long> (countSymptoms()) ;
		return order;
	}
	
	/** 
	 * 
	 * Method Writer
	 * 
	 * @return a file result.out 
	 * 
	 * 
	 */
	
	public void writer (Map<String,Long> result) throws IOException {
		
		writer.Writer(result);
	}
	
}
