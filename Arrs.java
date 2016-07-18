
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Arrs {

	public Arrs() {

	}


	public HashMap<String, String[]> MapToArray(HashMap<String, String> map,
			int num) {
		HashMap<String, String> Map = map;
		HashMap<String, String[]> Mas = new HashMap<String, String[]>();

		String[] strs = null;
		if (num > 1) {
			for (Map.Entry<String, String> entry : Map.entrySet()) {
				strs = this.StringToString(entry.getValue(), num);
				Mas.put(entry.getKey(), strs);
				strs = null;
			}
		} else {
			System.out.println("should be bigger than 2! ");
		}
		return Mas;
	}


	public String[] StringToString(String str, int num) {
		String[] new_strs;
		if (str.length() <= num) {
			new_strs = new String[1];
			new_strs[0] = str;
		} else {
			int count = str.length();
			new_strs = new String[count - num + 1];
			for (int x = 0; x < count - num + 1; x++) {
				new_strs[x] = (String) str.subSequence(x, x + num);

			}
		}
		return new_strs;
	}


	public String[] StringRemoveduplicate(String[] str) {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < str.length; i++) {
			if (!list.contains(str[i])) {
				list.add(str[i]);
			}
		}
		return (String[]) list.toArray(new String[list.size()]);
	}


	public HashMap<String, String[]> MapRemoveduplicate(
			HashMap<String, String[]> map) {
		HashMap<String, String[]> Map = map;
		for (Map.Entry<String, String[]> entry : Map.entrySet()) {
			Map.put(entry.getKey(),
					this.StringRemoveduplicate(entry.getValue()));
		}
		return Map;
	}


	public String[] StringIntersection(String[] a, String[] b) {
		List<String> list = new LinkedList<String>();
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < b.length; y++) {
				if (a[x].equals(b[y])) {
					list.add(a[x]);
					continue;
				}
			}
		}

		return (String[]) list.toArray(new String[list.size()]);
	}


	public String[] StringUnion(String[] a, String[] b) {
		int counta = a.length;
		int countb = b.length;

		String[] A = new String[counta + countb];

		for (int x = 0; x < counta; x++) {
			A[x] = a[x];
		}
		for (int x = counta; x < counta + countb; x++) {
			A[x] = b[x - counta];
		}


		A = this.StringRemoveduplicate(A);

		return A;
	}


	public String[] getStingArr(HashMap<String, String[]> map) {

		List<String> list = new LinkedList<String>();
		HashMap<String, String[]> Map = map;
		list.add("Collection");
		for (Map.Entry<String, String[]> entry : Map.entrySet()) {
			// Map.put(entry.getKey(),
			// this.StringRemoveduplicate(entry.getValue()));

			for (int x = 0; x<entry.getValue().length; x++) {
				list.add(entry.getValue()[x]);
			}

		}
		return this.StringRemoveduplicate((String[]) list.toArray(new String[list.size()]));
	}
	
	/**/
	public String[][] getStingArr(String[] s,HashMap<String, String[]> map) {

		int count = s.length;

		int x = 1;

		String[][] b = new String[this.getMapsNum(map)+1][count+1];
		for(int j = 0;j<b.length;j++){
			for(int k = 0;k<b[j].length;k++){
				b[j][k] = "0";
			}
		}

		b[0] = s;
//		List<String> list = new LinkedList<String>();
		HashMap<String, String[]> Map = map;
		
		for (Map.Entry<String, String[]> entry : Map.entrySet()) {

			b[x][0] = (String)entry.getKey();

			for(int y = 1;y<entry.getValue().length+1;y++){
				
//				b[x][y] = entry.getValue()[y-1];
				for(int z= 1;z<s.length;z++){
					
					if(entry.getValue()[y-1].equals(s[z])){
						b[x][z] = "1";
					}
				}
					
				
			}
			x++;
		}
		return b;
	}
	

	public int getMapsNum(HashMap<String, String[]> map) {

		int count = 0;
		HashMap<String, String[]> Map = map;

		for (Map.Entry<String, String[]> entry : Map.entrySet()) {
			count = count+1;
		}
		return count;
	}

}
