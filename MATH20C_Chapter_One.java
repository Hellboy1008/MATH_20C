
/**
 * Created by: 龍ONE 
 * Date Created: December 19, 2018
 * Date Edited: December 2, 2019
 * Purpose: Perform Calculations for MATH20C Problems in Chapter 1 of the textbook.
 */

import java.util.Scanner;

/**
 * This class prompts the user for the question they want answered.
 */
public class MATH20C_Chapter_One {

        // topic numbers
        private static final int TOPIC_ONE = 1, TOPIC_TWO = 2, TOPIC_THREE = 3, TOPIC_FOUR = 4, TOPIC_FIVE = 5,
                        TOPIC_SIX = 6, TOPIC_SEVEN = 7, TOPIC_EIGHT = 8, TOPIC_NINE = 9, TOPIC_TEN = 10,
                        TOPIC_ELEVEN = 11, TOPIC_TWELVE = 12, TOPIC_THIRTEEN = 13, TOPIC_FOURTEEN = 14,
                        TOPIC_FIFTEEN = 15, TOPIC_SIXTEEN = 16;

        // prompt for users
        private static final String PROMPT = "What do you want to solve? Choose from "
                        + "the following options and type the corresponding number:";
        // questions that can be answered
        private static final String QUESTIONS = "1: Line from two vectors\n2: Intersection of two lines\n"
                        + "3: Magnitude of a vector\n4: Dot product of two vectors\n5: Unit vector\n6: Angle between two vectors\n"
                        + "7: Orthogonal projection of two vectors\n8: Determinant of 3x3 matrix\n9: Cross product of two vectors\n"
                        + "10: Area of parallelogram spanned by two vectors\n11: Volume of parallelepiped spanned by three vectors\n"
                        + "12: Determine if three vectors are coplanar\n13: Equation of a plane given three points\n"
                        + "14: Equation of a plane given normal vector and point\n15: Intersection of line and plane\n"
                        + "16: Intersection of two planes\nType 0 to end the program";
        // question prompts for the questions above
        private static final String QUESTION_PROMPT_LINE = "Given the form l(t) = (a,b,c) + t(x,y,z)\n"
                        + "Enter the line like this: a,b,c,x,y,z",
                        QUESTION_PROMPT_MATRIX = "Enter the 3d matrix in this order:\n"
                                        + "(a1,a2,a3,b1,b2,b3,c1,c2,c3)",
                        QUESTION_PROMPT_PLANE = "Given the form P = Ax + By + Cz + D = 0\n"
                                        + "Enter the plane like this: A,B,C,D",
                        QUESTION_PROMPT_POINT = "Enter the point in the form x_1,x_2,...x_n",
                        QUESTION_PROMPT_VECTOR = "Enter the vector in the form x_1,x_2,...x_n";
        // the result of the calculations
        private static final String RESULT = "The result is: ";

        // scanner used to get user input
        private static Scanner scan = new Scanner(System.in);

        // class that will perform the calculations
        private static MATH20C_Calculations calculations = new MATH20C_Calculations();

        /**
         * The main method asks the user for the question they would like to answer.
         * 
         * @param args The number of arguments passed by the user
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
                                break;
                        case TOPIC_THREE:
                                break;
                        case TOPIC_FOUR:
                                break;
                        case TOPIC_FIVE:
                                break;
                        case TOPIC_SIX:
                                break;
                        case TOPIC_SEVEN:
                                break;
                        case TOPIC_EIGHT:
                                break;
                        case TOPIC_NINE:
                                break;
                        case TOPIC_TEN:
                                break;
                        case TOPIC_ELEVEN:
                                break;
                        case TOPIC_TWELVE:
                                break;
                        case TOPIC_THIRTEEN:
                                break;
                        case TOPIC_FOURTEEN:
                                break;
                        case TOPIC_FIFTEEN:
                                break;
                        case TOPIC_SIXTEEN:
                                break;
                        default:
                                answerQuestion = false;
                        }

                        System.out.println();
                }

                scan.close();
        }

        /**
         * This method runs the calculations for the first topic.
         */
        public static void topicOne() {
                // resulting vector
                double[] result_arr;
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
                        result_arr = calculations.vectorAddition(calculations.convertStringToArr(inputOne),
                                        calculations.convertStringToArr(inputTwo));
                } catch (Exception e) {
                        System.out.println(e);
                        return;
                }
                System.out.println(RESULT + calculations.convertArrToString(result_arr));
        }
}