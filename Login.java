import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login extends WindowAdapter implements ActionListener {
	static Frame f;
	static JTextField id, pwd;
	static JButton b;
	static String I = "kosea";
	static String P = "2019a";
	static JLabel l, lb, lb2, lb3;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void startFrame() {
		f = new Frame("로그인");
		b = new JButton("접속") {
			public void setBorder(Border border) {

			}
		};
		b.setForeground(Color.white);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
		b.setBounds(185, 271, 40, 20);
		f.setBounds(230, 80, 410, 500);
		f.setLayout(null);
		b.addActionListener(this);
		f.addWindowListener(this);
		l = new JLabel();
		l.setBounds(0, 0, 410, 500);
		l.setIcon(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\Login.png"));

		lb = new JLabel("ID : ", JLabel.RIGHT);
		lb2 = new JLabel("Password : ", JLabel.RIGHT);
		lb.setBounds(75, 165, 70, 20);
		lb2.setBounds(75, 205, 70, 20);
		lb.setForeground(Color.white);
		lb2.setForeground(Color.white);
		lb3 = new JLabel("", JLabel.LEFT);
		lb3.setBounds(185, 235, 190, 20);
		lb3.setBackground(Color.black);

		id = new JTextField(10);
		id.setBounds(185, 165, 150, 20);
		pwd = new JTextField(10);
		pwd.setBounds(185, 205, 150, 20);

		f.add(lb);
		f.add(id);
		f.add(lb2);
		f.add(pwd);
		f.add(b);
		f.add(l);
		l.add(lb3);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		id.getText();
		pwd.getText();
		if (e.getActionCommand().equals("접속")) {
			if (id.getText().equals("")) {
				lb3.setText("ID를 입력하세요.");
				lb3.setForeground(Color.red);
			} else if (pwd.getText().equals("")) {
				lb3.setText("비밀번호를 입력하세요.");
				lb3.setForeground(Color.red);
			} else if (id.getText().equals(I) && pwd.getText().equals(P)) {
				
				Test t = new Test();
				f.dispose();

			} else {

				lb3.setText("아이디와 비밀번호를 확인해주세요.");
				lb3.setForeground(Color.red);
			}
		}
	}

	public static void main(String[] args) {
		Login lg = new Login();
		lg.startFrame();

	}

}