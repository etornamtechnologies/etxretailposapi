package com.etx.engineering.PosService.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadUserByusername(String username) throws UsernameNotFoundException;
}
