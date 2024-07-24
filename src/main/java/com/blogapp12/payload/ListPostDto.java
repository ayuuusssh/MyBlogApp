package com.blogapp12.payload;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import java.util.List;

@Setter
@Getter
public class ListPostDto {
    private List<PostDto> postDto;
    private int totalPages;
    private int totalElements;
    private boolean firstPage;
    private boolean lastPage;
    private int pageNumber;


}
