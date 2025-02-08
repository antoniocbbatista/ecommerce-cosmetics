package com.cosmetics.ecommerce.service;

import com.cosmetics.ecommerce.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private CostumerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var user = repository.findByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("Usuário nao encontrado: " + login);
        }
        return user;
    }

}
