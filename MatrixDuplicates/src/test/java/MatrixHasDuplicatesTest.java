import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatrixHasDuplicatesTest {
	MatrixHasDuplicates matrixHasDuplicates;

	@Test
	public void shouldReturnFalseIfMatrixHasNoDuplicates() {
		matrixHasDuplicates = new MatrixHasDuplicates(new int[][]{{1, 2},{3, 4}});
		
		assertFalse(matrixHasDuplicates.withinDistance(1));
	}
	
	@Test
	public void shouldReturnTrueIfMatrixHasDuplicates() {
		matrixHasDuplicates = new MatrixHasDuplicates(new int[][]{{1, 2},{3, 2}});
		
		assertTrue(matrixHasDuplicates.withinDistance(2));
	}
	
	@Test
	public void shouldReturnFalseIfDuplicatesAreNotWithinKDistance() {
		matrixHasDuplicates = new MatrixHasDuplicates(new int[][]{{1, 2},{3, 4}, {2, 5}});
		
		assertFalse(matrixHasDuplicates.withinDistance(2));
	}
	
	@Test
	public void shouldReturnTrueIfAnyOfTheDuplicatesAreWithinKDistance() {
		matrixHasDuplicates = new MatrixHasDuplicates(new int[][]{{1, 2, 3},{4, 5, 1}, {1, 8, 9}});
		
		assertTrue(matrixHasDuplicates.withinDistance(2));
	}
}