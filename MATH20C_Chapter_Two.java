
//龍ONE

import java.util.Scanner;
import java.util.ArrayList;

public class MATH20C_Chapter_Two {

        public static ArrayList<Character> formula_array = new ArrayList<Character>();

        public static void main(String[] args) {
                boolean answerQuestion = true;
                int topic;
                while (answerQuestion == true) {
                        Scanner scan = new Scanner(System.in);
                        // 1. Limits
                        // 2. Partial Derivative (single function)
                        // 3. Partial Derivative (multiple functions)
                        // 4. Partial Derivative (composite functions)
                        // 5. Linear Approximation
                        // 6. Gradient
                        // 7. Tangent line for paths
                        // 8. Directional Derivatives
                        // 9. Directional Derivatives (max value)
                        // 10. Directional Derivatives (min value)
                        // 11. Tangent plane to level surfaces
                        System.out.println(
                                        "What do you want to solve? Choose from the following options and type the corresponding number:");
                        System.out.println("1: Derivative");
                        System.out.println("Type 0 to end the program");
                        topic = scan.nextInt();
                        // solve question given the topics
                        switch (topic) {
                        case 0:
                                answerQuestion = false;
                                break;
                        case 1:
                                System.out.println("Input the equation");
                                String formula = scan.next();
                                convertToArrayList(formula);
                                System.out.println("The derivative is:" + derivative(formula));
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

        public static void convertToArrayList(String input){
                for (int i = 0; i < input.length(); i++){
                        formula_array.add(input.charAt(i));
                }
                System.out.println(formula_array);
        }
}