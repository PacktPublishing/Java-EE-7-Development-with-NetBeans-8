/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "US_CITY")
@NamedQueries({
    @NamedQuery(name = "UsCity.findAll", query = "SELECT u FROM UsCity u"),
    @NamedQuery(name = "UsCity.findByUsCityId", query = "SELECT u FROM UsCity u WHERE u.usCityId = :usCityId"),
    @NamedQuery(name = "UsCity.findByUsCityNm", query = "SELECT u FROM UsCity u WHERE u.usCityNm = :usCityNm"),
    @NamedQuery(name = "UsCity.findByZip", query = "SELECT u FROM UsCity u WHERE u.zip = :zip")})
public class UsCity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "US_CITY_ID")
    private Integer usCityId;
    @Size(max = 30)
    @Column(name = "US_CITY_NM")
    private String usCityNm;
    @Size(max = 5)
    @Column(name = "ZIP")
    private String zip;
    @JoinColumn(name = "US_STATE_ID", referencedColumnName = "US_STATE_ID")
    @ManyToOne
    private UsState usState;

    public UsCity() {
    }

    public UsCity(Integer usCityId) {
        this.usCityId = usCityId;
    }

    public Integer getUsCityId() {
        return usCityId;
    }

    public void setUsCityId(Integer usCityId) {
        this.usCityId = usCityId;
    }

    public String getUsCityNm() {
        return usCityNm;
    }

    public void setUsCityNm(String usCityNm) {
        this.usCityNm = usCityNm;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public UsState getUsState() {
        return usState;
    }

    public void setUsState(UsState usState) {
        this.usState = usState;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usCityId != null ? usCityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsCity)) {
            return false;
        }
        UsCity other = (UsCity) object;
        if ((this.usCityId == null && other.usCityId != null) || (this.usCityId != null && !this.usCityId.equals(other.usCityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensode.jpa.UsCity[ usCityId=" + usCityId + " ]";
    }
    
}
