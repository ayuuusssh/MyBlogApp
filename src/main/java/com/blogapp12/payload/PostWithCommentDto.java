package com.blogapp12.payload;

import com.blogapp12.entity.Post;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PostWithCommentDto {
    private PostDto post;
   private List<CommentDto> commentDto=new ArrayList<>();
   
    @Override
    public String toString() {
        return "PostWithCommentDto{" +
                "post=" + post +
                ", commentDto=" + commentDto +
                '}';
    }
}
