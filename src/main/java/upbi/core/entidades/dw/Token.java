/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package upbi.core.entidades.dw;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 03/06/2016
 *
 */
@Entity
@TableGenerator(allocationSize = 1, initialValue = 1, name = "token_seq")
public class Token implements Serializable{

    @Id
    @GeneratedValue(generator = "token_seq", strategy = GenerationType.TABLE )
    private Long id;
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date validade;
    private Integer duracaoMinutos;

    public Token() {
    }

    public Token(String token, Date validade, Integer duracao) {
        this.token = token;
        this.validade = validade;
        this.duracaoMinutos = duracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
    
}
