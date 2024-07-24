package com.blogapp12.payload;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;
@Setter
@Getter
public class CommentDto {
    private long id;
    private String name;
    private String message;
}
