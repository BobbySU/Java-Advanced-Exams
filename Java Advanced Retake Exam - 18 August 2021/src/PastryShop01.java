import java.util.*;

public class PastryShop01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> pastry = new LinkedHashMap<>();
        pastry.put("Biscuit", 0);
        pastry.put("Cake", 0);
        pastry.put("Pie", 0);
        pastry.put("Pastry", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int check = liquids.peek() + ingredients.peek();
            if (check == 25) {
                pastry.put("Biscuit", pastry.get("Biscuit").intValue() + 1);
                ingredients.poll();
                liquids.pop();
            } else if (check == 50) {
                pastry.put("Cake", pastry.get("Cake").intValue() + 1);
                ingredients.poll();
                liquids.pop();
            } else if (check == 75) {
                pastry.put("Pastry", pastry.get("Pastry").intValue() + 1);
                ingredients.poll();
                liquids.pop();
            } else if (check == 100) {
                pastry.put("Pie", pastry.get("Pie").intValue() + 1);
                ingredients.poll();
                liquids.pop();
            } else {
                int n = ingredients.peek() + 3;
                ingredients.poll();
                ingredients.push(n);
                liquids.pop();
            }
        }
        int macet = (int) pastry.entrySet().stream().filter(e -> e.getValue() > 0).count();

        String emptyBox = macet == 4
                ? "Great! You succeeded in cooking all the food!"
                : "What a pity! You didn't have enough materials to cook everything.";
        System.out.println(emptyBox);
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("[\\[|\\]]", ""));
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("[\\[|\\]]", ""));
        }

        pastry.entrySet().forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
