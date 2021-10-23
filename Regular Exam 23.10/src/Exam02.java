import java.util.Scanner;

public class Exam02 {
    static int chees = 0;
    static int mRow = 0;
    static int mCol = 0;
    static int mEat = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];
        readMatrix(scan, matrix);

        String command = scan.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    move(matrix, mRow - 1, mCol);
                    break;
                case "down":
                    move(matrix, mRow + 1, mCol);
                    break;
                case "left":
                    move(matrix, mRow, mCol - 1);
                    break;
                case "right":
                    move(matrix, mRow, mCol + 1);
                    break;
            }
            command = scan.nextLine();
        }


        System.out.println("Where is the mouse?");
        System.out.println("The mouse couldn't eat the cheeses, she needed 3 cheeses more.");
//        System.out.println("Great job, the mouse is fed 4 cheeses!");
        printMatrix(matrix);
    }

    private static void readMatrix(Scanner scan, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().replaceAll(" ", "").toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }

    private static void move(char[][] matrix, int Row, int Col) {

        if (outOfRange(matrix, Row, Col)) {
            return;
        }
        if (matrix[Row][Col] == 'c') {
            chees--;
            mEat++;
        } else if (matrix[Row][Col] == 'B') {

        }
        mCol = Col;
        mRow = Row;
    }

    private static boolean outOfRange(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
