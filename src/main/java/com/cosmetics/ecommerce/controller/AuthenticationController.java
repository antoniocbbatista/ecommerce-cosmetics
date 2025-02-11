package com.cosmetics.ecommerce.controller;

import com.cosmetics.ecommerce.infra.security.TokenService;
import com.cosmetics.ecommerce.model.dto.AuthenticationDTO;
import com.cosmetics.ecommerce.model.dto.LoginResponseDTO;
import com.cosmetics.ecommerce.model.dto.RegisterDTO;
import com.cosmetics.ecommerce.model.entity.Costumer;
import com.cosmetics.ecommerce.repository.CostumerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        System.out.println("Tentativa de login com usuário: " + data.login());
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((Costumer) auth.getPrincipal());
            System.out.println("Login bem-sucedido para usuário: " + data.login());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e) {
            System.err.println("Erro ao tentar autenticar usuário: " + data.login());
            e.printStackTrace();
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.costumerRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Costumer newCostumer = new Costumer(data.login(), data.name(), encryptedPassword, data.email(), data.cpf(), data.phone(), data.address(), data.role());
        this.costumerRepository.save(newCostumer);
        return ResponseEntity.ok().build();
    }
}
