import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	String user = "kosea";
	String password = "kosea2019a";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<MemberVo> list(String sc) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM SEOULINFO";
			query += " LEFT OUTER join SEOULADD " + "USING ( UNIQUE_NUMBER ) WHERE NAME LIKE '%" + sc + "%' ORDER BY 1";

//			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String GROUP_NAME = rs.getString("GROUP_NAME");
				int UNIQUE_NUMBER = rs.getInt("UNIQUE_NUMBER");
				String NAME = rs.getString("NAME");
				String PHONE_NUMBER = rs.getString("PHONE_NUMBER");
				String TAG = rs.getString("TAG");
				String ADDRESS = rs.getString("ADDRESS");
				String NEWADDRESS = rs.getString("NEWADDRESS");

				MemberVo data = new MemberVo(GROUP_NAME, UNIQUE_NUMBER, NAME, PHONE_NUMBER, TAG, ADDRESS, NEWADDRESS);
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// ------------------------------
	public ArrayList<MemberVo> f_list(String sc, String B) {
		ArrayList<MemberVo> f_list = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM SEOULINFO";
			query += " LEFT OUTER join SEOULADD " + "USING ( UNIQUE_NUMBER ) WHERE NAME LIKE '%" + sc
					+ "%' AND ADDRESS LIKE '%" + B + "%'  ORDER BY 1";

//			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String GROUP_NAME = rs.getString("GROUP_NAME");
				int UNIQUE_NUMBER = rs.getInt("UNIQUE_NUMBER");
				String NAME = rs.getString("NAME");
				String PHONE_NUMBER = rs.getString("PHONE_NUMBER");
				String TAG = rs.getString("TAG");
				String ADDRESS = rs.getString("ADDRESS");
				String NEWADDRESS = rs.getString("NEWADDRESS");

				MemberVo data = new MemberVo(GROUP_NAME, UNIQUE_NUMBER, NAME, PHONE_NUMBER, TAG, ADDRESS, NEWADDRESS);
				f_list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f_list;
	}
	// ------------------------------

	public ArrayList<MemberVo> m_list(String sc, String B) {
		ArrayList<MemberVo> m_list = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM SEOULINFO";
			query += " LEFT OUTER join SEOULADD " + "USING ( UNIQUE_NUMBER ) WHERE GROUP_NAME LIKE '%¸í¼Ò%' AND NAME LIKE '%" + sc
					+ "%' AND ADDRESS LIKE '%" + B + "%'  ORDER BY 1";

//			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String GROUP_NAME = rs.getString("GROUP_NAME");
				int UNIQUE_NUMBER = rs.getInt("UNIQUE_NUMBER");
				String NAME = rs.getString("NAME");
				String PHONE_NUMBER = rs.getString("PHONE_NUMBER");
				String TAG = rs.getString("TAG");
				String ADDRESS = rs.getString("ADDRESS");
				String NEWADDRESS = rs.getString("NEWADDRESS");

				MemberVo data = new MemberVo(GROUP_NAME, UNIQUE_NUMBER, NAME, PHONE_NUMBER, TAG, ADDRESS, NEWADDRESS);
				m_list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m_list;
	}

//		-----------------------------------

	public ArrayList<MemberVo> list2(String sc2) {
		ArrayList<MemberVo> list2 = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM SEOULINFO";
			query += " LEFT OUTER join SEOULADD " + "USING ( UNIQUE_NUMBER ) WHERE TAG LIKE '%" + sc2 + "%' ORDER BY 1";

//			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String GROUP_NAME = rs.getString("GROUP_NAME");
				int UNIQUE_NUMBER = rs.getInt("UNIQUE_NUMBER");
				String NAME = rs.getString("NAME");
				String PHONE_NUMBER = rs.getString("PHONE_NUMBER");
				String TAG = rs.getString("TAG");
				String ADDRESS = rs.getString("ADDRESS");
				String NEWADDRESS = rs.getString("NEWADDRESS");

				MemberVo data2 = new MemberVo(GROUP_NAME, UNIQUE_NUMBER, NAME, PHONE_NUMBER, TAG, ADDRESS, NEWADDRESS);
				list2.add(data2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}