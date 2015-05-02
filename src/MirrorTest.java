/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nehe.demos.common;

import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class MirrorTest implements GLEventListener, MouseListener {

    private static GLCanvas glcanvas;
    private Point3D first = new Point3D(-10, 25, -30);
    private Point3D second = new Point3D(-10, 5, 10);
    private Point3D third = new Point3D(10, 5, 10);
    private Point3D fourth = new Point3D(10, 25, -30);

    private static void initialize(GL gl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    GLU glu = new GLU();
    GLUT glut = new GLUT();
    // width and height of the window
    int g_width = 900;
    int g_height = 600;
    // light 0 position
    float[] g_light0_pos = {10.0f, 5.0f, 0.0f, 1.0f};
    float g_inc = 0.0f;
    float g_incUp = 0.0f;
// clipping planes
//    double[] eqn1 = {0.0, 1.0, .0, 0.0};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GLCapabilities capabilities = new GLCapabilities();
        // The canvas 
        glcanvas = new GLCanvas(capabilities);
        MirrorTest triangledepthtest = new MirrorTest();
        glcanvas.addGLEventListener(triangledepthtest);
        glcanvas.setSize(900, 600);
        final FPSAnimator animator = new FPSAnimator(glcanvas, 60, true);
        final JFrame frame = new JFrame("3d  Triangle (solid)");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Thread() {
                    @Override
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }.start();
            }
        });
        animator.start();
    }
    private float val = 2;

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        drawable.addMouseListener(this);
        // set the GL clear color - use when the color buffer is cleared
        gl.glClearColor(1.0f, 1.0f, 1.0f, .5f);
        // set the shading model to 'smooth'
        //gl.glShadeModel(GL.GL_SMOOTH);
        // enable depth
        gl.glEnable(GL.GL_DEPTH_TEST);
        // set the front faces of polygons
        //gl.glFrontFace(GL.GL_CCW);
        // set fill mode
        // gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        // set the line width
        gl.glLineWidth(2.0f);

        // enable lighting
        // gl.glEnable(GL.GL_LIGHTING);
        // enable lighting for front
        // gl.glLightModeli(GL.GL_FRONT, GL.GL_TRUE);
        // material have diffuse and ambient lighting 
        gl.glColorMaterial(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE);
        // enable color
        gl.glEnable(GL.GL_COLOR_MATERIAL);

        // enable light 0
        // gl.glEnable(GL.GL_LIGHT0);
    }

    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        //  gl.glLoadIdentity();
        float angle = 0.0f;
        float angleUp = 0.0f;
        IntBuffer buffers = IntBuffer.wrap(new int[]{GL.GL_NONE});

        // get the current color buffer being drawn to
        gl.glGetIntegerv(GL.GL_DRAW_BUFFER, buffers);

        gl.glPushMatrix();
        // rotate the viewpoint
        angle += g_inc;

        angleUp += g_incUp;
        System.out.println("" + angle);
        gl.glTranslatef(-2, -18, -70);
        gl.glRotatef(angle, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(angleUp, 1.0f, 0.0f, 0.0f);

        // set the clear value
        gl.glClearStencil(0x0);
        // clear the stencil buffer
        gl.glClear(GL.GL_STENCIL_BUFFER_BIT);
        // always pass the stencil test
        gl.glStencilFunc(GL.GL_ALWAYS, 0x1, 0x1);
        // set the operation to modify the stencil buffer
        gl.glStencilOp(GL.GL_REPLACE, GL.GL_REPLACE, GL.GL_REPLACE);
        // disable drawing to the color buffer
        gl.glDrawBuffer(GL.GL_NONE);
        // enable stencil
        gl.glEnable(GL.GL_STENCIL_TEST);

        // draw the stencil mask
        gl.glBegin(GL.GL_QUADS);

        mirror(gl, val);

        gl.glEnd();

        // reenable drawing to color buffer
        gl.glDrawBuffer(buffers.get(0));
        // make stencil buffer read only
        gl.glStencilOp(GL.GL_KEEP, GL.GL_KEEP, GL.GL_KEEP);

        // clear the color and depth buffers
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        // draw the mirror image
        gl.glPushMatrix();
        // invert image about xy plane
//        gl.glScalef(1.0f, -1.0f, 1.0f);
        Point3D normal = Utils.getNormalVectorByMatrix(getKefByPoints(first, fourth, third)).multiply(1);
        float[] matr = getReflMatrix(first, normal.normalize());
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(1, 0, 0);
        gl.glVertex3f(0, 0, 0);
        gl.glVertex3f(normal.x * 10, normal.y * 10, normal.z * 10);
        gl.glEnd();
        System.out.println(normal);
        gl.glMultMatrixf(matr, 0);
//        // invert the clipping plane based on the view point
//        if (Math.cos(angle * Math.PI / 180.0) < 0.0) {
//            eqn1[2] = -1.0;
//        } else {
//            eqn1[2] = 1.0;
//        }
        // clip one side of the plane
//        DoubleBuffer db = DoubleBuffer.wrap(eqn1);
//        gl.glClipPlane(GL.GL_CLIP_PLANE0, db);
//        gl.glEnable(GL.GL_CLIP_PLANE0);
        // draw only where the stencil buffer == 1
        gl.glStencilFunc(GL.GL_EQUAL, 0x1, 0x1);
        // draw the object
        render(gl);

        // turn off clipping plane
        gl.glDisable(GL.GL_CLIP_PLANE0);
        gl.glPopMatrix();

        // disable the stencil buffer
        gl.glDisable(GL.GL_STENCIL_TEST);
        // disable drawing to the color buffer
        gl.glDrawBuffer(GL.GL_NONE);

        // draw the mirror pane into depth buffer -
        // to prevent object behind mirror from being render
        gl.glBegin(GL.GL_QUADS);
        mirror(gl, val);
        gl.glEnd();

        // enable drawing to the color buffer
        gl.glDrawBuffer(buffers.get());

        // draw the normal image, without stencil test
        gl.glPushMatrix();
        render(gl);
        gl.glPopMatrix();

        // draw the outline of the mirror
        gl.glColor3f(0.4f, 0.4f, 1.0f);
        gl.glBegin(GL.GL_LINE_LOOP);

        mirror(gl, val);

        gl.glEnd();

        // mirror shine
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glEnable(GL.GL_BLEND);
        gl.glDepthMask(false);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glDisable(GL.GL_LIGHTING);

        gl.glColor4f(1.0f, 1.0f, 1.0f, .2f);
//        gl.glTranslatef(0.0f, 0.0f, (float) (0.001f * eqn1[2]));

        gl.glBegin(GL.GL_QUADS);
        mirror(gl, val);
        gl.glEnd();

        gl.glDisable(GL.GL_BLEND);
        gl.glDepthMask(true);
        gl.glDepthFunc(GL.GL_LESS);
//        gl.glEnable(GL.GL_LIGHTING);

        gl.glPopMatrix();

        gl.glFlush();

//        glut.glut();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // save the new window size
        g_width = width;
        g_height = height;
        final GL gl = drawable.getGL();
        // map the view port to the client area
        gl.glViewport(0, 0, width, height);
        // set the matrix mode to project
        gl.glMatrixMode(GL.GL_PROJECTION);
        // load the identity matrix
        gl.glLoadIdentity();
        // create the viewing frustum
        glu.gluPerspective(45.0, (float) width / (float) height, 1.0, 300.0);
        // set the matrix mode to modelview
        gl.glMatrixMode(GL.GL_MODELVIEW);
        // load the identity matrix
        gl.glLoadIdentity();
        // position the view point
        glu.gluLookAt(0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    //-----------------------------------------------------------------------------
// Name: mirror( )
// Desc: draws mirror pane
//-----------------------------------------------------------------------------
//    void mirror(GL gl, float val) {
//        gl.glVertex3f(val, val, 0.0f);
//        gl.glVertex3f(-val, val, 0.0f);
//        gl.glVertex3f(-val, -val, 0.0f);
//        gl.glVertex3f(val, -val, 0.0f);
//    }
    void mirror(GL gl, float val) {
        gl.glVertex3f(val * first.x, val * first.y, val * first.z);
        gl.glVertex3f(val * second.x, val * second.y, val * second.z);
        gl.glVertex3f(val * third.x, val * third.y, val * third.z);
        gl.glVertex3f(val * fourth.x, val * fourth.y, val * fourth.z);
    }

    private float angle = 0f;
//-----------------------------------------------------------------------------
// Name: render( )
// Desc: draws scene
//-----------------------------------------------------------------------------

    void render(GL gl) {
//        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, FloatBuffer.wrap(g_light0_pos));
        gl.glPushMatrix();

        coordinateAxes(gl);

        gl.glTranslatef(2, 20, 2);
        gl.glRotatef(angle += 0.5, 0, 1, 0);
        gl.glTranslatef(-2, 0, -2);
        firstFigure(gl);
        gl.glTranslatef(0, 7, 2);
        gl.glRotated(angle, 1, 1, 0);
        gl.glTranslatef(0, -7, -2);
        secondFigure(gl);
        gl.glTranslatef(15, 11, 2);
        gl.glRotated(angle, 1, -1, 0);
        gl.glTranslatef(-15, -11, -2);
        thirdFigure(gl);
        gl.glRotated(-angle, 1, -1, 0);
        gl.glRotated(-angle, 1, 1, 0);
        gl.glRotatef(-angle, 0, 1, 0);

        gl.glPopMatrix();

    }

    void coordinateAxes(GL gl) {
        // oX
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(0f, 0f, 0f);
        gl.glVertex3f(0f, 0f, 0f);
        gl.glVertex3f(50f, 0f, 0f);
        gl.glEnd();

        // oY
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(0f, 0f, 0f);
        gl.glVertex3f(0f, 0f, 0f);
        gl.glVertex3f(0f, 50f, 0f);
        gl.glEnd();

        // oZ
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(0f, 0f, 0f);
        gl.glVertex3f(0f, 0f, 0f);
        gl.glVertex3f(0f, 0f, 50f);
        gl.glEnd();
    }

    void firstFigure(GL gl) {
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(4f, 0f, 0f);
        gl.glVertex3f(4f, 7f, 0f);
        gl.glVertex3f(0f, 11f, 0f);
        gl.glVertex3f(0f, 0f, 0f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1f, 0.0f, 0f);
        gl.glVertex3f(4f, 0f, 4f);
        gl.glVertex3f(4f, 7f, 4f);
        gl.glVertex3f(0f, 11f, 4f);
        gl.glVertex3f(0f, 0f, 4f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1f, 0f, 1f);
        gl.glVertex3f(4f, 0f, 4f);
        gl.glVertex3f(4f, 0f, 0f);
        gl.glVertex3f(4f, 7f, 0f);
        gl.glVertex3f(4f, 7f, 4f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1f, 0f, 1f);
        gl.glVertex3f(0f, 0f, 4f);
        gl.glVertex3f(0f, 0f, 0f);
        gl.glVertex3f(0f, 11f, 0f);
        gl.glVertex3f(0f, 11f, 4f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1f, 0f, 0f);
        gl.glVertex3f(0f, 0f, 0f);
        gl.glVertex3f(0f, 0f, 4f);
        gl.glVertex3f(4f, 0f, 4f);
        gl.glVertex3f(4f, 0f, 0f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(0f, 11f, 0f);
        gl.glVertex3f(0f, 11f, 4f);
        gl.glVertex3f(4f, 7f, 4f);
        gl.glVertex3f(4f, 7f, 0f);
        gl.glEnd();
    }

    void thirdFigure(GL gl) {
        //front
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0.5f, 0.8f, 0f);
        gl.glVertex3f(15f, 3f, 0f);
        gl.glVertex3f(15f, 7f, 0f);
        gl.glVertex3f(19f, 11f, 0f);
        gl.glVertex3f(19f, 3f, 0f);
        gl.glEnd();
//back
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1f, 0.8f, 0f);
        gl.glVertex3f(15f, 3f, 4f);
        gl.glVertex3f(15f, 7f, 4f);
        gl.glVertex3f(19f, 11f, 4f);
        gl.glVertex3f(19f, 3f, 4f);
        gl.glEnd();
//left
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1f, 0f, 1f);
        gl.glVertex3f(15f, 3f, 4f);
        gl.glVertex3f(15f, 3f, 0f);
        gl.glVertex3f(15f, 7f, 0f);
        gl.glVertex3f(15f, 7f, 4f);
        gl.glEnd();
//right
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1f, 0f, 1f);
        gl.glVertex3f(19f, 3f, 4f);
        gl.glVertex3f(19f, 3f, 0f);
        gl.glVertex3f(19f, 11f, 0f);
        gl.glVertex3f(19f, 11f, 4f);
        gl.glEnd();

        //bottom
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1f, 0f, 0f);
        gl.glVertex3f(15f, 3f, 0f);
        gl.glVertex3f(15f, 3f, 4f);
        gl.glVertex3f(19f, 3f, 4f);
        gl.glVertex3f(19f, 3f, 0f);
        gl.glEnd();
