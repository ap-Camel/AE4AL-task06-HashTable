import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        long startTime = System.nanoTime();
        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);

        Hash_table table = new Hash_table(1000);
        
        while(scanner.hasNext()) {

            table.add(scanner.next());
        }

        //table.print();

        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

        

        // the result from LinkedList ==> 219736348400
        // the result from HashTable  ==> 866551100
        //System.out.println(219736348400.0 / 866551100.0);
        // the hash table is around 253 times faster

        scanner.close();
    }
}
