
//龍ONE

import java.util.Arrays;

public class MATH20C_Calculations {

    private static final int THREE_DIMENSIONS = 3;
    private static final int TOPIC_NUMBER_ONE = 1, TOPIC_NUMBER_TWO = 2, TOPIC_NUMBER_THREE = 3, TOPIC_NUMBER_FOUR = 4,
            TOPIC_NUMBER_FIVE = 5, TOPIC_NUMBER_SIX = 6, TOPIC_NUMBER_SEVEN = 7, TOPIC_NUMBER_EIGHT = 8,
            TOPIC_NUMBER_NINE = 9, TOPIC_NUMBER_TEN = 10, TOPIC_NUMBER_ELEVEN = 11, TOPIC_NUMBER_TWELVE = 12,
            TOPIC_NUMBER_THIRTEEN = 13, TOPIC_NUMBER_FOURTEEN = 14, TOPIC_NUMBER_FIFTEEN = 15,
            TOPIC_NUMBER_SIXTEEN = 16;
    private static final char COMMA = ',', PLUS = '+', MINUS = '-', SPACE = ' ';
    private static final String NEWLINE = "\n";
    // Chapter One Answers
    private static final String ANSWER_LINE = "Line: (%.3f,%.3f,%.3f) + t(%.3f,%.3f,%.3f)",
            ANSWER_INTERSECT_LINE_YES = "The two lines intersect at:\n" + "(%.3f,%.3f,%.3f)",
            ANSWER_INTERSECT_LINE_NO = "The two lines don't intersect", ANSWER_MAGNITUDE = "Magnitude = %.3f",
            ANSWER_DOT_PRODUCT = "Dot Product = %.3f", ANSWER_VECTOR = "Vector = (%.3f,%.3f,%.3f)",
            ANSWER_ANGLE = "Angle = %.3f",
            ANSWER_ORTHOGONAL = "The orthogonal projection of vector 1 on vector 2 is: (%.3f,%.3f,%.3f)",
            ANSWER_DETERMINANT = "Determinant = %.3f", ANSWER_CROSS_PRODUCT = "Cross Product = (%.3f,%.3f,%.3f)",
            ANSWER_PARALLELOGRAM = "Area of the parallelogram = %.3f",
            ANSWER_PARALLELPIPED = "Volume of parallelpiped = %.3f", ANSWER_COPLANAR = "Yes, the vectors are coplanar",
            ANSWER_NOT_COPLANAR = "No, the vectors are not coplanar",
            ANSWER_PLANE = "The equation of the plane is %.3fx %c %.3fy %c %.3fz = %.3f",
            ANSWER_INTERSECT_POINT_NO = "The line and the plane do not intersect",
            ANSWER_INTERSECT_POINT_YES = "The line and the plane intersect at (%.3f,%.3f,%.3f)",
            ANSWER_INTERSECT_PLANE = "The intersection of the two planes is: (%.3f,%.3f,0) + t(%.3f,%.3f,%.3f)";
    // Chapter Two Answers

    public void ChapterOne(int topicNumber, String inputOne) {
        double[] inputOneArray = interpretStringToArray(inputOne);
        // select topics
        switch (topicNumber) {
        case TOPIC_NUMBER_THREE:
            ChapterOneTopicThree(inputOneArray, true);
            break;
        case TOPIC_NUMBER_FIVE:
            ChapterOneTopicFive(inputOneArray);
            break;
        case TOPIC_NUMBER_EIGHT:
            ChapterOneTopicEight(convertToMatrix(inputOneArray));
            break;
        }
    }

    public void ChapterOne(int topicNumber, String inputOne, String inputTwo) {
        double[] inputOneArray = interpretStringToArray(inputOne);
        double[] inputTwoArray = interpretStringToArray(inputTwo);
        // select topics
        switch (topicNumber) {
        case TOPIC_NUMBER_ONE:
            ChapterOneTopicOne(inputOneArray, inputTwoArray);
            break;
        case TOPIC_NUMBER_TWO:
            ChapterOneTopicTwo(inputOneArray, inputTwoArray);
            break;
        case TOPIC_NUMBER_FOUR:
            ChapterOneTopicFour(inputOneArray, inputTwoArray, true);
            break;
        case TOPIC_NUMBER_SIX:
            ChapterOneTopicSix(inputOneArray, inputTwoArray);
            break;
        case TOPIC_NUMBER_SEVEN:
            ChapterOneTopicSeven(inputOneArray, inputTwoArray);
            break;
        case TOPIC_NUMBER_NINE:
            ChapterOneTopicNine(inputOneArray, inputTwoArray, true);
            break;
        case TOPIC_NUMBER_TEN:
            ChapterOneTopicTen(inputOneArray, inputTwoArray);
            break;
        case TOPIC_NUMBER_FOURTEEN:
            ChapterOneTopicFourteen(inputOneArray, inputTwoArray);
            break;
        case TOPIC_NUMBER_FIFTEEN:
            ChapterOneTopicFifthteen(inputOneArray, inputTwoArray);
            break;
        case TOPIC_NUMBER_SIXTEEN:
            ChapterOneTopicSixteen(inputOneArray, inputTwoArray);
            break;
        }
    }