//top
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(19f, 11f, 0f);
        gl.glVertex3f(19f, 11f, 4f);
        gl.glVertex3f(15f, 7f, 4f);
        gl.glVertex3f(15f, 7f, 0f);
        gl.glEnd();
    }

    void secondFigure(GL gl) {

        //bottom 
        gl.glBegin(GL.GL_QUADS);

        gl.glColor3f(0f, 0f, 1f);
        gl.glVertex3f(15f, 7f, 0f);
        gl.glVertex3f(15f, 7f, 4f);
        gl.glVertex3f(4f, 7f, 4f);
        gl.glVertex3f(4f, 7f, 0f);
        gl.glEnd();
//top

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0f, 0f, 1f);
        gl.glVertex3f(19f, 11f, 0f);
        gl.glVertex3f(19f, 11f, 4f);
        gl.glVertex3f(0f, 11f, 4f);
        gl.glVertex3f(0f, 11f, 0f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0f, 0f, 1f);
        gl.glVertex3f(0f, 11f, 0f);
        gl.glVertex3f(0f, 11f, 4f);
        gl.glVertex3f(4f, 7f, 4f);
        gl.glVertex3f(4f, 7f, 0f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0f, 1f, 1f);
        gl.glVertex3f(0f, 11f, 0f);
        gl.glVertex3f(4f, 7f, 0f);
        gl.glVertex3f(15f, 7f, 0f);
        gl.glVertex3f(19f, 11f, 0f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0f, 1f, 1f);
        gl.glVertex3f(0f, 11f, 4f);
        gl.glVertex3f(4f, 7f, 4f);
        gl.glVertex3f(15f, 7f, 4f);
        gl.glVertex3f(19f, 11f, 4f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0f, 0f, 1f);
        gl.glVertex3f(19f, 11f, 0f);
        gl.glVertex3f(19f, 11f, 4f);
        gl.glVertex3f(15f, 7f, 4f);
        gl.glVertex3f(15f, 7f, 0f);
        gl.glEnd();
    }

    public void mouseClicked(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {
//        if (me.getButton() == MouseEvent.BUTTON1) {
//            g_inc -= INC_VAL;
//
//        } else if (me.getButton() == MouseEvent.BUTTON2) {
//            g_inc -= INC_VAL;
//        } else {
//            g_inc = 0.0f;
//        }
//        glcanvas.display();
    }

    private float INC_VAL = 2.0f;

    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            g_inc += INC_VAL;

        } else if (me.getButton() == MouseEvent.BUTTON2) {
            g_inc -= INC_VAL;
        } else {
            g_incUp += INC_VAL;
        }
        glcanvas.display();

    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    void reflectionmatrix(float[][] reflection_matrix,
            float[] p,
            float[] v) {
        float pv = p[0] * v[0] + p[1] * v[1] + p[2] * v[2];

        reflection_matrix[0][0] = 1 - 2 * v[0] * v[0];
        reflection_matrix[1][0] = - 2 * v[0] * v[1];
        reflection_matrix[2][0] = - 2 * v[0] * v[2];
        reflection_matrix[3][0] = 2 * pv * v[0];

        reflection_matrix[0][1] = - 2 * v[0] * v[1];
        reflection_matrix[1][1] = 1 - 2 * v[1] * v[1];
        reflection_matrix[2][1] = - 2 * v[1] * v[2];
        reflection_matrix[3][1] = 2 * pv * v[1];

        reflection_matrix[0][2] = - 2 * v[0] * v[2];
        reflection_matrix[1][2] = - 2 * v[1] * v[2];
        reflection_matrix[2][2] = 1 - 2 * v[2] * v[2];
        reflection_matrix[3][2] = 2 * pv * v[2];

        reflection_matrix[0][3] = 0;
        reflection_matrix[1][3] = 0;
        reflection_matrix[2][3] = 0;
        reflection_matrix[3][3] = 1;
    }

    private float[] getReflMatrix(Point3D point, Point3D vector) {
        float[][] res = new float[4][4];
        float[] points = new float[]{point.x, point.y, point.z};
        float[] vectors = new float[]{vector.x, vector.y, vector.z};
        reflectionmatrix(res, points, vectors);
        float[] sss = new float[res.length * res[0].length];
        int zz = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                sss[zz++] = res[i][j];
                System.out.print(res[i][j] + " ");
            }
            System.out.println("");
        }
        return sss;
    }

    public double[] getKefByPoints(Point3D a, Point3D b, Point3D c) {
        double[] arr = new double[4];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 0;
        arr[3] = 0;
//        double[][] A = new double[][]{{1, a.y, a.z}, {1, b.y, b.z}, {1, c.y, c.z}};
//        double[][] B = new double[][]{{a.x, 1, a.z}, {b.x, 1, b.z}, {c.x, 1, c.z}};
//        double[][] C = new double[][]{{a.x, a.y, 1}, {b.x, b.y, 1}, {c.x, c.y, 1}};
//        double[][] D = new double[][]{{a.z, a.y, a.x}, {b.y, b.y, b.x}, {c.y, c.y, c.x}};
//        arr[0] = (float) MatrixOperations.det(MatrixOperations.transpose(A));
//        arr[1] = (float) MatrixOperations.det(MatrixOperations.transpose(B));
//        arr[2] = (float) MatrixOperations.det(MatrixOperations.transpose(C));
//        arr[3] = (float) MatrixOperations.det(MatrixOperations.transpose(D));
//        return arr;
        double k2 = a.x - b.x;

        if (k2 == 0) {
            return arr;
        }

        //-------------------
        arr[0] = a.y * (b.z - c.z) + b.y * (c.z - a.z) + c.y * (a.z - b.z);
        arr[1] = a.z * (b.x - c.x) + b.z * (c.x - a.x) + c.z * (a.x - b.x);
        arr[2] = a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y);
        arr[3] = -(a.x * (b.y * c.z - c.y * b.z) + b.x * (c.y * a.z - a.y * c.z)
                + c.x * (a.y * b.z - b.y * a.z));
        return arr;

    }
//    public double[] getKefByPoints(Point3D a, Point3D b, Point3D c) {
//        double[] arr = new double[4];
//        double[][] A = new double[][]{{1, b.y, c.z}, {1, b.y, c.z}, {1, b.y, c.z}};
//        double[][] B = new double[][]{{a.x, 1, c.z}, {a.x, 1, c.z}, {a.x, 1, c.z}};
//        double[][] C = new double[][]{{a.x, b.y, 1}, {a.x, b.y, 1}, {a.x, b.y, 1}};
//        double[][] D = new double[][]{{a.x, b.y, c.z}, {a.x, b.y, c.z}, {a.x, b.y, c.z}};
//        arr[0] = (float) MatrixOperations.det(MatrixOperations.transpose(A));
//        arr[1] = (float) MatrixOperations.det(MatrixOperations.transpose(B));
//        arr[2] = (float) MatrixOperations.det(MatrixOperations.transpose(C));
//        arr[3] = -(float) MatrixOperations.det(D);
//        return arr;
//    }
}
