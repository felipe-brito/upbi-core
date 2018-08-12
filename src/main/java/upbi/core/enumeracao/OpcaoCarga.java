package upbi.core.enumeracao;

/**
 *
 * @author Felipe
 */
public enum OpcaoCarga {

    VENDA(0),
    CLIENTE(1),
    VENDEDOR(2),
    SUPERVISOR(3),
    GERENTE(4),
    PRODUTO(5),
    FORNECEDOR(6),
    ROTA(7),
    PERIODO(8);

    private final int valor;

    OpcaoCarga(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public static OpcaoCarga getTyoe(int valor) {
        switch (valor) {
            case 0:
                return OpcaoCarga.VENDA;
            case 1:
                return OpcaoCarga.CLIENTE;
            case 2:
                return OpcaoCarga.VENDEDOR;
            case 3:
                return OpcaoCarga.SUPERVISOR;
            case 4:
                return OpcaoCarga.GERENTE;
            case 5:
                return OpcaoCarga.PRODUTO;
            case 6:
                return OpcaoCarga.FORNECEDOR;
            case 7:
                return OpcaoCarga.ROTA;
            case 8:
                return OpcaoCarga.PERIODO;
            default:
                return null;
        }
    }

}
