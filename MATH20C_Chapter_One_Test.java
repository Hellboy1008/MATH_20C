
/**
 * Created by: 龍ONE 
 * Date Created: January 10, 2020
 * Date Edited: April 15, 2020
 * Purpose: Test calculations for MATH20C Problems in Chapter 1 of the textbook.
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class tests the different topics for chapter one.
 */
public class MATH20C_Chapter_One_Test {

    // expected results from calculations
    private static final String RESULT_TWO_LINES_DIMENSION_ERROR_R3 = "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z"
            + "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z"
            + "Incorrect input -> The line/lines are not in R3";
    private static final String RESULT_TWO_LINES_INCORRECT_INPUT = "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z"
            + "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z"
            + "Incorrect input -> Only numbers, dots, and commas are allowed as valid input";
    private static final String RESULT_TWO_VECTORS_DIMENSION_ERROR = "Enter the vector in the form x_1,x_2,...,x_n"
            + "Enter the vector in the form x_1,x_2,...,x_n"
            + "Incorrect input -> The vectors are not in the same dimension";
    private static final String RESULT_TWO_VECTORS_DIMENSION_ERROR_R3 = "Enter the vector in the form x_1,x_2,...,x_n"
            + "Enter the vector in the form x_1,x_2,...,x_n" + "Incorrect input -> The vector/vectors are not in R3";
    private static final String RESULT_TWO_VECTORS_INCORRECT_INPUT = RESULT_TWO_LINES_INCORRECT_INPUT.replace(
            "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z",
            "Enter the vector in the form x_1,x_2,...,x_n");

    // standard input stream
    private static final InputStream STANDARD_IN = System.in;
    // standard output stream
    private static final PrintStream STANDARD_OUT = System.out;

