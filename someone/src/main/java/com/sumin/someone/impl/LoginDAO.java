package com.sumin.someone.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.sumin.someone.MembersVO;
import com.sumin.someone.common.JDBCUtil;

public class LoginDAO {
	
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	String LOGIN_MEMBERS = "SELECT * FROM members WHERE id=? and password=?;";
	String ID_CHECKS = "SELECT * FROM members WHERE id=?;";
	
	public <MembersVo> MembersVO goLogin(MembersVO vo) {
		MembersVO user = new MembersVO();
		System.out.println("loginDAO 로그인 확인 접속");
		
		try {
			 conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(LOGIN_MEMBERS);
			pstmt.setString(1, vo.getId());
			System.out.println(vo.getId());
			pstmt.setString(2, vo.getPassword());
			System.out.println(vo.getPassword());
			rs = pstmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				user = new MembersVO();
				System.out.println("user: "+user);
				user.setId(rs.getString("ID"));
				//user.setPassword(rs.getNString("PASSWORD"));
			}else {
				user = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		 return user;
		
	}
	
	public <MembersVo> MembersVO join_check(MembersVO vo) {
		MembersVO user = new MembersVO();
		System.out.println("3. loginDAO 아이디 중복확인 접속");
		
		try {
			 conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(ID_CHECKS);
			pstmt.setString(1, vo.getId());
			System.out.println("3-1."+vo.getId());
			rs = pstmt.executeQuery();
			System.out.println("3-2:"+rs);
			if(rs.next()) {
				user = new MembersVO();
				System.out.println("3-3 user: "+user);
				user.setId(rs.getString("ID"));
			}else {
				user = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		 return user;
		
	}
	
	
	

}
