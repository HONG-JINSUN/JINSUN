import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Test extends JFrame implements ActionListener, MouseListener {

	DefaultTableModel model;
	JTable table;
	JScrollPane js;
	Object ob[][] = new Object[0][6];
	String header[] = { "분류", "고유번호", "이름", "전화번호", "주소", "키워드" };
	JPanel P, p2, background;
	JLabel lb, lb2, lb3, lb4, lb5, lb6;
	JTextField tf, tf2, tf3, tf4, tf5, tf6, sc, sc2, sc3;
	JFrame f, f2;
	JButton btn, btn2, btn3, btn4;
	JLabel llb, llb2, llb3, llb4, llb5, llb6;
	JCheckBox cb, cb2, cb3, cb4;
	Choice ci, ci2;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Test() {

		f = new JFrame("서울 관광정보 서비스");
		f.setBounds(50, 50, 1080, 570);
		f.getContentPane().setBackground(Color.getHSBColor(0.0f, 20.0f, 40.0f));
		f.getContentPane().setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		llb3 = new JLabel("서비스 분류", Label.RIGHT);
		llb3.setBounds(100, 150, 70, 40);
		Font yellow = new Font("", Font.BOLD, 10);
		llb3.setFont(yellow);

		ButtonGroup group1 = new ButtonGroup();
		cb = new JCheckBox("전체", true);
		cb.setBounds(200, 150, 50, 40);
		cb2 = new JCheckBox("명소", false);
		cb2.setBounds(250, 150, 50, 40);
		cb3 = new JCheckBox("맛집", false);
		cb3.setBounds(300, 150, 50, 40);
		cb4 = new JCheckBox("쇼핑", false);
		cb4.setBounds(350, 150, 50, 40);

		group1.add(cb);
		group1.add(cb2);
		group1.add(cb3);
		group1.add(cb4);

		cb.setOpaque(false);
		cb2.setOpaque(false);
		cb3.setOpaque(false);
		cb4.setOpaque(false);

		llb4 = new JLabel("지역 분류", Label.RIGHT);
		llb4.setFont(yellow);
		llb4.setBounds(100, 190, 70, 40);
		ci = new Choice();
		ci.setBounds(200, 200, 80, 40);
//		ci.add("지역선택");
		ci.add("서울");
		ci2 = new Choice();
		ci2.setBounds(285, 200, 100, 40);
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
		llb5.setBounds(505, 60, 80, 20);
		llb5.setFont(yellow);
		llb = new JLabel("검색 ", Label.RIGHT);
		llb.setFont(yellow);
		llb.setBounds(100, 235, 50, 50);
		llb2 = new JLabel("키워드 검색 ", Label.RIGHT);
		llb2.setFont(yellow);
		llb2.setBounds(100, 285, 80, 50);
		sc = new JTextField(10);
		sc.setBounds(200, 250, 100, 20);
		sc2 = new JTextField(10);
		sc2.setBounds(200, 300, 100, 20);
		sc3 = new JTextField();
		sc3.setEditable(false);
		sc3.setBounds(720, 60, 200, 20);
		sc3.setText(F);

		p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setBounds(350, 40, 190, 170);
		btn = new JButton("검색");
		btn.setBounds(305, 250, 60, 20);
		btn2 = new JButton("검색");
		btn2.setBounds(305, 300, 60, 20);
		btn3 = new JButton("위치검색");
		btn3.setBounds(930, 60, 90, 20);
		btn4 = new JButton("초기화");
		btn4.setBounds(560, 60, 70, 20);

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

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "https://map.naver.com/v5/search/";
					url += URLEncoder.encode(G, "UTF-8");
					Desktop.getDesktop().browse(new URI(url));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cb.setSelected(true);
				ci2.select(0);
				sc.setText("");
				sc2.setText("");
				model.setNumRows(0);
				sc3.setText("");
				;

			}
		});

		f.getContentPane().add(llb3);
		f.getContentPane().add(cb);
		f.getContentPane().add(cb2);
		f.getContentPane().add(cb3);
		f.getContentPane().add(cb4);
		f.getContentPane().add(llb4);
		f.getContentPane().add(ci);
		f.getContentPane().add(ci2);
		f.getContentPane().add(llb);
		f.getContentPane().add(sc);
		f.getContentPane().add(btn);
		f.getContentPane().add(llb2);
		f.getContentPane().add(sc2);
		f.getContentPane().add(btn2);
		f.getContentPane().add(llb5);
//		f.getContentPane().add(p2);
		f.getContentPane().add(llb6);
		f.getContentPane().add(btn3);
		f.getContentPane().add(sc3);
		f.getContentPane().add(btn4);

		P = new JPanel();
		lb = new JLabel("분류", JLabel.CENTER);
		lb2 = new JLabel("고유번호", JLabel.CENTER);
		lb3 = new JLabel("이름", JLabel.CENTER);
		lb4 = new JLabel("전화번호", JLabel.CENTER);
		lb5 = new JLabel("주소", JLabel.CENTER);
		lb6 = new JLabel("태그", JLabel.CENTER);

		tf = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		P.setLayout(new GridLayout(6, 7));
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
		model = new DefaultTableModel(ob, header) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table = new JTable(model);
		js = new JScrollPane(table);
		js.setBounds(500, 90, 520, 250);
		f.getContentPane().add(js);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\full.png"));
		lblNewLabel.setBounds(0, 0, 1066, 533);
		f.getContentPane().add(lblNewLabel);

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
			if (tf.getText().equals("") && tf2.getText().equals("") && tf3.getText().equals("")
					&& tf4.getText().equals("") && tf5.getText().equals("") && tf6.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "값을 입력하세요.");
				tf.requestFocus();
				return;
			}
			Object data[] = { tf.getText(), tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText(), tf6.getText() };
			model.addRow(data);
			tf.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
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

			if (cb.isSelected()) {
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

			} else if (cb2.isSelected()) {
				if (B.equals("시군구 선택")) {
					B = "";
				}

				String sql = "SELECT * FROM SEOULINFO LEFT OUTER join SEOULADD USING ( UNIQUE_NUMBER )"
						+ " WHERE GROUP_NAME = '명소' AND NAME LIKE '%" + C + "%' AND ADDRESS LIKE '%" + B
						+ "%' AND TAG LIKE '%" + D + "%' ORDER BY 1";
//				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

			} else if (cb3.isSelected()) {
				if (B.equals("시군구 선택")) {
					B = "";
				}

				String sql = "SELECT * FROM SEOULINFO LEFT OUTER join SEOULADD USING ( UNIQUE_NUMBER )"
						+ " WHERE GROUP_NAME = '맛집' AND NAME LIKE '%" + C + "%' AND ADDRESS LIKE '%" + B
						+ "%' AND TAG LIKE '%" + D + "%' ORDER BY 1";
//				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

			} else if (cb4.isSelected()) {
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
				String PHONENUMBER = rs.getString("PHONENUMBER");
				String TAG = rs.getString("TAG");
				String ADDRESS = rs.getString("ADDRESS");

				Object data[] = { GROUP_NAME, UNIQUE_NUMBER, NAME, PHONENUMBER, ADDRESS, TAG };
				model.addRow(data);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	String F = "";
	String G = "";

	public void mouseClicked(MouseEvent me) {

		int row = table.getSelectedRow();
//			System.out.println(table.getModel().getValueAt(row, 2) + "\t");
		F = (String) table.getModel().getValueAt(row, 2);
		G = (String) table.getModel().getValueAt(row, 4);
		sc3.setText(F);

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