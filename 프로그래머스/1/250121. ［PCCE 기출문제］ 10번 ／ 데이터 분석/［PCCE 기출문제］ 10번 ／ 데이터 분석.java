import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int ext_num = 0;
        int sort_num = 0;
        
        if(ext.equals("code")) {
            ext_num = 0;        
        } else if(ext.equals("date")) {
            ext_num = 1;
        } else if(ext.equals("maximum")) {
            ext_num = 2;
        } else if(ext.equals("remain")) {
            ext_num = 3;
        }
        
        if(sort_by.equals("code")) {
            sort_num = 0;
        } else if(sort_by.equals("date")) {
            sort_num = 1;
        } else if(sort_by.equals("maximum")) {
            sort_num =2;
        } else if(sort_by.equals("remain")) {
            sort_num =3;
        }
            
        int count = 0;
        for(int[] row : data) {
            if(row[ext_num] < val_ext) {
                count++;
            }
        }
        
        int[][] answer = new int[count][];
        
        int index = 0;
        for(int[] row : data) {
            if(row[ext_num] < val_ext) {
                answer[index++] = row;
            }
        }
        
        sortArray(answer, sort_num);
        return answer;
    }
    
    public static void sortArray(int[][] array, int column) {
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] row1, int[] row2) {
                return Integer.compare(row1[column], row2[column]);
            }
        });
    }
}