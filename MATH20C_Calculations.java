
/**
 * Created by: 龍ONE 
 * Date Created: March 12, 2019
 * Date Edited: December 1, 2019
 * Purpose: Perform Calculations for MATH20C Problems
 */

/**
 * This class contains methods that calculate various mathematical concepts from
 * MATH20C.
 */
public class MATH20C_Calculations {

    private static final int TWO_DIMENSION = 2;
    private static final int THREE_DIMENSION = 3;

    private static final char COMMA = ',';
    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';

    private static final String LINES_NOT_IN_R3 = "Incorrect input -> The line/lines are not in R3";
    private static final String NOT_SQUARE_MATRIX = "Incorrect input -> The matrix is not a square matrix";
    private static final String PLANES_NOT_IN_R3 = "Incorrect input -> The plane/planes are not in R3";
    private static final String POINTS_NOT_IN_R3 = "Incorrect input -> The point/points are not in R3";
    private static final String POINTS_NOT_IN_SAME_DIMENSION = "Incorrect input -> The points are not in the same dimension";
    private static final String VECTORS_NOT_IN_R3 = "Incorrect input -> The vector/vectors are not in R3";
    private static final String VECTORS_NOT_IN_SAME_DIMENSION = "Incorrect input -> The vectors are not in the same dimension";

    /**
     * This method converts a string of numbers into a double array.
     * 
     * @param string The string to be converted into a double array
     * @return The string in terms of a double array
     */
    public double[] convertStringToArr(String string) {
        // resulting double array
        double[] result;
        // String array of each individual value
        String[] stringArr;

        stringArr = string.split("" + COMMA);
        result = new double[stringArr.length];

        // convert string array to double array
        for (int index = 0; index < stringArr.length; index++) {
            result[index] = Double.parseDouble(stringArr[index]);
        }

        return result;
    }

