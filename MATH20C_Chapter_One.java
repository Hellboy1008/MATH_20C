
//龍ONE

import java.util.Scanner;
import java.util.Arrays;

public class MATH20C_Chapter_One {

    public static int[] line_1 = new int[6];
    public static int[] line_2 = new int[6];
    public static int[][] matrix = new int[3][3];
    public static int[] plane_1 = new int[4];
    public static int[] plane_2 = new int[4];
    public static int[] point_1 = new int[3];
    public static int[] point_2 = new int[3];
    public static int[] point_3 = new int[3];
    public static int[] vector_1 = new int[3];
    public static int[] vector_2 = new int[3];
    public static int[] vector_3 = new int[3];

    public static void main(String[] args) {
        boolean answerQuestion = true;
        int topic;
        while (answerQuestion == true) {
            Scanner scan = new Scanner(System.in);
            System.out.println(
                    "What do you want to solve? Choose from the following options and type the corresponding number:");
            System.out.println(
                    "1: Line from two vectors, 2: Intersection of two lines 3: Magnitude of a vector, 4: Dot product of two vectors");
            System.out.println(
                    "5: Unit vector, 6: Angle between two vectors, 7: Orthogonal projection of two vectors, 8: Determinant of 3x3 matrix");
            System.out.println(
                    "9: Cross product of two vectors, 10: Area of parallelogram spanned by two vectors, 11: Volume of parallelepiped spanned by three vectors");
            System.out.println(
                    "12: Determine if three vectors are coplanar, 13: Equation of a plane given three points, 14: Equation of a plane given normal vector and point");
            System.out.println("15: Intersection of line and plane, 16: Intersection of two planes");
            System.out.println("Type 0 to end the program");
            topic = scan.nextInt();
            // solve question given the topics
            String lineOne;
            String lineTwo;
            String matrixOne;
            String planeOne;
            String planeTwo;
            String pointOne;
            String pointTwo;
            String pointThree;
            String vectorOne;
            String vectorTwo;
            String vectorThree;
            switch (topic) {
            case 0:
                answerQuestion = false;
                break;
            case 1:
            case 4:
            case 6:
            case 7:
            case 9:
            case 10:
                // prompt user
                System.out.println("Enter the vectors in the form (x,y,z)");
                System.out.println("First Vector:");
                vectorOne = scan.next();
                System.out.println("Second Vector:");
                vectorTwo = scan.next();
                // put user input into arrays
                interpretString(vectorOne, "vector", 1);
                interpretString(vectorTwo, "vector", 2);
                // solve question
                if (topic == 1) {
                    topicOne(vector_1, vector_2);
                } else if (topic == 4) {
                    topicFour(vector_1, vector_2);
                } else if (topic == 6) {
                    topicSix(vector_1, vector_2);
                } else if (topic == 7) {
                    topicSeven(vector_1, vector_2);
                } else if (topic == 9) {
                    topicNine(vector_1, vector_2);
                } else if (topic == 10) {
                    topicTen(vector_1, vector_2);
                }
                break;
            case 2:
                // prompt user
                System.out.println("Given the form l(t) = (a,b,c) + t(x,y,z)");
                System.out.println("Enter the lines like this: (a,b,c,x,y,z)");
                System.out.println("First Line:");
                lineOne = scan.next();
                System.out.println("Second Line:");
                lineTwo = scan.next();
                // put user input into arrays
                interpretString(lineOne, "line", 1);
                interpretString(lineTwo, "line", 2);
                // solve question
                topicTwo(line_1, line_2);
                break;
            case 3:
            case 5:
                // prompt user
                System.out.println("Enter the vector in the form (x,y,z):");
                vectorOne = scan.next();
                // put user input into arrays
                interpretString(vectorOne, "vector", 1);
                // solve question
                if (topic == 3) {
                    topicThree(vector_1);
                } else if (topic == 5) {
                    topicFive(vector_1);
                }
                break;
            case 8:
                // prompt user
                System.out.println("Enter the 3d matrix in this order:");
                System.out.println("(a1,a2,a3,b1,b2,b3,c1,c2,c3)");
                matrixOne = scan.next();
                // put user input into arrays
                interpretString(matrixOne, "matrix", 1);
                // solve question
                topicEight(matrix);
                break;
            case 11:
            case 12:
                // prompt user
                System.out.println("Enter the vectors in the form (x,y,z)");
                System.out.println("First Vector:");
                vectorOne = scan.next();
                System.out.println("Second Vector:");
                vectorTwo = scan.next();
                System.out.println("Third Vector:");
                vectorThree = scan.next();
                // put user input into arrays
                interpretString(vectorOne, "vector", 1);
                interpretString(vectorTwo, "vector", 2);
                interpretString(vectorThree, "vector", 3);
                // solve question
                if (topic == 11) {
                    topicEleven(vector_1, vector_2, vector_3);
                } else if (topic == 12) {
                    topicTwelve(vector_1, vector_2, vector_3);
                }
                break;
            case 13:
                // prompt user
                System.out.println("Enter the points in the form (x,y,z)");
                System.out.println("First Point:");
                pointOne = scan.next();
                System.out.println("Second Point:");
                pointTwo = scan.next();
                System.out.println("Third Point:");
                pointThree = scan.next();
                // put user input into arrays
                interpretString(pointOne, "point", 1);
                interpretString(pointTwo, "point", 2);
                interpretString(pointThree, "point", 3);
                // solve question
                topicThirteen(point_1, point_2, point_3);
                break;
            case 14:
                // prompt user
                System.out.println("Enter the vector in the form (x,y,z)");
                System.out.println("Vector:");
                vectorOne = scan.next();
                System.out.println("Enter the point in the form (x,y,z)");
                System.out.println("Point:");
                pointOne = scan.next();
                // put user input into arrays
                interpretString(pointOne, "point", 1);
                interpretString(vectorOne, "vector", 1);
                // solve question
                topicFourteen(vector_1, point_1);
                break;
            case 15:
                // prompt user
                System.out.println("Given the form l(t) = (a,b,c) + t(x,y,z)");
                System.out.println("Enter the line like this: (a,b,c,x,y,z)");
                System.out.println("Line:");
                lineOne = scan.next();
                System.out.println("Given the form P = Ax + By + Cz + D = 0");
                System.out.println("Enter the plane like this: (A,B,C,D)");
                System.out.println("Plane:");
                planeOne = scan.next();
                // put user input into arrays
                interpretString(lineOne, "line", 1);
                interpretString(planeOne, "plane", 1);
                // solve question
                topicFifthteen(line_1, plane_1);
                break;
            case 16:
                // prompt user
                System.out.println("Given the form P = Ax + By + Cz + D = 0");
                System.out.println("Enter the planes like this: (A,B,C,D)");
                System.out.println("Plane 1:");
                planeOne = scan.next();
                System.out.println("Plane 2:");
                planeTwo = scan.next();
                // put user input into arrays
                interpretString(planeOne, "plane", 1);
                interpretString(planeTwo, "plane", 2);
                // solve question
                topicSixteen(plane_1, plane_2);
                break;
            }
        }
    }

