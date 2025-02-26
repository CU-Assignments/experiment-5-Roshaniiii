import java.util.*;

public class AutoBoxingSum {
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) numbers.add(Integer.parseInt(scanner.next()));
        System.out.println(calculateSum(numbers));
    }
}
