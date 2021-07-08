/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policedbms;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author shubham
 */
@Entity
@Table(name = "Officer", catalog = "Police", schema = "")
@NamedQueries({
    @NamedQuery(name = "Officer.findAll", query = "SELECT o FROM Officer o"),
    @NamedQuery(name = "Officer.findByPolID", query = "SELECT o FROM Officer o WHERE o.polID = :polID"),
    @NamedQuery(name = "Officer.findByPolName", query = "SELECT o FROM Officer o WHERE o.polName = :polName"),
    @NamedQuery(name = "Officer.findByPolAdd", query = "SELECT o FROM Officer o WHERE o.polAdd = :polAdd"),
    @NamedQuery(name = "Officer.findByPolPhone", query = "SELECT o FROM Officer o WHERE o.polPhone = :polPhone"),
    @NamedQuery(name = "Officer.findByPolEmail", query = "SELECT o FROM Officer o WHERE o.polEmail = :polEmail"),
    @NamedQuery(name = "Officer.findByPolDOB", query = "SELECT o FROM Officer o WHERE o.polDOB = :polDOB")})
public class Officer implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PolID")
    private Integer polID;
    @Basic(optional = false)
    @Column(name = "PolName")
    private String polName;
    @Basic(optional = false)
    @Column(name = "PolAdd")
    private String polAdd;
    @Basic(optional = false)
    @Column(name = "PolPhone")
    private String polPhone;
    @Basic(optional = false)
    @Column(name = "PolEmail")
    private String polEmail;
    @Basic(optional = false)
    @Column(name = "PolDOB")
    @Temporal(TemporalType.DATE)
    private Date polDOB;

    public Officer() {
    }

    public Officer(Integer polID) {
        this.polID = polID;
    }

    public Officer(Integer polID, String polName, String polAdd, String polPhone, String polEmail, Date polDOB) {
        this.polID = polID;
        this.polName = polName;
        this.polAdd = polAdd;
        this.polPhone = polPhone;
        this.polEmail = polEmail;
        this.polDOB = polDOB;
    }

    public Integer getPolID() {
        return polID;
    }

    public void setPolID(Integer polID) {
        Integer oldPolID = this.polID;
        this.polID = polID;
        changeSupport.firePropertyChange("polID", oldPolID, polID);
    }

    public String getPolName() {
        return polName;
    }

    public void setPolName(String polName) {
        String oldPolName = this.polName;
        this.polName = polName;
        changeSupport.firePropertyChange("polName", oldPolName, polName);
    }

    public String getPolAdd() {
        return polAdd;
    }

    public void setPolAdd(String polAdd) {
        String oldPolAdd = this.polAdd;
        this.polAdd = polAdd;
        changeSupport.firePropertyChange("polAdd", oldPolAdd, polAdd);
    }

    public String getPolPhone() {
        return polPhone;
    }

    public void setPolPhone(String polPhone) {
        String oldPolPhone = this.polPhone;
        this.polPhone = polPhone;
        changeSupport.firePropertyChange("polPhone", oldPolPhone, polPhone);
    }

    public String getPolEmail() {
        return polEmail;
    }

    public void setPolEmail(String polEmail) {
        String oldPolEmail = this.polEmail;
        this.polEmail = polEmail;
        changeSupport.firePropertyChange("polEmail", oldPolEmail, polEmail);
    }

    public Date getPolDOB() {
        return polDOB;
    }

    public void setPolDOB(Date polDOB) {
        Date oldPolDOB = this.polDOB;
        this.polDOB = polDOB;
        changeSupport.firePropertyChange("polDOB", oldPolDOB, polDOB);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polID != null ? polID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Officer)) {
            return false;
        }
        Officer other = (Officer) object;
        if ((this.polID == null && other.polID != null) || (this.polID != null && !this.polID.equals(other.polID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "policedbms.Officer[ polID=" + polID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
