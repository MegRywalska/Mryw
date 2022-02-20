package com.mryw.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private String text;

    @CreationTimestamp
    private LocalDate creationDate;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserMryw creatorComment;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Comment comment;




}
