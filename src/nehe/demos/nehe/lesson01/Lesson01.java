package nehe.demos.nehe.lesson01;
//package nehe.demos.nehe.lesson01;

import nehe.demos.common.GLDisplay;
//import nehe.demos.common.GLDisplay;

/**
 * @author Kevin J. Duling
 */
public class Lesson01 {
    public static void main(String[] args) {
        GLDisplay neheGLDisplay = GLDisplay.createGLDisplay("Lesson 01: An OpenGL Window");
        neheGLDisplay.addGLEventListener(new Renderer());
        neheGLDisplay.start();
    }
}