    // line from two vectors
    public static void topicOne(int[] vector_one, int[] vector_two) {
        int[] answer_line = new int[6];
        answer_line[0] = vector_one[0];
        answer_line[1] = vector_one[1];
        answer_line[2] = vector_one[2];
        answer_line[3] = vector_two[0] - vector_one[0];
        answer_line[4] = vector_two[1] - vector_one[1];
        answer_line[5] = vector_two[2] - vector_one[2];
        System.out.println("Line: (" + answer_line[0] + "," + answer_line[1] + "," + answer_line[2] + ") + t("
                + answer_line[3] + "," + answer_line[4] + "," + answer_line[5] + ")");
    }

    // intersection of two lines
    public static void topicTwo(int[] line_one, int[] line_two) {
        double a = (double) (line_one[3]);
        double b = (double) (-1 * line_two[3]);
        double c = (double) (line_two[0] - line_one[0]);
        double d = (double) (line_one[4]);
        double e = (double) (-1 * line_two[4]);
        double f = (double) (line_two[1] - line_one[1]);
        double x = (f * b - e * c) / (b * d - a * e);
        double y = (c - a * x) / b;
        if (line_one[2] + line_one[5] * x == line_two[2] + line_two[5] * y) {
            double xCor = line_one[0] + line_one[3] * x;
            double yCor = line_one[1] + line_one[4] * x;
            double zCor = line_one[2] + line_one[5] * x;
            System.out.println("The two lines intersect at:");
            System.out.println("(" + xCor + "," + yCor + "," + zCor + ")");
        } else {
            System.out.println("The two lines don't intersect");
        }
    }

