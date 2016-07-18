
public class Jaccard {
	public Jaccard() {

	}

	public String getJaccard(String[] A, String[] B) {
		double same = 0;
		double count = 0;
		if (A.length != B.length) {
			System.out.println("two collection don't equal.");
		} else {
			for (int x = 1; x < A.length; x++) {
				//System.out.println("A[" + x + "]:" + A[x] + "; B[" + x + "]:" + B[x]);
				if (A[x].equals(B[x]) && A[x].equals("1")) {
					same = same + 1;
					count = count + 1;
				}
				else if (A[x].equals(B[x]) && A[x].equals("0")) {

				}
				else {
					count = count + 1;
				}
			}
		}
		//System.out.println("same-count  "+same+"-"+count);
		return "0"+ new java.text.DecimalFormat("#.00000").format(same / count);
	}

	public String[][] getJaccardArray(String[][] A) {
		int column = A.length;
		String[][] d = new String[column][column];
		for (int x = 0; x < column; x++) {
			for (int y = 0; y < column; y++) {
				d[x][y] = "--";
			}
		}
		d[0][0] = "Jaccard";
		for (int x = 1; x < column; x++) {
			d[x][0] = A[x][0];
			d[0][x] = A[x][0];
		}
		for (int x = 1; x < column - 1; x++) {
			for (int y = x; y < column - 1; y++) {
				d[x][y + 1] = this.getJaccard(A[x], A[y + 1]);
			}
		}
		return d;
	}

	public String[][] getDistanceArray(String[][] A) {
		int column = A.length;
		String[][] distance = new String[column][column];
		for (int x = 0; x < column; x++) {
			for (int y = 0; y < column; y++) {
				distance[x][y] = "1.00000";
			}
		}
		distance[0][0] = "Distance";
		for (int x = 1; x < column; x++) {
			distance[x][0] = A[x][0];
			distance[0][x] = A[x][0];
		}
		for (int x = 1; x < column - 1; x++) {
			for (int y = x; y < column - 1; y++) {
				distance[x][y + 1] = String.valueOf(1.00000 - Double.parseDouble(this.getJaccard(A[x], A[y + 1])));
			}
		}
		return distance;
	}


}
