package upbi.core.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import upbi.core.interfaces.Bean;

/**
 *
 * @author Felipe
 */
@Data
@NoArgsConstructor
@Entity(name = "PROTUDOS")
@TableGenerator(name = "sq_produto", allocationSize = 1, initialValue = 1)
@EqualsAndHashCode(callSuper = false, of = {"id", "codProduto", "descricao"})
public class Produto implements Serializable, Bean {

    private static final long serialVersionUID = -578830265191427666L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sq_produto", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "COD_PRODUTO")
    private Integer codProduto;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "GRUPO")
    private String grupo;

    @Column(name = "SUB_GRUPO")
    private String subGrupo;

    @Column(name = "UNIDADE_MEDIDA")
    private String unidadeMedida;

    @Column(name = "CUSTO")
    private BigDecimal custo;

    @Column(name = "ATUAL")
    private Boolean atual;

    @Column(name = "DATA_HORA_MODIFICACAO")
    private LocalDateTime dataHoraModificacao;

    @Column(name = "CODE_HASH")
    private String codeHash;

    public Produto(Integer codProduto, String descricao, String grupo, String subGrupo, String unidadeMedida, BigDecimal custo, Boolean atual, LocalDateTime dataHoraModificacao) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.grupo = grupo;
        this.subGrupo = subGrupo;
        this.unidadeMedida = unidadeMedida;
        this.custo = custo;
        this.atual = atual;
        this.dataHoraModificacao = dataHoraModificacao;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
