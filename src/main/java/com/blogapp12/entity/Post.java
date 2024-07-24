package com.blogapp12.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "posts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String content;


    @OneToMany(mappedBy = "post",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<>();
}
