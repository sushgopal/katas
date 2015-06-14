import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class ArabicToRomanNumeralConverterTest {
	ArabicToRomanNumeralConverter underTest = new ArabicToRomanNumeralConverter();
	
	@Test
	public void convert1ToI() {
		assertThat(underTest.convert(1), is("I"));
	}
	
	@Test
	public void convert2ToII() {
		assertThat(underTest.convert(2), is("II"));
	}
	
	@Test
	public void convert3ToIII() {
		assertThat(underTest.convert(3), is("III"));
	}
	
	@Test
	public void convert4ToIV() {
		assertThat(underTest.convert(4), is("IV"));
	}
	
	@Test
	public void convert5ToV() {
		assertThat(underTest.convert(5), is("V"));
	}	
	
	@Test
	public void convert6ToVI() {
		assertThat(underTest.convert(6), is("VI"));
	}	
	
	@Test
	public void convert9toIX() {
		assertThat(underTest.convert(9), is("IX"));
	}	
	
	@Test
	public void convert10toX() {
		assertThat(underTest.convert(10), is("X"));
	}	
	
	@Test
	public void convert19toXIX() {
		assertThat(underTest.convert(19), is("XIX"));
	}
	
	@Test
	public void convert20toXX() {
		assertThat(underTest.convert(20), is("XX"));
	}
	
	@Test
	public void convert40toXL() {
		assertThat(underTest.convert(40), is("XL"));
	}
	
	@Test
	public void convert50toL() {
		assertThat(underTest.convert(50), is("L"));
	}
	
	@Test
	public void convert90toXC() {
		assertThat(underTest.convert(90), is("XC"));
	}
	
	@Test
	public void convert100toC() {
		assertThat(underTest.convert(100), is("C"));
	}
	
	@Test
	public void convert400toCD() {
		assertThat(underTest.convert(400), is("CD"));
	}
	
	@Test
	public void convert500toD() {
		assertThat(underTest.convert(500), is("D"));
	}
	
	@Test
	public void convert900toCM() {
		assertThat(underTest.convert(900), is("CM"));
	}
	
	@Test
	public void convert1000toM() {
		assertThat(underTest.convert(1000), is("M"));
	}
	
	@Test
	public void convert999toCMXCIX() {
		assertThat(underTest.convert(999), is("CMXCIX"));
	}
}
