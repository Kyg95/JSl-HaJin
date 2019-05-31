package yyg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class ManagerMode extends JPanel {

	public static void main(String[] args) {
	}

	HaJinmain hm;
	CardLayout card;
	JTabbedPane tabs;
	JPanel pan5, pan6;
	CustomerSystem pan1;
	SalesManage pan2;
	Reserve pan3;
	Font menufont;
	GoodsSystem pan4;
	JPanel card_pan;
	
	public ManagerMode(HaJinmain hm) {
		
		this.hm = hm;
		card = new CardLayout();
		card_pan = new JPanel(card);
		menufont = new Font("����ü", Font.PLAIN,30);
		tabs = new JTabbedPane();
		pan1 = new CustomerSystem(this);
		pan2 = new SalesManage();
		pan2.setSize(200, 200);
		pan2.setBackground(new Color(153, 255, 255));
		pan3 = new Reserve(this);
		pan3.setSize(200, 200);
		pan3.setBackground(new Color(153, 255, 255));
		pan4 = new GoodsSystem();
		pan4.setPreferredSize(getSize());
		pan4.setBackground(new Color(153, 255, 255));
		pan5 = new JPanel();
		pan5.setBackground(new Color(153, 255, 255));
		pan6 = new JPanel();
		pan6.setBackground(new Color(153, 255, 255));
		tabs.addTab("ȸ������", pan1);
		tabs.addTab("�������", pan2);
		tabs.addTab("  ����  ", pan3);
		tabs.addTab("  ����  ", pan4);
		tabs.addTab("���α׷�", pan5);
		tabs.addTab(" �̺�Ʈ ", pan6);
		card_pan.add(tabs,"tabs");
		this.add("Center", card_pan);
		this.setBounds(300, 300, 700, 600);
		this.setLayout(new BorderLayout());
	}
}

