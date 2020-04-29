
/**
 * Created by: 龍ONE 
 * Date Created: December 19, 2018
 * Date Edited: April 23, 2020
 * Purpose: Perform Calculations for MATH20C Problems in Chapter 1 of the textbook.
 */

import java.util.Scanner;

/**
 * This class prompts the user for the question they want answered.
 */
public class MATH20C_Chapter_One {

    // three dimensions
    private static final int THREE_DIMENSION = 3;
    // topic numbers
    private static final int TOPIC_ONE = 1, TOPIC_TWO = 2, TOPIC_THREE = 3, TOPIC_FOUR = 4, TOPIC_FIVE = 5,
            TOPIC_SIX = 6, TOPIC_SEVEN = 7, TOPIC_EIGHT = 8, TOPIC_NINE = 9, TOPIC_TEN = 10, TOPIC_ELEVEN = 11,
            TOPIC_TWELVE = 12, TOPIC_THIRTEEN = 13, TOPIC_FOURTEEN = 14, TOPIC_FIFTEEN = 15, TOPIC_SIXTEEN = 16,
            TOPIC_SEVENTEEN = 17, TOPIC_EIGHTEEN = 18, TOPIC_NINETEEN = 19;

    // error messages for users
    private static final String ERROR_INVALID_MATRIX_SIZE = "Incorrect Input -> The size of the matrix has to be an integer bigger than 1";
    private static final String ERROR_NOT_DOUBLE = "Incorrect Input -> The scalar value has to be a real number";
    // decimal format for 4 decimal places
    private static final String DECIMAL_FOUR = "%.4f";
    // prompt for users
    private static final String PROMPT = "What do you want to solve? Choose from "
            + "the following options and type the corresponding number:";
    // questions that can be answered
    private static final String QUESTIONS = "1: Addition of two vectors\n2: Subtraction of two vectors\n3: Scaling a vector\n4: Line from two vectors\n5: Intersection of two lines\n"
            + "6: Magnitude of a vector\n7: Dot product of two vectors\n8: Unit vector\n9: Angle between two vectors\n"
            + "10: Orthogonal projection of two vectors\n11: Determinant of a square matrix\n12: Cross product of two vectors\n"
            + "13: Area of parallelogram spanned by two vectors\n14: Volume of parallelepiped spanned by three vectors\n"
            + "15: Determine if three vectors are coplanar\n16: Equation of a plane given three points\n"
            + "17: Equation of a plane given normal vector and point\n18: Intersection of line and plane\n"
            + "19: Intersection of two planes\nType 0 to end the program";
    // question prompts for the questions above
    private static final String QUESTION_PROMPT_LINE = "Given the form l(t) = (a,b,c) + t(x,y,z)\n"
            + "Enter the line like this: a,b,c,x,y,z",
            QUESTION_PROMPT_MATRIX = "Enter each row of the matrix, separating each value with a comma in the form x_1,x_2,...,x_n",
            QUESTION_PROMPT_PLANE = "Given the form P = Ax + By + Cz + D = 0\n" + "Enter the plane like this: A,B,C,D",
            QUESTION_PROMPT_POINT = "Enter the point in the form x_1,x_2,...,x_n",
            QUESTION_PROMPT_SCALAR = "Enter the scalar value",
            QUESTION_PROMPT_SIZE_MATRIX = "Enter the size of the matrix",
            QUESTION_PROMPT_VECTOR = "Enter the vector in the form x_1,x_2,...,x_n";
    // results of the calculations
    private static final String RESULT = "The result is: ";
    private static final String RESULT_COPLANAR_FALSE = "The three vectors are not coplanar.";
    private static final String RESULT_COPLANAR_TRUE = "The three vectors are coplanar.";
    private static final String RESULT_LINE = "(%.4f,%.4f,%.4f) + t(%.4f,%.4f,%.4f)";
    private static final String RESULT_NO_INTERSECTION = "There is no intersection.";
    private static final String RESULT_PLANE = "%.4fx + %.4fy + %.4fz = %.4f";

