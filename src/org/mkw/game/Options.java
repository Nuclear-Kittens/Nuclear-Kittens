package org.mkw.game;

import java.awt.Color;
import java.awt.Font;

import org.mkw.engine.Button;
import org.mkw.engine.Game;
import org.mkw.engine.GameContainer;
import org.mkw.engine.Graphics;
import org.mkw.engine.Input;

public class Options extends Game{

	GameContainer gc;
	Input input;
	Button back;
	
	public Options(GameContainer launch, Input input) {
		super(launch);
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Options");
		gc.setTitle("Nuclear Kittens | Options");
		back = new Button(Info.path + "\\res\\button.png", gc.getWidth() / 2 - 125, 10, this, input, "Back");
	}

	@Override
	public void update() {
		if (back.isClicked()) {
			gc.enterState(2);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		g.setColor(Color.black);
		Font font = new Font("Arial", Font.PLAIN, 20);
		g.setFont(font);
		back.render(g);
	}

	@Override
	public int getID() {
		return 5;
	}
}