import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class RomanNumeralCalculatorTest {
	
	@InjectMocks
	RomanNumeralCalculator underTest;
	
	@Mock
	RomanToArabicNumeralConverter romanToArabicConverter;
	
	@Mock
	ArabicToRomanNumeralConverter arabicToRomanConverter;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldConvertArgumentsInRomanNumeralToArabic() {
		underTest.sumOf("I", "X");
		
		verify(romanToArabicConverter, times(1)).convert("I");
		verify(romanToArabicConverter, times(1)).convert("X");
	}
	
	@Test
	public void shouldConvertSumInArabicNumeralToRoman() {
		when(romanToArabicConverter.convert("I")).thenReturn(1);
		when(romanToArabicConverter.convert("II")).thenReturn(2);
		
		underTest.sumOf("I", "II");
		
		verify(arabicToRomanConverter, times(1)).convert(3);
	}
	
	@Test
	public void shouldReturnSumOfIAndIIIAsIV() {
		when(romanToArabicConverter.convert("D")).thenReturn(500);
		when(arabicToRomanConverter.convert(1000)).thenReturn("M");
		
		assertThat(underTest.sumOf("D", "D"), is("M"));
	}
	
}
