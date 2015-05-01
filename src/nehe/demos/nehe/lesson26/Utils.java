/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nehe.demos.nehe.lesson26;


/**
 *
 * @author ROMAN
 */
public class Utils {

    public static Point3D getNormalVectorByMatrix(double[] matrix) {
        return new Point3D((float) matrix[0], (float) matrix[1], (float) matrix[2]);
    }

    public static Point3D getPointByMatrix(double[] matrix) {
        Point3D n = getNormalVectorByMatrix(matrix);
        Point3D o = n.multiply((float) (matrix[3] / n.dotProduct(n)));
        return o;
    }

    public static double[] getMatrixByPointAndNormalVectors(Point3D o, Point3D N) {
        double[] arr = new double[4];
        arr[0] = N.x;
        arr[1] = N.y;
        arr[2] = N.z;
        arr[3] = o.multiply(-1).dotProduct(N);
        return arr;
    }

    public static void rorateAroundAxis(Point3D p, Point3D axis, double angle) {
        double[][] matr = MatrixOperations.createRotateMatrixAroundAxis(axis, angle);
        double[][] pointMatrix = new double[][]{{p.x, p.y, p.z}};
        pointMatrix = MatrixOperations.transpose(pointMatrix);
        pointMatrix = MatrixOperations.multiply(matr, pointMatrix);
        p.x = (float) pointMatrix[0][0];
        p.y = (float) pointMatrix[1][0];
        p.z = (float) pointMatrix[2][0];
    }
}
