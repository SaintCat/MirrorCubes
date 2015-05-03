package nehe.demos.common;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * Created by oyakovlev on 28.03.2015.
 */
public class KeyboardController implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()) {
            case VK_W:
                Common.cameraAngleX+=1.0f;
                break;
            case VK_A:
                Common.cameraAngleY-=1.0f;
                break;
            case VK_S:
                Common.cameraAngleX-=1.0f;
                break;
            case VK_D:
                Common.cameraAngleY+=1.0f;
                break;
            case VK_Q:
                Common.cameraAngleZ-=1.0f;
                break;
            case VK_E:
                Common.cameraAngleZ+=1.0f;
                break;
            case VK_LEFT:
                Common.cameraOffsetX-=1.0f;
                break;
            case VK_RIGHT:
                Common.cameraOffsetX+=1.0f;
                break;
            case VK_UP:
                Common.cameraOffsetY+=1.0f;
                break;
            case VK_DOWN:
                Common.cameraOffsetY-=1.0f;
                break;
            case VK_PAGE_UP:
                Common.cameraOffsetZ+=1.0f;
                break;
            case VK_PAGE_DOWN:
                Common.cameraOffsetZ-=1.0f;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
