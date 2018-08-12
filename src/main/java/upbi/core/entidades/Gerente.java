package upbi.core.entidades;

import java.io.Serializable;
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
@Entity(name = "GERENTES")
@TableGenerator(name = "sq_gerente", allocationSize = 1, initialValue = 1)
@EqualsAndHashCode(callSuper = false, of = {"id", "codGerente", "nome"})
public class Gerente implements Serializable, Bean {

    private static final long serialVersionUID = 7289975676344525550L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sq_gerente", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "COD_GERENTE")
    private Integer codGerente;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "NOME_REDUZIDO")
    private String nomeReduzido;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "DATA_HORA_MODIFICACAO")
    private LocalDateTime dataHoraModificao;

    @Column(name = "CODE_HASH")
    private String codeHash;

    public Gerente(Integer codGerente, String nome, String nomeReduzido, LocalDateTime dataHoraModificacao, Boolean ativo) {
        this.codGerente = codGerente;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.ativo = ativo;
        this.dataHoraModificao = dataHoraModificacao;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
