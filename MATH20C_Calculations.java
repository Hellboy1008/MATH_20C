
//龍ONE

import java.util.Arrays;

public class MATH20C_Calculations {

    private static final int THREE_DIMENSIONS = 3;
    private static final int TOPIC_NUMBER_ONE = 1, TOPIC_NUMBER_TWO = 2, TOPIC_NUMBER_THREE = 3, TOPIC_NUMBER_FOUR = 4,
            TOPIC_NUMBER_FIVE = 5, TOPIC_NUMBER_SIX = 6, TOPIC_NUMBER_SEVEN = 7, TOPIC_NUMBER_EIGHT = 8,
            TOPIC_NUMBER_NINE = 9, TOPIC_NUMBER_TEN = 10, TOPIC_NUMBER_ELEVEN = 11, TOPIC_NUMBER_TWELVE = 12,
            TOPIC_NUMBER_THIRTEEN = 13, TOPIC_NUMBER_FOURTEEN = 14, TOPIC_NUMBER_FIFTEEN = 15,
            TOPIC_NUMBER_SIXTEEN = 16;
    private static final char COMMA = ',';
    private static final String NEWLINE = "\n";
    // Chapter One Answers
    private static final String ANSWER_LINE = "Line: (%s" + COMMA + "%s" + COMMA + "%s" + ") + t(%s" + COMMA + "%s"
            + COMMA + "%s" + ")", ANSWER_INTERSECT_YES = "The two lines intersect at:\n" + "(%s,%s,%s)",
            ANSWER_INTERSECT_NO = "The two lines don't intersect", ANSWER_MAGNITUDE = "Magnitude = %s";
    // Chapter Two Answers

    public void ChapterOne(int topicNumber, String inputOne) {
        double[] inputOneArray = interpretStringToArray(inputOne);
    }

    public void ChapterOne(int topicNumber, String inputOne, String inputTwo) {
        double[] inputOneArray = interpretStringToArray(inputOne);
        double[] inputTwoArray = interpretStringToArray(inputTwo);
        switch (topicNumber) {
        case TOPIC_NUMBER_ONE:
            ChapterOneTopicOne(inputOneArray, inputTwoArray);
            break;
        case TOPIC_NUMBER_TWO:
            ChapterOneTopicTwo(inputOneArray, inputTwoArray);
            break;
        }
    }

    public void ChapterOne(int topicNumber, String inputOne, String inputTwo, String inputThree) {
        double[] inputOneArray = interpretStringToArray(inputOne);
        double[] inputTwoArray = interpretStringToArray(inputTwo);
        double[] inputThreeArray = interpretStringToArray(inputThree);
    }

