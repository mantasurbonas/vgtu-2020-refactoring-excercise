package pacman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String s[]) throws IOException {
		
		GameMap map = new GameMap();
		
		Pacman pacman = new Pacman( new Position(10,10) );
			
		List<Ghost> ghosts = new ArrayList<Ghost>();
			ghosts.add(new Ghost( new Position(15, 13),  -1, 0));
			ghosts.add(new Ghost( new Position(17, 10),  0,  1));
			
		GameLevel level = new GameLevel(map, pacman, ghosts);
		
		GameRendered renderer = new GameRendered();
		
		GameRules gameRules = new GameRules(level);
		
		ConsoleInput consoleInput = new ConsoleInput();
		
		while (!gameRules.isGameOver()) {
		
			renderer.renderMap(level);
			
			int key = consoleInput.readConsoleInput();
			
			gameRules.processUserInput(key);
			
			gameRules.moveGhosts();
			
		}
		
		System.out.println("Press any key to continue");
		System.in.read();
	}


}
