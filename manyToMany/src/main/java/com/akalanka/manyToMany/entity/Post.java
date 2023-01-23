package com.akalanka.manyToMany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private Date postedOn = new Date();
    @Column(name = "updated_at")
    private Date updatedOn = new Date();
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_tag", joinColumns = {
            @JoinColumn(name = "post_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "tag_id",
                    nullable = false, updatable = false) })
    private Set<Tag> tags = new HashSet<>();
}
