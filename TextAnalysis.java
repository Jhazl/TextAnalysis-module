import java.util.*;

class TextAnalysis{
	
	//Function to check whether a given input is digit 
	public static boolean isDigit(String input){
		return input.matches("\\d+");
	}
	
	//Function to check whether a given character is digit
	public static boolean isDigit(char input){
		String charCastedToString = String.valueOf(input);
		return isDigit(charCastedToString);
		
	}
	
	//Function to check whether a string is punctuation
	public static boolean isPunctuation(String string){
		return string.matches("\\p{Punct}");
	}
	
	//Function to check whether a character is punctuatiqon
	public static boolean isPunctuation(char character){
		String charCastedToString = String.valueOf(character);
		return isPunctuation(charCastedToString);
	}
	
	//Removes all punctuation from a string
	public static String removePunctuation(String str){
		String stringWithPuncRemoved = "";
		for(int i = 0; i<str.length(); i++){
			String characterToCheck = str.substring(i, i + 1);
			if(!(isPunctuation(characterToCheck))){
				stringWithPuncRemoved += characterToCheck;
			}
			
		}
		return stringWithPuncRemoved;
	}
	
	//Removes punctuation from string that isnt the exception punctuation
	public static String removePunctuationWithException(String str, String exception){
		String stringWithPuncRemoved = "";
		for(int i = 0; i<str.length(); i++){
			String characterToCheck = str.substring(i, i + 1);
			if(characterToCheck.equals(exception)){
				stringWithPuncRemoved += characterToCheck;
			}else if(!(isPunctuation(characterToCheck))){
				stringWithPuncRemoved += characterToCheck;
			}
			
		}
		return stringWithPuncRemoved;
	}
	
	//Removes punctuation from string that isn't the character exception
	public static String removePunctuationWithException(String str, char exception){
		String charExceptionAsString = String.valueOf(exception);
		return removePunctuationWithException(str, charExceptionAsString);
	}
	
	//Removes punctuation from string that isnt in the string array of exceptions 
	public static String removePunctuationWithExceptions(String str, String[] exceptions){
		ArrayList<String> exceptionsList = new ArrayList<String>();
		for(int i = 0; i < exceptions.length; i++){
			exceptionsList.add(exceptions[i]);
		}
		return removePunctuationWithExceptions(str, exceptionsList);
	}
	
	//Removes punctuation from string that isnt in the string arraylist of exceptions 
	public static String removePunctuationWithExceptions(String str, ArrayList<String> exceptions){
		String stringWithPuncRemoved = "";
		for(int i = 0; i<str.length(); i++){
			String characterToCheck = str.substring(i, i + 1);
			if(exceptions.indexOf(characterToCheck) != -1){
				stringWithPuncRemoved += characterToCheck;
			}else if(!(isPunctuation(characterToCheck))){
				stringWithPuncRemoved += characterToCheck;
			}
			
		}
		return stringWithPuncRemoved;
	}
	
	//Remove all characters in list from string
	public static String removeAllCharactersFromString(String str, String[] characters){
		ArrayList<String> characterList = new ArrayList<String>();
		for(int i = 0; i < characters.length; i++){
			characterList.add(characters[i]);
		}
		return removeAllCharactersFromString(str, characterList);
	}
	
	//Remove all characters in arraylist from string 
	public static String removeAllCharactersFromString(String str, ArrayList<String> characters){
		String stringWithCharactersRemoved = "";
		for(int i = 0; i<str.length(); i++){
			String characterToCheck = str.substring(i, i + 1);
			if(characters.indexOf(characterToCheck) == -1){
				stringWithCharactersRemoved += characterToCheck;
			}
		}
		return stringWithCharactersRemoved;
	}
	
	//Remove all digits
	public static String removeAllDigits(String input){
		String stringWithRemovedDigits = "";
		for(int i = 0; i<input.length(); i++){
			String currentChar = input.substring(i, i+1);
			if(!(isDigit(currentChar))){
				stringWithRemovedDigits += currentChar;
			}
		}
		return stringWithRemovedDigits;
		
	} 
	
	//Remove all digits and punctuation
	public static String removeAllDigitsAndPunctuation(String input){
		String stringWithRemovedDigits = "";
		for(int i = 0; i<input.length(); i++){
			String currentChar = input.substring(i, i+1);
			if(!(isDigit(currentChar)) && !(isPunctuation(currentChar))){
				stringWithRemovedDigits += currentChar;
			}
		}
		return stringWithRemovedDigits;
		
	} 
	
