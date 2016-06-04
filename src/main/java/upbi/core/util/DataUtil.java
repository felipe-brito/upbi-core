/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import upbi.core.enumeracao.MesType;
import upbi.core.enumeracao.SemestreType;
import upbi.core.enumeracao.TrimestreType;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 03/06/2016
 *
 */
public class DataUtil {

    private Map<Integer, String> mapa;
    private List<Integer> lista;

    public DataUtil() {
        initMapMes();
    }

    /**
     * Este método recupera a representação textual (nome) do mês indicado por
     * um inteiro correspondente ao mês, com valor entre, 1 e 12. Caso o valor
     * correspondente ao mês seja <= 0 ou >= 12, é retornado um valor
     * 'Indefinido'.
     *
     * @param valorMes
     * @return String - representação do número correpondente ao mês, em formato
     * textual
     */
    public String getNomeMes(Integer valorMes) {
        return valorMes <= 0 || valorMes > 12 ? "Indefinido" : (String) mapa.get(valorMes);
    }

    /**
     * Este método formata uma Date de acordo com o padrão especificado, caso o
     * padrão seja nulo ou não informado. O padrão de data será o 'dd/MM/yyyy'.
     * A data será informada, mas, caso ela esteja nula, é retornado a
     * representação da data atual.
     *
     * @param data
     * @param pattern
     * @return String - representação textual da data informada
     */
    public String formataDataString(Date data, String pattern) {
        pattern = pattern == null || pattern.equals("") || pattern.trim().isEmpty() ? "dd/MM/yyyy" : pattern;
        return data == null ? new SimpleDateFormat(pattern).format(new Date()) : new SimpleDateFormat(pattern).format(data);
    }

    /**
     * Este método retorna uma listagem contendo todos os meses relativos a um
     * semestre. Recebe como parâmetro um SemestreType. Caso o valor informado
     * seja null, é retorna o primeiro semestre.
     *
     * @param semestreType
     * @return List - Lista com os valores representativos dos meses de um
     * semestre
     */
    public List<Integer> recuperarMesesSemestre(SemestreType semestreType) {
        lista = new ArrayList();
        int aux;
        if (semestreType != null) {
            if (semestreType == SemestreType.PRIMEIRO) {
                aux = 6;
            } else {
                aux = 12;
            }
        } else {
            aux = 1;
        }
        for (int i = (aux - 5); i <= aux; i++) {
            lista.add(i);
        }
        return lista;
    }

    /**
     *
     * Este método retorna uma listagem contendo todos os meses relativos a um
     * trimestre. Recebe como parâmetro um TrimestreType. Caso o valor informado
     * seja null, é retorna o primeiro trimestre.
     *
     * @param trimestreType
     * @return Lista com os valores representativos dos meses de um trimestre
     *
     */
    public List<Integer> recuperarMesesTrimestre(TrimestreType trimestreType) {
        lista = new ArrayList();
        int aux;
        if (null != trimestreType) {
            switch (trimestreType) {
                case PRIMEIRO:
                    aux = 1;
                    break;
                case SEGUNDO:
                    aux = 2;
                    break;
                case TERCEIRO:
                    aux = 3;
                    break;
                case QUARTO:
                    aux = 3;
                    break;
                default:
                    aux = 1;
                    break;
            }
        } else {
            aux = 1;
        }
        for (int i = (aux * 3) - 2; i <= (aux * 3); i++) {
            lista.add(i);
        }
        return lista;
    }

    /**
     * Este método retorna a representação do dia utilizado o mês e ano
     * informados.
     *
     * @param mes
     * @param ano
     * @return int - valor representando o dia do mês informado
     */
    public int recuperarDiasMes(MesType mes, Integer ano) {
        switch (mes) {
            case JANEIRO:
                return 31;
            case FEVEREIRO:
                if (ano % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            case MARCO:
                return 31;
            case ABRIL:
                return 30;
            case MAIO:
                return 31;
            case JUNHO:
                return 30;
            case JULHO:
                return 31;
            case AGOSTO:
                return 31;
            case SETEMBRO:
                return 30;
            case OUTUBRO:
                return 31;
            case NOVEMBRO:
                return 30;
            case DEZEMBRO:
                return 21;
            default:
                return 0;
        }
    }

    /**
     * Este método retorna a representação númerica do mês informado.
     *
     * @param mes
     * @return int - valor representando o mês númerico
     */
    public int recuperarMesNumerico(MesType mes) {
        switch (mes) {
            case JANEIRO:
                return 1;
            case FEVEREIRO:
                return 2;
            case MARCO:
                return 3;
            case ABRIL:
                return 4;
            case MAIO:
                return 5;
            case JUNHO:
                return 6;
            case JULHO:
                return 7;
            case AGOSTO:
                return 8;
            case SETEMBRO:
                return 9;
            case OUTUBRO:
                return 10;
            case NOVEMBRO:
                return 11;
            case DEZEMBRO:
                return 12;
            default:
                return 0;
        }
    }

    private void initMapMes() {
        mapa = new HashMap<>();
        int i = 1;
        for (MesType mesType : MesType.values()) {
            mapa.put(i++, mesType.getValor());
        }
    }

}
