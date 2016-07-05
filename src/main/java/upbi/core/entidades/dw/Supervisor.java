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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import upbi.core.interfaces.BeanDW;

/**
 *
 * @author Felipe
 */
@Entity
@TableGenerator(allocationSize = 1,initialValue = 1, name = "supervisor_seq")
public class Supervisor implements Serializable, BeanDW{
    
    @Id
    @GeneratedValue(generator = "supervisor_seq", strategy = GenerationType.TABLE)    
    private Long id;
    private Integer codSupervisor;
    private Integer codGerente;
    private String nome;
    private String nomeReduzido;
    @Temporal(TemporalType.DATE)
    private Date dataModificacao;
    @Temporal(TemporalType.TIME)
    private Calendar horaModificacao;

    public Supervisor() {
    }

    public Supervisor(Integer codSupervisor, String nome, String nomeReduzido, Integer codGerente, Date dataModificacao, Calendar horaModificacao) {
        this.codSupervisor = codSupervisor;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.codGerente = codGerente;
        this.dataModificacao = dataModificacao;
        this.horaModificacao = horaModificacao;
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

    public Integer getCodSupervisor() {
        return codSupervisor;
    }

    public void setCodSupervisor(Integer codSupervisor) {
        this.codSupervisor = codSupervisor;
    }

    public Integer getCodGerente() {
        return codGerente;
    }

    public void setCodGerente(Integer codGerente) {
        this.codGerente = codGerente;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Calendar getHoraModificacao() {
        return horaModificacao;
    }

    public void setHoraModificacao(Calendar horaModificacao) {
        this.horaModificacao = horaModificacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + this.codSupervisor;
        hash = 89 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supervisor other = (Supervisor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.codSupervisor.intValue() != other.codSupervisor.intValue()) {
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
