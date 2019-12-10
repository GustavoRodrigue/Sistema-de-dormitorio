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
 * @author gustavo
 */
@Entity
@Table(name = "finalizaraluguel")
public class Finalizaraluguel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorReceber")
    private Float valorReceber;
    @Column(name = "QuantidadeDia")
    private Integer quantidadeDia;
    @JoinColumn(name = "idAluguel", referencedColumnName = "id")
    @ManyToOne
    private Aluguel idAluguel;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente idCliente;

    public Finalizaraluguel() {
    }

    public Finalizaraluguel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(Float valorReceber) {
        this.valorReceber = valorReceber;
    }

    public Integer getQuantidadeDia() {
        return quantidadeDia;
    }

    public void setQuantidadeDia(Integer quantidadeDia) {
        this.quantidadeDia = quantidadeDia;
    }

    public Aluguel getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Aluguel idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
        if (!(object instanceof Finalizaraluguel)) {
            return false;
        }
        Finalizaraluguel other = (Finalizaraluguel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Finalizaraluguel[ id=" + id + " ]";
    }
    
}
