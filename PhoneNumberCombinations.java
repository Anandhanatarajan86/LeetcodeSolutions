class Solution {
	// construct digitChar Map
	List<String> allCombinationWord = new ArrayList<>();
	 Map<Character, String> charDigitMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
     
		// construct Mapping for digit and chars
		construtDigitCharMapping(digits);

		//edge case when digits is empty
		if(digits.isEmpty() || digits.length()==0)
		return allCombinationWord;

		char[] inputDigitArray = digits.toCharArray();

		StringBuilder combination = new StringBuilder();

		dfsBacktracking(inputDigitArray, 0, 0, combination);
		//System.out.println("printing allCombinationWord**"+allCombinationWord);
		return allCombinationWord;
	   
    }
		// dfs Helper Method
	private void dfsBacktracking(char[] digitArray, int digitIndex, int charIndex, StringBuilder combination) {

		// Base case when we reach Last DigitIndex

		if (digitIndex == digitArray.length) {

			allCombinationWord.add((combination.toString().trim()));
			return;
		}

		// explore all possible candidates for given digit
		// Get the Mapping for current Digit
		String letter = charDigitMap.get(digitArray[digitIndex]);
		// very important check NULL pointer exception because 1 & 0 does not have any
		// mapping
		if (letter != null && letter.length() > 0) {
			for (int letterIndex = 0; letterIndex < letter.length(); letterIndex++) {
				// add the current character
				Character current = letter.charAt(letterIndex);
				combination.append(current);

				// do recursive call for next digit
				dfsBacktracking(digitArray, 1 + digitIndex, letterIndex, combination);
				// backtrack
				combination.deleteCharAt(combination.length() - 1);

			}
		}

	}
	private void construtDigitCharMapping(String digits) {
		charDigitMap.put('2', "abc");
		charDigitMap.put('3', "def");
		charDigitMap.put('4', "ghi");
		charDigitMap.put('5', "jkl");
		charDigitMap.put('6', "mno");
		charDigitMap.put('7', "pqrs");
		charDigitMap.put('8', "tuv");
		charDigitMap.put('9', "wxyz");
	}
}
Console

Run
Submit
Letter Combinations of a Phone Number - LeetCode
