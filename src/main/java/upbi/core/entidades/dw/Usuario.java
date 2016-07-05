/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.entidades.dw;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import upbi.core.queries.NamedQueryUsuario;

/**
 *
 * @author Felipe
 */
@Entity
@TableGenerator(allocationSize = 1,initialValue = 1, name = "usuario_seq")
@NamedQueries(value = {
    @NamedQuery(name = NamedQueryUsuario.LOGIN , query = "SELECT u FROM Usuario u WHERE u.email=:email AND u.senha=:senha AND u.ativo=true")
})
public class Usuario implements Serializable, Comparable<Usuario>{
    
    @Id
    @GeneratedValue(generator = "usuario_seq", strategy = GenerationType.TABLE)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    private Boolean ativo;

    public Usuario() {
        this.ativo = true;
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public int compareTo(Usuario o) {
        if(this.id < o.getId()){
            return -1;
        } else if( this.id > o.getId()){
            return 1;
        }
        return 0;
    }
    
}
