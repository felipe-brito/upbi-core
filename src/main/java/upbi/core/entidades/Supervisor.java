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
@Entity(name = "SUPERVISORES")
@TableGenerator(name = "sq_supervisores", allocationSize = 1, initialValue = 1)
@EqualsAndHashCode(callSuper = false, of = {"id", "codSupervisor"})
public class Supervisor implements Serializable, Bean {

    private static final long serialVersionUID = 6123030170616003141L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sq_supervisores", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "COD_SUPERVISOR")
    private Integer codSupervisor;

    @Column(name = "COD_GERENTE")
    private Integer codGerente;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "NOME_REDUZIDO")
    private String nomeReduzido;

    @Column(name = "DATA_HORA_MODIFICACAO")
    private LocalDateTime dataHoraModificacao;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "CODE_HASH")
    private String codeHash;

    public Supervisor(Integer codSupervisor, String nome, String nomeReduzido, Integer codGerente, LocalDateTime dataHoraModificacao, Boolean ativo) {
        this.codSupervisor = codSupervisor;
        this.nome = nome;
        this.nomeReduzido = nomeReduzido;
        this.codGerente = codGerente;
        this.dataHoraModificacao = dataHoraModificacao;
        this.ativo = ativo;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
