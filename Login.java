import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login extends WindowAdapter implements ActionListener {
	JFrame f, f2;
	TextField id, pwd, tf, tf2, tf3, tf4, tf5;
	JButton b, b2, b3, b4, b5;
	JLabel l, l2, lb, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;
	static String A = "";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void startFrame() {

		Connect();
		f = new JFrame("로그인");
		b = new JButton("접속") {
			public void setBorder(Border border) {

			}
		};
		b.setForeground(Color.white);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
		b.setBounds(245, 271, 40, 20);
		f.setBounds(230, 80, 425, 535);
		f.setLayout(null);
		b.addActionListener(this);
		f.addWindowListener(this);
		l = new JLabel();
		l.setBounds(0, 0, 410, 500);
		l.setIcon(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\중간 프로젝트\\Login.png"));
		b5 = new JButton("회원가입") {
			public void setBorder(Border border) {

			}
		};
		b5.setForeground(Color.white);
		b5.setBorderPainted(false);
		b5.setContentAreaFilled(false);
		b5.setFocusPainted(false);
		b5.setBounds(100, 271, 100, 20);

		lb = new JLabel("ID : ", JLabel.RIGHT);
		lb2 = new JLabel("Password : ", JLabel.RIGHT);
		lb.setBounds(75, 165, 70, 20);
		lb2.setBounds(75, 205, 70, 20);
		lb.setForeground(Color.white);
		lb2.setForeground(Color.white);
		lb3 = new JLabel("", JLabel.LEFT);
		lb3.setBounds(185, 235, 190, 20);
		lb3.setBackground(Color.black);

		id = new TextField(10);
		id.setBounds(185, 165, 150, 20);
		pwd = new TextField(10);
		pwd.setBounds(185, 205, 150, 20);
		pwd.setEchoChar('*');

		f.add(lb);
		f.add(id);
		f.add(lb2);
		f.add(pwd);
		f.add(b);
		f.add(l);
		l.add(lb3);
		l.add(b5);
		f.setVisible(true);

		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Account();

			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("접속")) {

			Match();

		}
	}

	public void Account() {

		f2 = new JFrame("회원가입");
		f2.setLayout(null);
		f2.setBounds(650, 80, 340, 495);
		l2 = new JLabel();
		l2.setBounds(0, 0, 325, 460);
		l2.setIcon(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\중간 프로젝트\\Account.png"));

		tf = new TextField();
		tf.setBounds(105, 80, 120, 20);
		b2 = new JButton("중복");
		b2.setBounds(240, 80, 60, 20);
		b2.setForeground(Color.white);
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setFocusPainted(false);
		tf2 = new TextField();
		tf2.setBounds(105, 130, 120, 20);
		tf2.setEchoChar('*');
		tf3 = new TextField();
		tf3.setBounds(105, 180, 80, 20);
		tf4 = new TextField();
		tf4.setBounds(105, 230, 100, 20);
		tf5 = new TextField();
		tf5.setBounds(105, 280, 150, 20);
		b3 = new JButton("확인");
		b3.setBounds(75, 380, 80, 20);
		b3.setForeground(Color.white);
		b3.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b3.setFocusPainted(false);
		b4 = new JButton("취소");
		b4.setBounds(165, 380, 80, 20);
		b4.setForeground(Color.white);
		b4.setBorderPainted(false);
		b4.setContentAreaFilled(false);
		b4.setFocusPainted(false);
		lb4 = new JLabel();
		lb4.setBounds(105, 105, 150, 20);
		lb5 = new JLabel("아이디", JLabel.LEFT);
		lb5.setForeground(Color.white);
		lb5.setBounds(45, 80, 70, 20);
		lb6 = new JLabel("비밀번호", JLabel.LEFT);
		lb6.setBounds(45, 130, 70, 20);
		lb6.setForeground(Color.white);
		lb7 = new JLabel("이름", JLabel.LEFT);
		lb7.setBounds(45, 180, 70, 20);
		lb7.setForeground(Color.white);
		lb8 = new JLabel("전화번호", JLabel.LEFT);
		lb8.setBounds(45, 230, 70, 20);
		lb8.setForeground(Color.white);
		lb9 = new JLabel("이메일", JLabel.LEFT);
		lb9.setBounds(45, 280, 70, 20);
		lb9.setForeground(Color.white);
		lb10 = new JLabel("", JLabel.LEFT);
		lb10.setBounds(85, 330, 200, 20);
		lb10.setForeground(Color.white);

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Add2();

			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Add();

			}
		});

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				f2.dispose();

			}
		});

		f2.add(b2);
		f2.add(tf);
		f2.add(tf2);
		f2.add(tf3);
		f2.add(tf4);
		f2.add(tf5);
		f2.add(b3);
		f2.add(b4);
		f2.add(lb4);
		f2.add(lb5);
		f2.add(lb6);
		f2.add(lb7);
		f2.add(lb8);
		f2.add(lb9);
		f2.add(lb10);
		f2.add(l2);
		f2.setVisible(true);

	}

	public void Connect() {

		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String user = "kosea";
		String password = "kosea2019a";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
//			System.out.println("접속");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Add() {

		if (tf.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("")
				|| tf5.getText().equals("")) {

			lb10.setText("누락된 입력정보가 있습니다.");
			lb10.setForeground(Color.red);

		} else {

			try {

				String ID = tf.getText(), PW = tf2.getText(), NAME = tf3.getText(), P_NUMBER = tf4.getText(),
						MAIL = tf5.getText();
				String sql = "INSERT INTO ACCOUNT VALUES ('" + ID + "','" + PW + "','" + NAME + "','" + P_NUMBER + "','"
						+ MAIL + "')";
//			System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				f2.dispose();

			} catch (Exception e) {
			}
		}
	}

	public void Match() {

		id.getText();
		pwd.getText();

		if (id.getText().equals("")) {
			lb3.setText("ID를 입력하세요.");
			lb3.setForeground(Color.red);
		} else if (pwd.getText().equals("")) {
			lb3.setText("비밀번호를 입력하세요.");
			lb3.setForeground(Color.red);
		} else {

			try {

				String sql3 = "SELECT ID, PW FROM ACCOUNT where ID ='" + id.getText() + "' AND PW = '" + pwd.getText()
						+ "'";
//			System.out.println(sql3);
				pstmt = con.prepareStatement(sql3);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					
					A = id.getText();
					Test t = new Test();
					f.dispose();

				} else {

					lb3.setText("아이디와 비밀번호를 확인해주세요.");
					lb3.setForeground(Color.red);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void Add2() {

		if (tf.getText().equals("")) {

			lb4.setText("아이디를 입력해주세요");
			lb4.setForeground(Color.red);

		} else {

			try {

				String sql3 = "SELECT ID FROM ACCOUNT where ID ='" + tf.getText() + "'";
//				System.out.println(sql);
				pstmt = con.prepareStatement(sql3);
				rs = pstmt.executeQuery();

				if (rs.next()) {

					lb4.setText("중복된 아이디 입니다.");
					lb4.setForeground(Color.red);

				} else {

					lb4.setText("사용가능한 아이디입니다.");
					lb4.setForeground(Color.blue);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Login lg = new Login();
		lg.startFrame();

	}

}