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
@Table(name = "CUSTOMER_ORDER")
@NamedQueries({
    @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c"),
    @NamedQuery(name = "CustomerOrder.findByCustomerOrderId", query = "SELECT c FROM CustomerOrder c WHERE c.customerOrderId = :customerOrderId"),
    @NamedQuery(name = "CustomerOrder.findByOrderNumber", query = "SELECT c FROM CustomerOrder c WHERE c.orderNumber = :orderNumber"),
    @NamedQuery(name = "CustomerOrder.findByOrderDescription", query = "SELECT c FROM CustomerOrder c WHERE c.orderDescription = :orderDescription")})
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMER_ORDER_ID")
    private Integer customerOrderId;
    @Size(max = 10)
    @Column(name = "ORDER_NUMBER")
    private String orderNumber;
    @Size(max = 200)
    @Column(name = "ORDER_DESCRIPTION")
    private String orderDescription;
    @JoinTable(name = "ORDER_ITEM", joinColumns = {
        @JoinColumn(name = "CUSTOMER_ORDER_ID", referencedColumnName = "CUSTOMER_ORDER_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")})
    @ManyToMany
    private Collection<Item> itemCollection;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne
    private Customer customer;

    public CustomerOrder() {
    }

    public CustomerOrder(Integer customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Integer getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Integer customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerOrderId != null ? customerOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.customerOrderId == null && other.customerOrderId != null) || (this.customerOrderId != null && !this.customerOrderId.equals(other.customerOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensode.jpa.CustomerOrder[ customerOrderId=" + customerOrderId + " ]";
    }
    
}
