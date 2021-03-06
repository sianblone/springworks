package com.biz.sec.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biz.sec.domain.AuthorityVO;
import com.biz.sec.domain.UserDetailsVO;
import com.biz.sec.persistence.AuthoritiesDao;
import com.biz.sec.persistence.UserDao;

import lombok.RequiredArgsConstructor;

// DB에서 가져온 사용자의 상세정보를
// Spring Security 여러 곳에서 사용할 수 있도록 VO에 연동하는 메소드
// Spring Security의 UserDetailsService 인터페이스(또는 abstract 메소드)를 implements 하여 가져와서 커스터마이징
@RequiredArgsConstructor
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	/*
	 * 외부에서 주입받을 객체, 변수 선언
	 * 보통은 객체나 변수에 @Autowired를 사용하지만
	 * private final로 변수를 선언하고 @RequiredArgsConstructor 를 이용하여 변수를 생성(초기화)
	 * 이런 방식을 사용하지 않으려면 필드변수가 있는 생성자를 만들고, 생성자에서 초기화를 해주어야 한다(그리고 생성자에 @Autowired 붙이기)
	 */
	private final AuthoritiesDao authDao;
	private final UserDao userDao;
	
	/*
	 * loadUserByUserName
	 * DB로부터 데이터를 불러와서 UserDetailsVO에 데이터를 복사하여 연동하는 코드가 작성될 곳
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// DB로부터 사용자 정보 가져오기
		// UserVO userVO = userDao.findByUserName(username);
		
		// spring security가 사용할 UserDetails를 implements한 VO 선언
		// UserDetailsVO userDetails = new UserDetailsVO();
		UserDetailsVO userDetails = userDao.findByUserName(username);
		if(userDetails == null) {
			throw new UsernameNotFoundException("등록되지 않은 사용자입니다");
		}
		
		
		// userDetails.setUsername(userVO.getUsername());
		// userDetails.setPassword(userVO.getPassword());
		// userDetails.setEnabled(true);
		
		// 사용자 정보를 사용할 수 있는지 아닌지를 세밀하게 제어하기 위한 칼럼들
		userDetails.setAccountNonExpired(true);//유저 정보가 만료되지 않았는지
		userDetails.setAccountNonLocked(true);//유저 정보가 잠기지 않았는지
		userDetails.setCredentialsNonExpired(true);//자격이 만료되지 않았는지
		userDetails.setAuthorities(this.getAuthoritiesCS(username));
		
//		userDetails.setEmail("n@n");
//		userDetails.setPhone("010-0000-0000");
//		userDetails.setAddress("지구");
		
		
		// builder pattern 이용
		/*
		userDetails = UserDetailsVO.builder()
							.username(userVO.getUsername())
							.password(userVO.getPassword())
							.enabled(true)
							.accountNonExpired(true)
							.accountNonLocked(true)
							.credentialsNonExpired(true)
							.authorities(this.getAuthoritiesCS(username))
							.build();
		*/				
		
		return userDetails;
	}
	
	/**
	 * authorities 테이블에서 권한 리스트를 가져오기
	 */
	private Collection<GrantedAuthority> getAuthoritiesCS(String username) {
		List<AuthorityVO> authList = authDao.findByUserName(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();//JAVA 1.8 이하에서는 뒤의 제네릭에도 type을 똑같이 지정해주어야 한다
		for(AuthorityVO vo : authList) {
			SimpleGrantedAuthority sAuth = new SimpleGrantedAuthority(vo.getAuthority());
			authorities.add(sAuth);
		}
		
		return authorities;
	}
	
}
