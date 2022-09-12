package com.example.SistemaClinicaOdontologica.Entity.Login;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NonNull
@Entity
public class appUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String Password;
    @Enumerated(EnumType.STRING)
    private appUsuarioRoles RolUsuario;

    public appUser() {

    }

    public appUser(String nombre, String username, String email, String password, appUsuarioRoles rolUsuario) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        Password = password;
        RolUsuario = rolUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUsuarioRoles.ROLE_USER.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
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
