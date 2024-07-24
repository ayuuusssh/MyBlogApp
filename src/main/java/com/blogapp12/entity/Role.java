package com.blogapp12.entity;

import lombok.Setter;
import lombok.Getter;
import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(length=60)
    private String name;

}
