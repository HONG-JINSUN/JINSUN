import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Test extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel model;
	JTable table;
	JScrollPane js;
	Object ob[][] = new Object[0][7];
	String header[] = { "분류", "고유번호", "이름", "전화번호", "주소", "신주소", "키워드" };
	JPanel P, p2;
	JLabel lb, lb2, lb3, lb4, lb5, lb6, lb7;
	JTextField tf, tf2, tf3, tf4, tf5, tf6, tf7, sc, sc2;
	JFrame f, f2;
	JButton btn, btn2;
	JLabel llb, llb2, llb3, llb4, llb5, llb6;
	Checkbox cb, cb2, cb3, cb4;
	Choice ci, ci2;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Test() {

		f = new JFrame();
		f.setBounds(50, 50, 1080, 570);
		f.getContentPane().setBackground(Color.getHSBColor(0.0f, 20.0f, 40.0f));
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		llb3 = new JLabel("서비스 분류", Label.RIGHT);
		llb3.setBounds(27, 50, 70, 40);
		Font yellow = new Font("", Font.BOLD, 10);
		llb3.setFont(yellow);
		cb = new Checkbox("전체", true);
		cb.setBounds(121, 50, 50, 40);
		cb2 = new Checkbox("명소");
		cb2.setBounds(171, 50, 50, 40);
		cb3 = new Checkbox("맛집");
		cb3.setBounds(221, 50, 50, 40);
		cb4 = new Checkbox("쇼핑");
		cb4.setBounds(271, 50, 50, 40);
		llb4 = new JLabel("지역 분류");
		llb4.setFont(yellow);
		llb4.setBounds(26, 82, 70, 40);
		ci = new Choice();
		ci.setBounds(120, 90, 80, 40);
//		ci.add("지역선택");
		ci.add("서울");
		ci2 = new Choice();
		ci2.setBounds(210, 90, 100, 40);
		ci2.add("시군구 선택");
		ci2.add("강남구");
		ci2.add("강동구");
		ci2.add("강북구");
		ci2.add("강서구");
		ci2.add("관악구");
		ci2.add("광진구");
		ci2.add("구로구");
		ci2.add("금천구");
		ci2.add("노원구");
		ci2.add("도봉구");
		ci2.add("동대문구");
		ci2.add("동작구");
		ci2.add("마포구");
		ci2.add("서대문구");
		ci2.add("서초구");
		ci2.add("성동구");
		ci2.add("성북구");
		ci2.add("송파구");
		ci2.add("양천구");
		ci2.add("영등포구");
		ci2.add("용산구");
		ci2.add("은평구");
		ci2.add("종로구");
		ci2.add("중구");
		ci2.add("중랑구");

		llb6 = new JLabel("", Label.LEFT);
		llb6.setBounds(118, 185, 180, 40);
		llb5 = new JLabel("검색결과", Label.RIGHT);
		llb5.setBounds(27, 230, 80, 20);
		llb5.setFont(yellow);
		llb = new JLabel("검색 ", Label.RIGHT);
		llb.setFont(yellow);
		llb.setBounds(27, 112, 50, 50);
		llb2 = new JLabel("키워드 검색 ", Label.RIGHT);
		llb2.setFont(yellow);
		llb2.setBounds(27, 145, 80, 50);
		sc = new JTextField(10);
		sc.setBounds(120, 125, 100, 20);
		sc2 = new JTextField(10);
		sc2.setBounds(120, 163, 100, 20);

		p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setBounds(360, 50, 170, 170);
		btn = new JButton("검색");
		btn.setBounds(223, 124, 60, 20);
		btn2 = new JButton("검색");
		btn2.setBounds(223, 162, 60, 20);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connect();
				Select();

			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connect();
				Select();

			}
		});

		f.add(llb3);
		f.add(cb);
		f.add(cb2);
		f.add(cb3);
		f.add(cb4);
		f.add(llb4);
		f.add(ci);
		f.add(ci2);
		f.add(llb);
		f.add(sc);
		f.add(btn);
		f.add(llb2);
		f.add(sc2);
		f.add(btn2);
		f.add(llb5);
		f.add(p2);
		f.add(llb6);

		P = new JPanel();
		lb = new JLabel("분류", JLabel.CENTER);
		lb2 = new JLabel("고유번호", JLabel.CENTER);
		lb3 = new JLabel("이름", JLabel.CENTER);
		lb4 = new JLabel("전화번호", JLabel.CENTER);
		lb5 = new JLabel("주소", JLabel.CENTER);
		lb6 = new JLabel("신주소", JLabel.CENTER);
		lb7 = new JLabel("태그", JLabel.CENTER);

		tf = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();
		P.setLayout(new GridLayout(7, 8));
		P.add(lb);
		P.add(tf);
		P.add(lb2);
		P.add(tf2);
		P.add(lb3);
		P.add(tf3);
		P.add(lb4);
		P.add(tf4);
		P.add(lb5);
		P.add(tf5);
		P.add(lb6);
		P.add(tf6);
		P.add(lb7);
		P.add(tf7);
		model = new DefaultTableModel(ob, header);
		table = new JTable(model);
		js = new JScrollPane(table);
		js.setBounds(30, 270, 500, 230);
		f.add(js);

