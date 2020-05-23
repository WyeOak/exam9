package com.exam.forum.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "Users")
public class User implements UserDetails {
    @MongoId
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    @Builder.Default
    private String image = "no-image.jpg";
    @NotBlank
    private String login;
    @NotNull
    @Email(message = "example@gmail.com")
    private String email;
    @NotBlank @Min(8)
    private String password;
    @Builder.Default
    private boolean enabled = true;
    @Builder.Default
    private String role = "USER";
    private int comments;

    public void plusComment() {
        this.comments++;
    }
    public void minusComment() {
        this.comments--;
    }


    @Override
    public String getUsername() {
        return this.email;
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role));
    }}