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
@Table(name = "aluguel")

public class Aluguel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAluguel")
    private Integer idAluguel;
    @Column(name = "qtdDias")
    private Integer qtdDias;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorReceber")
    private Float valorReceber;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "idQuartos", referencedColumnName = "id")
    @ManyToOne
    private Quartos idQuartos;

    public Aluguel() {
    }

    public Aluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Integer getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Integer getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(Integer qtdDias) {
        this.qtdDias = qtdDias;
    }

    public Float getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(Float valorReceber) {
        this.valorReceber = valorReceber;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Quartos getIdQuartos() {
        return idQuartos;
    }

    public void setIdQuartos(Quartos idQuartos) {
        this.idQuartos = idQuartos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluguel != null ? idAluguel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) object;
        if ((this.idAluguel == null && other.idAluguel != null) || (this.idAluguel != null && !this.idAluguel.equals(other.idAluguel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aluguel[ idAluguel=" + idAluguel + " ]";
    }
    
}
