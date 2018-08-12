package upbi.core.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Entity(name = "FORNECEDORES")
@TableGenerator(name = "sq_fornecedor", allocationSize = 1, initialValue = 1)
@EqualsAndHashCode(callSuper = false, of = {"id", "codFornecedor", "nome"})
public class Fornecedor implements Serializable, Bean {

    private static final long serialVersionUID = 6489320109818003852L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sq_fornecedor", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "COD_FORNECEDOR")
    private Integer codFornecedor;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "NOME_REDUZIDO")
    private String nomeReduzido;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "TIPO_PESSOA")
    private String tipoPessoa;

    @Embedded
    private Endereco endereco;

    @Column(name = "DATA_HORA_MODIFICACAO")
    private LocalDateTime dataHoraModificacao;

    @Column(name = "CODE_HASH")
    private String codeHash;

    public Fornecedor(Integer codFornecedor, String nome, String nomeReduzido, String cnpj, Boolean ativo, String tipoPessoa, String tipoLogradouro, String logradouro, String numero, String bairro, String cidade, String uf, LocalDateTime dataHoraModificacao) {
        this.codFornecedor = codFornecedor;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.cnpj = cnpj;
        this.ativo = ativo;
        this.tipoPessoa = tipoPessoa;
        this.endereco = new Endereco(tipoLogradouro, logradouro, numero, bairro, cidade, uf);
        this.dataHoraModificacao = dataHoraModificacao;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
