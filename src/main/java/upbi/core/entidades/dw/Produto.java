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

/**
 *
 * @author Felipe
 */
@Entity
@TableGenerator(allocationSize = 1,initialValue = 1, name = "produto_seq")
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(generator = "produto_seq", strategy = GenerationType.TABLE)    
    private Long id;
    private Integer codProduto;
    private String descricao;
    private String grupo;
    private String subGrupo;
    private String unidadeMedida;
    private Double custo;
    private Boolean atual;
    @Temporal(TemporalType.DATE)
    private Date dataModificar;
    @Temporal(TemporalType.TIME)
    private Calendar horaModificar;
    
    public Produto() {
    }

    public Produto(Integer codProduto, String descricao, String grupo, String subGrupo, String unidadeMedida, Double custo, Boolean atual, Date dataModificacao, Calendar horaModificacao) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.grupo = grupo;
        this.subGrupo = subGrupo;
        this.unidadeMedida = unidadeMedida;
        this.custo = custo;
        this.atual = atual;
        this.dataModificar = dataModificacao;
        this.horaModificar = horaModificacao;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(String subGrupo) {
        this.subGrupo = subGrupo;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Boolean getAtual() {
        return atual;
    }

    public void setAtual(Boolean atual) {
        this.atual = atual;
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
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + this.codProduto;
        hash = 97 * hash + Objects.hashCode(this.descricao);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.codProduto.intValue() != other.codProduto.intValue()) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    
}
