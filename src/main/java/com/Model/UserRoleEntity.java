package com.Model;

import javax.persistence.*;

/**
 * Created by wuwan on 2016/8/20.
 */
@Entity
@Table(name = "userrole_table", schema = "basissql", catalog = "")
public class UserRoleEntity {
    private Integer id;
    private Integer roleid;
    private Integer userid;
    private UserEntity userTableByUserid;
    private RoleEntity roleTableByRoleid;

    //@Transient标签将实体字段标记为游离态，将不加载该字段
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
    @Column(name = "ROLEID")
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "USERID")
    @Transient
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleEntity that = (UserRoleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (roleid != null ? !roleid.equals(that.roleid) : that.roleid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "ID", nullable = false)
    public UserEntity getUserTableByUserid() {
        return userTableByUserid;
    }

    public void setUserTableByUserid(UserEntity userTableByUserid) {
        this.userTableByUserid = userTableByUserid;
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
