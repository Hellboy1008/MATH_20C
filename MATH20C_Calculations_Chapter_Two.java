
/**
 * Created by: 龍ONE 
 * Date Created: April 23, 2020
 * Date Edited: April 29, 2020
 * Purpose: Perform Calculations for MATH20C Problems for Chapter 2
 */

/**
 * This class contains methods that calculate various mathematical concepts from
 * MATH20C in chapter 2.
 */
public class MATH20C_Calculations_Chapter_Two {

    // ascii start and end values for alphabet
    private static final int ASCII_A = 97;
    private static final int ASCII_Z = 122;

    // special character for simple derivatives
    private static final char SPECIAL_CHAR = '$';

    // error messages for function
    private static final String ERROR_CANNOT_CALCULATE_DERIVATIVE = "The derivative of this function could not be calculated.";
    private static final String ERROR_FUNCTION_CHAR = "Incorrect Input -> The acceptable characters for a function are: "
            + "letters in alphabet, digits (0-9), \'-\', \'+\', \'/\', \'*\', \'(\', \')\', \'^\'";
    private static final String ERROR_VARIABLE_CHAR = "Incorrect Input -> The variable has to be a letter in the alphabet";
    private static final String ERROR_VARIABLE_LENGTH = "Incorrect Input -> The variable can only be of length 1";

    // acceptable character for functions
    private static final char[] ACCEPTABLE_CHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '+', '/',
            '*', '(', ')', '^' };

    // simple derivatives and their results
    private static final String[] SIMPLE_DERIVATIVES = { "$", "e^$", "$^$", "ln($)", "sin($)", "cos($)", "tan($)",
            "sec($)", "cot($)", "csc($)", "arcsin($)", "arccos($)", "arctan($)", "arccot($)", "arcsec($)",
            "arccsc($)" };
    private static final String[] SIMPLE_DERIVATIVES_ANS = { "1", "e^$", "$^$ * (1 + ln($))", "1/$", "cos($)",
            "-sin($)", "sec^2($)", "sec($) * tan($)", "-csc^2($)", "-csc($) * cot($)", "1 / sqrt(1 - $^2)",
            "-1 / sqrt(1 - $^2)", "1 / (1 + $^2)", "-1 / (1 + $^2)", "1 / ($ * sqrt($^2 - 1))",
            "-1 / ($ * sqrt($^2 - 1))" };

    // d/dx of c*x = c
    // d/dx of x^c = c*x^c-1
    // d/dx of a^x = a^x * ln(a)
    // d/dx of loga(x) = 1/(x * ln(a))
    // sum rule
    // difference rule
    // product rule
    // quotient rule
    // chain rule

    /**
     * This method finds the derivative of a function given a variable
     * 
     * @param function The function that is in question
     * @param variable The variable in question for function
     * @return The derivative of the function in respect to the variable
     * @throws IllegalArgumentException If the function contains characters that are
     *                                  invalid or if the variable is not a letter
     *                                  of the alphabet or of length 1.
     */
    public String derivative(String function, String variable) {

        // checks if characters are valid for function
        boolean funcCharValid = true;

        // check if function contains characters that should not be present
        for (int indexOne = 0; indexOne < function.length(); indexOne++) {
            // check if the character is not an alphabet
            if ((int) function.charAt(indexOne) < ASCII_A || (int) function.charAt(indexOne) > ASCII_Z) {
                funcCharValid = false;
                // check if character is one of the acceptable characters
                for (int indexTwo = 0; indexTwo < ACCEPTABLE_CHAR.length; indexTwo++) {
                    if (function.charAt(indexOne) == ACCEPTABLE_CHAR[indexTwo]) {
                        funcCharValid = true;
                        break;
                    }
                }
            }

            // if the character is invalid, throw error
            if (funcCharValid == false) {
                throw new IllegalArgumentException(ERROR_FUNCTION_CHAR);
            }
        }

        // check if variable is of valid length
        if (variable.length() != 1) {
            throw new IllegalArgumentException(ERROR_VARIABLE_LENGTH);
        }

        // check if variable is a letter in the alphabet
        if ((int) variable.charAt(0) < ASCII_A || (int) variable.charAt(0) > ASCII_Z) {
            throw new IllegalArgumentException(ERROR_VARIABLE_CHAR);
        }

        // if the variable does not exist in the function, return 0
        if (function.indexOf(variable) == -1) {
            return "" + 0;
        }

        // catch different simple cases of derivative
        for (int index = 0; index < SIMPLE_DERIVATIVES.length; index++) {
            if (function.equals(SIMPLE_DERIVATIVES[index].replace(SPECIAL_CHAR, variable.charAt(0)))) {
                return SIMPLE_DERIVATIVES_ANS[index].replace(SPECIAL_CHAR, variable.charAt(0));
            }
        }

        return ERROR_CANNOT_CALCULATE_DERIVATIVE;
    }

    public static void main(String[] args) {
        MATH20C_Calculations_Chapter_Two a = new MATH20C_Calculations_Chapter_Two();
        // System.out.println(a.derivative("a,b,c", "x"));
        // System.out.println(a.derivative("10x", "3"));
        // System.out.println(a.derivative("10x", "xy"));
        System.out.println(a.derivative("10*x", "y"));
        System.out.println(a.derivative("8", "x"));
        System.out.println(a.derivative("100", "x"));
        System.out.println(a.derivative("x", "x"));
        System.out.println(a.derivative("e^x", "x"));
        System.out.println(a.derivative("x^x", "x"));
        System.out.println(a.derivative("ln(x)", "x"));
        System.out.println(a.derivative("sin(x)", "x"));
        System.out.println(a.derivative("cos(x)", "x"));
        System.out.println(a.derivative("tan(x)", "x"));
        System.out.println(a.derivative("sec(x)", "x"));
        System.out.println(a.derivative("cot(x)", "x"));
        System.out.println(a.derivative("csc(x)", "x"));
        System.out.println(a.derivative("arcsin(x)", "x"));
        System.out.println(a.derivative("arccos(x)", "x"));
        System.out.println(a.derivative("arctan(x)", "x"));
        System.out.println(a.derivative("arccot(x)", "x"));
        System.out.println(a.derivative("arcsec(x)", "x"));
        System.out.println(a.derivative("arccsc(x)", "x"));
        System.out.println(a.derivative("10*x", "x"));
    }
}