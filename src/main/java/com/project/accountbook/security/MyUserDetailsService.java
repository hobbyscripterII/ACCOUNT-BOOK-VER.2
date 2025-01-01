package com.project.accountbook.security;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.accountbook.user.UserMapper;

@Service
public class MyUserDetailsService implements UserDetailsService {
	Logger log = LoggerFactory.getLogger(getClass());
    private final UserMapper userMapper;

    public MyUserDetailsService(UserMapper userMapper) {
    	this.userMapper = userMapper;
	}
    
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    	log.info("id = {}", id);
    	
        MyUserDetails myUserDetails = userMapper.getUser(id);
        
        log.info("myUserDetails = {}", myUserDetails);
        
        if (myUserDetails != null) {
            return myUserDetails;
        } else {
            throw new UsernameNotFoundException("자격 증명에 실패하였습니다.");
        }
    }
    
	public String getRole() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>) authentication.getAuthorities();
		
		return authorities.stream()
						  .findFirst()
						  .map(GrantedAuthority :: getAuthority)
						  .orElse(null);
	}
}