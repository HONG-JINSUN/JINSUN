import java.awt.*;
import java.awt.event.*;

public class Login extends WindowAdapter implements ActionListener {
	static Frame f;
	static TextField id, pwd;
	static Button b;
	static String I = "KOSEA";
	static String P = "2019a";

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void startFrame() {
		f = new Frame("Login");
		b = new Button("Login");
		f.setSize(400, 65);
		f.setLayout(new FlowLayout());
		b.addActionListener(this);
		f.addWindowListener(this);

		Label lid = new Label("ID : ", Label.RIGHT);
		Label lpwd = new Label("Password : ", Label.RIGHT);

		id = new TextField(10);
		pwd = new TextField(10);
		pwd.setEchoChar('*');

		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.setVisible(true);
		f.add(b);

	}

	public void actionPerformed(ActionEvent e) {
		id.getText();
		pwd.getText();
		if (e.getActionCommand().equals("Login")) {
			if (id.getText().equals("")) {
				System.out.println("ID를 입력하세요.");
			} else if (pwd.getText().equals("")) {
				System.out.println("비밀번호를 입력하세요.");
			} else if (id.getText().equals(I) && pwd.getText().equals(P)) {

				System.out.println("로그인 되었습니다.");
				Test t = new Test();
				f.dispose();

			} else {

				System.out.println("아이디와 비밀번호를 확인해주세요.");
			}
		}
	}

	public static void main(String[] args) {
		Login lg = new Login();
		lg.startFrame();

	}

}