    // magnitude of a vector
    public static double topicThree(int[] vector_one) {
        double answer_number;
        answer_number = Math.sqrt(Math.pow(vector_one[0], 2) + Math.pow(vector_one[1], 2) + Math.pow(vector_one[2], 2));
        System.out.println("Magnitude = " + answer_number);
        return answer_number;
    }

    // dot product of two vectors
    public static void topicFour(int[] vector_one, int[] vector_two) {
        int answer_number = 0;
        answer_number = vector_one[0] * vector_two[0] + vector_one[1] * vector_two[1] + vector_one[2] * vector_two[2];
        System.out.println(answer_number);
    }

    // unit vector
    public static void topicFive(int[] vector_one) {
        double[] answer_vector = new double[3];
        double magnitude = Math
                .sqrt(Math.pow(vector_one[0], 2) + Math.pow(vector_one[1], 2) + Math.pow(vector_one[2], 2));
        answer_vector[0] = (double) (vector_one[0]) / magnitude;
        answer_vector[1] = (double) (vector_one[1]) / magnitude;
        answer_vector[2] = (double) (vector_one[2]) / magnitude;
        System.out.println("Vector: (" + answer_vector[0] + "," + answer_vector[1] + "," + answer_vector[2] + ")");
    }

    // angle between two vectors
    public static void topicSix(int[] vector_one, int[] vector_two) {
        double answer_angle = 0;
        double dot_product = vector_one[0] * vector_two[0] + vector_one[1] * vector_two[1]
                + vector_one[2] * vector_two[2];
        double magnitude_vector_one = Math
                .sqrt(Math.pow(vector_one[0], 2) + Math.pow(vector_one[1], 2) + Math.pow(vector_one[2], 2));
        double magnitude_vector_two = Math
                .sqrt(Math.pow(vector_two[0], 2) + Math.pow(vector_two[1], 2) + Math.pow(vector_two[2], 2));
        answer_angle = Math.acos(dot_product / (magnitude_vector_one * magnitude_vector_two));
        System.out.println("Angle = " + answer_angle);
    }

    // orthogonal projection of two vectors
    public static void topicSeven(int[] vector_one, int[] vector_two) {
        double[] answer_vector = new double[3];
        double magnitude_vector_two = Math
                .sqrt(Math.pow(vector_two[0], 2) + Math.pow(vector_two[1], 2) + Math.pow(vector_two[2], 2));
        double dot_product = vector_one[0] * vector_two[0] + vector_one[1] * vector_two[1]
                + vector_one[2] * vector_two[2];
        answer_vector[0] = (dot_product / Math.pow(magnitude_vector_two, 2)) * vector_two[0];
        answer_vector[1] = (dot_product / Math.pow(magnitude_vector_two, 2)) * vector_two[1];
        answer_vector[2] = (dot_product / Math.pow(magnitude_vector_two, 2)) * vector_two[2];
        System.out.println("The orthogonal projection of vector 1 on vector 2 is: (" + answer_vector[0] + ","
                + answer_vector[1] + "," + answer_vector[2] + ")");
    }

    // determinant of 3x3 matrix
    public static void topicEight(int[][] matrix_one) {
        int answer_number = 0;
        int i_component = matrix_one[0][0]
                * (matrix_one[1][1] * matrix_one[2][2] - matrix_one[1][2] * matrix_one[2][1]);
        int j_component = matrix_one[0][1]
                * (matrix_one[1][0] * matrix_one[2][2] - matrix_one[1][2] * matrix_one[2][0]);
        int k_component = matrix_one[0][2]
                * (matrix_one[1][0] * matrix_one[2][1] - matrix_one[1][1] * matrix_one[2][0]);
        answer_number = i_component - j_component + k_component;
        System.out.println("The determinant is: " + answer_number);
    }

