package com.Model;

import javax.persistence.*;

/**
 * Created by wuwan on 2016/9/30.
 */
@Entity
@Table(name = "autority_table", schema = "basissql", catalog = "")
public class AutorityEntity {
    private String id;
    private Integer vision;
    private MenuEntity menuTableByMenuid;
    private RoleEntity roleTableByRoleid;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Basic
    @Column(name = "VISION")
    public Integer getVision() {
        return vision;
    }

    public void setVision(Integer vision) {
        this.vision = vision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutorityEntity that = (AutorityEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        if (vision != null ? !vision.equals(that.vision) : that.vision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (vision != null ? vision.hashCode() : 0);
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
