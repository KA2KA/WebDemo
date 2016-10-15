package com.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wuwan on 2016/9/30.
 */
@Entity
@Table(name = "user_table", schema = "basissql", catalog = "")
public class UserEntity {
    public  static final Integer NORMAL = 1;//用户状态正常
    public static final Integer LOGOUT = 0;//用户状态注销
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String alias;
    private Integer state;
    private Integer vision;
    private Collection<UserRoleEntity> userRoleById;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "NICKNAME")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "ALIAS")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "STATE")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (alias != null ? !alias.equals(that.alias) : that.alias != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (vision != null ? !vision.equals(that.vision) : that.vision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (vision != null ? vision.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserid")
    public Collection<UserRoleEntity> getUserRoleById() {
        return userRoleById;
    }

    public void setUserRoleById(Collection<UserRoleEntity> userRoleById) {
        this.userRoleById = userRoleById;
    }
}
