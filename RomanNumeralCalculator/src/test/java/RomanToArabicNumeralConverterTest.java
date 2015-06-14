import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class RomanToArabicNumeralConverterTest {

	RomanToArabicNumeralConverter underTest = new RomanToArabicNumeralConverter();
	
	@Test
	public void convertIto1() {
		assertThat(underTest.convert("I"), is(1));
	}
	
	@Test
	public void convertIIto2() {
		assertThat(underTest.convert("II"), is(2));
	}	
	
	@Test
	public void convertIIIto3() {
		assertThat(underTest.convert("III"), is(3));
	}		
	
	@Test
	public void convertIVto4() {
		assertThat(underTest.convert("IV"), is(4));
	}	
	
	@Test
	public void convertVto5() {
		assertThat(underTest.convert("V"), is(5));
	}	
	
	@Test
	public void convertVIto6() {
		assertThat(underTest.convert("VI"), is(6));
	}
	
	@Test
	public void convertIXto9() {
		assertThat(underTest.convert("IX"), is(9));
	}
	
	@Test
	public void convertXLto40() {
		assertThat(underTest.convert("XL"), is(40));
	}
	
	@Test
	public void convertXLIto41() {
		assertThat(underTest.convert("XLI"), is(41));
	}
	
	@Test
	public void convertXCto90() {
		assertThat(underTest.convert("XC"), is(90));
	}
	
	@Test
	public void convertDto500() {
		assertThat(underTest.convert("D"), is(500));
	}
	
	@Test
	public void convertMto1000() {
		assertThat(underTest.convert("M"), is(1000));
	}
	
	@Test
	public void convertCMXCIXto999() {
		assertThat(underTest.convert("CMXCIX"), is(999));
	}	
}
