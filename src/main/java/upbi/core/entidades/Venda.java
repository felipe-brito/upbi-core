package upbi.core.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import upbi.core.interfaces.Bean;
import upbi.core.queries.NamedProcedureDW;
import upbi.core.queries.NamedQueryCliente;
import upbi.core.queries.NamedQueryProduto;

/**
 *
 * @author Felipe
 */
@Data
@NoArgsConstructor
@Entity(name = "VENDAS")
@TableGenerator(name = "venda_seq", allocationSize = 1, initialValue = 1)
@EqualsAndHashCode(callSuper = false, of = {"id", "codVenda"})
@NamedQueries(value = {
    @NamedQuery(name = NamedQueryCliente.CLIENTES_ATENDIDOS_MES, query = "SELECT COUNT( DISTINCT v.cliente.codCliente ) FROM VENDAS v WHERE v.periodo.mes =:mes AND v.periodo.ano =:ano")
    ,
    @NamedQuery(name = NamedQueryProduto.LISTAR_PRODUTOS_VENDIDOS_POR_SEMESTRE, query = "SELECT DISTINCT NEW upbi.app.web.business.entidades.vo.ProdutoCurvaABCVO(p.codProduto, p.descricao) FROM VENDAS v JOIN v.produto p JOIN v.periodo pe WHERE pe.ano=:ano AND pe.semestre=:semestre ORDER BY p.codProduto")
})
@NamedStoredProcedureQueries(value = {
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_VENDAS_TOTAIS_MES, procedureName = "calcularValorTotalDasVendasMes", parameters = {
        @StoredProcedureParameter(name = "mes", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    })
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_CUSTOS_TOTAIS_MES, procedureName = "calcularValorTotalDosCustosMes", parameters = {
        @StoredProcedureParameter(name = "mes", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    })
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_VENDAS_TOTAIS_DIA, procedureName = "calcularValorTotalDasVendasDia", parameters = {
        @StoredProcedureParameter(name = "dia", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "mes", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    })
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_CUSTOS_TOTAIS_DIA, procedureName = "calcularValorTotalDosCustosDia", parameters = {
        @StoredProcedureParameter(name = "dia", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "mes", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    })
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_VENDA_TOTAIS_ANO, procedureName = "calcularValorTotalDasVendasAno", parameters = {
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
    })
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.CALCULAR_VENDAS_TOTAL_LUCRATIVIDADE_POR_SEMESTRE, procedureName = "calcularTotalVendasSemestre", parameters = {
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "semestre", mode = ParameterMode.IN, type = Integer.class)
    })
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.CALCULAR_VENDAS_TOTAL_PRODUTO_POR_SEMESTRE, procedureName = "calcularTotalVendasProdutoSemestre", parameters = {
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "semestre", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "produto", mode = ParameterMode.IN, type = Integer.class)
    })
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_CALCULAR_VALOR_TOTAL_COMPRA_CLIENTE_POR_SEMESTRE, procedureName = "calcularvalortotalcompraporclientesemestre", parameters = {
        @StoredProcedureParameter(name = "idcliente", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "variante", mode = ParameterMode.IN, type = Integer.class)
    })
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_CALCULAR_VALOR_TOTAL_COMPRA_CLIENTE_POR_TRIMESTRE, procedureName = "calcularvalortotalcompraporclientestrimestre", parameters = {
        @StoredProcedureParameter(name = "idcliente", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "ano", mode = ParameterMode.IN, type = Integer.class)
        ,
        @StoredProcedureParameter(name = "variante", mode = ParameterMode.IN, type = Integer.class)
    })
})
public class Venda implements Serializable, Bean {

    private static final long serialVersionUID = 2260292549979913079L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "venda_seq", strategy = GenerationType.TABLE)
    private Long id;

    /**
     * Atributos
     */
    @Column(name = "COD_VENDA")
    private Long codVenda;

    /**
     * Medidas
     */
    @Column(precision = 10, scale = 3, name = "VALOR_VENDA")
    private BigDecimal valorVenda;

    @Column(precision = 10, scale = 3, name = "LUCRATIVIDADE")
    private BigDecimal lucratividade;

    @Column(name = "QTDE_PRODUTO_VENDIDO")
    private Integer qtdeProdutoVendido;

    @Column(precision = 10, scale = 3, name = "VALOR_TABELA")
    private BigDecimal valorTabela;

    @Column(precision = 10, scale = 3, name = "VALOR_ITEM")
    private BigDecimal valorItem;

    @Column(name = "QTDE_PRODUTO_DEVOLVIDO")
    private Integer qtdeProdutoDevoldido;

    @Column(precision = 10, scale = 3, name = "CUSTO_VENDA")
    private BigDecimal custoVenda;

    @Column(name = "STATUS_CONFIRMACAO")
    private Boolean statusConfirmacao;

    @Column(name = "CODE_HASH")
    private String codeHash;

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

    public Venda(Long codVenda, BigDecimal valorVenda, BigDecimal lucratividade, Integer qtdeProdutoVendido, BigDecimal valorTabela, BigDecimal valorItem, Integer qtdeProdutoDevoldido, BigDecimal custoVenda, Boolean statusConfirmacao, Produto produto, Cliente cliente, Vendedor vendedor, Periodo periodo, Rota rota, Gerente gerente, Supervisor supervisor, Fornecedor fornecedor) {
        this.codVenda = codVenda;
        this.valorVenda = valorVenda;
        this.lucratividade = lucratividade;
        this.qtdeProdutoVendido = qtdeProdutoVendido;
        this.valorTabela = valorTabela;
        this.valorItem = valorItem;
        this.qtdeProdutoDevoldido = qtdeProdutoDevoldido;
        this.custoVenda = custoVenda;
        this.statusConfirmacao = statusConfirmacao;
        this.produto = produto;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.periodo = periodo;
        this.rota = rota;
        this.gerente = gerente;
        this.supervisor = supervisor;
        this.fornecedor = fornecedor;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
