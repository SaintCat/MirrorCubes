package nehe.demos.nehe.lesson30;

import nehe.demos.common.GLDisplay;

/*--.          .-"-.
/   o_O        / O o \
\_  (__\       \_ v _/
//   \\        //   \\
((     ))      ((     ))
いいいいいいい--""---""--いい--""---""--いいいいいいいいいいいいい
�                 |||            |||                             �
�                  |              |                              �
�                                                                �
� Programmer:Abdul Bezrati                                       �
� Program   :Nehe's 30th lesson port to JOGL                     �
� Comments  :None                                                �
�    _______                                                     �
�  /` _____ `\;,    abezrati@hotmail.com                         �
� (__(^===^)__)';,                                 ___           �
�   /  :::  \   ,;                               /^   ^\         �
�  |   :::   | ,;'                              ( �   � )        �
い�'._______.'`いいいいいいいいいいいいい� --�oOo--(_)--oOo�--い*/

/**
 * @author Abdul Bezrati
 */
public class Lesson30 {
    public static void main(String[] args) {
        GLDisplay neheGLDisplay = GLDisplay.createGLDisplay("Lesson 30: Collision detection");
        Renderer renderer = new Renderer();
        InputHandler inputHandler = new InputHandler(renderer, neheGLDisplay);
        neheGLDisplay.addGLEventListener(renderer);
        neheGLDisplay.addKeyListener(inputHandler);
        neheGLDisplay.start();
    }
}