    public void ChapterOne(int topicNumber, String inputOne, String inputTwo, String inputThree) {
        double[] inputOneArray = interpretStringToArray(inputOne);
        double[] inputTwoArray = interpretStringToArray(inputTwo);
        double[] inputThreeArray = interpretStringToArray(inputThree);
        switch (topicNumber) {
        case TOPIC_NUMBER_ELEVEN:
            ChapterOneTopicEleven(inputOneArray, inputTwoArray, inputThreeArray, true);
            break;
        case TOPIC_NUMBER_TWELVE:
            ChapterOneTopicTwelve(inputOneArray, inputTwoArray, inputThreeArray);
            break;
        case TOPIC_NUMBER_THIRTEEN:
            ChapterOneTopicThirteen(inputOneArray, inputTwoArray, inputThreeArray);
            break;
        }
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
            int arrayIndex = 0, commaIndex = 0;
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

    private static double[][] convertToMatrix(double[] input) {
        int matrixSize = (int) Math.sqrt(input.length);
        double[][] matrix = new double[matrixSize][matrixSize];
        int inputMatrixIndex = 0;
        // turn double[] into 2-D array represented by double[][]
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
            System.out.printf(ANSWER_INTERSECT_LINE_YES + NEWLINE, xCor, yCor, zCor);
        } else {
            System.out.println(ANSWER_INTERSECT_LINE_NO);
        }
    }

    // magnitude of a vector
    public static double ChapterOneTopicThree(double[] vector_one, boolean print) {
        double answer_number = Math
                .sqrt(Math.pow(vector_one[0], THREE_DIMENSIONS - 1) + Math.pow(vector_one[1], THREE_DIMENSIONS - 1)
                        + Math.pow(vector_one[THREE_DIMENSIONS - 1], THREE_DIMENSIONS - 1));
        if (print == true) {
            System.out.printf(ANSWER_MAGNITUDE + NEWLINE, answer_number);
        }
        return answer_number;
    }

    // dot product of two vectors
    public static double ChapterOneTopicFour(double[] vector_one, double[] vector_two, boolean print) {
        double answer_number = vector_one[0] * vector_two[0] + vector_one[1] * vector_two[1]
                + vector_one[THREE_DIMENSIONS - 1] * vector_two[THREE_DIMENSIONS - 1];
        if (print == true) {
            System.out.printf(ANSWER_DOT_PRODUCT + NEWLINE, answer_number);
        }
        return answer_number;
    }

    // unit vector
    public static void ChapterOneTopicFive(double[] vector_one) {
        double[] answer_vector = new double[THREE_DIMENSIONS];
        double magnitude = ChapterOneTopicThree(vector_one, false);
        answer_vector[0] = (double) (vector_one[0]) / magnitude;
        answer_vector[1] = (double) (vector_one[1]) / magnitude;
        answer_vector[THREE_DIMENSIONS - 1] = (double) (vector_one[THREE_DIMENSIONS - 1]) / magnitude;
        System.out.printf(ANSWER_VECTOR + NEWLINE, answer_vector[0], answer_vector[1],
                answer_vector[THREE_DIMENSIONS - 1]);
    }

    // angle between two vectors
    public static void ChapterOneTopicSix(double[] vector_one, double[] vector_two) {
        double dot_product = ChapterOneTopicFour(vector_one, vector_two, false);
        double magnitude_vector_one = ChapterOneTopicThree(vector_one, false);
        double magnitude_vector_two = ChapterOneTopicThree(vector_two, false);
        double answer_angle = Math.acos(dot_product / (magnitude_vector_one * magnitude_vector_two));
        System.out.printf(ANSWER_ANGLE + NEWLINE, answer_angle);
    }

