/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.queries;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public interface NamedProcedureDW {
    
    public final String PROCEDURE_VENDAS_TOTAIS_MES = "procedure.vendas.totais.mes";
    
    public final String PROCEDURE_CUSTOS_TOTAIS_MES = "procedure.custos.totais.mes";
    
    public final String PROCEDURE_VENDAS_TOTAIS_DIA = "procedure.vendas.totais.dia";
    
    public final String PROCEDURE_CUSTOS_TOTAIS_DIA = "procedure.custos.totais.dia";
    
    public final String PROCEDURE_VENDA_TOTAIS_ANO = "procedure.vendas.totais.ano";
    
    public final String SOMATORIO_METAS_VENDEDORES = "somatorio.metas.vendedores";
    
    public final String CALCULAR_VENDAS_TOTAL_LUCRATIVIDADE_POR_SEMESTRE = "calcular.vendas.total.lucratividade.por.semestre";
    
    public final String CALCULAR_VENDAS_TOTAL_PRODUTO_POR_SEMESTRE = "calcular.vendas.total.lucratividade.produto.por.semestre";
    
    public final String PROCEDURE_CALCULAR_TOTAL_CLIENTES_ATIVOS = "calcular.total.clientes.ativos";
    
    public final String PROCEDURE_RECUPERAR_ID_CODIGO_NOME_CLIENTES_ATIVOS = "recuperar.id.codigo.nome.clientes.ativos";
    
    public final String PROCEDURE_CALCULAR_VALOR_TOTAL_COMPRA_CLIENTE_POR_SEMESTRE = "calcular.valor.total.compra.cliente.por.semestre";
    
    public final String PROCEDURE_CALCULAR_VALOR_TOTAL_COMPRA_CLIENTE_POR_TRIMESTRE = "calcular.valor.total.compra.cliente.por.trimestre";
    
}
