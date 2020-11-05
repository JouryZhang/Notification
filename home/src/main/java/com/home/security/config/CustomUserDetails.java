package com.home.security.config;


import com.home.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：自定义UserDetails，使UserDetails具有TUser的实体结构
 * 自定义SpringSecurity的认证器
 * @author
 * @date 2019/12/19 15:43
 **/

public class CustomUserDetails extends User implements UserDetails {

    public CustomUserDetails(User tUser){
        if(null != tUser){

        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> permsSet = new HashSet<GrantedAuthority>();
//        if("2".equals(this.getRole())){
//            permsSet.add(new SimpleGrantedAuthority("admin"));
//        }else if("1".equals(this.getRole())){
//            permsSet.add(new SimpleGrantedAuthority("custom"));
//        }else if("3".equals(this.getRole())){
//            permsSet.add(new SimpleGrantedAuthority("saler"));
//        }
        return permsSet;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
