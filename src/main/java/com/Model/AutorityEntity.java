package com.Model;

import javax.persistence.*;

/**
 * Created by wuwan on 2016/8/20.
 */
@Entity
@Table(name = "autority_table", schema = "basissql", catalog = "")
public class AutorityEntity {
    private Integer id;
    private Integer menuid;
    private Integer roleid;
    private MenuEntity menuTableByMenuid;
    private RoleEntity roleTableByRoleid;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Transient
    @Column(name = "MENUID")
    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    @Basic
    @Transient
    @Column(name = "ROLEID")
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutorityEntity that = (AutorityEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (menuid != null ? !menuid.equals(that.menuid) : that.menuid != null) return false;
        if (roleid != null ? !roleid.equals(that.roleid) : that.roleid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (menuid != null ? menuid.hashCode() : 0);
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MENUID", referencedColumnName = "ID", nullable = false)
    public MenuEntity getMenuTableByMenuid() {
        return menuTableByMenuid;
    }

    public void setMenuTableByMenuid(MenuEntity menuTableByMenuid) {
        this.menuTableByMenuid = menuTableByMenuid;
    }

    @ManyToOne
    @JoinColumn(name = "ROLEID", referencedColumnName = "ID", nullable = false)
    public RoleEntity getRoleTableByRoleid() {
        return roleTableByRoleid;
    }

    public void setRoleTableByRoleid(RoleEntity roleTableByRoleid) {
        this.roleTableByRoleid = roleTableByRoleid;
    }
}
