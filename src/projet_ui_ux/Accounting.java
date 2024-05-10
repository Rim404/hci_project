/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ui_ux;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author fcb
 */
@Entity
@Table(name = "accounting", catalog = "hci_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Accounting.findAll", query = "SELECT a FROM Accounting a")
    , @NamedQuery(name = "Accounting.findById", query = "SELECT a FROM Accounting a WHERE a.id = :id")
    , @NamedQuery(name = "Accounting.findByRevenue", query = "SELECT a FROM Accounting a WHERE a.revenue = :revenue")
    , @NamedQuery(name = "Accounting.findByDate", query = "SELECT a FROM Accounting a WHERE a.date = :date")
    , @NamedQuery(name = "Accounting.findByCustomer", query = "SELECT a FROM Accounting a WHERE a.customer = :customer")
    , @NamedQuery(name = "Accounting.findByOrderId", query = "SELECT a FROM Accounting a WHERE a.orderId = :orderId")})
public class Accounting implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "revenue")
    private BigDecimal revenue;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "customer")
    private String customer;
    @Column(name = "order_id")
    private Integer orderId;

    public Accounting() {
    }

    public Accounting(Integer id) {
        this.id = id;
    }

    public Accounting(Integer id, BigDecimal revenue, Date date) {
        this.id = id;
        this.revenue = revenue;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        BigDecimal oldRevenue = this.revenue;
        this.revenue = revenue;
        changeSupport.firePropertyChange("revenue", oldRevenue, revenue);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        String oldCustomer = this.customer;
        this.customer = customer;
        changeSupport.firePropertyChange("customer", oldCustomer, customer);
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        Integer oldOrderId = this.orderId;
        this.orderId = orderId;
        changeSupport.firePropertyChange("orderId", oldOrderId, orderId);
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
        if (!(object instanceof Accounting)) {
            return false;
        }
        Accounting other = (Accounting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projet_ui_ux.Accounting[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
