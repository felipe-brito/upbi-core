package upbi.core.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Entity(name = "CLIENTES")
@TableGenerator(name = "sq_cliente", allocationSize = 1, initialValue = 1)
@EqualsAndHashCode(callSuper = false, of = {"id", "codCliente", "nome"})
@NamedStoredProcedureQueries(value = {
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_CALCULAR_TOTAL_CLIENTES_ATIVOS, procedureName = "calculartotalclientesativos")
    ,
    @NamedStoredProcedureQuery(name = NamedProcedureDW.PROCEDURE_RECUPERAR_ID_CODIGO_NOME_CLIENTES_ATIVOS, procedureName = "recuperanomecodigoclientesativos")
})
public class Cliente implements Serializable, Bean {

    private static final long serialVersionUID = 3489215860498802355L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sq_cliente", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "COD_CLIENTE")
    private Integer codCliente;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "NOME_REDUZIDO")
    private String nomeReduzido;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "COD_VENDEDOR")
    private Integer codVendedor;

    @Embedded
    private Endereco endereco;

    @Column(name = "DATA_CADASTRAMENTO")
    private LocalDate dataCadastramento;

    @Column(name = "DATA_HORA_MODIFICACAO")
    private LocalDateTime dataHoraModificacao;

    @Column(name = "CODE_HASH")
    private String codeHash;

    public Cliente(Integer codCliente, String nome, String nomeReduzido, Boolean ativo, Integer codVendedor, String tipoLogradouro, String logradouro, String numero, String bairro, String cidade, String uf, LocalDate dataCadastramento, LocalDateTime dataHoraModificacao) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.ativo = ativo;
        this.codVendedor = codVendedor;
        this.endereco = new Endereco(tipoLogradouro, logradouro, numero, bairro, cidade, uf);
        this.dataCadastramento = dataCadastramento;
        this.dataHoraModificacao = dataHoraModificacao;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
