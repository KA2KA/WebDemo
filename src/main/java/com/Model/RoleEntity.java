package com.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wuwan on 2016/8/20.
 */
@Entity
@Table(name = "role_table", schema = "basissql", catalog = "")
public class RoleEntity {
    private Integer id;
    private String rolename;
    private String description;
    private Collection<AutorityEntity> autorityTablesById;
    private Collection<UserRoleEntity> userroleTablesById;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLENAME")
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (rolename != null ? !rolename.equals(that.rolename) : that.rolename != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleTableByRoleid")
    public Collection<AutorityEntity> getAutorityTablesById() {
        return autorityTablesById;
    }

    public void setAutorityTablesById(Collection<AutorityEntity> autorityTablesById) {
        this.autorityTablesById = autorityTablesById;
    }

    @OneToMany(mappedBy = "roleTableByRoleid")
    public Collection<UserRoleEntity> getUserroleTablesById() {
        return userroleTablesById;
    }

    public void setUserroleTablesById(Collection<UserRoleEntity> userroleTablesById) {
        this.userroleTablesById = userroleTablesById;
    }
}