	//Replace all character with a certain character which is case insensitive
	public static String replaceAllCharacter(String inputString, char characterToBeReplaced, char characterToUseForReplacement){
		
		String stringWithCharactersReplaced = "";
		
		String characterToBeRep = String.valueOf(characterToBeReplaced);
		String characterForRep = String.valueOf(characterToUseForReplacement);
		
		for(int i = 0; i<inputString.length(); i++){
			String characterToCheck = inputString.substring(i, i + 1);
			if(characterToCheck.toLowerCase().equals(characterToBeRep.toLowerCase())){
				if(Character.isUpperCase(inputString.charAt(i))){
					stringWithCharactersReplaced += characterForRep.toUpperCase();
				}else{
					stringWithCharactersReplaced += characterForRep.toLowerCase();
				}
			}else{
				stringWithCharactersReplaced += characterToCheck;
			}
		}
		
		return stringWithCharactersReplaced;
	}
	
	
	//Replace all character in list with a certain character which is case insensitive.
	public static String replaceAllCharacters(String inputString, char[] charactersToBeReplaced, char characterToUseForReplacement){
		
		String stringWithCharactersReplaced = inputString;
		
		for(int i = 0; i<charactersToBeReplaced.length; i++){
			stringWithCharactersReplaced = replaceAllCharacter(stringWithCharactersReplaced, charactersToBeReplaced[i], characterToUseForReplacement);
		}
		
		return stringWithCharactersReplaced;
	}
	
	
	
	//Returns an list of all words tokenised from string
	public static ArrayList<String> getAllWordsFromStringAsList(String str){
		ArrayList<String> arrayListToReturn = new ArrayList<String>();
		str = str.toLowerCase();
		str = str.replace("\n", "");
		String[] wordsInString = str.split(" ", 0);
		for(int i = 0; i<wordsInString.length; i++){
			String word = wordsInString[i];
			if(!(validUrl(word)) && !(isDigit(word)) && !(word.contains("."))){
				arrayListToReturn.add(removePunctuation(wordsInString[i]));
			}
		}
		return arrayListToReturn;
	}
	 
	
	//Checks using regex if a string representing a url is valid or not
	public static boolean validUrl(String url){
		return url.matches("(https?://|www\\.)[-a-zA-Z0-9+&@#/%?=~_|!:.;]*[-a-zA-Z0-9+&@#/%=~_|]");
	}
	
	//Returns all urls from a text
	public static ArrayList<String> getValidUrlFromText(String text){
		ArrayList<String> arrayListToReturn = new ArrayList<String>();
		String[] wordArray = text.split("\\s+");
		
		for(int i = 0; i<wordArray.length; i++){
			if(validUrl(wordArray[i])){
				arrayListToReturn.add(wordArray[i]);
			}
		}
		return arrayListToReturn;
	}
	
	//Removes all urls from a string
	public static String removeAllUrlsFromText(String text){
		String textWithRemovedUrls = "";
		String[] wordArray = text.split("\\s+");
		for(int i = 0; i<wordArray.length; i++){
			if(!(validUrl(wordArray[i]))){
				textWithRemovedUrls += wordArray[i] + " ";
			}
		}
		return textWithRemovedUrls.substring(0, (textWithRemovedUrls.length() - 1));
	}
	
		
	
	//Count occurances of word
	public static int getCountOfWord(String stringToFindOccurances, String word){
		word = word.toLowerCase();
		ArrayList<String> stringAsArray = getAllWordsFromStringAsList(stringToFindOccurances);
		int count = 0;
		for(int i = 0; i<stringAsArray.size(); i++){
			String stringToCheck = stringAsArray.get(i);
			System.out.println(stringToCheck);
			if(stringToCheck.equals(word)){
				count++;
			}	
		}
		return count;
	}
	
	
	
	
	
	//Get all unique words
	public static ArrayList<String> getAllUniqueWords(String str){
		ArrayList<String> listOfUniques = new ArrayList<String>();
		str = str.toLowerCase();
		str = str.replace("\n", "");
		String[] wordsInString = str.split(" ", 0);
		for(int i = 0; i<wordsInString.length; i++){
			String word = wordsInString[i];
			if(!(validUrl(word)) && !(isDigit(word)) && !(word.contains(".")) && (listOfUniques.indexOf(removePunctuation(word)) == -1)){
				listOfUniques.add(removePunctuation(wordsInString[i]));
			}
		}
		return listOfUniques;
	}
	
	
	//Count occurances of letter
	public static int countOccurancesOfLetter(String sentence, char letter){
		int count = 0;
		for(int i = 0; i<sentence.length(); i++){
			char currentChar = sentence.toLowerCase().charAt(i);
			if(currentChar == letter){
				count ++;
			}
		}
			
		return count;
		
	}
	
	//Capitalize each starting letter 
	public static String capitalizeStartingLetter(String strToCapitalize){
		String stringToReturn = "";
		String[] strToCapitalizeTokenised = strToCapitalize.split(" ", 0);
		for(int i = 0; i<strToCapitalizeTokenised.length; i++){
			String word = strToCapitalizeTokenised[i];
			if(!(isDigit(word)) && !(validUrl(word))){
				word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
				stringToReturn += word + " ";
			}
		}
		return stringToReturn.substring(0, (stringToReturn.length() - 1));
		
	}
	
	
	
	
	//to implement
	/*
	//Get most common word
	public static String getMostCommonWord(String str){
		String mostCommon = "Implement This Function";
		return mostCommon;
	}
	
	//Tokenises the text string into an arraylist with all fullstops being represented as a null value
	public static ArrayList<String> tokeniseWithFullStopsAsNulls(String str){
		ArrayList<String> arrayListToReturn = new ArrayList<String>();
		return arrayListToReturn;
	}
	
	//implement end
	*/ 
	
}