    // orthogonal projection of two vectors
    public static void ChapterOneTopicSeven(double[] vector_one, double[] vector_two) {
        double[] answer_vector = new double[THREE_DIMENSIONS];
        double magnitude_vector_two = ChapterOneTopicThree(vector_two, false);
        double dot_product = ChapterOneTopicFour(vector_one, vector_two, false);
        answer_vector[0] = (dot_product / Math.pow(magnitude_vector_two, THREE_DIMENSIONS - 1)) * vector_two[0];
        answer_vector[1] = (dot_product / Math.pow(magnitude_vector_two, THREE_DIMENSIONS - 1)) * vector_two[1];
        answer_vector[THREE_DIMENSIONS - 1] = (dot_product / Math.pow(magnitude_vector_two, THREE_DIMENSIONS - 1))
                * vector_two[THREE_DIMENSIONS - 1];
        System.out.printf(ANSWER_ORTHOGONAL + NEWLINE, answer_vector[0], answer_vector[1],
                answer_vector[THREE_DIMENSIONS - 1]);
    }

    // determinant of 3x3 matrix
    public static void ChapterOneTopicEight(double[][] matrix_one) {
        double i_component = matrix_one[0][0]
                * (matrix_one[1][1] * matrix_one[THREE_DIMENSIONS - 1][THREE_DIMENSIONS - 1]
                        - matrix_one[1][THREE_DIMENSIONS - 1] * matrix_one[THREE_DIMENSIONS - 1][1]);
        double j_component = matrix_one[0][1]
                * (matrix_one[1][0] * matrix_one[THREE_DIMENSIONS - 1][THREE_DIMENSIONS - 1]
                        - matrix_one[1][THREE_DIMENSIONS - 1] * matrix_one[THREE_DIMENSIONS - 1][0]);
        double k_component = matrix_one[0][THREE_DIMENSIONS - 1]
                * (matrix_one[1][0] * matrix_one[THREE_DIMENSIONS - 1][1]
                        - matrix_one[1][1] * matrix_one[THREE_DIMENSIONS - 1][0]);
        double answer_number = i_component - j_component + k_component;
        System.out.printf(ANSWER_DETERMINANT + NEWLINE, answer_number);
    }

    // cross product of two vectors
    public static double[] ChapterOneTopicNine(double[] vector_one, double[] vector_two, boolean print) {
        double[] answer_vector = new double[THREE_DIMENSIONS];
        answer_vector[0] = vector_one[1] * vector_two[THREE_DIMENSIONS - 1]
                - vector_one[THREE_DIMENSIONS - 1] * vector_two[1];
        answer_vector[1] = -1
                * (vector_one[0] * vector_two[THREE_DIMENSIONS - 1] - vector_one[THREE_DIMENSIONS - 1] * vector_two[0]);
        answer_vector[THREE_DIMENSIONS - 1] = vector_one[0] * vector_two[1] - vector_one[1] * vector_two[0];
        if (print == true) {
            System.out.printf(ANSWER_CROSS_PRODUCT + NEWLINE, answer_vector[0], answer_vector[1],
                    answer_vector[THREE_DIMENSIONS - 1]);
        }
        return answer_vector;
    }

    // area of parallelogram spanned by two vectors
    public static void ChapterOneTopicTen(double[] vector_one, double[] vector_two) {
        double[] cross_product = ChapterOneTopicNine(vector_one, vector_two, false);
        double answer_number = ChapterOneTopicThree(cross_product, false);
        System.out.printf(ANSWER_PARALLELOGRAM + NEWLINE, answer_number);
    }

    // volume of parallelepiped spanned by three vectors
    public static double ChapterOneTopicEleven(double[] vector_one, double[] vector_two, double[] vector_three,
            boolean print) {
        double determinant = ChapterOneTopicFour(ChapterOneTopicNine(vector_one, vector_two, false), vector_three,
                false);
        double answer_number = Math.abs(determinant);
        if (print == true) {
            System.out.printf(ANSWER_PARALLELPIPED + NEWLINE, answer_number);
        }
        return answer_number;
    }

    // determine if three vectors are coplanar
    public static void ChapterOneTopicTwelve(double[] vector_one, double[] vector_two, double[] vector_three) {
        if (ChapterOneTopicEleven(vector_one, vector_two, vector_three, false) == 0) {
            System.out.println(ANSWER_COPLANAR);
        } else {
            System.out.println(ANSWER_NOT_COPLANAR);
        }
    }

