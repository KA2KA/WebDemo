package com.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wuwan on 2016/9/30.
 */
@Entity
@Table(name = "menu_table", schema = "basissql", catalog = "")
public class MenuEntity {

    public static final Integer NORMAL = 1;
    private static final Integer LOGOUT = 0;
    private String id;
    private Integer parentid;
    private String name;
    private Integer grade;
    private String url;
    private String action;
    private Integer state;
    private Integer isleaf;
    private String iconcls;
    private Integer vision;
    private Collection<AutorityEntity> autorityTablesById;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PARENTID")
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "GRADE")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "ACTION")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
    @Column(name = "ISLEAF")
    public Integer getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(Integer isleaf) {
        this.isleaf = isleaf;
    }

    @Basic
    @Column(name = "ICONCLS")
    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
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

        MenuEntity that = (MenuEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (parentid != null ? !parentid.equals(that.parentid) : that.parentid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (isleaf != null ? !isleaf.equals(that.isleaf) : that.isleaf != null) return false;
        if (iconcls != null ? !iconcls.equals(that.iconcls) : that.iconcls != null) return false;
        if (vision != null ? !vision.equals(that.vision) : that.vision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parentid != null ? parentid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (isleaf != null ? isleaf.hashCode() : 0);
        result = 31 * result + (iconcls != null ? iconcls.hashCode() : 0);
        result = 31 * result + (vision != null ? vision.hashCode() : 0);
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
