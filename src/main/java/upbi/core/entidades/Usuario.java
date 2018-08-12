package upbi.core.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import lombok.Data;
import upbi.core.enumeracao.NivelType;
import upbi.core.queries.NamedQueryUsuario;

/**
 *
 * @author Felipe
 */
@Data
@Entity(name = "USUARIOS")
@TableGenerator(allocationSize = 1, initialValue = 1, name = "usuario_seq")
@NamedQueries(value = {
    @NamedQuery(name = NamedQueryUsuario.LOGIN, query = "SELECT u FROM USUARIOS u WHERE u.email = :email AND u.senha = :senha AND u.ativo = true")
    ,
    @NamedQuery(name = NamedQueryUsuario.EMAIL_DISPONIVEL, query = "SELECT u FROM USUARIOS u WHERE u.email = :email")
})
public class Usuario implements Serializable, Comparable<Usuario> {

    private static final long serialVersionUID = 7159889877103212325L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "usuario_seq", strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(unique = true, name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "NIVEL_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private NivelType nivelType;

    public Usuario() {
        configUsuarioAtivo();
    }

    public Usuario(String nome, String email, String senha, NivelType nivelType) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelType = nivelType;
        configUsuarioAtivo();
    }

    @Override
    public int compareTo(Usuario o) {
        if (this.id < o.getId()) {
            return -1;
        } else if (this.id > o.getId()) {
            return 1;
        }
        return 0;
    }

    private void configUsuarioAtivo() {
        this.ativo = Boolean.TRUE;
    }

}
