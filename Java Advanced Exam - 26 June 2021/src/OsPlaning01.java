import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OsPlaning01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(threads::offer);

        int valueOfTheTask = Integer.parseInt(scan.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            if (tasks.peek() == valueOfTheTask) {
                break;
            }
            if (tasks.peek() <= threads.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
                continue;
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threads.peek(), valueOfTheTask);
        System.out.println(threads.toString().replaceAll("[\\[|\\]|\\,]", ""));
    }
}
