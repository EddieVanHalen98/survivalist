package com.evh98.stext.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame{
	
	public static PreAction pa = new PreAction();
	public static Action a = new Action();
	
	public static JLabel line8;
	public static JLabel line7;
	public static JLabel line6;
	public static JLabel line5;
	public static JLabel line4;
	public static JLabel line3;
	public static JLabel line2;
	public static JLabel line1;
	
	public static JTextField input;
	
	public static JButton help;
	public static JButton options;

	public Window(){
		setLayout(null);
		
		line8 = new JLabel("oooOOooo");
		line7 = new JLabel("oooOOooo");
		line6 = new JLabel("oooOOooo");
		line5 = new JLabel("oooOOooo");
		line4 = new JLabel("oooOOooo");
		line3 = new JLabel("oooOOooo");
		line2 = new JLabel("oooOOooo");
		line1 = new JLabel("oooOOooo");
		line8.setFont(new Font("Roboto Lt", Font.PLAIN, 34));
		line7.setFont(new Font("Roboto Lt", Font.PLAIN, 34));
		line6.setFont(new Font("Roboto Lt", Font.PLAIN, 34));
		line5.setFont(new Font("Roboto Lt", Font.PLAIN, 34));
		line4.setFont(new Font("Roboto Lt", Font.PLAIN, 34));
		line3.setFont(new Font("Roboto Lt", Font.PLAIN, 34));
		line2.setFont(new Font("Roboto Lt", Font.PLAIN, 34));
		line1.setFont(new Font("Roboto", Font.PLAIN, 34));
		add(line8);
		add(line7);
		add(line6);
		add(line5);
		add(line4);
		add(line3);
		add(line2);
		add(line1);
		line8.setBounds(30, 15, 900, 38);
		line7.setBounds(30, 60, 900, 38);
		line6.setBounds(30, 105, 900, 38);
		line5.setBounds(30, 150, 900, 38);
		line4.setBounds(30, 195, 900, 38);
		line3.setBounds(30, 240, 900, 38);
		line2.setBounds(30, 285, 900, 38);
		line1.setBounds(30, 330, 900, 38);
		line8.setHorizontalAlignment(JLabel.CENTER);
		line7.setHorizontalAlignment(JLabel.CENTER);
		line6.setHorizontalAlignment(JLabel.CENTER);
		line5.setHorizontalAlignment(JLabel.CENTER);
		line4.setHorizontalAlignment(JLabel.CENTER);
		line3.setHorizontalAlignment(JLabel.CENTER);
		line2.setHorizontalAlignment(JLabel.CENTER);
		line1.setHorizontalAlignment(JLabel.CENTER);
		
		input = new JTextField(JTextField.CENTER);
		input.setFont(new Font("Roboto", Font.PLAIN, 22));
		add(input);
		input.setBounds(160, 390, 640, 30);
		input.setHorizontalAlignment(JTextField.CENTER);
		input.addActionListener(pa);
		
		ImageIcon ico = new ImageIcon("res/logo.png");
		
		setTitle(SurvivalistText.NAME + " " + SurvivalistText.VER + " - The 45 Industries");
		setIconImage(ico.getImage());
		setSize(960,540);
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}