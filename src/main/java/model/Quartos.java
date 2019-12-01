
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "quartos")
public class Quartos implements Serializable {

    @OneToMany(mappedBy = "idQuartos")
    private Collection<Aluguel> aluguelCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numeroQuarto")
    private Integer numeroQuarto;
    @Size(max = 50)
    @Column(name = "tipoQuartos")
    private String tipoQuartos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorQuarto")
    private Float valorQuarto;

    public Quartos() {
    }
    public Quartos(int numeroQuarto, String tipoQuartos, float valorQuarto) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuartos = tipoQuartos;
        this.valorQuarto = valorQuarto;
    }

    public Quartos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
    

    public String getTipoQuartos() {
        return tipoQuartos;
    }

    public void setTipoQuartos(String tipoQuartos) {
        this.tipoQuartos = tipoQuartos;
    }

    public Float getValorQuarto() {
        return valorQuarto;
    }

    public void setValorQuarto(Float valorQuarto) {
        this.valorQuarto = valorQuarto;
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
        if (!(object instanceof Quartos)) {
            return false;
        }
        Quartos other = (Quartos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Quartos[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Aluguel> getAluguelCollection() {
        return aluguelCollection;
    }

    public void setAluguelCollection(Collection<Aluguel> aluguelCollection) {
        this.aluguelCollection = aluguelCollection;
    }
    
}
