package upbi.core.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Felipe de Brito Lira
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco implements Serializable {

    @Column(name = "TIPO_LOGRADOURO")
    private String tipoLogradouro;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "UF")
    private String uf;

}
