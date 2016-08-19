/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.entidades.dw;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import upbi.core.interfaces.BeanDW;

/**
 *
 * @author Felipe
 */
@Entity
@XmlRootElement
public class Gerente implements Serializable, BeanDW{
    
    @Id
    private Long id;
    private Integer codGerente;
    private String nome;
    private String nomeReduzido;
    @Temporal(TemporalType.DATE)
    private Date dataModificar;
    @Temporal(TemporalType.TIME)
    private Calendar horaModificar;
    private Boolean ativo;
    
    public Gerente() {
    }

    public Gerente(Integer codGerente, String nome, String nomeReduzido, Date dataModificar, Calendar horaModificacao, Boolean ativo) {
        this.codGerente = codGerente;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.dataModificar = dataModificar;
        this.horaModificar = horaModificacao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeReduzido() {
        return nomeReduzido;
    }

    public void setNomeReduzido(String nomeReduzido) {
        this.nomeReduzido = nomeReduzido;
    }

    public Integer getCodGerente() {
        return codGerente;
    }

    public void setCodGerente(Integer codGerente) {
        this.codGerente = codGerente;
    }

    public Date getDataModificar() {
        return dataModificar;
    }

    public void setDataModificar(Date dataModificar) {
        this.dataModificar = dataModificar;
    }

    public Calendar getHoraModificar() {
        return horaModificar;
    }

    public void setHoraModificar(Calendar horaModificar) {
        this.horaModificar = horaModificar;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + this.codGerente;
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gerente other = (Gerente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.codGerente.intValue() != other.codGerente.intValue()) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public Long getIdBean() {
        return id;
    }
    
}
