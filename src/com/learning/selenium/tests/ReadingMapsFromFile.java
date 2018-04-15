
package com.learning.selenium.tests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.learning.selenium.utils.CredentialsReader;
import com.learning.selenium.utils.MapKeys;

public class ReadingMapsFromFile extends CredentialsReader {

	@Test
	public void readFromFile() {
		Map<String, String> user1 = buildUserMap("user1");
		Map<String, String> user2 = buildUserMap("user2");
		Map<String, String> user3 = buildUserMap("user3");

		System.out.println("user1Map : " + user1);
		System.out.println("user2Map : " + user2);
		System.out.println("user3Map : " + user3);

		System.out.println("user1's panNumer is:" + user1.get(MapKeys.panNumber.toString()));
		System.out.println("user1's weight is:" + user1.get(MapKeys.weight.toString()));
//		System.out.println("user2's height is:" + user2.get(MapKeys.height.toString()));
//		System.out.println("user3's username is:" + user3.get(MapKeys.height.toString()));
	}

	public static Map<String, String> buildUserMap(String userNumber) {
		String user1Values = CredentialsReader.getValue(userNumber);
		Map<String,String> user1Map = new LinkedHashMap<>();
		String [] user1Properties = user1Values.split(",");
//		System.out.println("user1 properties: "+ userProperties);
		for (String property : user1Properties) {
//			System.out.println("user1 properties: "+ property);
			String [] user1SplitProperties = property.split("\\|");
//			System.out.println("user1 key: "+ user1SplitProperties[0]);
//			System.out.println("user1 value: "+ user1SplitProperties[1]);
			user1Map.put(user1SplitProperties[0],user1SplitProperties[1]);
		}
//		System.out.println("user1Map : " + user1Map);
		return user1Map;
	}
}
