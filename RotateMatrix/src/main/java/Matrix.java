import static java.lang.Math.ceil;
import static java.util.stream.IntStream.range;

import java.util.function.IntConsumer;

public class Matrix {

	private int[][] input;

	public Matrix(int[][] input) {
		this.input = input;
	}

	public int[][] rotate() throws Exception {
		if (!isSquare(input)) {
			throw new Exception("ERROR: Input not a square matrix");
		}

		return rotateMatrix();
	}
	
	private boolean isSquare(int[][] matrix) {
		return rows() == columns();
	}

	private int rows() {
		return input.length;
	}
	
	private int columns() {
		return input[0].length;
	}
	
	private int[][] rotateMatrix() {
		int[][] result = new int[rows()][columns()];
		range(0, getLevels(input)).forEach(new IntConsumer() {
			@Override
			public void accept(int level) {
				rotateAtLevel(result, level);
			}
		});	
		return result;
	}
	
	private int getLevels(int[][] matrix) {
		return (int) ceil((double) rows() / 2);
	}
	
	void rotateAtLevel(int[][] result, int level) {
		if(isLastLevel(level) && isOddMatrixSize()) {
			result[level][level] = input[level][level];
			return;
		}
		
		shiftFirstRowAtLevel(result, level);
		shiftLastColumnAtLevel(result, level);
		shiftLastRowAtLevel(result, level);
		shiftFirstColumnAtLevel(result, level);
	}

	private boolean isLastLevel(int level) {
		return level == getLevels(input)-1;
	}

	private boolean isOddMatrixSize() {
		return rows() % 2 != 0;
	}
	
	private void shiftFirstRowAtLevel(int[][] result, int level) {
		range(level, getLastColumnForLevel(level)).forEach(new IntConsumer() {
			@Override
			public void accept(int column) {
				result[level][column+1] = input[level][column];
			}
		});
	}
	
	private void shiftLastColumnAtLevel(int[][] result, int level) {
		int lastColumnForLevel = getLastColumnForLevel(level);

		range(level, getLastRowForLevel(level)).forEach(new IntConsumer() {
			@Override
			public void accept(int row) {
				result[row+1][lastColumnForLevel] = input[row][lastColumnForLevel];
			}
		});
	}

	private void shiftLastRowAtLevel(int[][] result, int level) {
		int lastRowForLevel = getLastRowForLevel(level);

		range(level, getLastColumnForLevel(level)).map(column -> columns() - (column + 1))
												.forEach(new IntConsumer() {
													@Override
													public void accept(int column) {
														result[lastRowForLevel][column-1] = input[lastRowForLevel][column];
													}
												});
	}

	private void shiftFirstColumnAtLevel(int[][] result, int level) {
		range(level, getLastRowForLevel(level)).map(row -> rows() - (row + 1))
												.forEach(new IntConsumer() {
													@Override
													public void accept(int row) {
														result[row-1][level] = input[row][level];
													}
												});
	}

	private int getLastRowForLevel(int level) {
		return rows()-(level + 1);
	}

	private int getLastColumnForLevel(int level) {
		return columns()-(level + 1);
	}
	
}
