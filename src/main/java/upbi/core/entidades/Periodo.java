package upbi.core.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import upbi.core.interfaces.Bean;
import upbi.core.queries.NamedQueryPeriodo;

/**
 *
 * @author Felipe
 */
@Data
@NoArgsConstructor
@Entity(name = "PERIODOS")
@TableGenerator(name = "sq_periodo", allocationSize = 1, initialValue = 1)
@EqualsAndHashCode(callSuper = false, of = {"id", "dataPeriodo", "trimestre"})
@NamedQueries(value = {
    @NamedQuery(name = NamedQueryPeriodo.RECUPERA_ANOS_CADASTRADOS, query = "SELECT DISTINCT p.ano FROM PERIODOS p ORDER BY p.ano DESC")
})
public class Periodo implements Serializable, Bean {

    private static final long serialVersionUID = 8105758498641297930L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sq_periodo", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "DATA_PERIODO")
    private LocalDate dataPeriodo;

    @Column(name = "ANO")
    private Integer ano;

    @Column(name = "SEMESTRE")
    private Integer semestre;

    @Column(name = "TRIMESTRE")
    private Integer trimestre;

    @Column(name = "MES")
    private Integer mes;

    @Column(name = "DIA")
    private Integer dia;

    @Column(name = "CODE_HASH")
    private String codeHash;

    public Periodo(LocalDate dataPeriodo, Integer ano, Integer semestre, Integer trimestre, Integer mes, Integer dia) {
        this.dataPeriodo = dataPeriodo;
        this.ano = ano;
        this.semestre = semestre;
        this.trimestre = trimestre;
        this.mes = mes;
        this.dia = dia;
    }

    @Override
    public Long getIdBean() {
        return getId();
    }

}
