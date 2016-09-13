package com.Model;

import javax.persistence.*;

/**
 * Created by wuwan on 2016/8/21.
 */
@Entity
@Table(name = "test", schema = "basissql", catalog = "")
public class Test {

    private  Integer id ;

    private  String name;

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