    // cross product of two vectors
    public static void topicNine(int[] vector_one, int[] vector_two) {
        int[] answer_vector = new int[3];
        answer_vector[0] = vector_one[1] * vector_two[2] - vector_one[2] * vector_two[1];
        answer_vector[1] = -1 * (vector_one[0] * vector_two[2] - vector_one[2] * vector_two[0]);
        answer_vector[2] = vector_one[0] * vector_two[1] - vector_one[1] * vector_two[0];
        System.out.println(
                "The cross product is: (" + answer_vector[0] + "," + answer_vector[1] + "," + answer_vector[2] + ")");
    }

    // area of parallelogram spanned by two vectors
    public static void topicTen(int[] vector_one, int[] vector_two) {
        double answer_number = 0;
        int cross_product_icomponent = vector_one[1] * vector_two[2] - vector_one[2] * vector_two[1];
        int cross_product_jcomponent = -1 * (vector_one[0] * vector_two[2] - vector_one[2] * vector_two[0]);
        int cross_product_kcomponent = vector_one[0] * vector_two[1] - vector_one[1] * vector_two[0];
        answer_number = Math.sqrt(Math.pow(cross_product_icomponent, 2) + Math.pow(cross_product_jcomponent, 2)
                + Math.pow(cross_product_kcomponent, 2));
        System.out.println("Area of parallelogram = " + answer_number);
    }

    // volume of parallelepiped spanned by three vectors
    public static void topicEleven(int[] vector_one, int[] vector_two, int[] vector_three) {
        int answer_number = 0;
        int cross_product_icomponent = vector_one[0]
                * (vector_two[1] * vector_three[2] - vector_two[2] * vector_three[1]);
        int cross_product_jcomponent = -1 * vector_one[1]
                * (vector_two[0] * vector_three[2] - vector_two[2] * vector_three[0]);
        int cross_product_kcomponent = vector_one[2]
                * (vector_two[0] * vector_three[1] - vector_two[1] * vector_three[0]);
        answer_number = Math.abs(cross_product_icomponent + cross_product_jcomponent + cross_product_kcomponent);
        System.out.println("Volume of parallelepiped = " + answer_number);
    }

    // determine if three vectors are coplanar
    public static void topicTwelve(int[] vector_one, int[] vector_two, int[] vector_three) {
        String answer = "";
        int cross_product_icomponent = vector_one[0]
                * (vector_two[1] * vector_three[2] - vector_two[2] * vector_three[1]);
        int cross_product_jcomponent = -1 * vector_one[1]
                * (vector_two[0] * vector_three[2] - vector_two[2] * vector_three[0]);
        int cross_product_kcomponent = vector_one[2]
                * (vector_two[0] * vector_three[1] - vector_two[1] * vector_three[0]);
        int cross_product = Math.abs(cross_product_icomponent + cross_product_jcomponent + cross_product_kcomponent);
        if (cross_product == 0) {
            answer = "Yes";
        } else {
            answer = "No";
        }
        System.out.println(answer);
    }

    // equation of a plane given three points
    public static void topicThirteen(int[] point_one, int[] point_two, int[] point_three) {
        int[] vector_one = new int[3];
        int[] vector_two = new int[3];
        vector_one[0] = point_two[0] - point_one[0];
        vector_one[1] = point_two[1] - point_one[1];
        vector_one[2] = point_two[2] - point_one[2];
        vector_two[0] = point_three[0] - point_two[0];
        vector_two[1] = point_three[1] - point_two[1];
        vector_two[2] = point_three[2] - point_two[2];
        int cross_product_icomponent = vector_one[1] * vector_two[2] - vector_one[2] * vector_two[1];
        int cross_product_jcomponent = -1 * (vector_one[0] * vector_two[2] - vector_one[2] * vector_two[0]);
        int cross_product_kcomponent = vector_one[0] * vector_two[1] - vector_one[1] * vector_two[0];
        // A(x-x0) + B(y-y0) + C(z-z0) = 0
        int equation_d_value = cross_product_icomponent * point_one[0] + cross_product_jcomponent * point_one[1]
                + cross_product_kcomponent * point_one[2];
        String yComponent_sign;
        String zComponent_sign;
        if (cross_product_jcomponent > 0) {
            yComponent_sign = "+ ";
        } else {
            yComponent_sign = "- ";
            cross_product_jcomponent = Math.abs(cross_product_jcomponent);
        }
        if (cross_product_kcomponent > 0) {
            zComponent_sign = "+ ";
        } else {
            zComponent_sign = "- ";
            cross_product_kcomponent = Math.abs(cross_product_kcomponent);
        }
        System.out.println("The equation of the plane is: " + cross_product_icomponent + "x " + yComponent_sign
                + cross_product_jcomponent + "y " + zComponent_sign + cross_product_kcomponent + "z = "
                + equation_d_value);
    }

