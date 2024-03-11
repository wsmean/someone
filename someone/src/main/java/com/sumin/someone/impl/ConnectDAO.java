package com.sumin.someone.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sumin.someone.MembersVO;
import com.sumin.someone.ConnectVO;
import com.sumin.someone.common.JDBCUtil;

@Repository
public class ConnectDAO {

	static PreparedStatement pstmt = null;
	static Connection conn = null;
	static ResultSet rs = null;
	
	//members에서 회원 유무 확인
	static String SELECT_CONNECT = "SELECT * FROM members;";

	public static <MembersVo> String checkId(MembersVO vo) {
		System.out.println("3.checkDAO들어옴");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT_CONNECT);
			rs = pstmt.executeQuery();
			
			String check_id = vo.getId();
			System.out.println("내가 화면에서 받아 온 아이디: "+check_id);
			
			while(rs.next()) {
				String db_id = rs.getString("id");
				System.out.println("디비에서 가져온아이디: " +db_id);
				//만약 내가 받은 아이디랑 디비 아이디가 같다면
				if(check_id.equals(db_id)) {
					System.out.println("같은 아이디가 있네");
					return db_id;
					//break;
				}
				MembersVO user = new MembersVO();
				user.setId(db_id);
				}

			} catch (SQLException e) {
				System.out.println("왜 예외?");
				//e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, pstmt, conn);
		}
		//위의 if 조건이 false 일 경우 실행
		return null;
		
}
	
	//connect에서 중복 유무 확인
	static String SELECT_CHECK_CONNECT = "SELECT myid, coupleid FROM connect c WHERE c.myId = ? OR c.coupleId = ?;";
	public static List<ConnectVO> checkConnect(ConnectVO cvo) {
		System.out.println("checkConnect DAO들어옴");
		
		List<ConnectVO> list = new ArrayList<ConnectVO>();

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT_CHECK_CONNECT);
			String check_id = cvo.getMyId();
			System.out.println("내가 화면에서 받아 온 아이디: "+check_id);
			pstmt.setString(1, cvo.getMyId());
			System.out.println("c.myid : "+cvo.getMyId());
			pstmt.setString(2, cvo.getMyId());
			System.out.println("c.coupleid : "+cvo.getMyId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("아이디가 이미 연결 되어 있네요");
				return list;
			}else {
				System.out.println("아이디가 연결 되있지 않네요");
				return null;
			}

		}catch (SQLException e) {
				System.out.println("왜 예외?");
				//e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, pstmt, conn);
		}
		//위의 if 조건이 false 일 경우 실행
		return null;
	}
	
	//연결확인 된 아이디 끼리 같은 테이블에 넣기
	static String INSERT_CONNECT = "INSERT INTO connect(myId, coupleId) VALUE(?,?);";
	public String insertConnect(MembersVO vo) {
		System.out.println("insertConnectDAO로 들어옴");
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(INSERT_CONNECT);

			//현재 접속 계정 아이디
			pstmt.setString(1, vo.getM_id2());
			System.out.println("사용자 계정 아이디 : "+vo.getM_id2());
			//내가 입력한 아이디
			pstmt.setString(2, vo.getId2());
			System.out.println("받은 아이디 : "+vo.getId2());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("아이디가 이미 연결되어있습니다.");
			//e.printStackTrace();
		} finally {
            JDBCUtil.close(pstmt, conn);
        }
		return "true";

	}
	
	
}
