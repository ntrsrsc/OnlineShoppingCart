/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Reo
 */
@Entity
@Table(name = "SHOPPING_CART1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingCart1.findAll", query = "SELECT s FROM ShoppingCart1 s"),
    @NamedQuery(name = "ShoppingCart1.findById", query = "SELECT s FROM ShoppingCart1 s WHERE s.id = :id"),
    @NamedQuery(name = "ShoppingCart1.findByQuantity", query = "SELECT s FROM ShoppingCart1 s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "ShoppingCart1.findByDvdId", query = "SELECT s FROM ShoppingCart1 s WHERE s.dvdId = :dvdId")
})
public class ShoppingCart1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "DVD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DvdCatalog dvdId;

    public ShoppingCart1() {
    }

    public ShoppingCart1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public DvdCatalog getDvdId() {
        return dvdId;
    }

    public void setDvdId(DvdCatalog dvdId) {
        this.dvdId = dvdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingCart1)) {
            return false;
        }
        ShoppingCart1 other = (ShoppingCart1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ShoppingCart1[ id=" + id + " ]";
    }
    
}
