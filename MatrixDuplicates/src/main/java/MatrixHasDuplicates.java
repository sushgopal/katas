import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Map;


public class MatrixHasDuplicates {

	private int[][] input;
	
	private Map<Integer, ArrayList<Position>> map = newHashMap();

	public MatrixHasDuplicates(int[][] input) {
		this.input = input;
	}

	public boolean withinDistance(int k) {
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[0].length;j++) {
				if(map.containsKey(input[i][j])) {
					if(isWithinKDistance(i, j, map.get(input[i][j]), k)) {
						return true;
					} else {
						map.get(input[i][j]).add(new Position(i, j));
						map.put(input[i][j], map.get(input[i][j]));
					}
				} else {
					map.put(input[i][j], newArrayList(new Position(i, j)));
				}
			}
		}
		return false;
	}

	private boolean isWithinKDistance(int row, int column, ArrayList<Position> arrayList, int k) {
		for(Position p: arrayList) {
			if((abs(row-p.row())+abs(column-p.column())) <= k) {
				return true;
			}
		}
		return false;
	}

}
