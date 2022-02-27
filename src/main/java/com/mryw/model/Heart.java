package com.mryw.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long heartID;

    @CreationTimestamp
    private LocalDate creatDate;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserMryw userMryw;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Post post;


}