    private static double[] interpretStringToArray(String input) {
        double[] answer;
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
            answer = new double[numOfCommas + 1];
            int arrayIndex = 0;
            int commaIndex = 0;
            for (int index = 0; index < input.length(); index++) {
                if (input.charAt(index) == COMMA) {
                    answer[arrayIndex] = Double.parseDouble(input.substring(commaIndex, index));
                    arrayIndex++;
                    commaIndex = index + 1;
                }
            }
            answer[arrayIndex] = Double.parseDouble(input.substring(commaIndex));
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

    // line from two vectors
    public static void ChapterOneTopicOne(double[] vector_one, double[] vector_two) {
        double[] answer_line = new double[vector_one.length + vector_two.length];
        // use vector_one as first point
        for (int index = 0; index < THREE_DIMENSIONS; index++) {
            answer_line[index] = vector_one[index];
        }
        // use difference as slope
        for (int index = THREE_DIMENSIONS; index < answer_line.length; index++) {
            answer_line[index] = vector_two[index - THREE_DIMENSIONS] - vector_one[index - THREE_DIMENSIONS];
        }
        // print answer
        System.out.printf(ANSWER_LINE + NEWLINE, answer_line[0], answer_line[1], answer_line[THREE_DIMENSIONS - 1],
                answer_line[THREE_DIMENSIONS], answer_line[THREE_DIMENSIONS + 1], answer_line[answer_line.length - 1]);
    }

    // intersection of two lines
    public static void ChapterOneTopicTwo(double[] line_one, double[] line_two) {
        double a = (double) (line_one[THREE_DIMENSIONS]);
        double b = (double) (-1 * line_two[THREE_DIMENSIONS]);
        double c = (double) (line_two[0] - line_one[0]);
        double d = (double) (line_one[THREE_DIMENSIONS + 1]);
        double e = (double) (-1 * line_two[THREE_DIMENSIONS + 1]);
        double f = (double) (line_two[1] - line_one[1]);
        double x = (f * b - e * c) / (b * d - a * e);
        double y = (c - a * x) / b;
        if (line_one[THREE_DIMENSIONS - 1] + line_one[line_one.length - 1] * x == line_two[THREE_DIMENSIONS - 1]
                + line_two[line_two.length - 1] * y) {
            double xCor = line_one[0] + line_one[THREE_DIMENSIONS] * x;
            double yCor = line_one[1] + line_one[THREE_DIMENSIONS + 1] * x;
            double zCor = line_one[THREE_DIMENSIONS - 1] + line_one[line_one.length - 1] * x;
            System.out.printf(ANSWER_INTERSECT_YES + NEWLINE, xCor, yCor, zCor);
        } else {
            System.out.println(ANSWER_INTERSECT_NO);
        }
    }

    // magnitude of a vector
    public static void ChapterOneTopicThree(int[] vector_one) {
        double answer_number = Math
                .sqrt(Math.pow(vector_one[0], THREE_DIMENSIONS - 1) + Math.pow(vector_one[1], THREE_DIMENSIONS - 1)
                        + Math.pow(vector_one[THREE_DIMENSIONS - 1], THREE_DIMENSIONS - 1));
        System.out.printf(ANSWER_MAGNITUDE + NEWLINE, answer_number);
    }

    // dot product of two vectors
    public static void ChapterOneTopicFour(int[] vector_one, int[] vector_two) {
        int answer_number = 0;
        answer_number = vector_one[0] * vector_two[0] + vector_one[1] * vector_two[1] + vector_one[2] * vector_two[2];
        System.out.println(answer_number);
    }

    // unit vector
    public static void ChapterOneTopicFive(int[] vector_one) {
        double[] answer_vector = new double[3];
        double magnitude = Math
                .sqrt(Math.pow(vector_one[0], 2) + Math.pow(vector_one[1], 2) + Math.pow(vector_one[2], 2));
        answer_vector[0] = (double) (vector_one[0]) / magnitude;
        answer_vector[1] = (double) (vector_one[1]) / magnitude;
        answer_vector[2] = (double) (vector_one[2]) / magnitude;
        System.out.println("Vector: (" + answer_vector[0] + "," + answer_vector[1] + "," + answer_vector[2] + ")");
    }

    // angle between two vectors
    public static void ChapterOneTopicSix(int[] vector_one, int[] vector_two) {
        double answer_angle = 0;
        double dot_product = vector_one[0] * vector_two[0] + vector_one[1] * vector_two[1]
                + vector_one[2] * vector_two[2];
        double magnitude_vector_one = Math
                .sqrt(Math.pow(vector_one[0], 2) + Math.pow(vector_one[1], 2) + Math.pow(vector_one[2], 2));
        double magnitude_vector_two = Math
                .sqrt(Math.pow(vector_two[0], 2) + Math.pow(vector_two[1], 2) + Math.pow(vector_two[2], 2));
        answer_angle = Math.acos(dot_product / (magnitude_vector_one * magnitude_vector_two));
        System.out.println("Angle = " + answer_angle);
    }

    // orthogonal projection of two vectors
    public static void ChapterOneTopicSeven(int[] vector_one, int[] vector_two) {
        double[] answer_vector = new double[3];
        double magnitude_vector_two = Math
                .sqrt(Math.pow(vector_two[0], 2) + Math.pow(vector_two[1], 2) + Math.pow(vector_two[2], 2));
        double dot_product = vector_one[0] * vector_two[0] + vector_one[1] * vector_two[1]
                + vector_one[2] * vector_two[2];
        answer_vector[0] = (dot_product / Math.pow(magnitude_vector_two, 2)) * vector_two[0];
        answer_vector[1] = (dot_product / Math.pow(magnitude_vector_two, 2)) * vector_two[1];
        answer_vector[2] = (dot_product / Math.pow(magnitude_vector_two, 2)) * vector_two[2];
        System.out.println("The orthogonal projection of vector 1 on vector 2 is: (" + answer_vector[0] + ","
                + answer_vector[1] + "," + answer_vector[2] + ")");
    }

    // determinant of 3x3 matrix
    public static void ChapterOneTopicEight(int[][] matrix_one) {
        int answer_number = 0;
        int i_component = matrix_one[0][0]
                * (matrix_one[1][1] * matrix_one[2][2] - matrix_one[1][2] * matrix_one[2][1]);
        int j_component = matrix_one[0][1]
                * (matrix_one[1][0] * matrix_one[2][2] - matrix_one[1][2] * matrix_one[2][0]);
        int k_component = matrix_one[0][2]
                * (matrix_one[1][0] * matrix_one[2][1] - matrix_one[1][1] * matrix_one[2][0]);
        answer_number = i_component - j_component + k_component;
        System.out.println("The determinant is: " + answer_number);
    }

    // cross product of two vectors
    public static void ChapterOneTopicNine(int[] vector_one, int[] vector_two) {
        int[] answer_vector = new int[3];
        answer_vector[0] = vector_one[1] * vector_two[2] - vector_one[2] * vector_two[1];
        answer_vector[1] = -1 * (vector_one[0] * vector_two[2] - vector_one[2] * vector_two[0]);
        answer_vector[2] = vector_one[0] * vector_two[1] - vector_one[1] * vector_two[0];
        System.out.println(
                "The cross product is: (" + answer_vector[0] + "," + answer_vector[1] + "," + answer_vector[2] + ")");
    }

    // area of parallelogram spanned by two vectors
    public static void ChapterOneTopicTen(int[] vector_one, int[] vector_two) {
        double answer_number = 0;
        int cross_product_icomponent = vector_one[1] * vector_two[2] - vector_one[2] * vector_two[1];
        int cross_product_jcomponent = -1 * (vector_one[0] * vector_two[2] - vector_one[2] * vector_two[0]);
        int cross_product_kcomponent = vector_one[0] * vector_two[1] - vector_one[1] * vector_two[0];
        answer_number = Math.sqrt(Math.pow(cross_product_icomponent, 2) + Math.pow(cross_product_jcomponent, 2)
                + Math.pow(cross_product_kcomponent, 2));
        System.out.println("Area of parallelogram = " + answer_number);
    }

    // volume of parallelepiped spanned by three vectors
    public static void ChapterOneTopicEleven(int[] vector_one, int[] vector_two, int[] vector_three) {
        int answer_number = 0;
        int cross_product_icomponent = vector_one[0]
                * (vector_two[1] * vector_three[2] - vector_two[2] * vector_three[1]);
        int cross_product_jcomponent = -1 * vector_one[1]
                * (vector_two[0] * vector_three[2] - vector_two[2] * vector_three[0]);
        int cross_product_kcomponent = vector_one[2]
                * (vector_two[0] * vector_three[1] - vector_two[1] * vector_three[0]);
        answer_number = Math.abs(cross_product_icomponent + cross_product_jcomponent + cross_product_kcomponent);
        System.out.println("Volume of parallelepiped = " + answer_number);
    }

    // determine if three vectors are coplanar
    public static void ChapterOneTopicTwelve(int[] vector_one, int[] vector_two, int[] vector_three) {
        String answer = "";
        int cross_product_icomponent = vector_one[0]
                * (vector_two[1] * vector_three[2] - vector_two[2] * vector_three[1]);
        int cross_product_jcomponent = -1 * vector_one[1]
                * (vector_two[0] * vector_three[2] - vector_two[2] * vector_three[0]);
        int cross_product_kcomponent = vector_one[2]
                * (vector_two[0] * vector_three[1] - vector_two[1] * vector_three[0]);
        int cross_product = Math.abs(cross_product_icomponent + cross_product_jcomponent + cross_product_kcomponent);
        if (cross_product == 0) {
            answer = "Yes";
        } else {
            answer = "No";
        }
        System.out.println(answer);
    }

    // equation of a plane given three points
    public static void ChapterOneTopicThirteen(int[] point_one, int[] point_two, int[] point_three) {
        int[] vector_one = new int[3];
        int[] vector_two = new int[3];
        vector_one[0] = point_two[0] - point_one[0];
        vector_one[1] = point_two[1] - point_one[1];
        vector_one[2] = point_two[2] - point_one[2];
        vector_two[0] = point_three[0] - point_two[0];
        vector_two[1] = point_three[1] - point_two[1];
        vector_two[2] = point_three[2] - point_two[2];
        int cross_product_icomponent = vector_one[1] * vector_two[2] - vector_one[2] * vector_two[1];
        int cross_product_jcomponent = -1 * (vector_one[0] * vector_two[2] - vector_one[2] * vector_two[0]);
        int cross_product_kcomponent = vector_one[0] * vector_two[1] - vector_one[1] * vector_two[0];
        // A(x-x0) + B(y-y0) + C(z-z0) = 0
        int equation_d_value = cross_product_icomponent * point_one[0] + cross_product_jcomponent * point_one[1]
                + cross_product_kcomponent * point_one[2];
        String yComponent_sign;
        String zComponent_sign;
        if (cross_product_jcomponent > 0) {
            yComponent_sign = "+ ";
        } else {
            yComponent_sign = "- ";
            cross_product_jcomponent = Math.abs(cross_product_jcomponent);
        }
        if (cross_product_kcomponent > 0) {
            zComponent_sign = "+ ";
        } else {
            zComponent_sign = "- ";
            cross_product_kcomponent = Math.abs(cross_product_kcomponent);
        }
        System.out.println("The equation of the plane is: " + cross_product_icomponent + "x " + yComponent_sign
                + cross_product_jcomponent + "y " + zComponent_sign + cross_product_kcomponent + "z = "
                + equation_d_value);
    }

    // equation of a plane given normal vector and point
    public static void ChapterOneTopicFourteen(int[] vector_one, int[] point_one) {
        // A(x-x0) + B(y-y0) + C(z-z0) = 0
        int d_value = vector_one[0] * point_one[0] + vector_one[1] * point_one[1] + vector_one[2] * point_one[2];
        String yComponent_sign;
        String zComponent_sign;
        if (vector_one[1] > 0) {
            yComponent_sign = "+ ";
        } else {
            yComponent_sign = "- ";
            vector_one[1] = Math.abs(vector_one[1]);
        }
        if (vector_one[2] > 0) {
            zComponent_sign = "+ ";
        } else {
            zComponent_sign = "- ";
            vector_one[2] = Math.abs(vector_one[2]);
        }
        System.out.println("The equation of the plane is: " + vector_one[0] + "x " + yComponent_sign + vector_one[1]
                + "y " + zComponent_sign + vector_one[2] + "z = " + d_value);
    }

    // intersection of line and plane
    public static void ChapterOneTopicFifthteen(int[] line_one, int[] plane_one) {
        int dot_product = line_one[0] * plane_one[0] + line_one[1] * plane_one[1] + line_one[2] * plane_one[2];
        if (dot_product == 0) {
            System.out.println("The line and the plane do not intersect");
        } else {
            int time = (-1 * plane_one[3] - plane_one[0] * line_one[3] - plane_one[1] * line_one[4]
                    - plane_one[2] * line_one[5]) / (dot_product);
            int xCor = line_one[0] * time + line_one[3];
            int yCor = line_one[1] * time + line_one[4];
            int zCor = line_one[2] * time + line_one[5];
            System.out.println("The line and the plane intersect at (" + xCor + "," + yCor + "," + zCor + ")");
        }
    }

    // intersection of two planes
    public static void ChapterOneTopicSixteen(int[] plane_one, int[] plane_two) {
        double a = (double) (plane_one[0]);
        double b = (double) (plane_one[1]);
        double c = (double) (-1 * plane_one[3]);
        double d = (double) (plane_two[0]);
        double e = (double) (plane_two[1]);
        double f = (double) (-1 * plane_two[3]);
        double x = (f * b - e * c) / (b * d - a * e);
        double y = (c - a * x) / b;
        int cross_product_xComp = plane_one[1] * plane_two[2] - plane_one[2] * plane_two[1];
        int cross_product_yComp = -1 * (plane_one[0] * plane_two[2] - plane_one[2] * plane_two[0]);
        int cross_product_zComp = plane_one[0] * plane_two[1] - plane_one[1] * plane_two[0];
        System.out.println("The intersection of the two planes is: (" + x + "," + y + ",0) + t(" + cross_product_xComp
                + "," + cross_product_yComp + "," + cross_product_zComp + ")");
    }

}