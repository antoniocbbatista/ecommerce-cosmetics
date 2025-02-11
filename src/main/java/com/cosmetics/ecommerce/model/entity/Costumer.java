package com.cosmetics.ecommerce.model.entity;

import com.cosmetics.ecommerce.model.enums.CostumerRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "costumer")
public class Costumer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String login;

    private String name;

    private String password;

    private String email;

    private String cpf;

    private String phone;

    @OneToMany(mappedBy = "costumer")
    private List<Address> address;

    @OneToOne(mappedBy = "costumer")
    private Cart cart;

    private CostumerRole role;

    public Costumer(String login, String name, String password, String email, String cpf, String phone, List<Address> address, CostumerRole role) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public Costumer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == CostumerRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
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
