
/**
 * Created by: 龍ONE 
 * Date Created: January 10, 2020
 * Date Edited: January 10, 2020
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

    /**
     * This method tests topic one for the chapter
     */
    @Test
    @DisplayName("Testing Chapter One Topic One")
    public void topicOneTest() {
        String inputOne = "1,2,3\n4,5,6";
        InputStream in = new ByteArrayInputStream(inputOne.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        MATH20C_Chapter_One.topicOne();
        assertEquals(
                "Enter the vector in the form x_1,x_2,...,x_n\r\nEnter the vector in the form x_1,x_2,...,x_n\r\n\r\nThe result is: (5.0,7.0,9.0)\r\n",
                out.toString());
    }
}