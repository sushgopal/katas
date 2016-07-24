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

	private int getLevels(int[][] matrix) {
		return (int) Math.ceil((double) matrix.length / 2);
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
	
	private boolean isOddMatrixSize() {
		return rows() % 2 != 0;
	}
	
	void rotateAtLevel(int[][] result, int level) {
		if((level == getLevels(input)-1) && isOddMatrixSize()) {
			result[level][level] = input[level][level];
			return;
		}
		
		int lastColumnForLevel = getLastColumnForLevel(level);
		int lastRowForLevel = getLastRowForLevel(level);

		range(level, lastColumnForLevel).forEach(new IntConsumer() {
			@Override
			public void accept(int column) {
				result[level][column+1] = input[level][column];
			}
		});
		
		range(level, lastRowForLevel).forEach(new IntConsumer() {
			@Override
			public void accept(int row) {
				result[row+1][lastColumnForLevel] = input[row][lastColumnForLevel];
			}
		});
		
		for(int i=lastColumnForLevel; i>level; i--) {
			result[lastRowForLevel][i-1] = input[lastRowForLevel][i];
		}
		
		for(int i=lastRowForLevel; i>level; i--) {
			result[i-1][level] = input[i][level];
		}
//		range(level, columns-(level+1)).map(column -> columns - column - 1)
//									.forEach(new IntConsumer() {
//										@Override
//										public void accept(int column) {
//											
//										}
//									});
//		
//		range(level, rows-(level + 1)).map(row -> rows - row - 1)
//								.forEach(new IntConsumer() {
//									@Override
//									public void accept(int row) {
//										
//									}
//								});
		
	}

	private int getLastRowForLevel(int level) {
		return rows()-(level + 1);
	}

	private int getLastColumnForLevel(int level) {
		return columns()-(level + 1);
	}

	private int rows() {
		return input.length;
	}
	
	private int columns() {
		return input[0].length;
	}
	
}
