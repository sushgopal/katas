import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


public class MatrixHasDuplicatesTest {
	MatrixHasDuplicates matrixHasDuplicates;

	@Test
	public void shouldReturnFalseIfMatrixHasNoDuplicates() {
		matrixHasDuplicates = new MatrixHasDuplicates(new int[][]{{1, 2},{3, 4}});
		
		assertThat(matrixHasDuplicates.withinDistance(1), is(false));
	}
	
	@Test
	public void shouldReturnTrueIfMatrixHasDuplicates() {
		matrixHasDuplicates = new MatrixHasDuplicates(new int[][]{{1, 2},{3, 2}});
		
		assertThat(matrixHasDuplicates.withinDistance(2), is(true));
	}
	
	@Test
	public void shouldReturnFalseIfDuplicatesAreNotWithinKDistance() {
		matrixHasDuplicates = new MatrixHasDuplicates(new int[][]{{1, 2},{3, 4}, {2, 5}});
		
		assertThat(matrixHasDuplicates.withinDistance(2), is(false));
	}
	
	@Test
	public void shouldReturnTrueIfAnyOfTheDuplicatesAreWithinKDistance() {
		matrixHasDuplicates = new MatrixHasDuplicates(new int[][]{{1, 2, 3},{4, 5, 1}, {1, 8, 9}});
		
		assertThat(matrixHasDuplicates.withinDistance(2), is(true));
	}
}