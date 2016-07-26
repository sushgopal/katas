
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
}
