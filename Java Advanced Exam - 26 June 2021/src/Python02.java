import java.util.Scanner;

public class Python02 {
    static int food = 0;
    static int pCol = 0;
    static int pRol = 0;
    static int pLength = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[] command = scan.nextLine().split(", ");
        char[][] matrix = new char[n][n];
        readMatrix(scan, matrix);

        for (String comand : command) {
            if (comand.equals("up")) {
                move(matrix, pRol - 1, pCol);
            } else if (comand.equals("down")) {
                move(matrix, pRol + 1, pCol);
            } else if (comand.equals("left")) {
                move(matrix, pRol, pCol - 1);
            } else if (comand.equals("right")) {
                move(matrix, pRol, pCol + 1);
            }

            if (pLength == -1 || food == 0) {
                break;
            }
        }


        if (food == 0) {
            System.out.println("You win! Final python length is " + pLength);
        } else if (food > 0 && pLength != -1) {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        } else {
            System.out.println("You lose! Killed by an enemy!");
        }


//        printMatrix(matrix);
//        System.out.println();
    }

    private static void move(char[][] matrix, int Row, int Col) {

        if (outOfRange(matrix, Row, Col)) {
            int[] index = flip(matrix.length, Row, Col);
            Row = index[0];
            Col = index[1];
        }
        if (matrix[Row][Col] == 'e') {
            pLength = -1;
        } else if (matrix[Row][Col] == 'f') {
            pLength++;
            food--;
        }
        pCol = Col;
        pRol = Row;
    }

    private static int[] flip(int length, int row, int col) {
        int[] out = new int[2];
        if (row < 0) {
            out[0] = length - 1;
            out[1] = col;
        } else if (row >= length) {
            out[1] = col;
        } else if (col < 0) {
            out[0] = row;
            out[1] = length - 1;
        } else if (col >= length) {
            out[0] = row;
        }
        return out;
    }

    private static boolean outOfRange(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void readMatrix(Scanner scan, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
//            matrix[i] = scan.nextLine().replaceAll(" ", "").toCharArray();

            String line = scan.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
            if (line.contains("s")) {
                pCol = line.indexOf("s");
                pRol = i;
            }

            for (char c : matrix[i]) {
                if (c == 'f') {
                    food++;
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
