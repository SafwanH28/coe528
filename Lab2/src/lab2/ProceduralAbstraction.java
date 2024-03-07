package lab2;

/**
 *
 * @author Haque
 */
public class ProceduralAbstraction {

//Requires: None
//Modifies: None
//Effects: Returns the smallest positive integer n for which n!
// (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
// integer x. Otherwise returns 1.
    public static int reverseFactorial(int integer) {

        if (integer < 0) {
            System.out.println("Invalid Integer");
            return 1;
        } else {

            int revfactorial = integer, i;

            for (i = 2; revfactorial != i; i++) {
                revfactorial = revfactorial / i;
                if (revfactorial == 0) {
                    System.out.println("The reverse factorial of " + integer + " is " + i);
                    return i;
                }
            }
            System.out.println("The reverse factorial of " + integer + " is " + i);
            return i;
        }
    }

//Requires: None
//Modifies: None
//Effects: If the matrix arr satisfies Nice property, prints the sum and
// returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        int row = arr.length;
        int colmn = arr[0].length;
        int sum = 0, check = 0, sumRows = 0, sumColmn = 0, sumDiag1 = 0, sumDiag2 = 0;

        if (row != colmn) {
            System.out.println("Matrix is not nice.");
            return false;
        }

        for (int i = 0; i < row; i++) {
            check += arr[i][0];
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colmn; j++) {
                sumRows += arr[i][j];
            }
            if (check != sumRows) {
                System.out.println("Matrix is not nice.");
                return false;
            }
            sumRows = 0;
        }

        for (int i = 0; i < colmn; i++) {
            for (int j = 0; j < row; j++) {
                sumColmn += arr[j][i];
            }
            if (check != sumColmn) {
                System.out.println("Matrix is not nice.");
                return false;
            }
            sumColmn = 0;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colmn; j++) {
                if (i == j) {
                    sumDiag1 += arr[i][j];
                }
                if ((i + j) == (arr.length - 1)) {
                    sumDiag2 += arr[i][j];
                }
            }
        }

        if (sumDiag1 != check && sumDiag2 != check) {
            System.out.println("Matrix is not nice.");
            return false;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colmn; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Matrix is nice.");
        System.out.println("Sum of the matrix is: " + sum);
        return true;
    }

    public static void main(String[] args) {
        reverseFactorial(156);

        int arr[][] = {
            {5, 2, 3},
            {6, 9, 4},
            {7, 1, 0},};
        isMatrixNice(arr);

        int arr2[][] = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8},};
        isMatrixNice(arr2);
    }
}