    // scanner used to get user input
    private static Scanner scan = new Scanner(System.in);

    // class that will perform the calculations
    private static MATH20C_Calculations_Chapter_One calculations = new MATH20C_Calculations_Chapter_One();

    /**
     * The main method asks the user for the question they would like to answer.
     * 
     * @param args The number of arguments passed by the user
     * @return None
     */
    public static void main(String[] args) {
        // if the user wants a question answered
        boolean answerQuestion = true;
        // the topic they would like to ask a question for
        int topic;

        // while the user wants to answer a question
        while (answerQuestion == true) {
            System.out.println(PROMPT);
            System.out.println(QUESTIONS);
            topic = scan.nextInt();

            // run methods based on topics
            switch (topic) {
                case TOPIC_ONE:
                    topicOne();
                    break;
                case TOPIC_TWO:
                    topicTwo();
                    break;
                case TOPIC_THREE:
                    topicThree();
                    break;
                case TOPIC_FOUR:
                    topicFour();
                    break;
                case TOPIC_FIVE:
                    topicFive();
                    break;
                case TOPIC_SIX:
                    topicSix();
                    break;
                case TOPIC_SEVEN:
                    topicSeven();
                    break;
                case TOPIC_EIGHT:
                    topicEight();
                    break;
                case TOPIC_NINE:
                    topicNine();
                    break;
                case TOPIC_TEN:
                    topicTen();
                    break;
                case TOPIC_ELEVEN:
                    topicEleven();
                    break;
                case TOPIC_TWELVE:
                    topicTwelve();
                    break;
                case TOPIC_THIRTEEN:
                    topicThirteen();
                    break;
                case TOPIC_FOURTEEN:
                    topicFourteen();
                    break;
                case TOPIC_FIFTEEN:
                    topicFifteen();
                    break;
                case TOPIC_SIXTEEN:
                    topicSixteen();
                    break;
                case TOPIC_SEVENTEEN:
                    topicSeventeen();
                    break;
                case TOPIC_EIGHTEEN:
                    topicEighteen();
                    break;
                case TOPIC_NINETEEN:
                    topicNineteen();
                    break;
                default:
                    answerQuestion = false;
            }

            System.out.println();
        }

        scan.close();
    }

    /**
     * This method resets the scanner to point to a new input stream for the tester.
     * 
     * @param None
     * @return None
     */
    public static void resetScanner() {
        scan = new Scanner(System.in);
    }