    // equation of a plane given three points
    public static void ChapterOneTopicThirteen(double[] point_one, double[] point_two, double[] point_three) {
        double[] vector_one = new double[THREE_DIMENSIONS], vector_two = new double[THREE_DIMENSIONS];
        vector_one[0] = point_two[0] - point_one[0];
        vector_one[1] = point_two[1] - point_one[1];
        vector_one[THREE_DIMENSIONS - 1] = point_two[THREE_DIMENSIONS - 1] - point_one[THREE_DIMENSIONS - 1];
        vector_two[0] = point_three[0] - point_two[0];
        vector_two[1] = point_three[1] - point_two[1];
        vector_two[THREE_DIMENSIONS - 1] = point_three[THREE_DIMENSIONS - 1] - point_two[THREE_DIMENSIONS - 1];
        double[] cross_product = ChapterOneTopicNine(vector_one, vector_two, false);
        // A(x-x0) + B(y-y0) + C(z-z0) = 0
        double d_value = cross_product[0] * point_one[0] + cross_product[1] * point_one[1]
                + cross_product[THREE_DIMENSIONS - 1] * point_one[THREE_DIMENSIONS - 1];
        char yComponent_sign = PLUS, zComponent_sign = PLUS;
        if (cross_product[1] < 0) {
            yComponent_sign = MINUS;
            cross_product[1] = -1 * cross_product[1];
        }
        if (cross_product[THREE_DIMENSIONS - 1] < 0) {
            zComponent_sign = MINUS;
            cross_product[THREE_DIMENSIONS - 1] = -1 * cross_product[THREE_DIMENSIONS - 1];
        }
        System.out.printf(ANSWER_PLANE + NEWLINE, cross_product[0], yComponent_sign, cross_product[1], zComponent_sign,
                cross_product[THREE_DIMENSIONS - 1], d_value);
    }

    // equation of a plane given normal vector and point
    public static void ChapterOneTopicFourteen(double[] vector_one, double[] point_one) {
        // A(x-x0) + B(y-y0) + C(z-z0) = 0
        double d_value = vector_one[0] * point_one[0] + vector_one[1] * point_one[1]
                + vector_one[THREE_DIMENSIONS - 1] * point_one[THREE_DIMENSIONS - 1];
        char yComponent_sign = PLUS, zComponent_sign = PLUS;
        if (vector_one[1] < 0) {
            yComponent_sign = MINUS;
            vector_one[1] = -1 * vector_one[1];
        }
        if (vector_one[THREE_DIMENSIONS - 1] < 0) {
            zComponent_sign = MINUS;
            vector_one[THREE_DIMENSIONS - 1] = -1 * vector_one[THREE_DIMENSIONS - 1];
        }
        System.out.printf(ANSWER_PLANE + NEWLINE, vector_one[0], yComponent_sign, vector_one[1], zComponent_sign,
                vector_one[THREE_DIMENSIONS - 1], d_value);
    }

    // intersection of line and plane
    public static void ChapterOneTopicFifthteen(double[] line_one, double[] plane_one) {
        double[] line_one_direction = { line_one[THREE_DIMENSIONS], line_one[THREE_DIMENSIONS + 1],
                line_one[line_one.length - 1] };
        double dot_product = ChapterOneTopicFour(line_one_direction, plane_one, false);
        if (dot_product == 0) {
            System.out.println(ANSWER_INTERSECT_POINT_NO);
        } else {
            double time = (-1 * plane_one[THREE_DIMENSIONS] - plane_one[0] * line_one[0] - plane_one[1] * line_one[1]
                    - plane_one[THREE_DIMENSIONS - 1] * line_one[THREE_DIMENSIONS - 1])
                    / (plane_one[0] * line_one[THREE_DIMENSIONS] + plane_one[1] * line_one[THREE_DIMENSIONS + 1]
                            + plane_one[THREE_DIMENSIONS - 1] * line_one[line_one.length - 1]);
            System.out.println(time);
            double xCor = line_one[THREE_DIMENSIONS] * time + line_one[0];
            double yCor = line_one[THREE_DIMENSIONS + 1] * time + line_one[1];
            double zCor = line_one[line_one.length - 1] * time + line_one[THREE_DIMENSIONS - 1];
            System.out.printf(ANSWER_INTERSECT_POINT_YES + NEWLINE, xCor, yCor, zCor);
        }
    }

    // intersection of two planes
    public static void ChapterOneTopicSixteen(double[] plane_one, double[] plane_two) {
        plane_one[THREE_DIMENSIONS] = -1 * plane_one[THREE_DIMENSIONS];
        plane_two[THREE_DIMENSIONS] = -1 * plane_two[THREE_DIMENSIONS];
        double x = (plane_two[THREE_DIMENSIONS] * plane_one[1] - plane_two[1] * plane_one[THREE_DIMENSIONS])
                / (plane_one[1] * plane_two[0] - plane_one[0] * plane_two[1]);
        double y = (plane_one[THREE_DIMENSIONS] - plane_one[0] * x) / plane_one[1];
        double[] cross_product = ChapterOneTopicNine(plane_one, plane_two, false);
        System.out.printf(ANSWER_INTERSECT_PLANE + NEWLINE, x, y, cross_product[0], cross_product[1],
                cross_product[THREE_DIMENSIONS - 1]);
    }

    // derivatives

}