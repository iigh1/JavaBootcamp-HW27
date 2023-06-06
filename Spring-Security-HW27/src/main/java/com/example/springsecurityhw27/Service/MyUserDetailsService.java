package com.example.springsecurityhw27.Service;


import com.example.springsecurityhw27.ApiException.ApiException;
import com.example.springsecurityhw27.Model.MyUser;
import com.example.springsecurityhw27.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = authRepository.findUserByUsername(username);

        if (username==null){
            throw new ApiException("user not found");
        }
        return myUser;
    }
}
