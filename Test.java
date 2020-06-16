import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Test extends JFrame implements ActionListener, MouseListener {

	DefaultTableModel model, model2;
	JTable table, table2;
	JScrollPane js, js2;
	Object ob[][] = new Object[0][6];
	Object ob2[][] = new Object[0][2];
	String header[] = { "분류", "고유번호", "이름", "전화번호", "주소", "키워드" };
	String header2[] = { "리뷰", "날짜" };
	JPanel P, p2, background, f3background;
	JLabel lb, lb2, lb3, lb4, lb5, lb6, lb7;
	JTextField tf, tf2, tf3, tf4, tf5, tf6, sc, sc2, sc3, sc4;
	JFrame f, f2, f3;
	JButton btn, btn2, btn3, btn4, btn6;
	JLabel llb, llb2, llb3, llb4, llb5, llb6;
	JCheckBox cb, cb2, cb3, cb4;
	Choice ci, ci2;
	JTextArea ta;
	JLabel p2lb, p2lb2;
	JTextField p2tf, p2tf2;

	String F = "";
	String G = "";
	String H = "";
	int I = 0;
	String J = "";
	String K = Integer.toString(I);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Image img = new ImageIcon("C:\\Users\\JINSUN\\Desktop\\info.png").getImage(); // 이미지 선언
	Image review = new ImageIcon("C:\\Users\\JINSUN\\Desktop\\review.png").getImage(); // 이미지 선언

	Test() {

		f = new JFrame("서울 관광정보 서비스");
		f.setLayout(null);
		f.setBounds(50, 50, 1080, 655);
//		f.getContentPane().setBackground(Color.getHSBColor(0.0f, 20.0f, 40.0f));
		f.getContentPane().setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		llb3 = new JLabel("서비스 분류", Label.RIGHT);
		llb3.setBounds(110, 150, 70, 40);
		llb3.setForeground(Color.white);
		Font yellow = new Font("", Font.BOLD, 12);
		llb3.setFont(yellow);

		ButtonGroup group1 = new ButtonGroup();
		cb = new JCheckBox("전체", true);
		cb.setForeground(Color.white);
		cb.setBounds(210, 150, 50, 40);
		cb2 = new JCheckBox("명소", false);
		cb2.setForeground(Color.white);
		cb2.setBounds(260, 150, 50, 40);
		cb3 = new JCheckBox("맛집", false);
		cb3.setForeground(Color.white);
		cb3.setBounds(310, 150, 50, 40);
		cb4 = new JCheckBox("쇼핑", false);
		cb4.setForeground(Color.white);
		cb4.setBounds(360, 150, 50, 40);

		group1.add(cb);
		group1.add(cb2);
		group1.add(cb3);
		group1.add(cb4);

		cb.setOpaque(false);
		cb2.setOpaque(false);
		cb3.setOpaque(false);
		cb4.setOpaque(false);

		llb4 = new JLabel("지역 분류", Label.RIGHT);
		llb4.setForeground(Color.white);
		llb4.setFont(yellow);
		llb4.setBounds(110, 190, 70, 40);
		ci = new Choice();
		ci.setBounds(210, 200, 80, 40);
//		ci.add("지역선택");
		ci.add("서울");
		ci2 = new Choice();
		ci2.setBounds(295, 200, 100, 40);
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
		llb5.setForeground(Color.white);
		llb5.setBounds(505, 80, 80, 20);
		llb5.setFont(yellow);
		llb = new JLabel("검색 ", Label.RIGHT);
		llb.setForeground(Color.white);
		llb.setFont(yellow);
		llb.setBounds(110, 235, 50, 50);
		llb2 = new JLabel("키워드 검색 ", Label.RIGHT);
		llb2.setForeground(Color.white);
		llb2.setFont(yellow);
		llb2.setBounds(110, 285, 80, 50);
		sc = new JTextField(10) {
			public void setBorder(Border border) {

			}
		};
		sc.setOpaque(false);
		sc.setBounds(225, 250, 100, 20);
		sc.setForeground(Color.white);
		sc2 = new JTextField(10) {
			public void setBorder(Border border) {

			}
		};
		sc2.setBounds(225, 300, 100, 20);
		sc2.setOpaque(false);
		sc2.setForeground(Color.white);
		sc3 = new JTextField() {
			public void setBorder(Border border) {

			}
		};
		sc3.setEditable(false);
		sc3.setOpaque(false);
		sc3.setBounds(790, 80, 200, 20);
		sc3.setText(F);
		sc3.setForeground(Color.white);

//		btn = new JButton();
		btn = new JButton(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\버튼2.png")) {
			public void setBorder(Border border) {

			}
		};
		btn.setBounds(330, 250, 20, 20);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setForeground(Color.white);
//		btn2 = new JButton();
		btn2 = new JButton(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\버튼2.png")) {
			public void setBorder(Border border) {

			}
		};
		btn2.setBounds(330, 300, 20, 20);
		btn2.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setFocusPainted(false);
		btn2.setForeground(Color.white);
//		btn3 = new JButton();
		btn3 = new JButton(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\버튼32.png")) {
			public void setBorder(Border border) {

			}
		};
		btn3.setBounds(990, 80, 20, 20);
		btn3.setBorderPainted(false);
		btn3.setContentAreaFilled(false);
		btn3.setFocusPainted(false);
		btn3.setForeground(Color.white);
		btn4 = new JButton(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\버튼42.png")) {
			public void setBorder(Border border) {

			}
		};
		btn4.setBounds(560, 80, 20, 20);
		btn4.setBorderPainted(false);
		btn4.setContentAreaFilled(false);
		btn4.setFocusPainted(false);
		btn4.setForeground(Color.white);

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

				if (!F.equals("")) {
					try {
						String url = "https://map.naver.com/v5/search/";
						url += URLEncoder.encode(G, "UTF-8");
						Desktop.getDesktop().browse(new URI(url));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
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
				f2.dispose();
				f3.dispose();

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

		Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		table = new JTable(model);
		table.getColumn("분류").setPreferredWidth(50);
		table.getColumn("고유번호").setPreferredWidth(70);
		table.getColumn("이름").setPreferredWidth(300);
		table.getColumn("분류").setCellRenderer(dtcr);
		table.getColumn("고유번호").setCellRenderer(dtcr);
//		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setShowGrid(false);

//		table.getColumn("이름").setCellRenderer(dtcr);
		js = new JScrollPane(table);
//		js.setLayout(null);
		js.setBounds(500, 110, 520, 250);
		f.getContentPane().add(js);
		js.setOpaque(false);
		js.getViewport().setOpaque(false);
//		js.setBorder(emptyBorder);                 // 테이블 테두리
//		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);       // 테이블 스크롤바

		p2 = new JPanel();
		p2lb = new JLabel("리뷰", JLabel.CENTER);
		p2tf = new JTextField();
		p2lb2 = new JLabel("날짜", JLabel.CENTER);
		p2tf2 = new JTextField();
		p2.setLayout(new GridLayout(2, 3));
		model2 = new DefaultTableModel(ob2, header2) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}

		};

		table2 = new JTable(model2);
		table2.getColumn("리뷰").setPreferredWidth(240);
		table2.getColumn("리뷰").setCellRenderer(dtcr);
		js2 = new JScrollPane(table2);
		js2.setBounds(5, 5, 290, 195);
		table2.setShowGrid(false);
		js2.setOpaque(false);
		js2.getViewport().setOpaque(false);
		js2.setBorder(emptyBorder);
//		((DefaultTableCellRenderer)table2.getDefaultRenderer(Object.class)).setOpaque(false);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\BackGround2.png"));
		lblNewLabel.setBounds(0, 0, 1080, 620);
		f.getContentPane().add(lblNewLabel);

//		this.add("Center", js);
//		setBounds(250, 250, 600, 400);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
		f.setVisible(true);

		f2 = new JFrame("상세정보");
		f2.setLayout(null);

		f2.setBounds(1120, 50, 315, 387);
		ta = new JTextArea() {
			{
				setOpaque(false);
			}

			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, null); // 이미지 그리기
				super.paintComponent(g);
			}
		};

		ta.setBounds(0, 0, 300, 350);
		ta.setEditable(false);
		ta.setLineWrap(true);
		ta.setFont(yellow);
		ta.setForeground(Color.white);
		f2.getContentPane().add(ta);

		f3 = new JFrame("리뷰 남기기");
		f3.setLayout(null);
		f3.setBounds(1120, 435, 315, 270);

		sc4 = new JTextField();
		sc4.setBounds(5, 205, 265, 20);
		f3.add(sc4);
		f3.add(js2);

		f3background = new JPanel() {
			{
				setOpaque(false);
			}

			public void paintComponent(Graphics g) {
				g.drawImage(review, 0, 0, null); // 이미지 그리기
				super.paintComponent(g);
			}
		};
		f3background.setBounds(0, 0, 315, 270);

