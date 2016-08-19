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
import upbi.core.queries.NamedQueryCliente;

/**
 *
 * @author Felipe
 */
@Entity
@XmlRootElement
@NamedStoredProcedureQueries(value = {
    @NamedStoredProcedureQuery(name = NamedQueryCliente.CLIENTES_ATIVOS, procedureName = "calculartotalclientesativos")
})
public class Cliente implements Serializable, BeanDW {

    @Id
    private Long id;
    private Integer codCliente;
    private String nome;
    private String nomeReduzido;
    private Boolean ativo;
    private Integer codVendedor;
    private String tipoLogradouro;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    @Temporal(TemporalType.DATE)
    private Date dataCadastramento;
    @Temporal(TemporalType.DATE)
    private Date dataModificacao;
    @Temporal(TemporalType.TIME)
    private Calendar horaModificacao;

    public Cliente() {
    }

    public Cliente(String dataCadastramento, String dataModificacao, String horaModificacao){
        System.out.println("Data: "+ dataCadastramento);
        System.out.println("Data Modificacao: "+ dataModificacao);
        System.out.println("Hora: "+ horaModificacao);
    }
    
    public Cliente(Integer codCliente, String nome, String nomeReduzido, Boolean ativo, Integer codVendedor, String tipoLogradouro, String logradouro, String numero, String bairro, String cidade, String uf, Date dataCadastramento, Date dataModificacao, Calendar horaModificacao) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.ativo = ativo;
        this.codVendedor = codVendedor;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.dataCadastramento = dataCadastramento;
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

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Date getDataCadastramento() {
        return dataCadastramento;
    }

    public void setDataCadastramento(Date dataCadastramento) {
        this.dataCadastramento = dataCadastramento;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Integer codVendedor) {
        this.codVendedor = codVendedor;
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
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + this.codCliente;
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.codCliente.intValue() != other.codCliente.intValue()) {
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
