package upbi.core.queries;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public interface ClienteNamedQuery {

    public final String CLIENTES_ATENDIDOS_MES = "clientes.atendidos.mes";

    /**
     * Consulta um cliente utilizando o CodeHash
     */
    public final String CONSULTAR_CLIENTE_POR_HASH_CODE = "cliente.consultar.por.codehash";
}
