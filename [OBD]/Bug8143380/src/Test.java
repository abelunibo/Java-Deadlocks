import java.util.*;

public class Test {
  static {
    for (int n = 16; n <= 0x1000000 ; n<<=1) {
      Object[] array = new Object[n];
      List<?>  list  = Arrays.asList(array);

      System.out.println("start sequential n = "+n);
      list.stream().allMatch((v) -> (v == null));
      System.out.println("done sequential n = "+n);
      System.out.println("");
      
      System.out.println("start parallel n = "+n);
      list.parallelStream().allMatch((v) -> (v == null));
      System.out.println("done parallel n = "+n);
      System.out.println("");
    }
  }

  public static void main (String... args) throws Exception {
    // done
  }
}
