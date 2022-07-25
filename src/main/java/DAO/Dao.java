package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ScoreDto;
import DTO.StudentDto;

public class Dao {

	static PreparedStatement ps;
	static ResultSet rs;
	Connection con;
	
	public Dao(){
		try {
			this.con = getConnection();
			System.out.println("연동성공");
		} catch (Exception e) {
			System.out.println("연동 실패 : "+e);
		}
	}
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
	}
	
	public ArrayList<StudentDto> getlist() {
		ArrayList<StudentDto> slist = new ArrayList<>();
		String sql = "select * from student_tbl_03";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				StudentDto studentDto = new StudentDto(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
				slist.add(studentDto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return slist;
	}
	
	public boolean scoreinput(String sno, String ekor, String emath, String eeng, String ehist) {
		String sql = "insert into exam_tbl_03 values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, ekor);
			ps.setString(3, emath);
			ps.setString(4, eeng);
			ps.setString(5, ehist);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public ArrayList<ScoreDto> getscorelsit(){
		ArrayList<ScoreDto> scorelist = new ArrayList<>();
//		String sql = "select * from student_tbl_03 A left join exam_tbl_03 B on A.sno = B.sno";
//		String sql ="select substr(A.sno,1,1) , substr(A.sno,2,2),substr(A.sno, 4,2),A.sname, "
//				+ "B.ekor, B.emath, B.eeng, B.ehist ,(B.ekor+B.emath+B.eeng+B.ehist) \"합계\","
//				+ "(B.ekor+B.emath+B.eeng+B.ehist)/4 \"평균\","
//				+ "rank() over(order by (nvl(B.ekor,0)+nvl(B.emath,0)+nvl(B.eeng,0)+nvl(B.ehist,0))desc)) \"순위\"  "
//				+ "from student_tbl_03 A full outer join exam_tbl_03 B "
//				+ "on A.sno = B.sno "
//				+ "order by (nvl(B.ekor,0)+nvl(B.emath,0)+nvl(B.eeng,0)+nvl(B.ehist,0))) desc";
		String sql=
				"select A.sno, A.sname, "
				+ "B.ekor, B.emath, B.eeng, B.ehist ,"
				+ "(B.ekor+B.emath+B.eeng+B.ehist) \"합계\","
				+ "(B.ekor+B.emath+B.eeng+B.ehist)/4 \"평균\" "
				+ "from student_tbl_03 A "
				+ "left join exam_tbl_03 B "
				+ "on A.sno = B.sno"
				+ "order by (nvl(B.ekor,0)+nvl(B.emath,0)+nvl(B.eeng,0)+nvl(B.ehist,0)) desc";
		System.out.println(sql);
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ScoreDto dto = new ScoreDto(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)
						);
				scorelist.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return scorelist;
	}
	
}
