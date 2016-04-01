/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author heffel
 */
@Entity
@Table(name = "APP_USER")
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.findByAppUserId", query = "SELECT a FROM AppUser a WHERE a.appUserId = :appUserId"),
    @NamedQuery(name = "AppUser.findByUserName", query = "SELECT a FROM AppUser a WHERE a.userName = :userName"),
    @NamedQuery(name = "AppUser.findByPassword", query = "SELECT a FROM AppUser a WHERE a.password = :password")})
public class AppUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "APP_USER_ID")
    private Integer appUserId;
    @Size(max = 10)
    @Column(name = "USER_NAME")
    private String userName;
    @Size(max = 15)
    @Column(name = "PASSWORD")
    private String password;
    @JoinTable(name = "APP_USER_ROLE", joinColumns = {
        @JoinColumn(name = "APP_USER_ID", referencedColumnName = "APP_USER_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USER_ROLE_ID", referencedColumnName = "ROLE_ID")})
    @ManyToMany
    private Collection<UserRole> userRoleCollection;

    public AppUser() {
    }

    public AppUser(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<UserRole> getUserRoleCollection() {
        return userRoleCollection;
    }

    public void setUserRoleCollection(Collection<UserRole> userRoleCollection) {
        this.userRoleCollection = userRoleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appUserId != null ? appUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.appUserId == null && other.appUserId != null) || (this.appUserId != null && !this.appUserId.equals(other.appUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensode.jpa.AppUser[ appUserId=" + appUserId + " ]";
    }
    
}
