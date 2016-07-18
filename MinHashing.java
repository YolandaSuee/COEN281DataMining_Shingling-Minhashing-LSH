import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MinHashing {
	public int getMinHashs(int size, String[][] s) {
		Random random = new Random(size);
		int a = random.nextInt();
		return a;

	}

	public int[] getMinHash(String[][] s) {

		int[] i = new int[s.length - 1];
		System.out.println("s.length is :" + s.length + "; s[0].length:" + s[0].length);
		for (int x = 1; x < s.length; x++) {
			for (int y = 1; y < s[x].length; y++) {
				if (s[x][y].equals("1")) {
					i[x - 1] = y;
					System.out.println("equals to 1 at location: "+x+":"+y + "; i[" + (x-1) + "]:" + y );
					// continue;
					break;
				}
			}
		}
		return i;
	}
	/**/
	public String[][] RandomStringss(String[][] S) {
		

		String[] random_s = this.RandomStrings(S[0]);

		int r = S.length;
		int c = S[0].length;
		String[][] new_s  = new String[c][r];
		String[][] new_s1  = new String[c][r];
		String[][] re_s  = new String[r][c];
		for(int x = 0;x<r;x++){
			for(int y = 0;y<c;y++){
				new_s[y][x] = S[x][y];
			}
		}
		
		
		for(int x = 0;x<random_s.length;x++){
			for(int y = 0;y<S[0].length;y++){
				
				if(((String)random_s[x]).equals((new_s[y][0]))){
//					System.out.println("  r:"+random_s[x]+"M:"+new_s[y][0]);
					new_s1[x] = new_s[y];
					break;
				}
			}
		}
//		StdOut.print(new_s1);

		for(int x = 0;x<c;x++){
			for(int y = 0;y<r;y++){
				re_s[y][x] = new_s1[x][y];
			}
		}
//		System.out.println(re_s.length+" - "+re_s[0].length);
		return re_s;
	}
	
	

	public String[] RandomStrings(String[] S) {
		List<String> list = new ArrayList<String>();
		for(int x = 1;x<S.length;x++){
			list.add((String)S[x]);
			System.out.println(S[x]);
		}
		Collections.shuffle(list, new Random());
		list.add(0,(String)S[0]);
		return (String[]) list.toArray(new String[list.size()]);
	}

}
