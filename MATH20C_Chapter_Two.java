
//龍ONE

import java.util.Scanner;
import java.util.ArrayList;

public class MATH20C_Chapter_Two {

        private static final String PROMPT = "What do you want to solve? Choose from "
                        + "the following options and type the corresponding number:";
        private static final String QUESTION_ONE = "1: Partial Derivative",
                        QUESTION_TWO = "2: Partial Derivative (Chain Rule)", QUESTION_THREE = "3: Linear Approximation",
                        QUESTION_FOUR = "4: Derivative Matrix", QUESTION_FIVE = "5: Gradient",
                        QUESTION_SIX = "6: Tangent Plane", QUESTION_SEVEN = "7: Tangent Line for Paths",
                        QUESTION_EIGHT = "8: Directional Derivatives of function",
                        QUESTION_NINE = "9: Directional Derivatives (min value)",
                        QUESTION_TEN = "10: Directional Derivatives (max value)";
        private static final String QUESTION_SEPARATOR = ", ";
        private static final String END_PROMPT = "Type 0 to end the program";
        private static final String[] CASES = { "" };

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
                        System.out.println(QUESTION_ONE + QUESTION_SEPARATOR + QUESTION_TWO + QUESTION_SEPARATOR
                                        + QUESTION_THREE + QUESTION_SEPARATOR + QUESTION_FOUR);
                        System.out.println(QUESTION_FIVE + QUESTION_SEPARATOR + QUESTION_SIX + QUESTION_SEPARATOR
                                        + QUESTION_SEVEN + QUESTION_SEPARATOR + QUESTION_EIGHT);
                        System.out.println(QUESTION_NINE + QUESTION_SEPARATOR + QUESTION_TEN);
                        // Partial Derivative (single function)
                        // Partial Derivative (multiple functions)
                        // Partial Derivative (composite functions)
                        // Linear Approximation
                        // Derivative Matrix
                        // Gradient
                        // Tangent Plane
                        // Tangent line for paths
                        // Directional Derivatives
                        // Directional Derivatives (max value)
                        // Directional Derivatives (min value)
                        System.out.println(END_PROMPT);
                        topic = scan.nextInt();
                        // solve question given the topic (cases are based on last thing printed)
                        switch (CASES[topic]) {
                        case "":
                                answerQuestion = false;
                                scan.close();
                                break;
                        }
                }
        }

        public static String derivative(String operand) {
                // d/dx of c = 0
                // d/dx of x = 1
                // d/dx of c*x = c
                // d/dx of x^c = c*x^c-1
                // d/dx of e^x = e^x
                // d/dx of a^x = a^x * ln(a)
                // d/dx of x^x = x^x * (1 + ln(x))
                // d/dx of ln(x) = 1/x
                // d/dx of loga(x) = 1/(x * ln(a))
                // d/dx of sin(x) = cos(x)
                // d/dx of cos(x) = -sin(x)
                // d/dx of tan(x) = sec^2(x)
                // d/dx of sec(x) = sec(x)*tan(x)
                // d/dx of cot(x) = -csc^2(x)
                // d/dx of csc(x) = -csc(x)*cot(x)
                // d/dx of arcsin(x) = 1/sqrt(1-x^2)
                // d/dx of arccos(x) = -1/sqrt(1-x^2)
                // d/dx of arctan(x) = 1/(1+x^2)
                // d/dx of arccot(x) = -1/(1+x^2)
                // d/dx of arcsec(x) = 1/(x*sqrt(x^2-1))
                // d/dx of arccsc(x) = -1/(x*sqrt(x^2-1))
                // product rule
                // quotient rule
                // chain rule
                return "";
        }
}