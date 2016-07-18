

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class P2 {
	public P2(){

	}
	public static void main(String[] args)
	{
		try {
			ExecP2(9);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public static void ExecP2(int n) throws IOException {
		//DateRead dt = new DateRead();
		ReadFiles rf = new ReadFiles();
		List<String> FileList = rf.ReadInput(System.in);
		//List<String> FileList = rf.ReadInput(new FileInputStream("/Users/YolandaSuee/Desktop/DataMiningP2/coen281_copy/t29.dat"));
		try {
			HashMap<String,String> FileMap = rf.readFiles(FileList);
//			System.out.println("here try to print FileMap:");
//			StdOut.print(FileMap);

			Jaccard j = new Jaccard();
			MinHashing m = new MinHashing();
			Clustering group = new Clustering();

			Arrs ar = new Arrs();
			String[] stop_word = {"\u0020the\u0020","\u0020as\u0020","\u0020at\u0020","\u0020which\u0020","\u0020on\u0020",
				"The\u0020","As\u0020","At\u0020","Which\u0020","On\u0020"};

//		if (dt.getFile() != null) {
//			HashMap<String, String> maps = dt.FileToList(dt.getFile(),stop_word);
//			StdOut.printf(maps);
			HashMap<String, String[]> maps1 = ar.MapToArray(FileMap, n);
//			StdOut.print(maps1);

			maps1 = ar.MapRemoveduplicate(maps1);
//			System.out.println("here is maps1: ");
//			StdOut.print(maps1);

			String[] ss = ar.getStingArr(maps1);
//			System.out.println("here is ss: ");
//			StdOut.print(ss);

			String[][] ars= ar.getStingArr(ss, maps1);
//			System.out.println("[]:"+ars.length+"   [][]:"+ars[0].length);
//			StdOut.print(ars);

			String[][] jc = j.getJaccardArray(ars);
//			System.out.println("Jaccard similarity:");
//			StdOut.print(jc);
			String[][] distance = j.getDistanceArray(ars);
//			System.out.println("here print the distance : ");
//			StdOut.print(distance);

			int row = 0, column = 0;
			System.out.println("group pairs is : " + group.group(distance, row, column));
//			System.out.println(group.clustering(distance, 0.09));


//			int[] i = m.getMinHash(ars);
//			System.out.println("here print i:");
//			StdOut.print(i);
//			String[][] n_ars = m.RandomStringss(ars);
//			StdOut.print(n_ars);

//			int[] ii = m.getMinHash(n_ars);
//			System.out.println("here print ii:");
//			StdOut.print(ii);
//		}

		}
		finally {
		}

	}

}
