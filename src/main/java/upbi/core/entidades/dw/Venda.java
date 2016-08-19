/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.entidades.dw;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import upbi.core.interfaces.BeanDW;
import upbi.core.queries.NamedProcedureDW;
import upbi.core.queries.NamedQueryCliente;
import upbi.core.queries.NamedQueryProduto;

/**
 *
 * @author Felipe
 */
@Entity
@TableGenerator(name = "venda_seq", allocationSize = 1, initialValue = 1)
@NamedQueries(value = {
    @NamedQuery(name = NamedQueryCliente.CLIENTES_ATENDIDOS_MES, query = "SELECT COUNT( DISTINCT v.cliente.codCliente ) FROM Venda v WHERE v.periodo.mes =:mes AND v.periodo.ano =:ano"),
    @NamedQuery(name = NamedQueryProduto.LISTAR_PRODUTOS_VENDIDOS_POR_SEMESTRE, query = "SELECT DISTINCT NEW upbi.app.web.business.entidades.vo.ProdutoCurvaABCVO(p.codProduto, p.descricao) FROM Venda v JOIN v.produto p JOIN v.periodo pe WHERE pe.ano=:ano AND pe.semestre=:semestre ORDER BY p.codProduto")
})
@NamedStoredProcedureQueries(value = {
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_VENDAS_TOTAIS_MES, procedureName = "calcularValorTotalDasVendasMes", parameters = {
        @StoredProcedureParameter(name = "mes", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    }),
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_CUSTOS_TOTAIS_MES, procedureName = "calcularValorTotalDosCustosMes", parameters = {
        @StoredProcedureParameter(name = "mes", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    }),
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_VENDAS_TOTAIS_DIA, procedureName = "calcularValorTotalDasVendasDia", parameters = {
        @StoredProcedureParameter(name = "dia", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "mes", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    }),
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_CUSTOS_TOTAIS_DIA, procedureName = "calcularValorTotalDosCustosDia", parameters = {
        @StoredProcedureParameter(name = "dia", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "mes", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    }),
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_VENDA_TOTAIS_ANO, procedureName = "calcularValorTotalDasVendasAno", parameters = {
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    }),
    @NamedStoredProcedureQuery(name = NamedProcedureDW.CALCULAR_VENDAS_TOTAL_LUCRATIVIDADE_POR_SEMESTRE, procedureName = "calcularTotalVendasSemestre", parameters = {
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "semestre", mode = ParameterMode.IN, type = Integer.class)
    }),
    @NamedStoredProcedureQuery(name = NamedProcedureDW.CALCULAR_VENDAS_TOTAL_PRODUTO_POR_SEMESTRE, procedureName = "calcularTotalVendasProdutoSemestre", parameters = {
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "semestre", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "produto", mode = ParameterMode.IN, type = Integer.class)
    })
})
@XmlRootElement
public class Venda implements Serializable, BeanDW {

    @Id
    @GeneratedValue(generator = "venda_seq", strategy = GenerationType.TABLE)
    private Long id;
    /**
     * Atributos
     */
    private Long codVenda;
    /**
     * Medidas
     */
    @Column(precision = 10, scale = 3)
    private BigDecimal valorVenda;
    @Column(precision = 10, scale = 3)
    private BigDecimal lucratividade;
    private Integer qtdeProdutoVendido;
    private Double valorTabela;
    private Double valorItem;
    private Integer qtdeProdutoDevoldido;
    private Double custoVenda;
    private Boolean statusDeConfirmacao;
    /*
     * relacionamentos
     */
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Produto produto;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Cliente cliente;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Vendedor vendedor;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Periodo periodo;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Rota rota;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Gerente gerente;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Supervisor supervisor;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Fornecedor fornecedor;

    public Venda() {
    }

    public Venda(Long codVenda, BigDecimal valorVenda, BigDecimal lucratividade, Integer qtdeProdutoVendido, Double valorTabela, Double valorItem, Integer qtdeProdutoDevoldido, Double custoVenda, Boolean statusDeConfirmacao, Produto produto, Cliente cliente, Vendedor vendedor, Periodo periodo, Rota rota, Gerente gerente, Supervisor supervisor, Fornecedor fornecedor) {
        this.codVenda = codVenda;
        this.valorVenda = valorVenda;
        this.lucratividade = lucratividade;
        this.qtdeProdutoVendido = qtdeProdutoVendido;
        this.valorTabela = valorTabela;
        this.valorItem = valorItem;
        this.qtdeProdutoDevoldido = qtdeProdutoDevoldido;
        this.custoVenda = custoVenda;
        this.statusDeConfirmacao = statusDeConfirmacao;
        this.produto = produto;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.periodo = periodo;
        this.rota = rota;
        this.gerente = gerente;
        this.supervisor = supervisor;
        this.fornecedor = fornecedor;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getLucratividade() {
        return lucratividade;
    }

    public void setLucratividade(BigDecimal lucratividade) {
        this.lucratividade = lucratividade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Long codVenda) {
        this.codVenda = codVenda;
    }

    public Double getValorTabela() {
        return valorTabela;
    }

    public void setValorTabela(Double valorTabela) {
        this.valorTabela = valorTabela;
    }

    public Double getValorItem() {
        return valorItem;
    }

    public void setValorItem(Double valorItem) {
        this.valorItem = valorItem;
    }

    public Double getCustoVenda() {
        return custoVenda;
    }

    public void setCustoVenda(Double custoVenda) {
        this.custoVenda = custoVenda;
    }
    
    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getQtdeProdutoVendido() {
        return qtdeProdutoVendido;
    }

    public void setQtdeProdutoVendido(Integer qtdeProdutoVendido) {
        this.qtdeProdutoVendido = qtdeProdutoVendido;
    }

    public Integer getQtdeProdutoDevoldido() {
        return qtdeProdutoDevoldido;
    }

    public void setQtdeProdutoDevoldido(Integer qtdeProdutoDevoldido) {
        this.qtdeProdutoDevoldido = qtdeProdutoDevoldido;
    }

    public Boolean getStatusDeConfirmacao() {
        return statusDeConfirmacao;
    }

    public void setStatusDeConfirmacao(Boolean statusDeConfirmacao) {
        this.statusDeConfirmacao = statusDeConfirmacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.codVenda.intValue());
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.codVenda.intValue(), other.codVenda.intValue())) {
            return false;
        }
        return true;
    }

    @Override
    public Long getIdBean() {
        return id;
    }
    
}
