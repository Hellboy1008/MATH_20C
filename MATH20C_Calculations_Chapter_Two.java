
/**
 * Created by: 龍ONE 
 * Date Created: April 23, 2020
 * Date Edited: April 25, 2020
 * Purpose: Perform Calculations for MATH20C Problems for Chapter 2
 */

/**
 * This class contains methods that calculate various mathematical concepts from
 * MATH20C in chapter 2.
 */
public class MATH20C_Calculations_Chapter_Two {

    // Derivative of a function with 1 variable
    // Partial Derivative for function with 2 variables
    // Partial Derivative matrix for functions with 2 variables
    // Partial Derivative matrix for composite functions
    // Gradient of functions with 3 variables
    // Gradient of functions with 3 variables at a point
    // Equation of the plane tangent to a function with two variables at a given
    // point
    // Velocity of a curve in R2 or R3
    // Tangent line of a curve at a certain point and time R2 and R3
    // Directional derivative of a function with two or 3 variables at a point in
    // the direction of a vector
    // Direction in which a function with two or 3 variables increases the fastest
    // at a point
    // Maximum value of directional derivative given a function with 2/3 variables
    // and a point

    // simple derivatives and their results
    private static final String[] SIMPLE_DERIVATIVES = {};
    private static final String[] SIMPLE_DERIVATIVES_ANS = {};

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

    /**
     * This method finds the derivative of a function given a variable
     * 
     * @param function The function that is in question
     * @param variable The variable in question for function
     * @return The derivative of the function in respect to the variable
     */
    public String derivative(String function, String variable) {

        // if the function is a number, return 0
        try {
            double x = Double.parseDouble(function);
            x += x;
            return "" + 0;
        } catch (IllegalArgumentException e) {
        }

        // catch different simple cases of derivative

        return "";
    }

    public static void main (String[] args){
        MATH20C_Calculations_Chapter_Two a = new MATH20C_Calculations_Chapter_Two();
        System.out.println(a.derivative("10","x"));
    }
}