package com.project.accountbook.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.accountbook.cmmn.Const;

import lombok.Getter;

@Getter
public class MyUserDetails implements UserDetails {
    private String id;
    private String pw;
//    private String nickName;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(Const.ROLE_PREFIX + role));
        return list;
    }

    @Override public String getUsername() {return id;}
    @Override public String getPassword() {return pw;}
//		      public String getNickName() {return nickName;}
    @Override public boolean isAccountNonExpired() {return true;}
    @Override public boolean isAccountNonLocked() {return true;}
    @Override public boolean isCredentialsNonExpired() {return true;}
    @Override public boolean isEnabled() {return true;}
}