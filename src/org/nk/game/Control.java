package org.nk.game;

import java.awt.event.KeyEvent;

import org.nk.engine.*;

public class Control extends Input {

	public Control() {
	}

	@Override
	public void keyPress(KeyEvent e, Game game) {
		if (e.getKeyCode() == 87) {
			Single.player.jumping = true;
		}
		if (e.getKeyCode() == 68) {
			Single.player.movement = 2;
		} else if (e.getKeyCode() == 65) {
			Single.player.movement = 0;
		}
	}

	@Override
	public void keyRelease(KeyEvent e, Game game) {
		if ((e.getKeyCode() == 68) || (e.getKeyCode() == 65)) {
			Single.player.movement = -1;
		}
		if (game.getStateName() == "Play") {
			if (e.getKeyCode() == 27) {
				Single.exit();
			}
		}
	}

	@Override
	public void keyType(KeyEvent e, Game game) {
	}
}
