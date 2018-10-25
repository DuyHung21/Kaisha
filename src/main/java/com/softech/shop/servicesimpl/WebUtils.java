/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.shop.servicesimpl;

import com.softech.shop.model.Employees;
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
 *
 * @author Nguyen Tri
 */
public class WebUtils {
    public static String toString(User user) {
        StringBuilder sb = new StringBuilder();
 
        sb.append("LoginName:").append(user.getUsername());
 
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