//		btn6 = new JButton();
		btn6 = new JButton(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\버튼43.png")) {
			public void setBorder(Border border) {

			}
		};
		btn6.setBounds(275, 205, 20, 20);
		btn6.setBorderPainted(false);
		btn6.setContentAreaFilled(false);
		btn6.setFocusPainted(false);
		f3.add(btn6);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connect();
				Update();
				Select2();
				sc4.setText("");

			}
		});

		f3.add(f3background);
//		lb7 = new JLabel();
//		lb7.setIcon(new ImageIcon("C:\\Users\\JINSUN\\Desktop\\full.png"));
//		lb7.setBounds(0, 0, 70, 40);
//		f2.add(lb7);

		tf.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
		tf5.addActionListener(this);
		tf6.addActionListener(this);
		p2tf.addActionListener(this);
		p2tf2.addActionListener(this);
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
		if (e.getSource() == p2tf) {
			p2tf2.requestFocus();
		} else if (e.getSource() == p2tf2) {
		}
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
			Object data2[] = { p2tf.getText(), p2tf2.getText() };
			model.addRow(data);
			model2.addRow(data2);
			tf.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf.requestFocus();
			p2tf.setText("");
			p2tf2.setText("");
			p2tf.requestFocus();
		}

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

	public void Update() {
		try {

			String sql2 = "SELECT MAX(R_NUMBER) FROM SEOULREVIEW";
			pstmt = con.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			int Z = 0;
			while (rs.next()) {

				Z = rs.getInt("MAX(R_NUMBER)");

			}
			J = sc4.getText();

			String R_NUMBER = Integer.toString(Z + 1), REVIEW = J; /* 맥스값 + 10, Integer -> String */
			int UNIQUE_NUMBER = I;
			String sql4 = "INSERT INTO SEOULREVIEW VALUES ('" + R_NUMBER + "','" + UNIQUE_NUMBER + "','" + REVIEW
					+ "',sysdate)";
//			System.out.println(sql4);
			pstmt = con.prepareStatement(sql4);
			rs = pstmt.executeQuery();

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

	public void Select2() {

		model2.setNumRows(0);

		try {

			String sql3 = "SELECT REVIEW, N_DATE FROM SEOULREVIEW where UNIQUE_NUMBER = '" + I + "' ORDER BY R_NUMBER";
//				System.out.println(sql);
			pstmt = con.prepareStatement(sql3);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String REVIEW = rs.getString("REVIEW");
				String N_DATE = rs.getString("N_DATE");

				Object data2[] = { REVIEW, N_DATE };
				model2.addRow(data2);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void mouseClicked(MouseEvent me) {

		int row = table.getSelectedRow();
//			System.out.println(table.getModel().getValueAt(row, 2) + "\t");
		F = (String) table.getModel().getValueAt(row, 2);
		G = (String) table.getModel().getValueAt(row, 4);
		I = (int) table.getModel().getValueAt(row, 1);

		H = "\n\n\n\n                       " + (String) table.getModel().getValueAt(row, 2)
				+ "\n\n                       ● 분류\n\n                       "
				+ (String) table.getModel().getValueAt(row, 0)
				+ "\n\n                       ● 전화번호\n\n                       "
				+ (String) table.getModel().getValueAt(row, 3)
				+ "\n\n                       ● 주소\n\n                       "
				+ (String) table.getModel().getValueAt(row, 4);

		sc3.setText(F);

		ta.setText(H);

		f2.setVisible(true);

		Select2();
		f3.setVisible(true);

		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

			}
		});

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