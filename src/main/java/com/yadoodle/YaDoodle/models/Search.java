package com.yadoodle.YaDoodle.models;

import org.springframework.data.keyvalue.annotation.KeySpace;

import javax.persistence.*;

@Entity
@Table(name="search")
@KeySpace("searches")
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String desc;
    private String url;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
