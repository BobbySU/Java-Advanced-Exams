import java.util.*;
import java.util.stream.Collectors;

public class Exam01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(stack::push);

        Map<String, Integer> coctail = new TreeMap<>();
        coctail.put("Pear Sour", 0);
        coctail.put("The Harvest", 0);
        coctail.put("Apple Hinny", 0);
        coctail.put("High Fashion", 0);
        int sum = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (queue.peek() == 0) {
                queue.poll();
            } else {
                int check = queue.peek() * stack.peek();
                if (check == 150) {
                    coctail.put("Pear Sour", coctail.get("Pear Sour").intValue() + 1);
                    queue.poll();
                    stack.pop();
                } else if (check == 250) {
                    coctail.put("The Harvest", coctail.get("The Harvest").intValue() + 1);
                    queue.poll();
                    stack.pop();
                } else if (check == 300) {
                    coctail.put("Apple Hinny", coctail.get("Apple Hinny").intValue() + 1);
                    queue.poll();
                    stack.pop();
                } else if (check == 400) {
                    coctail.put("High Fashion", coctail.get("High Fashion").intValue() + 1);
                    queue.poll();
                    stack.pop();
                } else {
                    int n = queue.peek() + 5;
                    queue.poll();
                    queue.offer(n);
                    stack.pop();
                }
            }
        }
        int macet = (int) coctail.entrySet().stream().filter(e -> e.getValue() > 0).count();

        String emptyBox = queue.isEmpty() && macet == 4
                ? "It's party time! The cocktails are ready!"
                : "What a pity! You didn't manage to prepare all cocktails.";
        System.out.println(emptyBox);

        if (!queue.isEmpty()) {
            int outSum = queue.stream().mapToInt(Integer::intValue).sum();
            if (outSum > 0) {
                System.out.printf("Ingredients left: %d%n", outSum);
            }
        }

        coctail.entrySet().forEach(e -> {
            if (e.getValue() > 0) {
                System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue());
            }
        });
    }
}
