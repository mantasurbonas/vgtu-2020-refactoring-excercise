package pacman;

import java.io.IOException;

public class ConsoleInput {

	public int readConsoleInput() throws IOException {
		int key;
		do {
			key = System.in.read();
		} while(key == 13 || key ==10);
		return key;
	}
}
