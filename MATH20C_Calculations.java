
//龍ONE

import java.util.Arrays;

public class MATH20C_Calculations {

    public static final int THREE_DIMENSIONS = 3;
    public static final char COMMA = ',';

    public String ChapterOne(int topicNumber, String input) {

        return ""; // remove later
    }

    public static int[] interpretString(String input) {
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

}