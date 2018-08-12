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
import lombok.NoArgsConstructor;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 03/06/2016
 *
 */
@Data
@NoArgsConstructor
@Entity(name = "TOKENS")
@TableGenerator(allocationSize = 1, initialValue = 1, name = "token_seq")
public class Token implements Serializable {

    private static final long serialVersionUID = 5150385307172292125L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "token_seq", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "VALIDADE")
    private LocalDateTime validade;

    @Column(name = "DURACAO_MINUTO")
    private Integer duracaoMinutos;

    public Token(String token, LocalDateTime validade, Integer duracao) {
        this.token = token;
        this.validade = validade;
        this.duracaoMinutos = duracao;
    }
}
