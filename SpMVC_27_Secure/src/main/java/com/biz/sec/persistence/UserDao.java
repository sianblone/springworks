package com.biz.sec.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.biz.sec.domain.UserVO;

public interface UserDao {
	
	public List<UserVO> selectAll();
	
	// VO는 username으로 설계해놓았기 때문에 AS를 이용해서 매핑될 수 있도록 설정해준다 
	@Select("SELECT user_name AS username FROM tbl_users WHERE user_name = #{username}")
	public String findByUserName(String username);
	
	public int insert(Map<String, String> userMap);
	
	public int update();

}
