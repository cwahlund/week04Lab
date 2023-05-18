//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  StringBuilders, Lists, Sets, & Maps
// Java Week 04 Lab  
//
package week04Lab;

import java.util.*;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// 		a. Instantiate a new StringBuilder
		//		b. Append the characters 0 through 9 to it separated by dashes
		// 				Note:  make sure no dash appears at the end of the StringBuilder

		// Strings are immutable and cannot really be changed - it ends up making a new object and retains the old one, using up memory
		
		StringBuilder newStringBuilder = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			newStringBuilder.append(i);
			if (i < 9) {
				newStringBuilder.append("-");
			}
		}
		
		System.out.println(newStringBuilder.toString());
		
		// 2. List of String:
		//		a. Create a list of Strings 
		//		b. Add 5 Strings to it, each with a different length

		List<String> stringList = new ArrayList<String>();
		stringList.add("Tests");
		stringList.add("To");
		stringList.add("Try");
		stringList.add("Test");
		stringList.add("Strings");
		
		System.out.println(stringList);
		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string

		String shortestString = getShortestString(stringList);
		
		System.out.println("The shortest string is: " + shortestString);
		
		
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched
		stringList = switchFirstAndLast(stringList);
		
		System.out.println(stringList);
		
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma

		String commaDelimited = commaConcatinate(stringList);
		
		System.out.println(commaDelimited);
		
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)

		String searchString = "Test";
		
		List<String> searchResults = findMatches(stringList, searchString);
		
		System.out.println(searchResults.toString());
		
		// 7. Write and test a method that takes a list of integers 
		//			and returns a List<List<Integer>> with the following conditions specified
		//			for the return value:
		//		a. The first List in the returned value contains any number from the input list 
		//			that is divisible by 2
		//		b. The second List contains values from the input list that are divisible by 3
		//		c. The third containing values divisible by 5, and 
		//		d. The fourth all numbers from the input List not divisible by 2, 3, or 5

		List<Integer> dividingIntegers = Arrays.asList(2, 4, 3, 5, 10, 9, 7);
		
		List<List<Integer>> listsOfIntegerDivision = makeDivisionLists(dividingIntegers);
		for (List<Integer> listIntegerDivision : listsOfIntegerDivision) {
			System.out.println(listIntegerDivision.toString());
		}
		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string

		List<Integer> stringLengthList = getStringSizeList(stringList);
		System.out.println("String lengths: " + stringLengthList.toString());
		
		// 9. Create a set of strings and add 5 values

		Set<String> stringSet = new HashSet<String>();
		stringSet.add("And");
		stringSet.add("another");
		stringSet.add("grouping");
		stringSet.add("of");
		stringSet.add("items");
		
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.

		char firstCharacter = 'a';
		
		System.out.println(findStartsWith(stringSet, firstCharacter).toString());
		
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings
	
		System.out.println(copyStringSetToList(stringSet).toString());

		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set

		Set<Integer> integerSet = new HashSet<>(Arrays.asList(1,2,3,4,5));
		
		System.out.println("Even numbers: " + returnEvenNumbers(integerSet));
		
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word

		Map<String, String> dictionary = new HashMap<String, String>();
		
		dictionary.put("here", "Where you are now.");
		dictionary.put("pizza", "A flat baked pie of Italian origins.");
		dictionary.put("hut", "A small building.");
		
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)

		String word = "hut";
		
		System.out.println(word + " definition: " + lookupDefinition(dictionary, word));
		
		// 15. Write and test a method that takes a List<String> 
		//			and returns a Map<Character, Integer> containing a count of 
		//			all the strings that start with a given character
		
		Character countCharacter = 't';
		final char COUNTCHAR = Character.toLowerCase(countCharacter);
		int foundMatches;
		
		Map<Character, Integer> charCountMap = findCharCount(stringList);
		
		if (! charCountMap.isEmpty()) {
			if (charCountMap.containsKey(COUNTCHAR)) {
				foundMatches = charCountMap.get(COUNTCHAR);
				System.out.println(foundMatches + " words start with " + COUNTCHAR);
			} else {
				System.out.println("No words start with " + COUNTCHAR);
			}
		}
	}


	// Method 15:
	
	public static Map<Character, Integer> findCharCount(List<String> stringList){
		Map<Character, Integer> returnMap = new HashMap<>();
		
		int startingCharacterCount = 0;
		char firstChar;
		
		for (String string : stringList) {
			firstChar = string.toLowerCase().charAt(0);
			if (returnMap.containsKey(firstChar)) {
				startingCharacterCount = returnMap.get(firstChar);
				startingCharacterCount++;
				returnMap.put(firstChar, startingCharacterCount);
			} else {
				returnMap.put(firstChar, 1);
			}
		}
		
		return returnMap;
	}
	
	// Method 14:
	
	public static String lookupDefinition(Map<String, String> dictionary, String word) {
		return dictionary.get(word);
	}
	
	// Method 12:
	
	public static Set<Integer> returnEvenNumbers(Set<Integer> integerSet){
		Set<Integer> returnIntSet = new HashSet<Integer>();
		
		for (int integer : integerSet) {
			if (integer % 2 == 0) {
				returnIntSet.add(integer);
			}
		}
		
		return returnIntSet;
	}
	
	// Method 11:
	
	public static List<String> copyStringSetToList(Set<String> stringSet){
		List<String> stringList = new ArrayList<String>();
		
		for (String string : stringSet) {
			stringList.add(string);
		}
		
		return stringList;
	}

	// Method 10:
	
	public static Set<String> findStartsWith(Set<String> stringSet, char firstCharacter) {
		Set<String> resultsSet = new HashSet<String>();
		
		for (String string : stringSet) {
			char[] stringCharArray = string.toLowerCase().toCharArray();
			if (stringCharArray[0] == firstCharacter) {
				resultsSet.add(string);
			}
		}
		
		return resultsSet;
	}
	
	// Method 8:
	
	public static List<Integer> getStringSizeList(List<String> stringList) {
		List<Integer> lengthList = new ArrayList<Integer>();
		
		for (String string : stringList) {
			lengthList.add(string.length());
		}
		
		return lengthList;
	}
	
	// Method 7:
	
	public static List<List<Integer>> makeDivisionLists(List<Integer> dividingIntegers){
		List<List<Integer>> listsOfIntegerDivision = new ArrayList<>();
		List<Integer> divisibleByTwo = new ArrayList<Integer>();
		List<Integer> divisibleByThree = new ArrayList<Integer>();
		List<Integer> divisibleByFive = new ArrayList<Integer>();
		List<Integer> notDivisible = new ArrayList<Integer>();
		
		for (Integer divInteger : dividingIntegers) {
			if (divInteger % 2 == 0) {
				divisibleByTwo.add(divInteger);
			}
			if (divInteger % 3 == 0) {
				divisibleByThree.add(divInteger);
			}
			if (divInteger % 5 == 0) {
				divisibleByFive.add(divInteger);
			}
			if (divInteger % 2 != 0 && divInteger % 3 != 0 && divInteger % 5 != 0) {
				notDivisible.add(divInteger);
			}
		}
		
		listsOfIntegerDivision.add(divisibleByTwo);
		listsOfIntegerDivision.add(divisibleByThree);
		listsOfIntegerDivision.add(divisibleByFive);
		listsOfIntegerDivision.add(notDivisible);
		
		return listsOfIntegerDivision;
	}
	
	// Method 6:
	
	public static List<String> findMatches(List<String> stringList, String searchString){
		List<String> matches = new ArrayList<String>();
		
		for (String string : stringList) {
			if (string.contains(searchString)) {
				matches.add(string);
			}
		}
		
		return matches;
	}
	
	// Method 5:
	
	public static String commaConcatinate(List<String> stringList) {
		StringBuilder commaDelimited = new StringBuilder();
		
		for (String string : stringList) {
			commaDelimited.append(string + ",");
		}
		
		commaDelimited.deleteCharAt(commaDelimited.length()-1);
		
		return commaDelimited.toString();
	}
	
	
	// Method 4:
	
	public static List<String> switchFirstAndLast(List<String> stringList){
		String holdingString = stringList.get(0);
		stringList.set(0, stringList.get(stringList.size()-1));
		stringList.set(stringList.size()-1, holdingString);
		
		return stringList;
	}
	
	// Method 3:
	
	public static String getShortestString(List<String> stringList) {
		int shortestCount = 0;
		String shortestString = null;
		
		for (int i = 0; i < stringList.size(); i++) {
			if (shortestCount == 0 || stringList.get(i).length() < shortestCount) {
				shortestCount = stringList.get(i).length();
				shortestString = stringList.get(i);
			}
		}
		
		return shortestString;
	}

}