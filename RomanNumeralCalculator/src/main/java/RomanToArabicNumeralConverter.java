public class RomanToArabicNumeralConverter {

	public int convert(String romanNumeral) {
		if (isEmpty(romanNumeral)) {
			return 0;
		}

		char currentCharacter = romanNumeral.charAt(0);
		char lookupCharacter = getLookupCharacter(romanNumeral);

		if (lookupGreaterThanCurrentCharacter(currentCharacter, lookupCharacter)) {
			return subtractCurrentFromLookup(currentCharacter, lookupCharacter)
					+ convert(romanNumeral.substring(2));
		} else {
			return getArabicNumber(currentCharacter)
					+ convert(romanNumeral.substring(1));
		}
	}

	private int subtractCurrentFromLookup(char currentCharacter,
			char lookupCharacter) {
		return getArabicNumber(lookupCharacter)
				- getArabicNumber(currentCharacter);
	}

	private boolean lookupGreaterThanCurrentCharacter(char currentCharacter,
			char lookupCharacter) {
		return getArabicNumber(lookupCharacter) > getArabicNumber(currentCharacter);
	}

	private char getLookupCharacter(String romanNumeral) {
		return romanNumeral.length() > 1 ? romanNumeral.charAt(1) : 0;
	}

	private boolean isEmpty(String romanNumber) {
		return romanNumber.equals("");
	}

	private int getArabicNumber(char character) {
		switch (character) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

}