    /**
     * This method tests topic one for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic One")
    public void topicOneTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc\nabc", "abc\n1,2", "1,2,3\nabc", "1,2,3.0\n4,5,6,7", "4,5,6,7\n1,2,3.0", "32\n64",
                "32,43\n1,2", "1,2,-3\n4,5,6", "1,-6,1\n2,-1,2" };
        // list of expected results
        String[] results = { RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_INCORRECT_INPUT,
                RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_DIMENSION_ERROR,
                RESULT_TWO_VECTORS_DIMENSION_ERROR,
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (96.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (33.0000,45.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (5.0000,7.0000,3.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (3.0000,-7.0000,3.0000)" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicOne();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic two for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Two")
    public void topicTwoTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc\nabc", "abc\n1,2,3,4", "1,2,3\nabc", "1,2,3.0\n4,5,6,7", "4,5,6,7\n1,2,3.0", "32\n64",
                "32,43\n1,2", "1,2,-3\n4,5,6", "3,5,9\n5,5,0" };
        // list of expected results
        String[] results = { RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_INCORRECT_INPUT,
                RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_DIMENSION_ERROR,
                RESULT_TWO_VECTORS_DIMENSION_ERROR,
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (-32.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (31.0000,41.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (-3.0000,-3.0000,-9.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (-2.0000,0.0000,9.0000)" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicTwo();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic three for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Three")
    public void topicThreeTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc\ncat", "abc\n20", "1,2,3\nabc", "40\n2", "300,130.0\n0.5", "6,8,9\n-4", "-6,-8,-13\n-5",
                "6,8,9,4,5\n0" };
        // list of expected results
        String[] results = {
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the scalar value"
                        + "Incorrect input -> The scalar value has to be a real number",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the scalar value"
                        + "Incorrect input -> Only numbers, dots, and commas are allowed as valid input",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the scalar value"
                        + "Incorrect input -> The scalar value has to be a real number",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the scalar value" + "The result is: (80.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the scalar value"
                        + "The result is: (150.0000,65.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the scalar value"
                        + "The result is: (-24.0000,-32.0000,-36.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the scalar value"
                        + "The result is: (30.0000,40.0000,65.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the scalar value"
                        + "The result is: (0.0000,0.0000,0.0000,0.0000,0.0000)" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicThree();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic four for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Four")
    public void topicFourTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc\ndef", "abc\n6,-1,-5", "1,2,3\nabc", "1,2\n3,4,5", "1,2,3\n4,5", "2,1,-3\n6,-1,-5",
                "1,0,2\n0,3,7", "-1,-1,-1\n6,-1,4" };
        // list of expected results
        String[] results = { RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_INCORRECT_INPUT,
                RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_DIMENSION_ERROR_R3,
                RESULT_TWO_VECTORS_DIMENSION_ERROR_R3,
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (2.0000,1.0000,-3.0000) + t(4.0000,-2.0000,-2.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (1.0000,0.0000,2.0000) + t(-1.0000,3.0000,5.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (-1.0000,-1.0000,-1.0000) + t(7.0000,0.0000,5.0000)" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicFour();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic five for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Five")
    public void topicFiveTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc\nabcd", "abc\n3,1,4,5,4,4", "3,1,4,5,4,4\nabc", "3,1,5,4\n3,5,7,3,4,10",
                "3,5,7,3,4,10\n3,1,5,4", "1,2,1,2,2,2\n3,1,4,5,4,4", "3,-1,1,4,1,6\n-1,-2,0,4,1,1" };
        // list of expected results
        String[] results = { RESULT_TWO_LINES_INCORRECT_INPUT, RESULT_TWO_LINES_INCORRECT_INPUT,
                RESULT_TWO_LINES_INCORRECT_INPUT, RESULT_TWO_LINES_DIMENSION_ERROR_R3,
                RESULT_TWO_LINES_DIMENSION_ERROR_R3,
                "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z"
                        + "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z"
                        + "There is no intersection.",
                "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z"
                        + "Given the form l(t) = (a,b,c) + t(x,y,z)Enter the line like this: a,b,c,x,y,z"
                        + "The result is: (3.0000,-1.0000,1.0000)" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicFive();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic six for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Six")
    public void topicSixTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc", "20", "2.0,3", "9,-1,4", "1,1,-1", "2,14,-10", "1,-6,1", "2,-1,2" };
        // list of expected results
        String[] results = {
                "Enter the vector in the form x_1,x_2,...,x_n"
                        + "Incorrect input -> Only numbers, dots, and commas are allowed as valid input",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: 20.0000",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: 3.6056",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: 9.8995",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: 1.7321",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: 17.3205",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: 6.1644",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: 3.0000" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicSix();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic seven for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Seven")
    public void topicSevenTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc\nabc", "abc\n20,40", "50,60\nabc", "1,2,3.0\n4,5,6,7", "4,5,6,7\n5.4,3.2", "30\n-2",
                "30,50\n-5,10", "3,1,-2\n1,-1,1", "1,1,1\n-2,1,0", "1,2,3\n-2,1,0", "9,-1,4\n1,1,-1", "3,5,1\n1,3,-1",
                "1,-6,1\n2,-1,2" };
        // list of expected results
        String[] results = { RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_INCORRECT_INPUT,
                RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_DIMENSION_ERROR,
                RESULT_TWO_VECTORS_DIMENSION_ERROR,
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: -60.0000",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: 350.0000",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: 0.0000",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: -1.0000",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: 0.0000",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: 4.0000",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: 17.0000",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: 10.0000" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicSeven();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic eight for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Eight")
    public void topicEightTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc", "20", "3,4", "2,3,-0.5", "1,1,1" };
        // list of expected results
        String[] results = {
                "Enter the vector in the form x_1,x_2,...,x_n"
                        + "Incorrect input -> Only numbers, dots, and commas are allowed as valid input",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: (1.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: (0.6000,0.8000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: (0.5494,0.8242,-0.1374)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: (0.5774,0.5774,0.5774)" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicEight();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic nine for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Nine")
    public void topicNineTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc\nabc", "abc\n20,40,2", "50,60,4\nabc", "4,5,6,7\n1,2,3.0", "1,2,3.0\n4,5,6,7",
                "1,0,0\n0.5,0.61237243569,0.61237243569" };
        // list of expected results
        String[] results = { RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_INCORRECT_INPUT,
                RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_DIMENSION_ERROR,
                RESULT_TWO_VECTORS_DIMENSION_ERROR, "Enter the vector in the form x_1,x_2,...,x_n"
                        + "Enter the vector in the form x_1,x_2,...,x_n" + "The result is: 1.0472" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicNine();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }

    /**
     * This method tests topic ten for the chapter
     * 
     * @param None
     * @return None
     */
    @Test
    @DisplayName("Testing Chapter One Topic Ten")
    public void topicTenTest() {
        // string output from running the function
        String output;
        // list of string tests
        String[] tests = { "abc\nabc", "abc\n20,40", "50,60,4\nabc", "1,2,3.0\n4,5,6,7", "4,5,6,7\n1,2,3.0", "1\n10",
                "1,0\n10,0", "1,2,3\n1,0,1" };
        // list of expected results
        String[] results = { RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_INCORRECT_INPUT,
                RESULT_TWO_VECTORS_INCORRECT_INPUT, RESULT_TWO_VECTORS_DIMENSION_ERROR,
                RESULT_TWO_VECTORS_DIMENSION_ERROR,
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (1.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (1.0000,0.0000)",
                "Enter the vector in the form x_1,x_2,...,x_n" + "Enter the vector in the form x_1,x_2,...,x_n"
                        + "The result is: (2.0000,0.0000,2.0000)" };
        // input stream for the test
        InputStream in;
        // output stream for the test
        ByteArrayOutputStream out;

        // run tests
        for (int index = 0; index < tests.length; index++) {
            // set input and output streams
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(tests[index].getBytes());
            System.setIn(in);

            // run topic and see if results differ
            MATH20C_Chapter_One.resetScanner();
            MATH20C_Chapter_One.topicTen();
            output = out.toString();
            output = output.replaceAll("\r", "");
            output = output.replaceAll("\n", "");
            assertEquals(results[index], output);
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }
}