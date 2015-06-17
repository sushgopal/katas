import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class RomanNumeralCalculatorTest {
	
	RomanNumeralCalculator underTest = new RomanNumeralCalculator();
	
	@Mock
	RomanToArabicNumeralConverter romanToArabicConverter;
	
	@Mock
	ArabicToRomanNumeralConverter arabicToRomanConverter;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addingIAndIIIMustReturnIV() {
		when(romanToArabicConverter.convert("I")).thenReturn(1);
		when(romanToArabicConverter.convert("II")).thenReturn(2);
		when(arabicToRomanConverter.convert(3)).thenReturn("III");
		
		assertThat(underTest.add("I", "II"), is("III"));
	}
	
	@Test
	public void addingDAndDMustReturnM() {
		assertThat(underTest.add("D", "D"), is("M"));
	}
}
