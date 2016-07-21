import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class RotateMatrix {

	public int[][] rotate(int[][] matrix) throws Exception {
		if (!isSquare(matrix)) {
			throw new Exception("ERROR: Input not a square matrix");
		}

		int rows = matrix.length;
		
		int levels = (int) Math.ceil((double) rows / 2);
		int[][] result = new int[rows][rows];
		
		IntStream.range(0, levels).forEach(new IntConsumer() {
			@Override
			public void accept(int level) {
				rotateAtLevel(result, matrix, level);
			}
		});
		
		return result;
	}

	void rotateAtLevel(int[][] result, int[][] matrix, int level) {
		
	}
	
	private boolean isSquare(int[][] matrix) {
		return matrix.length == matrix[0].length;
	}

}
