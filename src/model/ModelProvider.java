package model;

import java.util.ArrayList;
import java.util.List;

import util.UtilFile;

public enum ModelProvider {
	INSTANCE(getFilePath());

	private List<Person> persons;

	private ModelProvider() {
		persons = new ArrayList<Person>();
		
	}

	
	private ModelProvider(String inputdata) {
		List<String> contents = UtilFile.readFile(inputdata);
		List<List<String>> tableContents = UtilFile.convertTableContents(contents);

		persons = new ArrayList<Person>();
		for (List<String> iList : tableContents) {                        
			persons.add(new Person(iList.get(0), iList.get(1), iList.get(2)));
		}
	}

	private static String getFilePath() {
		return "C:/Users/Rajasree/eclipse-workspace/project0918-filtering-Balakrishnan/src/inputdata.txt";
	}

	public List<Person> getPersons() {
		return persons;
	}

}
