
/**
 * Created by: 龍ONE 
 * Date Created: March 12, 2019
 * Date Edited: November 25, 2019
 * Purpose: Perform Calculations for MATH20C Problems
 */

/**
 * This class contains methods that calculate various mathematical concepts from
 * MATH20C.
 */
public class MATH20C_Calculations {

    private static final int TWO_DIMENSION = 2;
    private static final int THREE_DIMENSION = 3;
    private static final String LINES_NOT_IN_R3 = "The line/lines are not in R3";
    private static final String NOT_SQUARE_MATRIX = "The matrix is not a square matrix";
    private static final String VECTORS_NOT_IN_R3 = "The vector/vectors are not in R3";
    private static final String VECTORS_NOT_IN_SAME_DIMENSION = "The vectors are not in the same dimension";

    private static final int TOPIC_NUMBER_ONE = 1, TOPIC_NUMBER_TWO = 2, TOPIC_NUMBER_THREE = 3, TOPIC_NUMBER_FOUR = 4,
            TOPIC_NUMBER_FIVE = 5, TOPIC_NUMBER_SIX = 6, TOPIC_NUMBER_SEVEN = 7, TOPIC_NUMBER_EIGHT = 8,
            TOPIC_NUMBER_NINE = 9, TOPIC_NUMBER_TEN = 10, TOPIC_NUMBER_ELEVEN = 11, TOPIC_NUMBER_TWELVE = 12,
            TOPIC_NUMBER_THIRTEEN = 13, TOPIC_NUMBER_FOURTEEN = 14, TOPIC_NUMBER_FIFTEEN = 15,
            TOPIC_NUMBER_SIXTEEN = 16;
    private static final char COMMA = ',', PLUS = '+', MINUS = '-', SPACE = ' ';
    private static final String NEWLINE = "\n";
    // Chapter One Answers
    private static final String ANSWER_LINE = "Line: (%.3f,%.3f,%.3f) + t(%.3f,%.3f,%.3f)",
            ANSWER_INTERSECT_LINE_YES = "The two lines intersect at:\n" + "(%.3f,%.3f,%.3f)",
            ANSWER_INTERSECT_LINE_NO = "The two lines don't intersect", ANSWER_MAGNITUDE = "Magnitude = %.3f",
            ANSWER_DOT_PRODUCT = "Dot Product = %.3f", ANSWER_VECTOR = "Vector = (%.3f,%.3f,%.3f)",
            ANSWER_ANGLE = "Angle = %.3f",
            ANSWER_ORTHOGONAL = "The orthogonal projection of vector 1 on vector 2 is: (%.3f,%.3f,%.3f)",
            ANSWER_DETERMINANT = "Determinant = %.3f", ANSWER_CROSS_PRODUCT = "Cross Product = (%.3f,%.3f,%.3f)",
            ANSWER_PARALLELOGRAM = "Area of the parallelogram = %.3f",
            ANSWER_PARALLELPIPED = "Volume of parallelpiped = %.3f", ANSWER_COPLANAR = "Yes, the vectors are coplanar",
            ANSWER_NOT_COPLANAR = "No, the vectors are not coplanar",
            ANSWER_PLANE = "The equation of the plane is %.3fx %c %.3fy %c %.3fz = %.3f",
            ANSWER_INTERSECT_POINT_NO = "The line and the plane do not intersect",
            ANSWER_INTERSECT_POINT_YES = "The line and the plane intersect at (%.3f,%.3f,%.3f)",
            ANSWER_INTERSECT_PLANE = "The intersection of the two planes is: (%.3f,%.3f,0) + t(%.3f,%.3f,%.3f)";
    // Chapter Two Answers

    public void ChapterOne(int topicNumber, String inputOne) {
    }

    public void ChapterOne(int topicNumber, String inputOne, String inputTwo) {
    }

    public void ChapterOne(int topicNumber, String inputOne, String inputTwo, String inputThree) {
        double[] inputOneArray = interpretStringToArray(inputOne);
        double[] inputTwoArray = interpretStringToArray(inputTwo);
        double[] inputThreeArray = interpretStringToArray(inputThree);
        switch (topicNumber) {
        case TOPIC_NUMBER_ELEVEN:
            ChapterOneTopicEleven(inputOneArray, inputTwoArray, inputThreeArray, true);
            break;
        case TOPIC_NUMBER_TWELVE:
            ChapterOneTopicTwelve(inputOneArray, inputTwoArray, inputThreeArray);
            break;
        case TOPIC_NUMBER_THIRTEEN:
            ChapterOneTopicThirteen(inputOneArray, inputTwoArray, inputThreeArray);
            break;
        }
    }

