package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.util.TreeMap;

public class AnalyticsCounter {
	static BufferedReader symptomsFile;
	static String pathFile = "Project02Eclipse\\symptoms.txt";
	static String outputPath = "Project02Eclipse";
	static TreeMap<String, Integer> result = new TreeMap<>();
	/**
	 * @param args : args[0]=pathFile, args[1]=outputPath
	 * */
	public static void main(String[] args) {
		try {
			//We check if there's an argument
			if (!(args == null)) {
				if (args.length == 1) {
					if (!args[0].isEmpty()) {
						pathFile = args[0];
					}
				}

				if (args.length == 2) {
					if (!args[1].isEmpty() && (!args[0].isEmpty())) {
						pathFile = args[0];
						outputPath = args[1];
					}
				}
			}

			//We read symptoms
			ReadSymptomDataFromFile readSymptoms = new ReadSymptomDataFromFile(pathFile, symptomsFile);
			symptomsFile  = readSymptoms.GetAllSymptoms();
			//We count and increment
			CountSymptom countSymptom = new CountSymptom(symptomsFile, result);
			countSymptom.countAllSymptoms();
			//And we export it !
			WriteSymptom writeSymptom = new WriteSymptom(result, outputPath);
			writeSymptom.writeSymptomsInFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
