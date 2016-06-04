package upbi.core.conversor;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.Serializable;
import upbi.core.execoes.ConverteJSONException;

/**
 * Conversor de arquivos JSON, esta classe tem a finalidade de prover métodos
 * resposáveis por realizar o parse de Objetos para o padrão de arquivo JSON,
 * bem como realizar o processo inverso, transformar um arquivo JSON em um
 * objeto.
 *
 * @author Felipe de Brito Lira
 */
public class ConversorJSON implements Serializable {

    private final Gson gson;
    private final Class classe;

    public ConversorJSON(Class classe) {
        this.gson = new Gson();
        this.classe = classe;
    }

    /**
     * Este método realiza o parse do Objeto para o formato JSON.
     *
     * @param object
     * @return String - representação do objeto
     */
    public String converteJSON(Object object) {
        return this.gson.toJson(object);
    }

    /**
     * Este método realiza o parse de uma String json para um objeto
     * especificado.
     *
     * @param json - string de representação do json
     * @return Object - objeto deserializado
     * @throws ConverteJSONException - exceção lançanda caso a representação do
     * json não esteja no padrão RFC 4627.
     */
    public Object converteObject(String json) throws ConverteJSONException {

        try {
            return this.gson.fromJson(json, this.classe);
        } catch (JsonSyntaxException e) {
            throw new ConverteJSONException(String.format("Arquivo JSON fora do padrão RFC 4627.\nMensagem: %s", e.getMessage()));
        }

    }

}
