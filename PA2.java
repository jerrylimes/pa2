import java.util.*;
public class PA2 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int test_cases = stdin.nextInt();
        stdin.nextLine();
        ArrayList<ArrayList<Integer>> orders = new ArrayList<>();
        for (int i = 0; i < test_cases; i++) {
            String line = stdin.nextLine();
            Scanner lineScanner = new Scanner(line);
            ArrayList<Integer> order = new ArrayList<>();
            while (lineScanner.hasNextInt()) {
                order.add(lineScanner.nextInt());
            }
            orders.add(order);
        }
        /* testing input readability */
        for (ArrayList<Integer> order : orders){
            System.out.println(order.toString());
        }
    }
}
