

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


 class Result {

    /*
     * Complete the 'newPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public  String newPassword(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if(a != null && b !=null ){
            char[] first = a.toCharArray();
            char[] second = b.toCharArray();
            
            if(first.length > second.length){
                IntStream.range(0, second.length-1).forEach(i->{
                    sb.append(first[i]).append(second[i]);
                });
                sb.append(a.substring(second.length-1, a.length()));
            } else{
                IntStream.range(0, first.length-1).forEach(i->{
                    sb.append(first[i]).append(second[i]);
                });
                sb.append(b.substring(first.length-1, b.length()));
            }
        }
    return sb.toString();

}
 }
public  class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        String result = new Result().newPassword(a, b);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
