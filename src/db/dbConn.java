package db;

import java.sql.*;

/**
 * 
 * Title: 数据库连接 
 * Description: 数据库连接模块
 * 
 * @author 周志成
 */

public class dbConn {
	public dbConn() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Statement conn() {
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("成功加载MySQL驱动！");
			// 数据库名称，管理员账号、密码
			String url = "jdbc:mysql://localhost:3306/stumanagerdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
			String user = "root";
			String pwd = "2424241";

			// 连接
			Connection con = DriverManager.getConnection(url, user, pwd);	//error
			Statement stat = con.createStatement();
			System.out.println("成功连接到数据库！");
			return stat;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		} catch (SQLException ex1) {
			ex1.printStackTrace();
			return null;
		}
	}

	// 查询数据库
	public ResultSet getRs(String sql) {
		try {
			Statement stat = conn();
			ResultSet rs = stat.executeQuery(sql);
			System.out.println(rs);
			return rs;
		} catch (SQLException ex) {
			System.err.println("------------" + ex.getMessage());
			return null;
		}
	}

	// 更新数据库
	public int getUpdate(String sql) {
		try {
			Statement stat = conn();
			assert stat != null;
			int i = stat.executeUpdate(sql);
			return i;
		} catch (Exception ex) {
			System.out.println(">>>>>>>>" + ex.getMessage());
			return -1;
		}
	}

	private void jbInit() throws Exception {
		conn();
	}

}
