import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

public class RotateMatrixTest {
	
	@Spy
	private RotateMatrix rotateMatrix = new RotateMatrix();
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionIfMatrixIsNotSquare() throws Exception {		
		rotateMatrix.rotate(new int[][]{{1, 2, 0}, {3, 4, 5}});
	}
	
	@Test
	public void shouldCallRotateMatrixAtLevelExpectedNumberOfTimes() throws Exception {
		int[][] matrix = new int[][]{{1,2,3}, {1,2,3}, {1,2,3}};
		rotateMatrix.rotate(matrix);
		
		verify(rotateMatrix).rotateAtLevel(any(), eq(matrix), eq(0));
		verify(rotateMatrix).rotateAtLevel(any(), eq(matrix), eq(1));
	}
}
