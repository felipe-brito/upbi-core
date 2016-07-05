/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.entidades.dw;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import upbi.core.interfaces.BeanDW;

/**
 *
 * @author Felipe
 */
@Entity
@TableGenerator(allocationSize = 1,initialValue = 1, name = "periodo_seq")
public class Periodo implements Serializable, BeanDW{
    
    @Id
    @GeneratedValue(generator = "periodo_seq", strategy = GenerationType.TABLE)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dataCompleta;
    private Integer ano;
    private Integer semestre;
    private Integer trimestre;
    private Integer mes;
    private Integer dia;
    
    public Periodo() {
    }

    public Periodo(Date dataCompleta, Integer ano, Integer semestre, Integer trimestre, Integer mes, Integer dia) {
        this.dataCompleta = dataCompleta;
        this.ano = ano;
        this.semestre = semestre;
        this.trimestre = trimestre;
        this.mes = mes;
        this.dia = dia;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCompleta() {
        return dataCompleta;
    }

    public void setDataCompleta(Date dataCompleta) {
        this.dataCompleta = dataCompleta;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.dataCompleta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Periodo other = (Periodo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataCompleta, other.dataCompleta)) {
            return false;
        }
        return true;
    }

    @Override
    public Long getIdBean() {
        return id;
    }
    
}
