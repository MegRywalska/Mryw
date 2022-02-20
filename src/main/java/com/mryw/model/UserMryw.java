package com.mryw.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
public class UserMryw {

    @Id
    private String login;

    private String password;
    private String accountName;
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


}
