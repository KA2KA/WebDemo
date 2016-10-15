package com.Model;

import javax.persistence.*;

/**
 * Created by wuwan on 2016/9/30.
 */
@Entity
@Table(name = "userrole_table", schema = "basissql", catalog = "")
public class UserRoleEntity {
    private Integer id;
    private Integer vision;
    private UserEntity userByUserid;
    private RoleEntity roleByRoleid;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

        UserRoleEntity that = (UserRoleEntity) o;

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
    @JoinColumn(name = "USERID", referencedColumnName = "ID", nullable = false)
    public UserEntity getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(UserEntity userTableByUserid) {
        this.userByUserid = userTableByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "ROLEID", referencedColumnName = "ID", nullable = false)
    public RoleEntity getRoleByRoleid() {
        return roleByRoleid;
    }

    public void setRoleByRoleid(RoleEntity roleTableByRoleid) {
        this.roleByRoleid = roleTableByRoleid;
    }
}
