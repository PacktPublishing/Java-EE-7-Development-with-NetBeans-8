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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author heffel
 */
@Entity
@Table(name = "TELEPHONE_TYPE")
@NamedQueries({
    @NamedQuery(name = "TelephoneType.findAll", query = "SELECT t FROM TelephoneType t"),
    @NamedQuery(name = "TelephoneType.findByTelephoneTypeId", query = "SELECT t FROM TelephoneType t WHERE t.telephoneTypeId = :telephoneTypeId"),
    @NamedQuery(name = "TelephoneType.findByTelephoneTypeCd", query = "SELECT t FROM TelephoneType t WHERE t.telephoneTypeCd = :telephoneTypeCd"),
    @NamedQuery(name = "TelephoneType.findByTelephoneTypeText", query = "SELECT t FROM TelephoneType t WHERE t.telephoneTypeText = :telephoneTypeText")})
public class TelephoneType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEPHONE_TYPE_ID")
    private Integer telephoneTypeId;
    @Column(name = "TELEPHONE_TYPE_CD")
    private Character telephoneTypeCd;
    @Size(max = 20)
    @Column(name = "TELEPHONE_TYPE_TEXT")
    private String telephoneTypeText;
    @OneToMany(mappedBy = "telephoneType")
    private Collection<Telephone> telephoneCollection;

    public TelephoneType() {
    }

    public TelephoneType(Integer telephoneTypeId) {
        this.telephoneTypeId = telephoneTypeId;
    }

    public Integer getTelephoneTypeId() {
        return telephoneTypeId;
    }

    public void setTelephoneTypeId(Integer telephoneTypeId) {
        this.telephoneTypeId = telephoneTypeId;
    }

    public Character getTelephoneTypeCd() {
        return telephoneTypeCd;
    }

    public void setTelephoneTypeCd(Character telephoneTypeCd) {
        this.telephoneTypeCd = telephoneTypeCd;
    }

    public String getTelephoneTypeText() {
        return telephoneTypeText;
    }

    public void setTelephoneTypeText(String telephoneTypeText) {
        this.telephoneTypeText = telephoneTypeText;
    }

    public Collection<Telephone> getTelephoneCollection() {
        return telephoneCollection;
    }

    public void setTelephoneCollection(Collection<Telephone> telephoneCollection) {
        this.telephoneCollection = telephoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telephoneTypeId != null ? telephoneTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelephoneType)) {
            return false;
        }
        TelephoneType other = (TelephoneType) object;
        if ((this.telephoneTypeId == null && other.telephoneTypeId != null) || (this.telephoneTypeId != null && !this.telephoneTypeId.equals(other.telephoneTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensode.jpa.TelephoneType[ telephoneTypeId=" + telephoneTypeId + " ]";
    }
    
}
