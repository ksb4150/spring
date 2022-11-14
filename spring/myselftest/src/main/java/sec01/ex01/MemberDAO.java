package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		
	}
	
	public void addMember(MemberBean memberBean) {
		try {
			con = dataFactory.getConnection();
			String id = memberBean.getId();
			String pwd = memberBean.getPwd();
			String name = memberBean.getName();
			String email = memberBean.getEmail();
			
			String query = "insert into t_member";
				   query += "(id, pwd, name, email)";
				   query += "values(?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.execute();
			pstmt.close();
		} catch(Exception e) {
			System.out.println("연결에 실패");
		}
	}
	
	public List listMembers() {
		List memberlist = new ArrayList();
		
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet re = pstmt.executeQuery();
			
			while(re.next()) {
				String id = re.getString("id");
				String pwd = re.getString("pwd");
				String name = re.getString("name");
				String email = re.getString("email");
				Date joinDate = re.getDate("joinDate");
				
				MemberBean m = new MemberBean(id, pwd, name, email);
				memberlist.add(m);
			}
			re.close();
			pstmt.close();
			con.close();
			
		} catch(Exception e) {
			System.out.println("연결에 실패");
		}
		return memberlist;
	}
}
