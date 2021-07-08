/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPack;

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
 * @author shubham
 */
@Entity
@Table(name = "Station", catalog = "Police", schema = "")
@NamedQueries({
    @NamedQuery(name = "Station.findAll", query = "SELECT s FROM Station s"),
    @NamedQuery(name = "Station.findByStdID", query = "SELECT s FROM Station s WHERE s.stdID = :stdID"),
    @NamedQuery(name = "Station.findByStdName", query = "SELECT s FROM Station s WHERE s.stdName = :stdName"),
    @NamedQuery(name = "Station.findByStdCity", query = "SELECT s FROM Station s WHERE s.stdCity = :stdCity"),
    @NamedQuery(name = "Station.findByStdPhone", query = "SELECT s FROM Station s WHERE s.stdPhone = :stdPhone"),
    @NamedQuery(name = "Station.findByStdAdd", query = "SELECT s FROM Station s WHERE s.stdAdd = :stdAdd")})
public class Station implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "StdID")
    private Integer stdID;
    @Basic(optional = false)
    @Column(name = "StdName")
    private String stdName;
    @Basic(optional = false)
    @Column(name = "StdCity")
    private String stdCity;
    @Basic(optional = false)
    @Column(name = "StdPhone")
    private String stdPhone;
    @Basic(optional = false)
    @Column(name = "StdAdd")
    private String stdAdd;

    public Station() {
    }

    public Station(Integer stdID) {
        this.stdID = stdID;
    }

    public Station(Integer stdID, String stdName, String stdCity, String stdPhone, String stdAdd) {
        this.stdID = stdID;
        this.stdName = stdName;
        this.stdCity = stdCity;
        this.stdPhone = stdPhone;
        this.stdAdd = stdAdd;
    }

    public Integer getStdID() {
        return stdID;
    }

    public void setStdID(Integer stdID) {
        Integer oldStdID = this.stdID;
        this.stdID = stdID;
        changeSupport.firePropertyChange("stdID", oldStdID, stdID);
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        String oldStdName = this.stdName;
        this.stdName = stdName;
        changeSupport.firePropertyChange("stdName", oldStdName, stdName);
    }

    public String getStdCity() {
        return stdCity;
    }

    public void setStdCity(String stdCity) {
        String oldStdCity = this.stdCity;
        this.stdCity = stdCity;
        changeSupport.firePropertyChange("stdCity", oldStdCity, stdCity);
    }

    public String getStdPhone() {
        return stdPhone;
    }

    public void setStdPhone(String stdPhone) {
        String oldStdPhone = this.stdPhone;
        this.stdPhone = stdPhone;
        changeSupport.firePropertyChange("stdPhone", oldStdPhone, stdPhone);
    }

    public String getStdAdd() {
        return stdAdd;
    }

    public void setStdAdd(String stdAdd) {
        String oldStdAdd = this.stdAdd;
        this.stdAdd = stdAdd;
        changeSupport.firePropertyChange("stdAdd", oldStdAdd, stdAdd);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdID != null ? stdID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Station)) {
            return false;
        }
        Station other = (Station) object;
        if ((this.stdID == null && other.stdID != null) || (this.stdID != null && !this.stdID.equals(other.stdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MainPack.Station[ stdID=" + stdID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
