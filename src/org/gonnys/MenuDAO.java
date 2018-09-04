package org.gonnys;

import org.gonnys.domain.MenuVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    public List<MenuVO> getMenus(int sno) {
        String sql = "select * from tbl_menu where sno = ? order by mno";
        List<MenuVO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.10.10.91:1521:XE",
                    "zerock",
                    "12345678");
            System.out.println(con);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, sno);

            rs = stmt.executeQuery();

            while (rs.next()) {
                MenuVO vo = new MenuVO();
                vo.setMno(rs.getInt("mno"));
                vo.setSmo(rs.getInt("sno"));
                vo.setMname(rs.getString("mname"));
                vo.setPrice(rs.getInt("price"));
                list.add(vo);
            }

        }//close try
        catch (Exception e) {
            System.out.println(e.getMessage());
        }//close catch
        finally {
            if (rs != null) { try { rs.close(); } catch (Exception e) { }}
            if (stmt != null) { try { stmt.close(); } catch (Exception e) { }}
            if (con != null) { try { con.close(); } catch (Exception e) { }}
        }//close finally
        return list;

            }//close getmanus
        }//close menuDAO