//		this.add("Center", js);
//		setBounds(250, 250, 600, 400);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
		f.setVisible(true);

		tf.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
		tf5.addActionListener(this);
		tf6.addActionListener(this);
		tf7.addActionListener(this);
		table.addMouseListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e2) {
					System.exit(0);
				}

			}

		});

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf) {
			tf2.requestFocus();
		} else if (e.getSource() == tf2) {
			tf3.requestFocus();
		} else if (e.getSource() == tf3) {
			tf4.requestFocus();
		} else if (e.getSource() == tf4) {
			tf5.requestFocus();
		} else if (e.getSource() == tf5) {
			tf6.requestFocus();
		} else if (e.getSource() == tf6) {
			tf7.requestFocus();
		} else if (e.getSource() == tf7) {
			if (tf.getText().equals("") && tf2.getText().equals("") && tf3.getText().equals("")
					&& tf4.getText().equals("") && tf5.getText().equals("") && tf7.getText().equals("")
					&& tf7.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "값을 입력하세요.");
				tf.requestFocus();
				return;
			}
			Object data[] = { tf.getText(), tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText(), tf6.getText(),
					tf7.getText() };
			model.addRow(data);
			tf.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			tf.requestFocus();
		}

	}

	private void Connect() {

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

	public void Select() {

		model.setNumRows(0);

		try {

//			String A = ci.getSelectedItem().toString();
			String B = ci2.getSelectedItem().toString();
			String C = sc.getText();
			String D = sc2.getText();

			if (cb.getState()) {
				if (B.equals("시군구 선택")) {
					B = "";
				}
				if (D.equals("")) {
					D = "";
				}

				String sql = "SELECT * FROM SEOULINFO LEFT OUTER join SEOULADD USING ( UNIQUE_NUMBER ) WHERE NAME LIKE '%"
						+ C + "%' AND ADDRESS LIKE '%" + B + "%' AND TAG LIKE '%" + D + "%' ORDER BY 1";
//				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

			} else if (cb2.getState()) {
				if (B.equals("시군구 선택")) {
					B = "";
				}

				String sql = "SELECT * FROM SEOULINFO LEFT OUTER join SEOULADD USING ( UNIQUE_NUMBER )"
						+ " WHERE GROUP_NAME = '명소' AND NAME LIKE '%" + C + "%' AND ADDRESS LIKE '%" + B
						+ "%' AND TAG LIKE '%" + D + "%' ORDER BY 1";
//				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

			} else if (cb3.getState()) {
				if (B.equals("시군구 선택")) {
					B = "";
				}

				String sql = "SELECT * FROM SEOULINFO LEFT OUTER join SEOULADD USING ( UNIQUE_NUMBER )"
						+ " WHERE GROUP_NAME = '맛집' AND NAME LIKE '%" + C + "%' AND ADDRESS LIKE '%" + B
						+ "%' AND TAG LIKE '%" + D + "%' ORDER BY 1";
//				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

			} else if (cb4.getState()) {
				if (B.equals("시군구 선택")) {
					B = "";
				}

				String sql = "SELECT * FROM SEOULINFO LEFT OUTER join SEOULADD USING ( UNIQUE_NUMBER )"
						+ " WHERE GROUP_NAME = '쇼핑' AND NAME LIKE '%" + C + "%' AND ADDRESS LIKE '%" + B
						+ "%' AND TAG LIKE '%" + D + "%' ORDER BY 1";
//				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

			}

			while (rs.next()) {
				String GROUP_NAME = rs.getString("GROUP_NAME");
				int UNIQUE_NUMBER = rs.getInt("UNIQUE_NUMBER");
				String NAME = rs.getString("NAME");
				String PHONE_NUMBER = rs.getString("PHONE_NUMBER");
				String TAG = rs.getString("TAG");
				String ADDRESS = rs.getString("ADDRESS");
				String NEWADDRESS = rs.getString("NEWADDRESS");

				Object data[] = { GROUP_NAME, UNIQUE_NUMBER, NAME, PHONE_NUMBER, ADDRESS, NEWADDRESS, TAG };
				model.addRow(data);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void mouseClicked(MouseEvent me) {

		int row = table.getSelectedRow();
			System.out.println(table.getModel().getValueAt(row, 2) + "\t");
			

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public static void main(String[] args) {
		Test t = new Test();

	}

}
