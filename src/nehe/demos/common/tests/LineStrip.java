/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nehe.demos.common.tests;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class LineStrip implements GLEventListener {

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL gl = drawable.getGL();
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glVertex3f(-0.50f, -0.75f, 0);
        gl.glVertex3f(0.7f, 0.5f, 0);
        gl.glVertex3f(0.70f, -0.70f, 0);
        gl.glVertex3f(0f, 0.5f, 0);
        gl.glEnd();
    }


    @Override
    public void init(GLAutoDrawable arg0) {
// method body
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
            int arg4) {
// method body
    }

    public static void main(String[] args) {
//getting the capabilities object of GL2 profile
        GLCapabilities capabilities = new GLCapabilities();
// The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        LineStrip r = new LineStrip();
        glcanvas.addGLEventListener(r);
        glcanvas.setSize(400, 400);
//creating frame
        final JFrame frame = new JFrame("LineStrip");
//adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
    }//end of main

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//end of classimport javax.media.opengl.GL2;
