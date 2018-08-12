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
@Entity(name = "ROTAS")
@TableGenerator(name = "sq_rotas", allocationSize = 1, initialValue = 1)
@EqualsAndHashCode(callSuper = false, of = {"id", "codRota"})
public class Rota implements Serializable, Bean {

    private static final long serialVersionUID = 590326435745590460L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sq_rotas", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "COD_ROTA")
    private Integer codRota;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_HORA_MODIFICACAO")
    private LocalDateTime dataHoraModificacao;

    @Column(name = "CODE_HASH")
    private String codeHash;

    public Rota(Integer codRota, String nome, LocalDateTime dataHoraModificacao) {
        this.codRota = codRota;
        this.nome = nome;
        this.dataHoraModificacao = dataHoraModificacao;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