    /**
     * This method converts a double array to a string of numbers.
     * 
     * @param doubleArr The double array to be converted into a string
     * @return The double array in terms of a string
     */
    public String convertArrToString(double[] doubleArr) {
        // resulting String
        String result = "" + LEFT_PARENTHESIS;

        // convert double array to string
        for (int index = 0; index < doubleArr.length; index++) {
            // if the index is not 0, add a comma before
            if (index != 0) {
                result += COMMA;
            }
            result += doubleArr[index];
        }

        result += RIGHT_PARENTHESIS;

        return result;
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
        for (double val : vector) {
            answer_number += val * val;
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

    /**
     * This methods returns the volume of a parallelepiped spanned by three vectors
     * in R3.
     * 
     * @param vector_one   The first vector
     * @param vector_two   The second vector
     * @param vector_three The third vector
     * @return The volume of the parallelepiped
     */
    public double volumeOfParallelepipedThreeVectors(double[] vector_one, double[] vector_two, double[] vector_three) {
        // cross product of the first two vectors
        double[] crossProduct = crossProductOfTwoVectors(vector_one, vector_two);
        // dot product of the third vector and the cross product
        double dotProduct = dotProductTwoVectors(crossProduct, vector_three);

        return Math.abs(dotProduct);
    }

    /**
     * This method determines whether three vectors in R3 are coplanar
     * 
     * @param vector_one   The first vector
     * @param vector_two   The second vector
     * @param vector_three The third vector
     * @return True if the vectors are coplanar, false if not
     */
    public boolean threeVectorsCoplanar(double[] vector_one, double[] vector_two, double[] vector_three) {
        return volumeOfParallelepipedThreeVectors(vector_one, vector_two, vector_three) == 0;
    }

    /**
     * This method calculates the equation of a plane in R3 given three points in
     * R3.
     * 
     * @param point_one   The first point
     * @param point_two   The second point
     * @param point_three The third point
     * @return The equation of the plane
     * @throws IllegalArgumentException if the points are not in the same dimension
     *                                  or if it is not in R3
     */
    public double[] equationOfPlaneThreePoints(double[] point_one, double[] point_two, double[] point_three)
            throws IllegalArgumentException {
        // cross product of the two vectors
        double[] crossProduct = new double[point_one.length];
        // equation of the plane
        double[] plane = new double[point_one.length + 1];
        // vector from point one to point two
        double[] vectorP1P2 = new double[point_one.length];
        // vector from point one to point three
        double[] vectorP1P3 = new double[point_one.length];

        // check if points are all in the same dimension
        if (point_one.length != point_two.length || point_one.length != point_three.length) {
            throw new IllegalArgumentException(POINTS_NOT_IN_SAME_DIMENSION);
        }

        // check if points are in R3
        if (point_one.length != THREE_DIMENSION) {
            throw new IllegalArgumentException(POINTS_NOT_IN_R3);
        }

        // initialize the two vectors
        vectorP1P2[0] = point_two[0] - point_one[0];
        vectorP1P2[1] = point_two[1] - point_one[1];
        vectorP1P2[THREE_DIMENSION - 1] = point_two[THREE_DIMENSION - 1] - point_one[THREE_DIMENSION - 1];
        vectorP1P3[0] = point_three[0] - point_one[0];
        vectorP1P3[1] = point_three[1] - point_one[1];
        vectorP1P3[THREE_DIMENSION - 1] = point_three[THREE_DIMENSION - 1] - point_one[THREE_DIMENSION - 1];

        // calculate the cross product of the two vectors
        crossProduct = crossProductOfTwoVectors(vectorP1P2, vectorP1P3);

        // calculate values for the plane
        plane[0] = crossProduct[0];
        plane[1] = crossProduct[1];
        plane[THREE_DIMENSION - 1] = crossProduct[THREE_DIMENSION - 1];
        plane[THREE_DIMENSION] = crossProduct[0] * point_one[0] + crossProduct[1] * point_one[1]
                + crossProduct[THREE_DIMENSION - 1] * point_one[THREE_DIMENSION - 1];

        return reduceCoefficientsPlane(plane);
    }

    /**
     * This method reduces the coefficients of a plane using the greatest common
     * divisor.
     * 
     * @param plane The original plane
     * @return The plane with reduced coefficients
     */
    public double[] reduceCoefficientsPlane(double[] plane) {
        // divisibility by the smallest divisor
        boolean divisibleBySmallestDivisor;
        // divisibility by -1
        boolean divisibleNegOne = true;
        // smallest coefficient
        double smallestCoefficient = plane[0];
        // smallest divisor
        double smallestDivisor;

        // check if the coefficients are divisible by -1
        for (double val : plane) {
            if (val >= 0) {
                divisibleNegOne = false;
            }
        }

        // if the coefficients are divisible by -1, divide it by -1
        if (divisibleNegOne == true) {
            for (int index = 0; index < plane.length; index++) {
                plane[index] /= -1;
            }
        }

        // find smallest coefficient
        for (double val : plane) {
            if (val < smallestCoefficient) {
                smallestCoefficient = val;
            }
        }

        // find smallest divisor
        smallestDivisor = Math.abs(smallestCoefficient);
        while (smallestDivisor != 1) {
            divisibleBySmallestDivisor = true;
            // see if each coefficient is divisible by the smallest divisor
            for (double val : plane) {
                if (val % smallestDivisor != 0) {
                    divisibleBySmallestDivisor = false;
                }
            }
            // if the coefficients are divisible, we have found the smallest divisor
            if (divisibleBySmallestDivisor == true) {
                break;
            }
            smallestDivisor--;
        }

        // divide each coefficient by smallest divisor
        for (int index = 0; index < plane.length; index++) {
            plane[index] /= smallestDivisor;
        }

        return plane;
    }

    /**
     * This method calculates the equation of a plane in R3 given a point in R3 and
     * a normal vector in R3.
     * 
     * @param point  The point used to find the plane
     * @param vector The vector used to find the plane
     * @return The equation of the plane
     * @throws IllegalArgumentException if the point or vector is not in R3
     */
    public double[] equationOfPlanePointAndNormalVector(double[] point, double[] vector)
            throws IllegalArgumentException {
        // equation of the plane
        double[] plane = new double[point.length + 1];

        // check if the point is in R3
        if (point.length != THREE_DIMENSION) {
            throw new IllegalArgumentException(POINTS_NOT_IN_R3);
        }

        // check if the vector is in R3
        if (vector.length != THREE_DIMENSION) {
            throw new IllegalArgumentException(VECTORS_NOT_IN_R3);
        }

        // calculate the values for the plane
        plane[0] = vector[0];
        plane[1] = vector[1];
        plane[THREE_DIMENSION - 1] = vector[THREE_DIMENSION - 1];
        plane[THREE_DIMENSION] = vector[0] * point[0] + vector[1] * point[1]
                + vector[THREE_DIMENSION - 1] * point[THREE_DIMENSION - 1];

        return reduceCoefficientsPlane(plane);
    }

    /**
     * This method determines the intersection between a line and a plane in R3.
     * 
     * @param line  The line used to find intersection
     * @param plane The plane used to find intersection
     * @return The intersection between the line and plane if it exists
     * @throws IllegalArgumentException if the line or plane is not in R3
     */
    public double[] intersectionOfLineAndPlane(double[] line, double[] plane) throws IllegalArgumentException {
        // dot product of line and plane
        double dotProduct;
        // time component of intersection
        double time;
        // directional vector of the line
        double[] directionVector = new double[plane.length - 1];
        // intersection of the line and plane
        double[] intersection = new double[plane.length - 1];
        // orthogonal vector of the plane
        double[] orthogonalVector = new double[plane.length - 1];

        // check if line is in R3
        if (line.length != THREE_DIMENSION + THREE_DIMENSION) {
            throw new IllegalArgumentException(LINES_NOT_IN_R3);
        }

        // check if plane is in R3
        if (plane.length != THREE_DIMENSION + 1) {
            throw new IllegalArgumentException(PLANES_NOT_IN_R3);
        }

        // fill directional vector and orthogonal vector
        directionVector[0] = line[THREE_DIMENSION];
        directionVector[1] = line[THREE_DIMENSION + 1];
        directionVector[THREE_DIMENSION - 1] = line[line.length - 1];
        orthogonalVector[0] = plane[0];
        orthogonalVector[1] = plane[1];
        orthogonalVector[THREE_DIMENSION - 1] = plane[THREE_DIMENSION - 1];

        // calculate dot product
        dotProduct = dotProductTwoVectors(directionVector, orthogonalVector);

        // if dot product is 0, there is no intersection
        if (dotProduct == 0) {
            return null;
        }

        // calculate intersection
        time = (-1 * plane[THREE_DIMENSION] - plane[0] * line[0] - plane[1] * line[1]
                - plane[THREE_DIMENSION - 1] * line[THREE_DIMENSION - 1])
                / (plane[0] * line[THREE_DIMENSION] + plane[1] * line[THREE_DIMENSION + 1]
                        + plane[THREE_DIMENSION - 1] * line[line.length - 1]);
        intersection[0] = line[THREE_DIMENSION] * time + line[0];
        intersection[1] = line[THREE_DIMENSION + 1] * time + line[1];
        intersection[THREE_DIMENSION - 1] = line[THREE_DIMENSION] * time + line[THREE_DIMENSION - 1];

        return intersection;
    }

    /**
     * This method calculates the intersection of two planes in R3.
     * 
     * @param plane_one The first plane
     * @param plane_two The second plane
     * @return The intersection of the two planes if it exists
     */
    public double[] intersectionOfTwoPlanes(double[] plane_one, double[] plane_two) {
        // cross product of the two planes
        double[] crossProduct = new double[plane_one.length - 1];
        // intersection of the two planes
        double[] intersection = new double[THREE_DIMENSION + THREE_DIMENSION];
        // orthogonal vector for the first plane
        double[] orthogonalVectorP1 = new double[plane_one.length - 1];
        // orthogonal vector for the second plane
        double[] orthogonalVectorP2 = new double[plane_two.length - 1];

        // reverse sign for last component of the planes
        plane_one[plane_one.length - 1] *= -1;
        plane_two[plane_two.length - 1] *= -1;

        // find orthogonal vectors
        orthogonalVectorP1[0] = plane_one[0];
        orthogonalVectorP1[1] = plane_one[1];
        orthogonalVectorP1[THREE_DIMENSION - 1] = plane_one[THREE_DIMENSION - 1];
        orthogonalVectorP2[0] = plane_two[0];
        orthogonalVectorP2[1] = plane_two[1];
        orthogonalVectorP2[THREE_DIMENSION - 1] = plane_two[THREE_DIMENSION - 1];

        // calculate the components of intersection
        intersection[0] = (plane_two[THREE_DIMENSION] * plane_one[1] - plane_two[1] * plane_one[THREE_DIMENSION])
                / (plane_one[1] * plane_two[0] - plane_one[0] * plane_two[1]);
        intersection[1] = (plane_one[THREE_DIMENSION] - plane_one[0] * intersection[0]) / plane_one[1];
        intersection[THREE_DIMENSION - 1] = 0;
        crossProduct = crossProductOfTwoVectors(orthogonalVectorP1, orthogonalVectorP2);
        intersection[THREE_DIMENSION] = crossProduct[0];
        intersection[THREE_DIMENSION + 1] = crossProduct[1];
        intersection[intersection.length - 1] = crossProduct[THREE_DIMENSION - 1];

        return intersection;
    }
}