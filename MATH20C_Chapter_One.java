
/**
 * Created by: 龍ONE 
 * Date Created: December 19, 2018
 * Date Edited: November 30, 2019
 * Purpose: Perform Calculations for MATH20C Problems in Chapter 1 of the textbook.
 */

import java.util.Scanner;

/**
 * This class prompts the user for the question they want answered.
 */
public class MATH20C_Chapter_One {

    private static final String PROMPT = "What do you want to solve? Choose from "
            + "the following options and type the corresponding number:";
    private static final String QUESTIONS = "1: Line from two vectors\n2: Intersection of two lines\n"
            + "3: Magnitude of a vector\n4: Dot product of two vectors\n5: Unit vector\n6: Angle between two vectors\n"
            + "7: Orthogonal projection of two vectors\n8: Determinant of 3x3 matrix\n9: Cross product of two vectors\n"
            + "10: Area of parallelogram spanned by two vectors\n11: Volume of parallelepiped spanned by three vectors\n"
            + "12: Determine if three vectors are coplanar\n13: Equation of a plane given three points\n"
            + "14: Equation of a plane given normal vector and point\n15: Intersection of line and plane\n"
            + "16: Intersection of two planes\nType 0 to end the program";
    private static final String QUESTION_PROMPT_VECTOR = "Enter the vectors in the form x,y,z",
            QUESTION_PROMPT_LINE = "Given the form l(t) = (a,b,c) + t(x,y,z)\n"
                    + "Enter the lines like this: a,b,c,x,y,z",
            QUESTION_PROMPT_MATRIX = "Enter the 3d matrix in this order:\n" + "(a1,a2,a3,b1,b2,b3,c1,c2,c3)",
            QUESTION_PROMPT_POINT = "Enter the points in the form x,y,z",
            QUESTION_PROMPT_PLANE = "Given the form P = Ax + By + Cz + D = 0\n" + "Enter the planes like this: A,B,C,D";
    private static final String VECTOR_ONE = "First Vector:", VECTOR_TWO = "Second Vector:",
            VECTOR_THREE = "Third Vector:";
    private static final String LINE_ONE = "First Line", LINE_TWO = "Second Line";
    private static final String POINT_ONE = "First Point", POINT_TWO = "Second Point", POINT_THREE = "Third Point";
    private static final String PLANE_ONE = "First Plane", PLANE_TWO = "Second Plane";

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
        // scanner used to get user input
        Scanner scan;
        // class that will perform the calculations
        MATH20C_Calculations calculations = new MATH20C_Calculations();

        // while the user wants to answer a question
        while (answerQuestion == true) {
            scan = new Scanner(System.in);
            System.out.println(PROMPT);
            System.out.println(QUESTIONS);
            topic = scan.nextInt();

            // run methods based on topics
        }
    }
}