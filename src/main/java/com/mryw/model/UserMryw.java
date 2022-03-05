package com.mryw.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Builder
@Setter
@Getter
@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
public class UserMryw implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String accountName;
    private String password;

    private String accountURL;

    @CreationTimestamp
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    private StatusAccount statusAccount;

    @Lob
    private Blob avatar;

    @OneToMany(mappedBy = "userMryw")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Set<Heart> hearts;

    @OneToMany(mappedBy = "creatorPost")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Post> posts;

    @OneToMany(mappedBy = "creatorComment")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Comment> comments;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    private Set<UserMryw> observedUsers;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "observedUsers")
    private Set<UserMryw> observedByUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Override
    public String getUsername() {
        return email;
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
