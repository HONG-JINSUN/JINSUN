import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberTest extends WindowAdapter {

	static MemberDAO dao;
	static JFrame f;
	static JTextField sc, sc2;
	static JButton btn, btn2;
	static Panel p;

	public static void main(String[] args) {
		dao = new MemberDAO();
		f = new JFrame("���� �������� ����");
		f.setSize(1080, 570);
		f.getContentPane().setBackground(Color.getHSBColor(0.0f, 20.0f, 40.0f));
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		Label lb3 = new Label("���� �з�", Label.RIGHT);
		lb3.setBounds(27, 50, 70, 40);
		Font yellow = new Font("", Font.BOLD, 10);
		lb3.setFont(yellow);
		Checkbox cb = new Checkbox("��ü", true);
		cb.setBounds(121, 50, 50, 40);
		Checkbox cb2 = new Checkbox("���");
		cb2.setBounds(171, 50, 50, 40);
		Checkbox cb3 = new Checkbox("����");
		cb3.setBounds(221, 50, 50, 40);
		Checkbox cb4 = new Checkbox("����");
		cb4.setBounds(271, 50, 50, 40);
		Label lb4 = new Label("���� �з�");
		lb4.setFont(yellow);
		lb4.setBounds(34, 82, 70, 40);
		Choice ci = new Choice();
		ci.setBounds(120, 90, 80, 40);
		ci.add("��������");
		ci.add("����");
		Choice ci2 = new Choice();
		ci2.setBounds(210, 90, 100, 40);
		ci2.add("�ñ��� ����");
		ci2.add("������");
		ci2.add("������");
		ci2.add("���ϱ�");
		ci2.add("������");
		ci2.add("���Ǳ�");
		ci2.add("������");
		ci2.add("���α�");
		ci2.add("��õ��");
		ci2.add("�����");
		ci2.add("������");
		ci2.add("���빮��");
		ci2.add("���۱�");
		ci2.add("������");
		ci2.add("���빮��");
		ci2.add("���ʱ�");
		ci2.add("������");
		ci2.add("���ϱ�");
		ci2.add("���ı�");
		ci2.add("��õ��");
		ci2.add("��������");
		ci2.add("��걸");
		ci2.add("����");
		ci2.add("���α�");
		ci2.add("�߱�");
		ci2.add("�߶���");

		Label lb6 = new Label("", Label.LEFT);
		lb6.setBounds(118, 185, 180, 40);
		Label lb5 = new Label("�˻����", Label.RIGHT);
		lb5.setBounds(2, 230, 80, 20);
		lb5.setFont(yellow);
		Label lb = new Label("�˻� ", Label.RIGHT);
		lb.setFont(yellow);
		lb.setBounds(13, 112, 50, 50);
		Label lb2 = new Label("Ű���� �˻� ", Label.RIGHT);
		lb2.setFont(yellow);
		lb2.setBounds(19, 150, 80, 50);
		sc = new JTextField(10);
		sc.setBounds(120, 125, 100, 20);
		sc2 = new JTextField(10);
		sc2.setBounds(120, 163, 100, 20);
		TextArea ta = new TextArea();
		ta.setBackground(Color.getHSBColor(0, 20, 40));
		ta.setBounds(35, 260, 500, 250);
		ta.setEditable(false);
		p = new Panel();
		p.setBackground(Color.white);
		p.setBounds(360, 50, 170, 170);
		btn = new JButton("�˻�");
		btn.setBounds(223, 124, 60, 20);
		btn2 = new JButton("�˻�");
		btn2.setBounds(223, 162, 60, 20);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb6.setText("");

				String A = ci.getSelectedItem().toString();
				String B = ci2.getSelectedItem().toString();

				if (cb.getState()) {
					if (A.equals("����")) {

						ArrayList<MemberVo> list = dao.list(sc.getText());

						String s;
						int number = 1;
						ta.setText("");
						for (int i = 0; i < list.size(); i++) {
							MemberVo data = (MemberVo) list.get(i);
							String GROUP_NAME = data.getGROUP_NAME();
							int UNIQUE_NUMBER = data.getUNIQUE_NUMBER();
							String NAME = data.getNAME();
							String PHONE_NUMBER = data.getPHONE_NUMBER();
							String TAG = data.getTAG();
							String ADDRESS = data.getADDRESS();
							String NEWADDRESS = data.getNEWADDRESS();

							if (ADDRESS.contains(B)) {

								String n = ta.getText();
								s = number++ + ". " + NAME + " ( ������ȣ : " + UNIQUE_NUMBER + " )" + "\n" + "�з� : "
										+ GROUP_NAME + "\n" + "��ȭ��ȣ : " + PHONE_NUMBER + "\n" + "�ּ� : " + ADDRESS + "\n"
										+ "�� �ּ� : " + NEWADDRESS + "\n" + "Ű���� : " + TAG;
								ta.setText(n + s + "\n" + "\n");
							}
						}

					} else {
						ArrayList<MemberVo> list = dao.list(sc.getText());

						String s;
						int number = 1;
						ta.setText("");
						for (int i = 0; i < list.size(); i++) {
							MemberVo data = (MemberVo) list.get(i);
							String GROUP_NAME = data.getGROUP_NAME();
							int UNIQUE_NUMBER = data.getUNIQUE_NUMBER();
							String NAME = data.getNAME();
							String PHONE_NUMBER = data.getPHONE_NUMBER();
							String TAG = data.getTAG();
							String ADDRESS = data.getADDRESS();
							String NEWADDRESS = data.getNEWADDRESS();

							String n = ta.getText();
							s = number++ + ". " + NAME + " ( ������ȣ : " + UNIQUE_NUMBER + " )" + "\n" + "�з� : "
									+ GROUP_NAME + "\n" + "��ȭ��ȣ : " + PHONE_NUMBER + "\n" + "�ּ� : " + ADDRESS + "\n"
									+ "�� �ּ� : " + NEWADDRESS + "\n" + "Ű���� : " + TAG;
							ta.setText(n + s + "\n" + "\n");
						}

					}

				} else if (cb2.getState()) {

					ArrayList<MemberVo> list = dao.list(sc.getText());

					String s;
					int number = 1;
					ta.setText("");
					for (int i = 0; i < list.size(); i++) {
						MemberVo data = (MemberVo) list.get(i);
						String GROUP_NAME = data.getGROUP_NAME();
						int UNIQUE_NUMBER = data.getUNIQUE_NUMBER();
						String NAME = data.getNAME();
						String PHONE_NUMBER = data.getPHONE_NUMBER();
						String TAG = data.getTAG();
						String ADDRESS = data.getADDRESS();
						String NEWADDRESS = data.getNEWADDRESS();

						if (GROUP_NAME.equals("���")) {

							String n = ta.getText();
							s = number++ + ". " + NAME + " ( ������ȣ : " + UNIQUE_NUMBER + " )" + "\n" + "�з� : "
									+ GROUP_NAME + "\n" + "��ȭ��ȣ : " + PHONE_NUMBER + "\n" + "�ּ� : " + ADDRESS + "\n"
									+ "�� �ּ� : " + NEWADDRESS + "\n" + "Ű���� : " + TAG;
							ta.setText(n + s + "\n" + "\n");
						}

					}
				} else if (cb3.getState()) {

					ArrayList<MemberVo> list = dao.list(sc.getText());

					String s;
					int number = 1;
					ta.setText("");
					for (int i = 0; i < list.size(); i++) {
						MemberVo data = (MemberVo) list.get(i);
						String GROUP_NAME = data.getGROUP_NAME();
						int UNIQUE_NUMBER = data.getUNIQUE_NUMBER();
						String NAME = data.getNAME();
						String PHONE_NUMBER = data.getPHONE_NUMBER();
						String TAG = data.getTAG();
						String ADDRESS = data.getADDRESS();
						String NEWADDRESS = data.getNEWADDRESS();

						if (GROUP_NAME.equals("����")) {

							String n = ta.getText();
							s = number++ + ". " + NAME + " ( ������ȣ : " + UNIQUE_NUMBER + " )" + "\n" + "�з� : "
									+ GROUP_NAME + "\n" + "��ȭ��ȣ : " + PHONE_NUMBER + "\n" + "�ּ� : " + ADDRESS + "\n"
									+ "�� �ּ� : " + NEWADDRESS + "\n" + "Ű���� : " + TAG;
							ta.setText(n + s + "\n" + "\n");
						}
					}

				} else if (cb4.getState()) {

					ArrayList<MemberVo> list = dao.list(sc.getText());

					String s;
					int number = 1;
					ta.setText("");
					for (int i = 0; i < list.size(); i++) {
						MemberVo data = (MemberVo) list.get(i);
						String GROUP_NAME = data.getGROUP_NAME();
						int UNIQUE_NUMBER = data.getUNIQUE_NUMBER();
						String NAME = data.getNAME();
						String PHONE_NUMBER = data.getPHONE_NUMBER();
						String TAG = data.getTAG();
						String ADDRESS = data.getADDRESS();
						String NEWADDRESS = data.getNEWADDRESS();

						if (GROUP_NAME.equals("����")) {

							String n = ta.getText();
							s = number++ + ". " + NAME + " ( ������ȣ : " + UNIQUE_NUMBER + " )" + "\n" + "�з� : "
									+ GROUP_NAME + "\n" + "��ȭ��ȣ : " + PHONE_NUMBER + "\n" + "�ּ� : " + ADDRESS + "\n"
									+ "�� �ּ� : " + NEWADDRESS + "\n" + "Ű���� : " + TAG;
							ta.setText(n + s + "\n" + "\n");
						}
					}

				}

			}
		});

		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lb6.setText("");

				if (sc2.getText().equals("")) {
					lb6.setForeground(Color.red);
					lb6.setText("Ű���带 �Է��ϼ���.");
				} else {

					ArrayList<MemberVo> list2 = dao.list2(sc2.getText());

					if (list2.size() == 0) {
						lb6.setForeground(Color.red);
						lb6.setText("��ġ�ϴ� Ű���尡 �����ϴ�.");
					} else {
						lb6.setForeground(Color.black);
						lb6.setText("��ȸ �Ǿ����ϴ�.");
					}

					String s;
					int number = 1;
					ta.setText("");
					for (int i = 0; i < list2.size(); i++) {
						MemberVo data2 = (MemberVo) list2.get(i);
						String GROUP_NAME = data2.getGROUP_NAME();
						int UNIQUE_NUMBER = data2.getUNIQUE_NUMBER();
						String NAME = data2.getNAME();
						String PHONE_NUMBER = data2.getPHONE_NUMBER();
						String TAG = data2.getTAG();
						String ADDRESS = data2.getADDRESS();
						String NEWADDRESS = data2.getNEWADDRESS();

						String n = ta.getText();
						s = number++ + ". " + NAME + " ( ������ȣ : " + UNIQUE_NUMBER + " )" + "\n" + "�з� : " + GROUP_NAME
								+ "\n" + "��ȭ��ȣ : " + PHONE_NUMBER + "\n" + "�ּ� : " + ADDRESS + "\n" + "�� �ּ� : "
								+ NEWADDRESS + "\n" + "Ű���� : " + TAG;
						ta.setText(n + s + "\n" + "\n");

					}
				}
			}
		});

		ArrayList<MemberVo> list2 = dao.list2(sc2.getText());

		String[][] table = new String[list2.size()][7];
		for (int i = 0; i < list2.size(); i++) {
			MemberVo data2 = (MemberVo) list2.get(i);
			String GROUP_NAME = data2.getGROUP_NAME();
			int UNIQUE_NUMBER = data2.getUNIQUE_NUMBER();
			String NAME = data2.getNAME();
			String PHONE_NUMBER = data2.getPHONE_NUMBER();
			String TAG = data2.getTAG();
			String ADDRESS = data2.getADDRESS();
			String NEWADDRESS = data2.getNEWADDRESS();
			String iUN = Integer.toString(UNIQUE_NUMBER);

			for (int j = 0; j < 7; j++) {
				if (j == 0) {
					table[i][j] = GROUP_NAME;
				} else if (j == 1) {
					table[i][j] = iUN;
				} else if (j == 2) {
					table[i][j] = NAME;
				} else if (j == 3) {
					table[i][j] = PHONE_NUMBER;
				} else if (j == 4) {
					table[i][j] = ADDRESS;
				} else if (j == 5) {
					table[i][j] = NEWADDRESS;
				} else if (j == 6) {
					table[i][j] = TAG;
				}
			}

		}

		String header[] = { "�з�", "������ȣ", "�̸�", "��ȭ��ȣ", "�ּ�", "���ּ�", "Ű����" };
		DefaultTableModel model = new DefaultTableModel(table, header);
		JTable tb = new JTable(model);
		JScrollPane scroll = new JScrollPane(tb);
		scroll.setBounds(550, 300, 500, 200);

		f.add(lb3);
		f.add(cb);
		f.add(cb2);
		f.add(cb3);
		f.add(cb4);
		f.add(lb4);
		f.add(ci);
		f.add(ci2);
		f.add(lb);
		f.add(sc);
		f.add(btn);
		f.add(lb2);
		f.add(sc2);
		f.add(btn2);
		f.add(lb5);
		f.add(ta);
		f.add(p);
		f.add(lb6);
		f.add(scroll);
		f.setVisible(true);

	}

}