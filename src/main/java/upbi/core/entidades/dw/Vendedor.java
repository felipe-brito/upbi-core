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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import upbi.core.interfaces.BeanDW;
import upbi.core.queries.NamedProcedureDW;

/**
 *
 * @author Felipe
 */
@Entity
@XmlRootElement
@NamedStoredProcedureQueries(value = {
    @NamedStoredProcedureQuery(name = NamedProcedureDW.SOMATORIO_METAS_VENDEDORES, procedureName = "calcularMetaVendedoresMes")
})
public class Vendedor implements Serializable, BeanDW {

    @Id
    private Long id;
    private Integer codVendedor;
    private Integer codSupervisor;
    private String nome;
    private String nomeReduzido;
    private Double meta;
    @Temporal(TemporalType.DATE)
    private Date dataModificacao;
    @Temporal(TemporalType.TIME)
    private Calendar horaModificacao;
    private Boolean ativo;
    
    public Vendedor() {
    }

    public Vendedor(Integer codVendedor, String nome, String nomeReduzido, Double meta, Integer codSupervisor, Date dataMoficacao, Calendar horaModificacao, Boolean ativo) {
        this.codVendedor = codVendedor;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.meta = meta;
        this.codSupervisor = codSupervisor;
        this.dataModificacao = dataMoficacao;
        this.horaModificacao = horaModificacao;
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

    public Double getMeta() {
        return meta;
    }

    public void setMeta(Double meta) {
        this.meta = meta;
    }

    public Integer getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }

    public Integer getCodSupervisor() {
        return codSupervisor;
    }

    public void setCodSupervisor(Integer codSupervisor) {
        this.codSupervisor = codSupervisor;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + this.codVendedor;
        hash = 83 * hash + Objects.hashCode(this.nome);
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
        final Vendedor other = (Vendedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.codVendedor.intValue() != other.codVendedor.intValue()) {
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
