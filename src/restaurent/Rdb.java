/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author SIYAM
 */
@Entity
@Table(name = "rdb", catalog = "restaurantbd", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rdb.findAll", query = "SELECT r FROM Rdb r"),
    @NamedQuery(name = "Rdb.findByDate", query = "SELECT r FROM Rdb r WHERE r.date = :date"),
    @NamedQuery(name = "Rdb.findByTime", query = "SELECT r FROM Rdb r WHERE r.time = :time"),
    @NamedQuery(name = "Rdb.findByTotal", query = "SELECT r FROM Rdb r WHERE r.total = :total")})
public class Rdb implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "Date")
    private String date;
    @Id
    @Basic(optional = false)
    @Column(name = "Time")
    private String time;
    @Column(name = "Total")
    private String total;

    public Rdb() {
    }

    public Rdb(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        String oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        String oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (time != null ? time.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rdb)) {
            return false;
        }
        Rdb other = (Rdb) object;
        if ((this.time == null && other.time != null) || (this.time != null && !this.time.equals(other.time))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurent.Rdb[ time=" + time + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
