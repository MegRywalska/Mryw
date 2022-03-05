package com.mryw.dto;

import com.mryw.model.StatusPost;
import com.mryw.model.UserMryw;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDTO {
    private String text;
    private LocalDate creationDate = LocalDate.now();
    private StatusPost statusPost = StatusPost.ORIGINAL;
}
