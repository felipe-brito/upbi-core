/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.webservice.request;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 19/07/2016
 *
 */
@XmlRootElement
public class RequestCarga implements Serializable {

    private List<String> registros;
    private Integer opcao;

    public RequestCarga() {
    }

    public RequestCarga(List<String> registros, Integer opcao) {
        this.registros = registros;
        this.opcao = opcao;
    }

    public List<String> getRegistros() {
        return registros;
    }

    public void setRegistros(List<String> registros) {
        this.registros = registros;
    }

    public Integer getOpcao() {
        return opcao;
    }

    public void setOpcao(Integer opcao) {
        this.opcao = opcao;
    }
    
}
