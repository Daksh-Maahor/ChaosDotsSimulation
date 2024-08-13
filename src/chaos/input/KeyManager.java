package chaos.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
private boolean[] keys;
	
	public boolean dir;

	public KeyManager() {
		keys = new boolean[256];
		init();
	}
	
	private void init() {
		for (int i = 0; i < 256; i++) {
			keys[i] = false;
		}
	}

	public void tick() {
		dir = keys[KeyEvent.VK_G];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_G)
			keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_G)
			keys[e.getKeyCode()] = false;
		else
			keys[e.getKeyCode()] = !keys[e.getKeyCode()];
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
