

import java.util.Arrays;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YolandaSuee on 2/13/16.
 */
public class Clustering {

    public Clustering(){

    }

    protected String group(String[][] matrix, int row, int column) {
        Double MinValue = Double.MAX_VALUE;
        int i = 0, j  = 0;
        String pairs = null;
        pairs = matrix[1][0] + matrix[0][1];
        //System.out.println("pairs: " + pairs);
        if(matrix.length == 0) {
            return pairs;
        }
        for(i = 0; i < matrix.length; i++) {
            for(j = 0; j < matrix[i].length; j++) {
//                System.out.println("matrix[" + i + "][" + j + "])" + matrix[i][j]);
                if(matrix[i][j].startsWith("0")) {

                    if( Double.parseDouble(matrix[i][j]) < MinValue.doubleValue()) {
                        MinValue = Math.min(MinValue.doubleValue(), Double.parseDouble(matrix[i][j]));
                        pairs = matrix[i][0] + " and " + matrix[0][j];
                        row = j;
                        column = i;
                    }
                }
            }
        }
        //System.out.println("group pairs is : " + pairs + "; ");
        return pairs;
    }

    protected Map<String,String> clustering(String[][] matrix, double threshold) {
        String pair = null;
        Map<String,String> PairsMap = new HashMap<>();
        Double MinDistance = Double.MAX_VALUE;
        Double ComparedValue = Double.MAX_VALUE;
        int i, j ;

        if(matrix.length == 0) {
            System.out.println("matrix.length is 0");
            return PairsMap;
        }
        do{
            for(i = 0; i < matrix.length; i++) {
                for (j = 0; j < matrix[0].length; j++) {
                    System.out.println("PairsMap.containsKey(matrix[i][0] + \" & \"  + matrix[0][j])" + PairsMap.containsKey(matrix[i][0] + " & "  + matrix[0][j]));
                    if (matrix[i][j].startsWith("0.") && (Double.parseDouble(matrix[i][j]) <=MinDistance.doubleValue())
                            && !PairsMap.containsKey(matrix[i][0] + " & "  + matrix[0][j])) {
                        System.out.println("find a pair");
                        MinDistance = Double.parseDouble(matrix[i][j]);
                        pair = matrix[i][0] + " & " + matrix[0][j] + " is a group; ";
                        System.out.println("value: " + MinDistance.toString());
                        PairsMap.put(pair, MinDistance.toString());
                        System.out.println("print hashMap : " );
                        StdOut.print(PairsMap.get(pair));
                        System.out.println(" ");
                    }
                }
            }
            ComparedValue = MinDistance;
            System.out.println("ComparedValue: " + ComparedValue.toString());
        }
        while(ComparedValue > threshold);
        return PairsMap;
    }

}
