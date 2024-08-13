package chaos;

import chaos.input.KeyManager;
import chaos.renderer.Renderer;

public class Handler {
	
	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Renderer getRenderer() {
		return game.getRenderer();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

}
