import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class MatrixTest {
	
	private int[][] input = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
	
	private int[][] result = new int[3][3];
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionIfMatrixIsNotSquare() throws Exception {
		Matrix subject = new Matrix(new int[][]{{1, 2, 0}, {3, 4, 5}});
		
		subject.rotate();
	}
	
	@Test
	public void shouldCallRotateMatrixAtLevelExpectedNumberOfTimes() throws Exception {
		Matrix subject = spy(new Matrix(input));
		subject.rotate();
		
		verify(subject).rotateAtLevel(any(), eq(0));
		verify(subject).rotateAtLevel(any(), eq(1));
	}
	
	@Test
	public void shouldSetSizeOfResultMatrixTheSameAsInputMatrix() throws Exception {
		Matrix subject = new Matrix(input);
		int[][] result = subject.rotate();
		
		assertThat(result.length, is(input.length));
		assertThat(result[0].length, is(input[0].length));
	}
	
	@Test
	public void shouldShiftFirstRowAtGivenLevel() {
		Matrix subject = new Matrix(input);
		subject.rotateAtLevel(result, 0);
		
		assertThat(result[0][1], is(1));
		assertThat(result[0][2], is(2));
	}
	
	@Test
	public void shouldShiftLastRowAtGivenLevel() {
		Matrix subject = new Matrix(input);
		subject.rotateAtLevel(result, 0);
		
		assertThat(result[2][0], is(8));
		assertThat(result[2][1], is(9));
	}
	
	@Test
	public void shouldShiftFirstColumnAtGivenLevel() {
		Matrix subject = new Matrix(input);
		subject.rotateAtLevel(result, 0);
		
		assertThat(result[0][0], is(4));
		assertThat(result[1][0], is(7));
	}
	
	@Test
	public void shouldShiftLastColumnAtGivenLevel() {
		Matrix subject = new Matrix(input);
		subject.rotateAtLevel(result, 0);
		
		assertThat(result[1][2], is(3));
		assertThat(result[2][2], is(6));
	}
	
	@Test
	public void shouldReturnExpectedRotatedMatrixForOddNumberOfLevels() throws Exception {
		Matrix subject = new Matrix(input);
		int[][] result = subject.rotate();
		
		assertThat(result[0], equalTo(new int[]{4, 1, 2}));
		assertThat(result[1], equalTo(new int[]{7, 5, 3}));
		assertThat(result[2], equalTo(new int[]{8, 9, 6}));
	}
	
	@Test
	public void shouldReturnExpectedRotatedMatrixForEvenNumberOfLevels() throws Exception {
		Matrix subject = new Matrix(new int[][]{{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}});
		int[][] result = subject.rotate();
		
		assertThat(result[0], equalTo(new int[]{5, 1, 2, 3}));
		assertThat(result[1], equalTo(new int[]{9, 10, 6, 4}));
		assertThat(result[2], equalTo(new int[]{13, 11, 7, 8}));
		assertThat(result[3], equalTo(new int[]{14, 15, 16, 12}));
	}
}
