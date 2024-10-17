package me.yosae.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String email, String password, String auth){
        this.email = email;
        this.password = password;
    }

    @Override //권한 반한
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override //계정 만료 여부
    public boolean isAccountNonExpired() {
        // 만료되었는지 확인하는 로직 필요
        return true;
    }

    @Override //계정 잠금 여부
    public boolean isAccountNonLocked() {
        // 잠금되었는지 확인하는 로직 필요
        return true;
    }

    @Override //패스워드의 만료 여부
    public boolean isCredentialsNonExpired() {
        //패스워드가 만료되었는지 확인하는 로직 필요
        return true;
    }

    @Override //계정 사용 가능 여부
    public boolean isEnabled() {
        //계정 사용이 가능한지 확인하는 로직 필요
        return true;
    }

}
