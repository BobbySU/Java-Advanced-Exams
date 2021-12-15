import java.util.Scanner;

public class Exam02 {
    static int parisRol = 0;
    static int parisCol = 0;
    static int helenRol = 0;
    static int helenCol = 0;
    static int energyParis = 0;
    static boolean winParis = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        energyParis = Integer.parseInt(scan.nextLine());

        int n = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[n][];
        readMatrix(n, scan, matrix);

        String command = scan.nextLine();
        while (!command.equals("1")) {
            String[] index = command.split(" ");

            String moving = index[0];
            int rowS = Integer.parseInt(index[1]);
            int colS = Integer.parseInt(index[2]);

            matrix[rowS][colS] = "S";
            parisMoving(matrix, moving);


            command = scan.nextLine();
        }

        if (winParis){
            System.out.println("Paris has successfully abducted Helen!");
            System.out.printf("Energy left: %d",energyParis);
        }

        printMatrix(matrix);
    }

    private static void parisMoving(String[][] matrix, String moving) {
        matrix[parisRol][parisCol] = "-";
        if (moving.equals("up")) {
            move(matrix, parisRol - 1, parisCol);
        } else if (moving.equals("down")) {
            move(matrix, parisRol + 1, parisCol);
        } else if (moving.equals("left")) {
            move(matrix, parisRol, parisCol - 1);
        } else if (moving.equals("right")) {
            move(matrix, parisRol, parisCol + 1);
        }
    }

    private static void move(String[][] matrix, int Row, int Col) {

        if (outOfRange(matrix, Row, Col)) {
            return;
        }
        if (matrix[Row][Col] == "S") {
            energyParis += -2;
        } else if (matrix[Row][Col] == "-") {
            energyParis += -1;
        } else if (matrix[Row][Col] == "H") {
            winParis = true;
            matrix[Row][Col] = "-";
            return;
        }
        parisCol = Col;
        parisRol = Row;
        matrix[Row][Col] = "P";
    }

    private static boolean outOfRange(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void readMatrix(Integer n, Scanner scan, String[][] matrix) {
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("");
            matrix[i] = new String[input.length];
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = input[j];
                if (input[j].equals("P")) {
                    parisRol = i;
                    parisCol = j;
                } else if (input[j].equals("H")) {
                    helenRol = i;
                    helenCol = j;
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}


