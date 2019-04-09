
//龍ONE

import java.util.Scanner;

public class MATH20C_Chapter_One {

    private static final String PROMPT = "What do you want to solve? Choose from "
            + "the following options and type the corresponding number:";
    private static final String QUESTION_ONE = "1: Line from two vectors",
            QUESTION_TWO = "2: Intersection of two lines", QUESTION_THREE = "3: Magnitude of a vector",
            QUESTION_FOUR = "4: Dot product of two vectors", QUESTION_FIVE = "5: Unit vector",
            QUESTION_SIX = "6: Angle between two vectors", QUESTION_SEVEN = "7: Orthogonal projection of two vectors",
            QUESTION_EIGHT = "8: Determinant of 3x3 matrix", QUESTION_NINE = "9: Cross product of two vectors",
            QUESTION_TEN = "10: Area of parallelogram spanned by two vectors",
            QUESTION_ELEVEN = "11: Volume of parallelepiped spanned by three vectors",
            QUESTION_TWELVE = "12: Determine if three vectors are coplanar",
            QUESTION_THIRTEEN = "13: Equation of a plane given three points",
            QUESTION_FOURTEEN = "14: Equation of a plane given normal vector and point",
            QUESTION_FIFTEEEN = "15: Intersection of line and plane",
            QUESTION_SIXTEEN = "16: Intersection of two planes";
    private static final String QUESTION_SEPARATOR = ", ";
    private static final String END_PROMPT = "Type 0 to end the program";
    private static final String QUESTION_PROMPT_VECTOR = "Enter the vectors in the form x,y,z",
            QUESTION_PROMPT_LINE = "Given the form l(t) = (a,b,c) + t(x,y,z)\n"
                    + "Enter the lines like this: a,b,c,x,y,z",
            QUESTION_PROMPT_MATRIX = "Enter the 3d matrix in this order:\n" + "(a1,a2,a3,b1,b2,b3,c1,c2,c3)",
            QUESTION_PROMPT_POINT = "Enter the points in the form x,y,z",
            QUESTION_PROMPT_PLANE = "Given the form P = Ax + By + Cz + D = 0\n"
                    + "Enter the planes like this: A,B,C,D";
    private static final String VECTOR_ONE = "First Vector:", VECTOR_TWO = "Second Vector:",
            VECTOR_THREE = "Third Vector:";
    private static final String LINE_ONE = "First Line", LINE_TWO = "Second Line";
    private static final String POINT_ONE = "First Point", POINT_TWO = "Second Point", POINT_THREE = "Third Point";
    private static final String PLANE_ONE = "First Plane", PLANE_TWO = "Second Plane";
    private static final String[] CASES = { "", VECTOR_TWO, LINE_TWO, QUESTION_PROMPT_VECTOR, VECTOR_TWO,
            QUESTION_PROMPT_VECTOR, VECTOR_TWO, VECTOR_TWO, QUESTION_PROMPT_MATRIX, VECTOR_TWO, VECTOR_TWO,
            VECTOR_THREE, VECTOR_THREE, POINT_THREE, POINT_ONE, PLANE_ONE, PLANE_TWO };

    public static void main(String[] args) {
        boolean answerQuestion = true;
        int topic;
        String inputOne;
        String inputTwo;
        String inputThree;
        MATH20C_Calculations calculations = new MATH20C_Calculations();
        while (answerQuestion == true) {
            inputOne = "";
            inputTwo = "";
            inputThree = "";
            Scanner scan = new Scanner(System.in);
            System.out.println(PROMPT);
            System.out.println(QUESTION_ONE + QUESTION_SEPARATOR + QUESTION_TWO + QUESTION_SEPARATOR + QUESTION_THREE
                    + QUESTION_SEPARATOR + QUESTION_FOUR);
            System.out.println(QUESTION_FIVE + QUESTION_SEPARATOR + QUESTION_SIX + QUESTION_SEPARATOR + QUESTION_SEVEN
                    + QUESTION_SEPARATOR + QUESTION_EIGHT);
            System.out
                    .println(QUESTION_NINE + QUESTION_SEPARATOR + QUESTION_TEN + QUESTION_SEPARATOR + QUESTION_ELEVEN);
            System.out.println(
                    QUESTION_TWELVE + QUESTION_SEPARATOR + QUESTION_THIRTEEN + QUESTION_SEPARATOR + QUESTION_FOURTEEN);
            System.out.println(QUESTION_FIFTEEEN + QUESTION_SEPARATOR + QUESTION_SIXTEEN);
            System.out.println(END_PROMPT);
            topic = scan.nextInt();
            // solve question given the topic (cases are based on last thing printed)
            switch (CASES[topic]) {
            case "":
                answerQuestion = false;
                scan.close();
                break;
            case VECTOR_TWO:
                // prompt user
                System.out.println(QUESTION_PROMPT_VECTOR);
                System.out.println(VECTOR_ONE);
                inputOne = scan.next();
                System.out.println(VECTOR_TWO);
                inputTwo = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne, inputTwo);
                break;
            case LINE_TWO:
                // prompt user
                System.out.println(QUESTION_PROMPT_LINE);
                System.out.println(LINE_ONE);
                inputOne = scan.next();
                System.out.println(LINE_TWO);
                inputTwo = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne, inputTwo);
                break;
            case QUESTION_PROMPT_VECTOR:
                // prompt user
                System.out.println(QUESTION_PROMPT_VECTOR);
                inputOne = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne);
                break;
            case QUESTION_PROMPT_MATRIX:
                // prompt user
                System.out.println(QUESTION_PROMPT_MATRIX);
                inputOne = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne);
                break;
            case VECTOR_THREE:
                // prompt user
                System.out.println(QUESTION_PROMPT_VECTOR);
                System.out.println(VECTOR_ONE);
                inputOne = scan.next();
                System.out.println(VECTOR_TWO);
                inputTwo = scan.next();
                System.out.println(VECTOR_THREE);
                inputThree = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne, inputTwo, inputThree);
                break;
            case POINT_THREE:
                // prompt user
                System.out.println(QUESTION_PROMPT_POINT);
                System.out.println(POINT_ONE);
                inputOne = scan.next();
                System.out.println(POINT_TWO);
                inputTwo = scan.next();
                System.out.println(POINT_THREE);
                inputThree = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne, inputTwo, inputThree);
                break;
            case POINT_ONE:
                // prompt user
                System.out.println(QUESTION_PROMPT_VECTOR);
                System.out.println(VECTOR_ONE);
                inputOne = scan.next();
                System.out.println(QUESTION_PROMPT_POINT);
                System.out.println(POINT_ONE);
                inputTwo = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne, inputTwo);
                break;
            case PLANE_ONE:
                // prompt user
                System.out.println(QUESTION_PROMPT_LINE);
                System.out.println(LINE_ONE);
                inputOne = scan.next();
                System.out.println(QUESTION_PROMPT_PLANE);
                System.out.println(PLANE_ONE);
                inputTwo = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne, inputTwo);
                break;
            case PLANE_TWO:
                // prompt user
                System.out.println(QUESTION_PROMPT_PLANE);
                System.out.println(PLANE_ONE);
                inputOne = scan.next();
                System.out.println(PLANE_TWO);
                inputTwo = scan.next();
                // solve question
                calculations.ChapterOne(topic, inputOne, inputTwo);
                break;
            }
        }
    }
}