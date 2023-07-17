# Text Analysis module
Module for better string analysis on Java

## About
The following class is made for text analysis in Java. The class consists of static methods to analyze text and is designed to be used similarly to the math module in java but for strings. The functions in this package can be implemented in programs where the programmers aren't familiar with regex or don't have time to worry about the implementation of the methods. Since all the methods are static you can you can call all methods using TextAnalysis.FunctionName(Input), e.g. TextAnalysis.isDigit("Hello world") will return false. 

## Function list

|Return type|Method|Description|
| --- | --- | --- |
|boolean|isDigit(String input|Returns whether a string is digit|
|boolean|isDigit(char input)|Returns whether a char is a digit|
|boolean|isPunctuation(String string)|Returns whether a string is punctuation|
|String|removePunctuation(String str)|Returns a new string with all the punctuation removed|
|String|removePunctuationWithExceptions(String str, String[] exceptions)|Removes punctuation from the string that isnt in the array of exceptions|
|String|removePunctuationWithExceptions(String str, ArrayList<String> exceptions)|Removes punctuation from the string that isnt in the array of exceptions|
|String|removeAllCharactersFromString(String str, ArrayList<String> characters)|Removes all characters from the string that are in the arraylist|
|String|removeAllDigits(String input)|Removes all digits from the string|
|String|removeAllDigitsAndPunctuation(String input)|Returns a string with all digits removed|
|String|replaceAllCharaccter(String inputString, char characterToBeReplaced, char characterToUseForReplacement)|Replace all characters that are the characterToBeReplaced with the characterToUseForReplacement|
|String|replaceAllCharacters(String inputString, char[] charactersToBeReplaced, char characterToUseForReplacement)|Returns a string with all characters in the array replaced with the characterToUseForReplacement|
|ArrayList<String>|getAllWordsFromStringAsList(String str)|Gets all words from the string as a list|
|boolean|validUrl(String url)|Uses regex to return whether a url is valid|
|ArrayList<String>|getValidUrlFromText(String text)|Returns all valid urls from text|
|String|removeAllUrlsFromText(String text)|Removes all valid urls from text|
|int|getCountOfWord(String stringToFindOccurances, String word)|Returns a count of the word in the text|
|ArrayList<String>|getAllUniqueWords(String str)|Returns all the words that are unique in a string|
|int|countOccurancesOfLetter(String sentence, char letter)|Returns a count of all the occurances of a letter|
|String|capitalizeStartingLetter(String strToCapitalize)|Capitilizes the starting letter of all words in the string that aren't a url|

## How to use

Download the TextAnalysis.java to see the source code. Add either the TextAnalysis.java or the TextAnalysis.class to your repository and call functions using TextAnalysis.FunctionName(Argument)
