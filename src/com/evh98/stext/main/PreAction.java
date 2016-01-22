package com.evh98.stext.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreAction implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println(Window.input.getText());
		SurvivalistText.input = Window.input.getText();
		SurvivalistText.init();
	}
}
