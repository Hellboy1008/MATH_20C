
//龍ONE

import java.util.Arrays;

public class MATH20C_Calculations {

    public static final int THREE_DIMENSIONS = 3;
    public static final char COMMA = ',';

    public void ChapterOne(int topicNumber, String input) {
    }

    private static int[] interpretString(String input) {
        int[] answer;
        int numOfCommas = 0;
        // count the number of commas
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == COMMA) {
                numOfCommas++;
            }
        }
        // put the number in the strings into the array
        if (numOfCommas == 0) {
            return null;
        } else {
            answer = new int[numOfCommas + 1];
            int arrayIndex = 0;
            for (int index = 0; index < input.length(); index++) {
                if (input.charAt(index) != COMMA) {
                    answer[arrayIndex] = Character.getNumericValue(input.charAt(index));
                    arrayIndex++;
                }
            }
        }
        return answer;
    }

    private static int[][] convertToMatrix(int[] input) {
        int matrixSize = (int) Math.sqrt(input.length);
        int[][] matrix = new int[matrixSize][matrixSize];
        int inputMatrixIndex = 0;
        // turn int[] into 2-D array represented by int[][]
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[inputMatrixIndex];
                inputMatrixIndex++;
            }
        }
        return matrix;
    }

}