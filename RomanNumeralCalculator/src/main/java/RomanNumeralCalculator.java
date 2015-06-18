public class RomanNumeralCalculator {

	RomanToArabicNumeralConverter toArabicConverter = new RomanToArabicNumeralConverter();

	ArabicToRomanNumeralConverter toRomanConverter = new ArabicToRomanNumeralConverter();

	public String sumOf(String romanNumeral1, String romanNumeral2) {
		return toRomanConverter.convert(toArabicConverter
				.convert(romanNumeral1)
				+ toArabicConverter.convert(romanNumeral2));
	}

}
