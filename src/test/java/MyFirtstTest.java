import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyFirtstTest {
    public static void main(String[] arg) {

        Person tom = new Person("Tom");
        System.out.println(tom.toString()); // Будет выводить что-то наподобие Person@7960847b
        System.out.println(tom.hashCode());
      // stream();
    }
    public static void hello(){
        System.out.println("Helloy World");
    }

    private static boolean isPolindrom(String str){
        if (str==null)
            return  false;
        int lenght= str.length();
        System.out.println(lenght/2);
        for(int i=0;i< lenght/2;i++) {
        if (str.charAt(i)!=str.charAt(lenght-i-1))
            return false;
        }
        return true;
    }
    public static  void stream(){
        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120).filter(x -> x < 90).map(x -> x + 10)
                .limit(3).forEach(System.out::print);
    }
    12312

}
