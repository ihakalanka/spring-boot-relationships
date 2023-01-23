package com.akalanka.oneToMany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "post_id", referencedColumnName = "id")
    List<Comment> comments = new ArrayList<>();

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
