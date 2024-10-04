package com.johnbordner.NFLhypoBet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private int totalWins;
    private int totalLosses;
    private double percentage;
    private int points;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You can return roles or authorities here
        return null;  // Return roles/authorities if you have them
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Or implement logic to check if the account is expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Or implement logic to check if the account is locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Or implement logic to check if credentials are expired
    }

    @Override
    public boolean isEnabled() {
        return true;  // Or implement logic to check if the user is enabled
    }



}
