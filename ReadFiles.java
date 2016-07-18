

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class ReadFiles {

    public List<String> ReadInput(InputStream is) {
        List<String> AllFiles = new ArrayList<>();
        Scanner scanner = new Scanner(is);

        while (scanner.hasNext()) {
            String ReadLine = scanner.nextLine().replace("\n", " ").replace("\t", " ").replaceAll(" +", " ");
            String[] fileNames = ReadLine.split(" ");
            AllFiles.addAll(Arrays.asList(fileNames));
        }
        return AllFiles;
    }


    public HashMap<String, String> readFiles(List<String> files) throws IOException {
        HashMap<String, String> result = new HashMap<>();

        for(String file : files) {
            result.put(file, readFile(file));
        }

        return result;
    }


    public String readFile(String filePath) throws IOException{
        //FileReader fileReader = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        //try (FileReader fileReader = new FileReader("/Users/YolandaSuee/Desktop/DataMiningP2/coen281/" + filePath)) {
            try (FileReader fileReader = new FileReader("/home/mwang2/test/coen281/" + filePath)) {
            br = new BufferedReader(fileReader);
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
            }
        }

        return sb.toString();
    }
}

