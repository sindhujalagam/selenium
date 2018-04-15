package com.learning.selenium.tests;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class MapsAndLists {
	
	@Test
	public void mappingThings() {
		Map<String, String> propertiesMap = new LinkedHashMap<>();
		propertiesMap.put("username", "sindhu@gmail.com");
		propertiesMap.put("height","234723");
		propertiesMap.put("panNumber","2ASH23342");
		System.out.println("username is: "+ propertiesMap.get("username"));
		System.out.println("height is: "+ propertiesMap.get("height"));
		System.out.println("panNumber is: "+ propertiesMap.get("panNumber"));

		Map<String, String> propertiesMap1 = new LinkedHashMap<>();
		propertiesMap1.put("username", "@gmail.com");
		propertiesMap1.put("height","2323");
		propertiesMap1.put("panNumber","2AS342");
		System.out.println("username is: "+ propertiesMap1.get("username"));
		System.out.println("height is: "+ propertiesMap1.get("height"));
		System.out.println("panNumber is: "+ propertiesMap1.get("panNumber"));

		Map<String, String> propertiesMap2 = new LinkedHashMap<>();
		propertiesMap2.put("username", "sindhu@");
		propertiesMap2.put("height","00909");
		propertiesMap2.put("panNumber","023947023742");
		System.out.println("username is: "+ propertiesMap2.get("username"));
		System.out.println("height is: "+ propertiesMap2.get("height"));
		System.out.println("panNumber is: "+ propertiesMap2.get("panNumber"));

		List<Map<String, String>> usersList = new ArrayList<>();
		usersList.add(propertiesMap);
		usersList.add(propertiesMap1);
		usersList.add(propertiesMap2);

		System.out.println("Total user count: " + usersList.size());
		System.out.println("\n\n\n PRINTING ALL THE USERS:  \n\n");
		System.out.println("LISTIS:" + usersList);
		for (Map<String, String> user : usersList) {
			System.out.println("username is: " + user.get("username"));
			System.out.println("height is: " + user.get("height"));
			System.out.println("panNumber is: " + user.get("panNumber"));
		}

		System.out.println("\n\n PRINTING SECOND USER");
		System.out.println("username is: " + usersList.get(1).get("username"));
		System.out.println("height is: " + usersList.get(1).get("height"));
		System.out.println("panNumber is: " + usersList.get(1).get("panNumber"));
	}

}
