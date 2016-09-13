package com.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wuwan on 2016/8/20.
 */
@Entity
@Table(name = "menu_table", schema = "basissql", catalog = "")
public class MenuEntity {
    private Integer id;
    private String menuname;
    private Integer parentmenuid;
    private Collection<AutorityEntity> autorityTablesById;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MENUNAME")
    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    @Basic
    @Column(name = "PARENTMENUID")
    public Integer getParentmenuid() {
        return parentmenuid;
    }

    public void setParentmenuid(Integer parentmenuid) {
        this.parentmenuid = parentmenuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuEntity that = (MenuEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (menuname != null ? !menuname.equals(that.menuname) : that.menuname != null) return false;
        if (parentmenuid != null ? !parentmenuid.equals(that.parentmenuid) : that.parentmenuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (menuname != null ? menuname.hashCode() : 0);
        result = 31 * result + (parentmenuid != null ? parentmenuid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "menuTableByMenuid")
    public Collection<AutorityEntity> getAutorityTablesById() {
        return autorityTablesById;
    }

    public void setAutorityTablesById(Collection<AutorityEntity> autorityTablesById) {
        this.autorityTablesById = autorityTablesById;
    }
}
