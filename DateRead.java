
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DateRead {
	File file;
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}

	public DateRead(){
		
		System.out.print("Please input the path of the files: B for default path, and T for terminate and quit ");
		String s = "a";
		boolean flag = false;
		/*  */
		while(!flag){
			s = new Scanner(System.in).next().toUpperCase();
			if(s.equals("B")){
				System.out.println("Using default path: /Users/YolandaSuee/Desktop/DataMiningP2/coen281 ");
				flag = StdIn.setScanner();
				s ="/Users/YolandaSuee/Desktop/DataMiningP2/coen281";
			}else if(s.equals("T")) {
				System.out.println("now quit");
				break;
			}else{
//
				flag = StdIn.setScanner(s);
			}
//
		}
//		System.out.println("s--:"+s);
		 if(!s.equals("T")){
			 this.setFile( StdIn.getFile(s));
		 }
		
	}
	

	public HashMap<String, String> FileToList(File f,String[] stop_word){
		
		String[] name = f.list();
//		System.out.println("String[] name : "+name );
		File[] files = f.listFiles();
		HashMap<String, String> map = new HashMap<String, String>();
//
		if(name.length==files.length){
			for(int x = 0;x<name.length;x++){
				map.put(name[x], this.StringReplace(this.FileToString(files[x]), stop_word));
			}
		}
		return map;
		
	}
	

	public String StringReplace(String A,String[] B){
		String b = "";
		String str = A.replaceAll("\\s+", " ");
		for(int x = 0;x<B.length;x++){
			b = B[x];
			str = str.replaceAll(b, "");
		}
		return str;
		
	}
	

	public String FileToString(File f){
		File file = f;
		String line;
		String str="";
		int count = (int) file.length();
		if( file.length()>0){
			InputStreamReader read;
			
			try {
				read = new InputStreamReader (new FileInputStream(file),"gb2312");
				BufferedReader reader=new BufferedReader(read);
				while ((line = reader.readLine()) != null) { 
					
					//System.out.println("line="+line); 
					str=str+line;
//					 System.out.println("str"+str);
				} 
				
				
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else{
			System.out.println("empty file");
		}
		
		return str;
		
	}
	
	
}
