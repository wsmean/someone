package com.sumin.someone.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sumin.someone.RandomVO;
import com.sumin.someone.common.JDBCUtil;

@Repository
public class RandomDAO {

	PreparedStatement pstmt = null;
	Connection conn=null;
	ResultSet rs = null;
	
	String SELECT_RANDOM = "SELECT * \r\n" + 
						   " FROM random_question\r\n" + 
						   " ORDER BY RAND()\r\n" + 
						   " LIMIT 1;"; 
					
	
	
	public List<RandomVO> loadrandom_question() {
		System.out.println("RandomDAO loadrandom_question들어옴");
		
		List<RandomVO> list = new ArrayList<RandomVO>();

        try {
        	conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(SELECT_RANDOM);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	int auto = rs.getInt("auto");
            	String question = rs.getString("question");
            	String mAnswer = rs.getString("mAnswer");
            	String cAnswer = rs.getString("cAnswer");

            	
            	RandomVO randoms = new RandomVO(auto, question, mAnswer, cAnswer);
            	list.add(randoms);
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
	
	//받은 대답 DB에 넣기
	String UPDATE_RANDOM = "UPDATE random_question SET mAnswer = ? WHERE auto = ?;";
	
	public String saveAnswer_(RandomVO vo) {
		System.out.println("RandomDAO saveAnswer 들어옴");
		System.out.println("DAO: "+vo);
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_RANDOM);
			pstmt.setString(1, vo.getmAnswer());
			pstmt.setInt(2, vo.getAuto());
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.close(pstmt, conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return UPDATE_RANDOM;
		
	}
}
