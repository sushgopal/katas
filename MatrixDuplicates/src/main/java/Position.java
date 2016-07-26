import static java.lang.Math.abs;

import java.util.List;

public class Position {

	private int column;
	private int row;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int row() {
		return row;
	}
	
	public int column() {
		return column;
	}

	public boolean isAnyWithinKDistance(List<Position> duplicatePositions, int distance) {
		for(Position position: duplicatePositions) {
			if(rowLineSegmentFrom(position)+columnLineSegmentFrom(position) <= distance) {
				return true;
			}
		}
		return false;
	}

	private int columnLineSegmentFrom(Position p) {
		return lineSegment(column, p.column());
	}

	private int rowLineSegmentFrom(Position p) {
		return lineSegment(row, p.row());
	}
	
	private int lineSegment(int a, int b) {
		return abs(a-b);
	}
}
