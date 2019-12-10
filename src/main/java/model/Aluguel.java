/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorReceber")
    private Float valorReceber;
    @OneToMany(mappedBy = "idAluguel")
    private Collection<Finalizaraluguel> finalizaraluguelCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "data_encerramento")
    @Temporal(TemporalType.DATE)
    private Date dataEncerramento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "idQuartos", referencedColumnName = "id")
    @ManyToOne
    private Quartos idQuartos;

    public Aluguel() {
    }

    public Aluguel(Integer id) {
        this.id = id;
    }

    public int verificaQtdDias(){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(getDataEncerramento());//data maior

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(getDataEntrada());// data menor

        calendar1.add(Calendar.DATE, -calendar2.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
        return calendar1.get(Calendar.DAY_OF_MONTH);
       
    }

    ;

    public Aluguel(Integer id, float valorReceber, boolean status) {
        this.id = id;
        this.valorReceber = valorReceber;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aluguel[ id=" + id + " ]";
    }

    public Float getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(Float valorReceber) {
        this.valorReceber = valorReceber;
    }

    @XmlTransient
    public Collection<Finalizaraluguel> getFinalizaraluguelCollection() {
        return finalizaraluguelCollection;
    }

    public void setFinalizaraluguelCollection(Collection<Finalizaraluguel> finalizaraluguelCollection) {
        this.finalizaraluguelCollection = finalizaraluguelCollection;
    }

}
