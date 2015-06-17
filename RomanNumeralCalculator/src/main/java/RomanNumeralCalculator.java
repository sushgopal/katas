public class RomanNumeralCalculator {

	RomanToArabicNumeralConverter romanToArabicConverter = new RomanToArabicNumeralConverter();

	ArabicToRomanNumeralConverter arabicToRomanConverter = new ArabicToRomanNumeralConverter();

	public String add(String n1, String n2) {
		int a = romanToArabicConverter.convert(n1);
		int b = romanToArabicConverter.convert(n2);

		return arabicToRomanConverter.convert(a + b);
	}

}
