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
@TableGenerator(allocationSize = 1,initialValue = 1, name = "fornecedor_seq")
public class Fornecedor implements Serializable, BeanDW{
    
    @Id
    @GeneratedValue(generator = "fornecedor_seq", strategy = GenerationType.TABLE)
    private Long id;
    private Integer codFornecedor;
    private String nome;
    private String nomeReduzido;
    private String cnpj;
    private Boolean ativo;
    private String tipoPessoa;
    private String tipoLogradouro;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    @Temporal(TemporalType.DATE)
    private Date dataModificacao;
    @Temporal(TemporalType.TIME)
    private Calendar horaModificacao;

    public Fornecedor() {
    }

    public Fornecedor(Integer codFornecedor, String nome, String nomeReduzido, String cnpj, Boolean ativo, String tipoPessoa, String tipoLogradouro, String logradouro, String numero, String bairro, String cidade, String uf, Date dataModificacao, Calendar horaModificacao) {
        this.codFornecedor = codFornecedor;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.cnpj = cnpj;
        this.ativo = ativo;
        this.tipoPessoa = tipoPessoa;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
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

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + this.codFornecedor;
        hash = 29 * hash + Objects.hashCode(this.nome);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.codFornecedor.intValue() != other.codFornecedor.intValue()) {
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
