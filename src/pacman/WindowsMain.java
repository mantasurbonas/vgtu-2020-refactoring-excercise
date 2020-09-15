package pacman;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class WindowsMain extends JFrame{

	private GameLevel level;
	private GameRules gameRules;
	private Renderer renderer;

	public WindowsMain() throws IOException {
		super.setPreferredSize(new Dimension(1500, 900));
		super.pack();
		super.setVisible(true);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		GameMap map = new GameMap();
		Pacman pacman = new Pacman( new Position(10,10) );
		List<Ghost> ghosts = new ArrayList<>();
			ghosts.add(new Ghost( new Position(15, 13),  -1, 0));
			ghosts.add(new Ghost( new Position(17, 10),  0,  1));
			
		this.level = new GameLevel(map, pacman, ghosts);
		
		this.gameRules = new GameRules(level);

		this.renderer = new WindowsRenderer();
		
		super.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}			
			
			@Override
			public void keyPressed(KeyEvent e) {
				char command = e.getKeyChar();
				repaint();
				
				gameRules.processUserInput(command);
			}
		});
		
		new Timer(300, e -> {
			repaint();

			gameRules.moveGhosts();
		}).start();
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		this.renderer.render(graphics, this.level);
	}
	
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> {
			try {
				new WindowsMain();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	
	private static final long serialVersionUID = 1L;

}
