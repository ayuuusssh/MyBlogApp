package com.blogapp12.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class PostDto {
    private long id;
    @NotEmpty
    @Size(min = 3,message = "Title should be atleatt 3 character")
    private String title;
    @NotEmpty
    @Size(min = 3, message = "Description should be atleat 3 character")
    private String description;
    private String content;

}
