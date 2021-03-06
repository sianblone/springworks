package com.biz.shop.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.biz.shop.domain.CustomUserDetails;

/*
 * Spring Security의 authentication 클래스 상속
 * 아래의 supports() 메소드가 true를 리턴하면
 * 정상적으로 로그인된 사용자 정보가 token 형태로
 * default-target-url에 지정된 controller path로 데이터가 전송된다
 * 
 * authenticate에서 필요한 사용자 정보를 만들거나 가공할 수 있다
 */
public class CustomAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal(); // username 추출
		String password = (String) authentication.getCredentials(); // password 추출
		
		if(username == null || username.isEmpty()) {
			return null;
		}
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		roles.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
		
		/*
		 * 만약 해당 사용자 Detail 정보가 DB에 있다면
		 * 해당 정보를 DB에서 조회하여
		 * CustomUserDetails 클래스에 세팅해서 controller로 전송할 수 있다
		 */
		CustomUserDetails cUserDetails = new CustomUserDetails();
//		cUserDetails.setNickname("홍길동");
//		cUserDetails.setTel("010-1111-1111");
//		cUserDetails.setTel("서울특별시");
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					username,//principal
					password,//credentials
					roles//authorities
				);
		token.setDetails(cUserDetails);
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
