import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;

public class MatrixHasDuplicates {

	private int[][] input;

	private Map<Integer, List<Position>> duplicatePositions = newHashMap();

	public MatrixHasDuplicates(int[][] input) {
		this.input = input;
	}

	public boolean withinDistance(int k) {

		for (int row = 0; row < rows(); row++) {
			for (int column = 0; column < columns(); column++) {
				if (numberAlreadyExists(row, column) && isWithinKDistanceFromDuplicates(row, column, k)) {
					return true;
				}

				addToMap(row, column);
			}
		}
		return false;

	}
	
	private int rows() {
		return input.length;
	}
	
	private int columns() {
		return input[0].length;
	}
	
	private boolean numberAlreadyExists(int i, int j) {
		return duplicatePositions.containsKey(input[i][j]);
	}
	
	private boolean isWithinKDistanceFromDuplicates(int row, int column, int k) {
		return new Position(row, column).isAnyWithinKDistance(duplicatePositions.get(input[row][column]), k);
	}

	private void addToMap(int row, int column) {
		List<Position> duplicates = duplicatePositions.get(input[row][column]);
		
		if(duplicates == null) {
			duplicates = newArrayList();
		}
		
		duplicates.add(new Position(row, column));
		duplicatePositions.put(input[row][column], duplicates);
	}

}
