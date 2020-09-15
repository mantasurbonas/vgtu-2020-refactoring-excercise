package pacman;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInputHandler {

    public PlayerInput getPlayerInput() {
        PlayerInput input = currentInput;
        resetPlayerInput();
        return input;
    }

    private void setPlayerInput(PlayerInput input) {
        if (currentInput.getPriority() <= input.getPriority()) {
            currentInput = input;
        }
    }

    private void resetPlayerInput() {
        currentInput = PlayerInput.NONE;
    }

    public PlayerInputHandler(JFrame frame) {

        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent event) {
            }

            @Override
            public void keyReleased(KeyEvent event) {
            }

            @Override
            public void keyPressed(KeyEvent event) {
                char command = event.getKeyChar();
                switch (command) {
                    default:
                        resetPlayerInput();
                        break;
                    case 'q':
                        setPlayerInput(PlayerInput.QUIT);
                        break;
                    case 'w':
                        setPlayerInput(PlayerInput.UP);
                        break;
                    case 'd':
                        setPlayerInput(PlayerInput.RIGHT);
                        break;
                    case 's':
                        setPlayerInput(PlayerInput.DOWN);
                        break;
                    case 'a':
                        setPlayerInput(PlayerInput.LEFT);
                        break;
                }
            }
        });
    }

    private PlayerInput currentInput = PlayerInput.NONE;
}
