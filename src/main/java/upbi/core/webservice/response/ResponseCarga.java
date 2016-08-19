/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package upbi.core.webservice.response;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 16/07/2016
 *
 */
@XmlRootElement
public class ResponseCarga implements Serializable{

    private Long id;

    public ResponseCarga() {
    }
    
    public ResponseCarga(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
