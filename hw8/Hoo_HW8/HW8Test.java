import java.io.*;
import java.util.*;

public class HW8Test {
   private static List<List<String>> allrows = new ArrayList<List<String>>();
   
   public static void main(String[] args) throws IOException {
//      Scanner sc = new Scanner(new FileInputStream("text.csv"));
      Scanner sc = new Scanner(new FileInputStream(("/Users/drewhoo/Documents/Boston_College/Senior_Year/OOD/Homeworks/HW8/text.csv")));
      while (sc.hasNextLine()) {
         String line = sc.nextLine();
         processLine(line);
      }
      sc.close();
      for (List<String> row : allrows) {
         for (String value : row) 
            System.out.print(value + " ");
         System.out.println();
      }
   }
   
   private static void processLine(String line) {
      CSVstateMachine m = new CSVstateMachine();
      for (int i=0; i<line.length(); i++) {
         char c = line.charAt(i);
         m.processChar(c);
      }
      List<String> row = m.getRow();
      allrows.add(row);
   }
}
