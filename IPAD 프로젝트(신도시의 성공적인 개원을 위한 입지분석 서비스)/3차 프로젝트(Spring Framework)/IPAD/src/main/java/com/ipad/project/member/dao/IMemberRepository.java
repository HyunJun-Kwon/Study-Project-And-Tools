package com.ipad.project.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ipad.project.member.model.MemberVO;

@Repository
public interface IMemberRepository {
	void insertMember(@Param("id") String id,@Param("pass1") String pass1,@Param("email") String email,@Param("name") String name,@Param("tel") String tel,@Param("year") String year,@Param("map") String map);
	List<MemberVO> confirmId(@Param("id") String id);
	List<MemberVO> loginCheck(@Param("id") String id, @Param("pass1") String pass1);
	List<MemberVO> editSearch(@Param("id") String id, @Param("pass") String pass);
	void editUpdate(@Param("id") String id, @Param("pass1") String pass1, @Param("email") String email,@Param("name") String name,@Param("tel") String tel,@Param("year") String year,@Param("map") String map);
	void deleteMember(@Param("id") String id, @Param("pass1") String pass1);
}
