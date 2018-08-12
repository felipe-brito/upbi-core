package upbi.core.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.TableGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import upbi.core.interfaces.Bean;
import upbi.core.queries.NamedProcedureDW;

/**
 *
 * @author Felipe
 */
@Data
@NoArgsConstructor
@Entity(name = "VENDEDORES")
@TableGenerator(name = "sq_vendedores", allocationSize = 1, initialValue = 1)
@NamedStoredProcedureQueries(value = {
    @NamedStoredProcedureQuery(name = NamedProcedureDW.SOMATORIO_METAS_VENDEDORES, procedureName = "calcularMetaVendedoresMes")
})
@EqualsAndHashCode(callSuper = false, of = {"id", "codVendedor"})
public class Vendedor implements Serializable, Bean {

    private static final long serialVersionUID = 2213398439524331064L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sq_vendedores", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "COD_VENDEDOR")
    private Integer codVendedor;

    @Column(name = "COD_SUPERVISOR")
    private Integer codSupervisor;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "NOME_REDUZIDO")
    private String nomeReduzido;

    @Column(name = "META")
    private BigDecimal meta;

    @Column(name = "DATA_HORA_MODIFICACAO")
    private LocalDateTime dataHoraModificacao;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "CODE_HASH")
    private String codeHash;

    public Vendedor(Integer codVendedor, String nome, String nomeReduzido, BigDecimal meta, Integer codSupervisor, LocalDateTime dataHoraModificacao, Boolean ativo) {
        this.codVendedor = codVendedor;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.meta = meta;
        this.codSupervisor = codSupervisor;
        this.dataHoraModificacao = dataHoraModificacao;
        this.ativo = ativo;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
