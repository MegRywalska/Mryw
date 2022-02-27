package com.mryw.dto;

import com.mryw.model.Post;
import com.mryw.model.StatusPost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String text;
    private LocalDate creationDate;
    private StatusPost statusPost;
    private int numberOfComments;
    private int numberOfHearts;
    private String accountName;

    public static PostDTO fromPost(Post post){
        return PostDTO.builder()
                .id(post.getId())
                .text(post.getText())
                .creationDate(post.getCreationDate())
                .statusPost(post.getStatusPost())
                .numberOfComments(post.getComments().size())
                .numberOfHearts(post.getHearts().size())
                .accountName(post.getCreatorPost()!= null ? post.getCreatorPost().getAccountName() : "Unknown")
                .build();
    }
}
