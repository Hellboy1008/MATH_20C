
/**
 * Created by: 龍ONE 
 * Date Created: January 10, 2020
 * Date Edited: January 17, 2020
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

    // denotes a new line with both new line and enter character
    private static final String NEWLINE = "\r\n";
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
        // list of string tests
        String[] tests = { "1,2,3\nabc", "1,2,3\n4,5,6,7", "32\n64", "32,43\n1,2", "1,2,-3\n4,5,6" };
        // list of expected results
        String[] results = {
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE
                        + "Incorrect input -> Only numbers, dots, and commas are allowed as valid input" + NEWLINE,
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE
                        + "Incorrect input -> The vectors are not in the same dimension" + NEWLINE,
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE + "The result is: (96.0)"
                        + NEWLINE,
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE
                        + "The result is: (33.0,45.0)" + NEWLINE,
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE
                        + "The result is: (5.0,7.0,3.0)" + NEWLINE };
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
            assertEquals(results[index], out.toString());
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
        // list of string tests
        String[] tests = { "1,2,3\nabc", "1,2,3\n4,5,6,7", "32\n64", "32,43\n1,2", "1,2,-3\n4,5,6" };
        // list of expected results
        String[] results = {
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE
                        + "Incorrect input -> Only numbers, dots, and commas are allowed as valid input" + NEWLINE,
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE
                        + "Incorrect input -> The vectors are not in the same dimension" + NEWLINE,
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE + "The result is: (-32.0)"
                        + NEWLINE,
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE
                        + "The result is: (31.0,41.0)" + NEWLINE,
                "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE
                        + "Enter the vector in the form x_1,x_2,...,x_n" + NEWLINE + NEWLINE
                        + "The result is: (-3.0,-3.0,-9.0)" + NEWLINE };
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
            assertEquals(results[index], out.toString());
        }

        System.setOut(STANDARD_OUT);
        System.setIn(STANDARD_IN);
    }
}