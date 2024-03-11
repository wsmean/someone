package com.sumin.someone.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sumin.someone.MembersVO;
import com.sumin.someone.common.JDBCUtil;

@Repository
public class MermbersDAO {
	
	PreparedStatement pstmt = null;
	Connection conn=null;
	ResultSet rs = null;
	
	String SELECT_MEMBERS = "SELECT * FROM members;"; 
	
	
	public List<MembersVO> loadmembers() {
		System.out.println("----> loadmemebers");
		
		List<MembersVO> list = new ArrayList<MembersVO>();

        try {
        	conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(SELECT_MEMBERS);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	int auto = rs.getInt("auto");
            	String name = rs.getString("name");
            	String id = rs.getString("id");
            	String password = rs.getString("password");
            	String email = rs.getString("email");
            	
            	MembersVO members = new MembersVO(auto, name, id, password,email);
            	list.add(members);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	JDBCUtil.close(rs, pstmt, conn);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        
        return list;
	}
	
	String INSERT_MEMBERS =	"INSERT INTO members(name, id, password, email) values(?,?,?,?);";
	//회원 정보 저장
	public int insertMembers(MembersVO vo) {
		System.out.println("insert members DAO들어옴");
		int n=0;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT_MEMBERS);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getEmail());
			n = pstmt.executeUpdate();
			
            if (n > 0) {
                System.out.println("데이터 입력 성공 :" + n);
            } else {
                System.out.println("데이터 입력 실패 :" + n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	JDBCUtil.close(pstmt, conn);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        
        return n;
	}
	
	//회원 정보 삭제
	String DELETE_MEMBERS = "DELETE FROM members WHERE id = ?;";
	public  void deleteMembers(MembersVO vo) {
		System.out.println("delete members DAO들어옴");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE_MEMBERS);
			pstmt.setString(1, vo.getId());
			System.out.println("DAO들어온 값 : "+vo.getId());
			pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
        
	}
	
}
