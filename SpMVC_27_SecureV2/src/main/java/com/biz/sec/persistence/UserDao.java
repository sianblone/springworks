package com.biz.sec.persistence;

import java.util.List;

import com.biz.sec.domain.UserDetailsVO;

public interface UserDao {
	
	public List<UserDetailsVO> selectAll();
	
	public UserDetailsVO findById(long id);
	
	public void create_table(String create_table);
	
	public UserDetailsVO findByUserName(String username);
	
	public UserDetailsVO findByUsernameAuthorities(String username);
	
	public int insert(UserDetailsVO userVO);
	
	public int updateInfo(UserDetailsVO userVO);

	public int updatePW(UserDetailsVO userVO);

}