    // equation of a plane given normal vector and point
    public static void topicFourteen(int[] vector_one, int[] point_one) {
        // A(x-x0) + B(y-y0) + C(z-z0) = 0
        int d_value = vector_one[0] * point_one[0] + vector_one[1] * point_one[1] + vector_one[2] * point_one[2];
        String yComponent_sign;
        String zComponent_sign;
        if (vector_one[1] > 0) {
            yComponent_sign = "+ ";
        } else {
            yComponent_sign = "- ";
            vector_one[1] = Math.abs(vector_one[1]);
        }
        if (vector_one[2] > 0) {
            zComponent_sign = "+ ";
        } else {
            zComponent_sign = "- ";
            vector_one[2] = Math.abs(vector_one[2]);
        }
        System.out.println("The equation of the plane is: " + vector_one[0] + "x " + yComponent_sign + vector_one[1]
                + "y " + zComponent_sign + vector_one[2] + "z = " + d_value);
    }

    // intersection of line and plane
    public static void topicFifthteen(int[] line_one, int[] plane_one) {
        int dot_product = line_one[0] * plane_one[0] + line_one[1] * plane_one[1] + line_one[2] * plane_one[2];
        if (dot_product == 0) {
            System.out.println("The line and the plane do not intersect");
        } else {
            int time = (-1 * plane_one[3] - plane_one[0] * line_one[3] - plane_one[1] * line_one[4]
                    - plane_one[2] * line_one[5]) / (dot_product);
            int xCor = line_one[0] * time + line_one[3];
            int yCor = line_one[1] * time + line_one[4];
            int zCor = line_one[2] * time + line_one[5];
            System.out.println("The line and the plane intersect at (" + xCor + "," + yCor + "," + zCor + ")");
        }
    }

    // intersection of two planes
    public static void topicSixteen(int[] plane_one, int[] plane_two) {
        double a = (double) (plane_one[0]);
        double b = (double) (plane_one[1]);
        double c = (double) (-1 * plane_one[3]);
        double d = (double) (plane_two[0]);
        double e = (double) (plane_two[1]);
        double f = (double) (-1 * plane_two[3]);
        double x = (f * b - e * c) / (b * d - a * e);
        double y = (c - a * x) / b;
        int cross_product_xComp = plane_one[1] * plane_two[2] - plane_one[2] * plane_two[1];
        int cross_product_yComp = -1 * (plane_one[0] * plane_two[2] - plane_one[2] * plane_two[0]);
        int cross_product_zComp = plane_one[0] * plane_two[1] - plane_one[1] * plane_two[0];
        System.out.println("The intersection of the two planes is: (" + x + "," + y + ",0) + t(" + cross_product_xComp
                + "," + cross_product_yComp + "," + cross_product_zComp + ")");
    }

