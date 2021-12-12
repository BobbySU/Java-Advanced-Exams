import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(stack::push);

        int sum = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int check = queue.peek() + stack.peek();
            if (check % 2 == 0) {
                sum += check;
                queue.poll();
                stack.pop();
            } else {
                queue.offer(stack.pop());
            }
        }

        String emptyBox = queue.isEmpty() ? "First magic box is empty." : "Second magic box is empty.";
        String value = sum >= 90 ? "Wow, your prey was epic! Value: " : "Poor prey... Value: ";

        System.out.println(emptyBox);
        System.out.println(value + sum);
    }
}
