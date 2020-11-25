/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Reo
 */
@Entity
@Table(name = "DVD_CATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DvdCatalog.findAll", query = "SELECT d FROM DvdCatalog d"),
    @NamedQuery(name = "DvdCatalog.findById", query = "SELECT d FROM DvdCatalog d WHERE d.id = :id"),
    @NamedQuery(name = "DvdCatalog.findByName", query = "SELECT d FROM DvdCatalog d WHERE d.name = :name"),
    @NamedQuery(name = "DvdCatalog.findByRate", query = "SELECT d FROM DvdCatalog d WHERE d.rate = :rate"),
    @NamedQuery(name = "DvdCatalog.findByYears", query = "SELECT d FROM DvdCatalog d WHERE d.years = :years"),
    @NamedQuery(name = "DvdCatalog.findByPrice", query = "SELECT d FROM DvdCatalog d WHERE d.price = :price")})
public class DvdCatalog implements Serializable {

    @Size(max = 80)
    @Column(name = "NAME")
    private String name;
    @Size(max = 40)
    @Column(name = "RATE")
    private String rate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dvdId")
    private Collection<ShoppingCart1> shoppingCart1Collection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "YEARS")
    private Integer years;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;

    public DvdCatalog() {
    }

    public DvdCatalog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        if (!(object instanceof DvdCatalog)) {
            return false;
        }
        DvdCatalog other = (DvdCatalog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DvdCatalog[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @XmlTransient
    public Collection<ShoppingCart1> getShoppingCart1Collection() {
        return shoppingCart1Collection;
    }

    public void setShoppingCart1Collection(Collection<ShoppingCart1> shoppingCart1Collection) {
        this.shoppingCart1Collection = shoppingCart1Collection;
    }
    
}
