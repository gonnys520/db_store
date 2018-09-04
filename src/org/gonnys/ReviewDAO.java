package org.gonnys;

import org.gonnys.domain.ReviewVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReviewDAO {

    public void add(ReviewVO vo) {

        //PreparedStatement를 이용하여 sql문 실행.

        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "insert into tbl_review (rno, mid, mno, score, cmt) values (seq_review.nextval, ?, ?, ?,?)"; //값을 넣을 부분만 물음표를 넣어준다.

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.10.10.91:1521:XE",
                    "zerock",
                    "12345678");
            System.out.println(con);
            stmt = con.prepareStatement(sql);
            //mid, mno, score가 전달되어야 한다.
            stmt.setString(1, vo.getMid());
            stmt.setInt(2, vo.getMno());
            stmt.setDouble(3, vo.getScore());
            stmt.setString(4, vo.getCmt());


            int count = stmt.executeUpdate();
            System.out.println(count);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {
                    }

                }// end if
            }//end finally

        }

    }

}