package pacman;

import javax.swing.*;
import java.awt.*;

public interface Renderer {

    void render(Graphics graphics, GameLevel level);
}