    // interpret string
    public static void interpretString(String input, String type, int number) {
        input = input.substring(1, input.length() - 1); // remove parenthesis
        if (type.equals("vector")) {
            // put values into array
            int counter = 0;
            int[] commaIndex = new int[2];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ',') {
                    commaIndex[counter] = i;
                    counter++;
                }
            }
            if (number == 1) {
                vector_1[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                vector_1[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                vector_1[2] = Integer.parseInt(input.substring(commaIndex[1] + 1));
            } else if (number == 2) {
                vector_2[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                vector_2[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                vector_2[2] = Integer.parseInt(input.substring(commaIndex[1] + 1));
            } else if (number == 3) {
                vector_3[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                vector_3[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                vector_3[2] = Integer.parseInt(input.substring(commaIndex[1] + 1));
            }
        } else if (type.equals("point")) {
            // put values into array
            int counter = 0;
            int[] commaIndex = new int[2];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ',') {
                    commaIndex[counter] = i;
                    counter++;
                }
            }
            if (number == 1) {
                point_1[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                point_1[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                point_1[2] = Integer.parseInt(input.substring(commaIndex[1] + 1));
            } else if (number == 2) {
                point_2[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                point_2[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                point_2[2] = Integer.parseInt(input.substring(commaIndex[1] + 1));
            } else if (number == 3) {
                point_3[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                point_3[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                point_3[2] = Integer.parseInt(input.substring(commaIndex[1] + 1));
            }
        } else if (type.equals("line")) {
            // put values into array
            int counter = 0;
            int[] commaIndex = new int[5];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ',') {
                    commaIndex[counter] = i;
                    counter++;
                }
            }
            if (number == 1) {
                line_1[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                line_1[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                line_1[2] = Integer.parseInt(input.substring(commaIndex[1] + 1, commaIndex[2]));
                line_1[3] = Integer.parseInt(input.substring(commaIndex[2] + 1, commaIndex[3]));
                line_1[4] = Integer.parseInt(input.substring(commaIndex[3] + 1, commaIndex[4]));
                line_1[5] = Integer.parseInt(input.substring(commaIndex[4] + 1));
            } else if (number == 2) {
                line_2[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                line_2[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                line_2[2] = Integer.parseInt(input.substring(commaIndex[1] + 1, commaIndex[2]));
                line_2[3] = Integer.parseInt(input.substring(commaIndex[2] + 1, commaIndex[3]));
                line_2[4] = Integer.parseInt(input.substring(commaIndex[3] + 1, commaIndex[4]));
                line_2[5] = Integer.parseInt(input.substring(commaIndex[4] + 1));
            }
        } else if (type.equals("plane")) {
            // put values into array
            int counter = 0;
            int[] commaIndex = new int[3];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ',') {
                    commaIndex[counter] = i;
                    counter++;
                }
            }
            if (number == 1) {
                plane_1[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                plane_1[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                plane_1[2] = Integer.parseInt(input.substring(commaIndex[1] + 1, commaIndex[2]));
                plane_1[3] = Integer.parseInt(input.substring(commaIndex[2] + 1));
            } else if (number == 2) {
                plane_2[0] = Integer.parseInt(input.substring(0, commaIndex[0]));
                plane_2[1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
                plane_2[2] = Integer.parseInt(input.substring(commaIndex[1] + 1, commaIndex[2]));
                plane_2[3] = Integer.parseInt(input.substring(commaIndex[2] + 1));
            }
        } else if (type.equals("matrix")) {
            // put values into array
            int counter = 0;
            int[] commaIndex = new int[8];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ',') {
                    commaIndex[counter] = i;
                    counter++;
                }
            }
            matrix[0][0] = Integer.parseInt(input.substring(0, commaIndex[0]));
            matrix[0][1] = Integer.parseInt(input.substring(commaIndex[0] + 1, commaIndex[1]));
            matrix[0][2] = Integer.parseInt(input.substring(commaIndex[1] + 1, commaIndex[2]));
            matrix[1][0] = Integer.parseInt(input.substring(commaIndex[2] + 1, commaIndex[3]));
            matrix[1][1] = Integer.parseInt(input.substring(commaIndex[3] + 1, commaIndex[4]));
            matrix[1][2] = Integer.parseInt(input.substring(commaIndex[4] + 1, commaIndex[5]));
            matrix[2][0] = Integer.parseInt(input.substring(commaIndex[5] + 1, commaIndex[6]));
            matrix[2][1] = Integer.parseInt(input.substring(commaIndex[6] + 1, commaIndex[7]));
            matrix[2][2] = Integer.parseInt(input.substring(commaIndex[7] + 1));
        }
    }
}