    /**
     * This method runs the calculations for the first topic.
     */
    public static void topicOne() {
        // resulting vector
        double[] result_vector;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_vector = calculations.vectorAddition(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        System.out.println(RESULT + calculations.convertArrToString(result_vector));
    }

    /**
     * This method runs the calculations for the second topic.
     * 
     * @param None
     * @return None
     */
    public static void topicTwo() {
        // resulting vector
        double[] result_vector;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_vector = calculations.vectorSubtraction(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        System.out.println(RESULT + calculations.convertArrToString(result_vector));
    }

    /**
     * This method runs the calculations for the third topic.
     * 
     * @param None
     * @return None
     */
    public static void topicThree() {
        // resulting vector
        double[] result_vector;
        // first input vector
        String inputOne;
        // scalar value
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_SCALAR);
        inputTwo = scan.next();
        System.out.println();

        // catch exception for scalar value
        try {
            double x = Double.parseDouble(inputTwo);
            x += x;
        } catch (Exception e) {
            System.out.println(ERROR_NOT_DOUBLE);
            return;
        }

        // catch exceptions for vector
        try {
            result_vector = calculations.vectorScaling(calculations.convertStringToArr(inputOne),
                    Double.parseDouble(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        System.out.println(RESULT + calculations.convertArrToString(result_vector));
    }

    /**
     * This method runs the calculations for the fourth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicFour() {
        // resulting line
        double[] result_line;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_line = calculations.lineFromTwoVectors(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        System.out.println(RESULT + String.format(RESULT_LINE, result_line[0], result_line[1],
                result_line[THREE_DIMENSION - 1], result_line[THREE_DIMENSION], result_line[THREE_DIMENSION + 1],
                result_line[result_line.length - 1]));
    }

    /**
     * This method runs the calculations for the fifth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicFive() {
        // resulting point
        double[] result_point;
        // first input line
        String inputOne;
        // second input line
        String inputTwo;

        System.out.println(QUESTION_PROMPT_LINE);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_LINE);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_point = calculations.intersectionOfTwoLines(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        // no intersection case
        if (result_point == null) {
            System.out.println(RESULT_NO_INTERSECTION);
            return;
        }

        System.out.println(RESULT + calculations.convertArrToString(result_point));
    }

    /**
     * This method runs the calculations for the sixth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicSix() {
        // magnitude of vector
        double magnitude;
        // first input vector
        String inputOne;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println();

        // catch exceptions
        try {
            magnitude = calculations.magnitudeOfVector(calculations.convertStringToArr(inputOne));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + String.format(DECIMAL_FOUR, magnitude));
    }

    /**
     * This method runs the calculations for the seventh topic.
     * 
     * @param None
     * @return None
     */
    public static void topicSeven() {
        // dot product of vector
        double dot_product;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            dot_product = calculations.dotProductTwoVectors(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + String.format(DECIMAL_FOUR, dot_product));
    }

    /**
     * This method runs the calculations for the eighth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicEight() {
        // unit vector
        double[] result_vector;
        // first input vector
        String inputOne;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_vector = calculations.unitVector(calculations.convertStringToArr(inputOne));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + calculations.convertArrToString(result_vector));
    }

    /**
     * This method runs the calculations for the ninth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicNine() {
        // angle between the two vectors
        double angle;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            angle = calculations.angleBetweenTwoVectors(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + String.format(DECIMAL_FOUR, angle));
    }

    /**
     * This method runs the calculations for the tenth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicTen() {
        // resulting vector
        double[] result_vector;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_vector = calculations.orthogonalProjectionOfTwoVectors(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + calculations.convertArrToString(result_vector));
    }

    /**
     * This method runs the calculations for the eleventh topic.
     * 
     * @param None
     * @return None
     * @throws IllegalArgumentException if the matrix size is not an integer greater
     *                                  than or equal to 1
     */
    public static void topicEleven() {
        // resulting determinant
        double determinant;
        // input matrix size
        String inputOne;
        // input matrix row
        String inputTwo;
        // input matrix
        double[][] matrix;

        System.out.println(QUESTION_PROMPT_SIZE_MATRIX);
        inputOne = scan.next();

        // check if the matrix size is valid
        try {
            int x = Integer.parseInt(inputOne);
            if (x == 1) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println(ERROR_INVALID_MATRIX_SIZE);
            return;
        }

        System.out.println(QUESTION_PROMPT_MATRIX);

        // read individual rows
        matrix = new double[Integer.parseInt(inputOne)][];
        for (int i = 0; i < Integer.parseInt(inputOne); i++) {
            inputTwo = scan.next();
            try {
                matrix[i] = calculations.convertStringToArr(inputTwo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println();

        // catch exceptions
        try {
            determinant = calculations.determinantOfSquareMatrix(matrix);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + String.format(DECIMAL_FOUR, determinant));
    }

    /**
     * This method runs the calculations for the twelfth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicTwelve() {
        // resulting vector
        double[] result_vector;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_vector = calculations.crossProductOfTwoVectors(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + calculations.convertArrToString(result_vector));
    }

    /**
     * This method runs the calculations for the thirteenth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicThirteen() {
        // area of parallelogram
        double area;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            area = calculations.areaOfParallelogramTwoVectors(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + String.format(DECIMAL_FOUR, area));
    }

    /**
     * This method runs the calculations for the fourteenth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicFourteen() {
        // volume of parallelepiped
        double volume;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;
        // third input vector
        String inputThree;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputThree = scan.next();
        System.out.println();

        // catch exceptions
        try {
            volume = calculations.volumeOfParallelepipedThreeVectors(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo), calculations.convertStringToArr(inputThree));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + String.format(DECIMAL_FOUR, volume));
    }

    /**
     * This method runs the calculations for the fifteenth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicFifteen() {
        // true if the vectors are coplanar, false if not
        boolean coplanar;
        // first input vector
        String inputOne;
        // second input vector
        String inputTwo;
        // third input vector
        String inputThree;

        System.out.println(QUESTION_PROMPT_VECTOR);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputThree = scan.next();
        System.out.println();

        // catch exceptions
        try {
            coplanar = calculations.threeVectorsCoplanar(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo), calculations.convertStringToArr(inputThree));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        // print results
        if (coplanar == true) {
            System.out.println(RESULT_COPLANAR_TRUE);
        } else {
            System.out.println(RESULT_COPLANAR_FALSE);
        }
    }

    /**
     * This method runs the calculations for the sixteenth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicSixteen() {
        // resulting plane
        double[] result_plane;
        // first input point
        String inputOne;
        // second input point
        String inputTwo;
        // third input point
        String inputThree;

        System.out.println(QUESTION_PROMPT_POINT);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_POINT);
        inputTwo = scan.next();
        System.out.println(QUESTION_PROMPT_POINT);
        inputThree = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_plane = calculations.equationOfPlaneThreePoints(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo), calculations.convertStringToArr(inputThree));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + String.format(RESULT_PLANE, result_plane[0], result_plane[1],
                result_plane[THREE_DIMENSION - 1], result_plane[THREE_DIMENSION]));
    }

    /**
     * This method runs the calculations for the seventeenth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicSeventeen() {
        // resulting plane
        double[] result_plane;
        // first input point
        String inputOne;
        // first input vector
        String inputTwo;

        System.out.println(QUESTION_PROMPT_POINT);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_VECTOR);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_plane = calculations.equationOfPlanePointAndNormalVector(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println(RESULT + String.format(RESULT_PLANE, result_plane[0], result_plane[1],
                result_plane[THREE_DIMENSION - 1], result_plane[THREE_DIMENSION]));
    }

    /**
     * This method runs the calculations for the eighteenth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicEighteen() {
        // resulting point
        double[] result_point;
        // first input line
        String inputOne;
        // first input plane
        String inputTwo;

        System.out.println(QUESTION_PROMPT_LINE);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_PLANE);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_point = calculations.intersectionOfLineAndPlane(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        // no intersection case
        if (result_point == null) {
            System.out.println(RESULT_NO_INTERSECTION);
            return;
        }

        System.out.println(RESULT + calculations.convertArrToString(result_point));
    }

    /**
     * This method runs the calculations for the nineteenth topic.
     * 
     * @param None
     * @return None
     */
    public static void topicNineteen() {
        // resulting line
        double[] result_line;
        // first input plane
        String inputOne;
        // first input plane
        String inputTwo;

        System.out.println(QUESTION_PROMPT_PLANE);
        inputOne = scan.next();
        System.out.println(QUESTION_PROMPT_PLANE);
        inputTwo = scan.next();
        System.out.println();

        // catch exceptions
        try {
            result_line = calculations.intersectionOfTwoPlanes(calculations.convertStringToArr(inputOne),
                    calculations.convertStringToArr(inputTwo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        // no intersection case
        if (result_line == null) {
            System.out.println(RESULT_NO_INTERSECTION);
            return;
        }

        // convert negative zeroes to positive zeroes
        for (int index = 0; index < result_line.length; index++) {
            if (result_line[index] == 0) {
                result_line[index] += 0.0;
            }
        }

        System.out.println(RESULT + String.format(RESULT_LINE, result_line[0], result_line[1],
                result_line[THREE_DIMENSION - 1], result_line[THREE_DIMENSION], result_line[THREE_DIMENSION + 1],
                result_line[result_line.length - 1]));
    }
}