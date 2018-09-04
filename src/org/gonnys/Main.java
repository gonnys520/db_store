package org.gonnys;

import org.gonnys.domain.MenuVO;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        VoteDAO dao = new VoteDAO();
//        dao.addVote("user");

//        ReviewVO vo = new ReviewVO();
//        vo.setMid("gonnys");
//        vo.setMno(8);
//        vo.setScore(5.0);
//        vo.setCmt("이거완전JMT아니냐");
//
//        ReviewDAO dao = new ReviewDAO();
//        dao.add(vo);

        MenuDAO vo = new MenuDAO();
        List<MenuVO> list = vo.getMenus(5);
        System.out.println(list);
    }
}