    private static double[] interpretStringToArray(String input) {
        double[] answer;
        int numOfCommas = 0;
        // count the number of commas
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == COMMA) {
                numOfCommas++;
            }
        }
        // put the number in the strings into the array
        if (numOfCommas == 0) {
            return null;
        } else {
            answer = new double[numOfCommas + 1];
            int arrayIndex = 0, commaIndex = 0;
            for (int index = 0; index < input.length(); index++) {
                if (input.charAt(index) == COMMA) {
                    answer[arrayIndex] = Double.parseDouble(input.substring(commaIndex, index));
                    arrayIndex++;
                    commaIndex = index + 1;
                }
            }
            answer[arrayIndex] = Double.parseDouble(input.substring(commaIndex));
        }
        return answer;
    }

    private static double[][] convertToMatrix(double[] input) {
        int matrixSize = (int) Math.sqrt(input.length);
        double[][] matrix = new double[matrixSize][matrixSize];
        int inputMatrixIndex = 0;
        // turn double[] into 2-D array represented by double[][]
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[inputMatrixIndex];
                inputMatrixIndex++;
            }
        }
        return matrix;
    }

    public static void main(String args[]) {
        MATH20C_Calculations c = new MATH20C_Calculations();
        // test vector addition
        double[] v1 = { 1, 0, 2 };
        double[] v2 = { 0, 3, 7 };
        double[] x = c.vectorAddition(v1, v2);
        System.out.println(java.util.Arrays.toString(x));
        // test vector subtraction
        x = c.vectorSubtraction(v1, v2);
        System.out.println(java.util.Arrays.toString(x));
        // test vector scaling
        x = c.vectorScaling(v1, 5);
        System.out.println(java.util.Arrays.toString(x));
        x = c.vectorScaling(v2, -5);
        System.out.println(java.util.Arrays.toString(x));
        // test lineFromTwoVectors
        x = c.lineFromTwoVectors(v1, v2);
        System.out.println(java.util.Arrays.toString(x));
        // test intersectionOfTwoLines
        double[] l1 = { 2, 1, 0, -1, -1, -1 };
        double[] l2 = { 3, 0, 5, 2, 0, 6 };
        x = c.intersectionOfTwoLines(l1, l2);
        System.out.println(java.util.Arrays.toString(x));
        // test magnitudeOfVector
        double y = c.magnitudeOfVector(v1);
        System.out.println(y);
        // test dot product
        y = c.dotProductTwoVectors(v1, v2);
        System.out.println(y);
        // test unit vector
        x = c.unitVector(v1);
        System.out.println(java.util.Arrays.toString(x));
        // test angle between two vectors
        y = c.angleBetweenTwoVectors(v1, v2);
        System.out.println(y);
        // test orthogonal projection of two vectors
        x = c.orthogonalProjectionOfTwoVectors(v1, v2);
        System.out.println(java.util.Arrays.toString(x));
        // test determinant of square matrix
        double[][] m = { { 3, 2, -1, 4 }, { 2, 1, 5, 7 }, { 0, 5, 2, -6 }, { -1, 2, 1, 0 } };
        y = c.determinantOfSquareMatrix(m);
        System.out.println(y);
        // test cross product of two vectors
        x = c.crossProductOfTwoVectors(v1, v2);
        System.out.println(java.util.Arrays.toString(x));
        // test area of parallelogram
        y = c.areaOfParallelogramTwoVectors(v1, v2);
        System.out.println(y);
    }

    /**
     * This method adds two vectors and returns the result
     * 
     * @param vector_one The first vector
     * @param vector_two The second vector
     * @return The addition of the two vectors
     * @throws IllegalArgumentException if the two vectors are not in the same
     *                                  dimension
     */
    public double[] vectorAddition(double[] vector_one, double[] vector_two) throws IllegalArgumentException {
        // result of the vector addition
        double[] result = new double[vector_one.length];

        // check if the vectors are in the same dimension
        if (vector_one.length != vector_two.length) {
            throw new IllegalArgumentException(VECTORS_NOT_IN_SAME_DIMENSION);
        }

        // add the vectors
        for (int index = 0; index < vector_one.length; index++) {
            result[index] = vector_one[index] + vector_two[index];
        }

        return result;
    }

    /**
     * This method subtracts two vectors and returns the result
     * 
     * @param vector_one The first vector
     * @param vector_two The second vector
     * @return The subtraction of the two vectors
     * @throws IllegalArgumentException if the two vectors are not in the same
     *                                  dimension
     */
    public double[] vectorSubtraction(double[] vector_one, double[] vector_two) throws IllegalArgumentException {
        // result of the vector subtraction
        double[] result = new double[vector_one.length];

        // check if the vectors are in the same dimension
        if (vector_one.length != vector_two.length) {
            throw new IllegalArgumentException(VECTORS_NOT_IN_SAME_DIMENSION);
        }

        // subtract the vectors
        for (int index = 0; index < vector_one.length; index++) {
            result[index] = vector_one[index] - vector_two[index];
        }

        return result;
    }

    /**
     * This method scales a vector and returns the result
     * 
     * @param vector_one The vector being scaled
     * @param scale      The scalar for the vector
     * @return The scalar of the vector
     * 
     */
    public double[] vectorScaling(double[] vector_one, double scale) {
        // result of the vector scaling
        double[] result = new double[vector_one.length];

        // scalar the vector
        for (int index = 0; index < vector_one.length; index++) {
            result[index] = vector_one[index] * scale;
        }

        return result;
    }

    /**
     * This method calculates the line formed by the two vectors in R3.
     * 
     * @param vector_one The first vector
     * @param vector_two The second vector
     * @return The line formed by two vectors
     * @throws IllegalArgumentException if the vectors are not in R3
     */
    public double[] lineFromTwoVectors(double[] vector_one, double[] vector_two) throws IllegalArgumentException {
        // line formed by the two vectors
        double[] line = new double[vector_one.length + vector_two.length];

        // check if the vectors are in R3
        if (vector_one.length != THREE_DIMENSION || vector_two.length != THREE_DIMENSION) {
            throw new IllegalArgumentException(VECTORS_NOT_IN_R3);
        }

        // use vector_one as the first point
        for (int index = 0; index < THREE_DIMENSION; index++) {
            line[index] = vector_one[index];
        }
        // use difference for slope
        for (int index = THREE_DIMENSION; index < line.length; index++) {
            line[index] = vector_two[index - THREE_DIMENSION] - vector_one[index - THREE_DIMENSION];
        }

        return line;
    }

    /**
     * This method calculates the intersection between two lines in R3.
     * 
     * @param line_one The first line
     * @param line_two The second line
     * @return The intersection point if it exists, null if it doesn't exist
     * @throws IllegalArgumentException if the lines are not in R3
     */
    public double[] intersectionOfTwoLines(double[] line_one, double[] line_two) throws IllegalArgumentException {
        // variables used for calculation of x and y
        double a, b, c, d, e, f, x, y;
        // intersection point of the two lines
        double[] intersectionPoint = new double[THREE_DIMENSION];

        // check if the lines are in R3
        if (line_one.length != THREE_DIMENSION + THREE_DIMENSION
                || line_two.length != THREE_DIMENSION + THREE_DIMENSION) {
            throw new IllegalArgumentException(LINES_NOT_IN_R3);
        }

        // calculate the x and y values
        a = line_one[THREE_DIMENSION];
        b = -1 * line_two[THREE_DIMENSION];
        c = line_two[0] - line_one[0];
        d = line_one[THREE_DIMENSION + 1];
        e = -1 * line_two[THREE_DIMENSION + 1];
        f = line_two[1] - line_one[1];
        x = (f * b - e * c) / (b * d - a * e);
        y = (c - a * x) / b;

        // check to see if intersection exists
        if (line_one[THREE_DIMENSION - 1] + line_one[line_one.length - 1] * x == line_two[THREE_DIMENSION - 1]
                + line_two[line_two.length - 1] * y) {
            intersectionPoint[0] = line_one[0] + line_one[THREE_DIMENSION] * x;
            intersectionPoint[1] = line_one[1] + line_one[THREE_DIMENSION + 1] * x;
            intersectionPoint[intersectionPoint.length - 1] = line_one[THREE_DIMENSION - 1]
                    + line_one[line_one.length - 1] * x;
        } else {
            return null;
        }

        return intersectionPoint;
    }

    /**
     * This method calculates the magnitude of a vector.
     * 
     * @param vector The vector used in calculation
     * @return The magnitude of the vector
     */
    public double magnitudeOfVector(double[] vector) {
        double answer_number = 0;

        // find the sum of the squares for each component
        for (int index = 0; index < vector.length; index++) {
            answer_number += (vector[index] * vector[index]);
        }

        answer_number = Math.sqrt(answer_number);

        return answer_number;
    }

    /**
     * This method calculates the dot product between two vectors.
     * 
     * @param vector_one The first vector
     * @param vector_two The second vector
     * @return The dot product of the two vectors
     * @throws IllegalArgumentException if the two vectors are not in the same
     *                                  dimension
     */
    public double dotProductTwoVectors(double[] vector_one, double[] vector_two) throws IllegalArgumentException {
        // result for dot product
        double dotProduct = 0;

        // check if the vectors are in the same dimension
        if (vector_one.length != vector_two.length) {
            throw new IllegalArgumentException(VECTORS_NOT_IN_SAME_DIMENSION);
        }

        // Calculate dot product
        for (int index = 0; index < vector_one.length; index++) {
            dotProduct += vector_one[index] * vector_two[index];
        }

        return dotProduct;
    }

    /**
     * This method calculates the unit vector for the given vector.
     * 
     * @param vector The vector that is converted to a unit vector
     * @return The unit vector for the given vector
     */
    public double[] unitVector(double[] vector) {
        // magnitude of the vector
        double magnitude = magnitudeOfVector(vector);
        // resulting unit vector
        double[] unitVector = new double[vector.length];

        // calculate unit vector
        for (int index = 0; index < vector.length; index++) {
            unitVector[index] = vector[index] / magnitude;
        }

        return unitVector;
    }

    /**
     * This method calculates the angle between two vectors
     * 
     * @param vector_one The first vector
     * @param vector_two The second vector
     * @return The angle between the two vectors
     */
    public double angleBetweenTwoVectors(double[] vector_one, double[] vector_two) {
        // angle between two vectors
        double angle = 0;
        // dot product between two vectors
        double dotProduct = dotProductTwoVectors(vector_one, vector_two);
        // magnitude of first vector
        double magnitudeVectorOne = magnitudeOfVector(vector_one);
        // magnitude of second vector
        double magnitudeVectorTwo = magnitudeOfVector(vector_two);

        // calculate angle
        angle = Math.acos(dotProduct / (magnitudeVectorOne * magnitudeVectorTwo));

        return angle;
    }

    /**
     * This method calculates the orthogonal projection of the first vector on the
     * second vector.
     * 
     * @param vector_one The first vector
     * @param vector_two The second vector
     * @return The orthogonal projection of the first vector on the second vector
     */
    public double[] orthogonalProjectionOfTwoVectors(double[] vector_one, double[] vector_two) {
        // dot product of the two vectors
        double dotProduct = dotProductTwoVectors(vector_one, vector_two);
        // magnitude of second vector
        double magnitudeVectorTwo = magnitudeOfVector(vector_two);
        // result of orthogonal projection
        double[] projection = new double[vector_one.length];

        // calculate projection
        for (int index = 0; index < vector_two.length; index++) {
            projection[index] = vector_two[index] * (dotProduct / (magnitudeVectorTwo * magnitudeVectorTwo));
        }

        return projection;
    }

    /**
     * This method calculates the determinant of a square matrix.
     * 
     * @param matrix The square matrix used to calculate the determinant
     * @return The determinant of the square matrix
     * @throws IllegalArgumentException if the matrix is not a square matrix
     */
    public double determinantOfSquareMatrix(double[][] matrix) {
        // determinant of matrix
        double determinant = 0;
        // array for signs in matrix
        double[] signs = new double[matrix.length];
        // sub matrix for recursive calls
        double[][] subMatrix;

        // if the matrix is not a square matrix
        for (int row = 0; row < matrix.length; row++) {
            if (matrix.length != matrix[row].length) {
                throw new IllegalArgumentException(NOT_SQUARE_MATRIX);
            }
        }

        // base case for 2x2 matrix
        if (matrix.length == TWO_DIMENSION) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // fill signs matrix
        signs[0] = 1;
        for (int index = 1; index < signs.length; index++) {
            signs[index] = -1 * signs[index - 1];
        }

        // recursive call for bigger square matrices
        for (int indexOne = 0; indexOne < 1; indexOne++) {
            for (int indexTwo = 0; indexTwo < matrix[indexOne].length; indexTwo++) {
                // create sub matrix
                subMatrix = createSubMatrix(matrix, indexOne, indexTwo);
                // calculate determinant
                determinant += matrix[indexOne][indexTwo] * determinantOfSquareMatrix(subMatrix) * signs[indexTwo];
            }
        }

        return determinant;
    }

    /**
     * This method creates a sub matrix for calculating the determinant of a square
     * matrix.
     * 
     * @param originalMatrix The original square matrix
     * @param avoidRow       The row to avoid in sub matrix
     * @param avoidCol       The column to avoid in sub matrix
     * @return The sub matrix for the given matrix
     */
    private double[][] createSubMatrix(double[][] originalMatrix, int avoidRow, int avoidCol) {
        // index for row of sub matrix
        int subIndexRow = 0;
        // index for col of sub matrix
        int subIndexCol = 0;
        // sub matrix for original matrix
        double[][] subMatrix = new double[originalMatrix.length - 1][originalMatrix.length - 1];

        // fill sub matrix
        for (int indexOne = 0; indexOne < originalMatrix.length; indexOne++) {
            for (int indexTwo = 0; indexTwo < originalMatrix[indexOne].length; indexTwo++) {
                // add value to sub matrix if valid
                if (indexOne != avoidRow && indexTwo != avoidCol) {
                    subMatrix[subIndexRow][subIndexCol] = originalMatrix[indexOne][indexTwo];

                    // increment sub index for row and column
                    if (subIndexCol == subMatrix[subIndexRow].length - 1) {
                        subIndexRow++;
                        subIndexCol = 0;
                    } else {
                        subIndexCol++;
                    }
                }

            }
        }

        return subMatrix;
    }

    /**
     * This method calculates the cross product of two vectors in R3.
     * 
     * @param vector_one The first vector
     * @param vector_two The second vector
     * @return The cross product of the two vectors
     * @throws IllegalArgumentException if the vectors are not in R3
     */
    public double[] crossProductOfTwoVectors(double[] vector_one, double[] vector_two) throws IllegalArgumentException {
        // result of cross product
        double[] cross_product = new double[vector_one.length];

        // if the vectors are not in R3
        if (vector_one.length != THREE_DIMENSION || vector_two.length != THREE_DIMENSION) {
            throw new IllegalArgumentException(VECTORS_NOT_IN_R3);
        }

        // calculate cross product
        cross_product[0] = vector_one[1] * vector_two[THREE_DIMENSION - 1]
                - vector_one[THREE_DIMENSION - 1] * vector_two[1];
        cross_product[1] = -1
                * (vector_one[0] * vector_two[THREE_DIMENSION - 1] - vector_one[THREE_DIMENSION - 1] * vector_two[0]);
        cross_product[THREE_DIMENSION - 1] = vector_one[0] * vector_two[1] - vector_one[1] * vector_two[0];

        return cross_product;
    }

    /**
     * The area of a parallelogram spanned by two vectors in R3
     * 
     * @param vector_one The first vector
     * @param vector_two The second vector
     * @return The area of parallelogram
     */
    public double areaOfParallelogramTwoVectors(double[] vector_one, double[] vector_two) {
        // cross product of the two vectors
        double[] crossProduct = crossProductOfTwoVectors(vector_one, vector_two);

        return magnitudeOfVector(crossProduct);
    }

    // volume of parallelepiped spanned by three vectors
    public static double ChapterOneTopicEleven(double[] vector_one, double[] vector_two, double[] vector_three,
            boolean print) {
        double determinant = 0;
        double answer_number = Math.abs(determinant);
        if (print == true) {
            System.out.printf(ANSWER_PARALLELPIPED + NEWLINE, answer_number);
        }
        return answer_number;
    }

    // determine if three vectors are coplanar
    public static void ChapterOneTopicTwelve(double[] vector_one, double[] vector_two, double[] vector_three) {
        if (ChapterOneTopicEleven(vector_one, vector_two, vector_three, false) == 0) {
            System.out.println(ANSWER_COPLANAR);
        } else {
            System.out.println(ANSWER_NOT_COPLANAR);
        }
    }

    // equation of a plane given three points
    public static void ChapterOneTopicThirteen(double[] point_one, double[] point_two, double[] point_three) {
        double[] vector_one = new double[THREE_DIMENSION], vector_two = new double[THREE_DIMENSION];
        vector_one[0] = point_two[0] - point_one[0];
        vector_one[1] = point_two[1] - point_one[1];
        vector_one[THREE_DIMENSION - 1] = point_two[THREE_DIMENSION - 1] - point_one[THREE_DIMENSION - 1];
        vector_two[0] = point_three[0] - point_two[0];
        vector_two[1] = point_three[1] - point_two[1];
        vector_two[THREE_DIMENSION - 1] = point_three[THREE_DIMENSION - 1] - point_two[THREE_DIMENSION - 1];
        double[] cross_product = null;
        // A(x-x0) + B(y-y0) + C(z-z0) = 0
        double d_value = cross_product[0] * point_one[0] + cross_product[1] * point_one[1]
                + cross_product[THREE_DIMENSION - 1] * point_one[THREE_DIMENSION - 1];
        char yComponent_sign = PLUS, zComponent_sign = PLUS;
        if (cross_product[1] < 0) {
            yComponent_sign = MINUS;
            cross_product[1] = -1 * cross_product[1];
        }
        if (cross_product[THREE_DIMENSION - 1] < 0) {
            zComponent_sign = MINUS;
            cross_product[THREE_DIMENSION - 1] = -1 * cross_product[THREE_DIMENSION - 1];
        }
        System.out.printf(ANSWER_PLANE + NEWLINE, cross_product[0], yComponent_sign, cross_product[1], zComponent_sign,
                cross_product[THREE_DIMENSION - 1], d_value);
    }

    // equation of a plane given normal vector and point
    public static void ChapterOneTopicFourteen(double[] vector_one, double[] point_one) {
        // A(x-x0) + B(y-y0) + C(z-z0) = 0
        double d_value = vector_one[0] * point_one[0] + vector_one[1] * point_one[1]
                + vector_one[THREE_DIMENSION - 1] * point_one[THREE_DIMENSION - 1];
        char yComponent_sign = PLUS, zComponent_sign = PLUS;
        if (vector_one[1] < 0) {
            yComponent_sign = MINUS;
            vector_one[1] = -1 * vector_one[1];
        }
        if (vector_one[THREE_DIMENSION - 1] < 0) {
            zComponent_sign = MINUS;
            vector_one[THREE_DIMENSION - 1] = -1 * vector_one[THREE_DIMENSION - 1];
        }
        System.out.printf(ANSWER_PLANE + NEWLINE, vector_one[0], yComponent_sign, vector_one[1], zComponent_sign,
                vector_one[THREE_DIMENSION - 1], d_value);
    }

    // intersection of line and plane
    public static void ChapterOneTopicFifthteen(double[] line_one, double[] plane_one) {
        double[] line_one_direction = { line_one[THREE_DIMENSION], line_one[THREE_DIMENSION + 1],
                line_one[line_one.length - 1] };
        double dot_product = 0;
        if (dot_product == 0) {
            System.out.println(ANSWER_INTERSECT_POINT_NO);
        } else {
            double time = (-1 * plane_one[THREE_DIMENSION] - plane_one[0] * line_one[0] - plane_one[1] * line_one[1]
                    - plane_one[THREE_DIMENSION - 1] * line_one[THREE_DIMENSION - 1])
                    / (plane_one[0] * line_one[THREE_DIMENSION] + plane_one[1] * line_one[THREE_DIMENSION + 1]
                            + plane_one[THREE_DIMENSION - 1] * line_one[line_one.length - 1]);
            System.out.println(time);
            double xCor = line_one[THREE_DIMENSION] * time + line_one[0];
            double yCor = line_one[THREE_DIMENSION + 1] * time + line_one[1];
            double zCor = line_one[line_one.length - 1] * time + line_one[THREE_DIMENSION - 1];
            System.out.printf(ANSWER_INTERSECT_POINT_YES + NEWLINE, xCor, yCor, zCor);
        }
    }

    // intersection of two planes
    public static void ChapterOneTopicSixteen(double[] plane_one, double[] plane_two) {
        plane_one[THREE_DIMENSION] = -1 * plane_one[THREE_DIMENSION];
        plane_two[THREE_DIMENSION] = -1 * plane_two[THREE_DIMENSION];
        double x = (plane_two[THREE_DIMENSION] * plane_one[1] - plane_two[1] * plane_one[THREE_DIMENSION])
                / (plane_one[1] * plane_two[0] - plane_one[0] * plane_two[1]);
        double y = (plane_one[THREE_DIMENSION] - plane_one[0] * x) / plane_one[1];
        double[] cross_product = null;
        System.out.printf(ANSWER_INTERSECT_PLANE + NEWLINE, x, y, cross_product[0], cross_product[1],
                cross_product[THREE_DIMENSION - 1]);
    }

    // derivatives

}