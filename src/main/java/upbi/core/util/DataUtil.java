package upbi.core.util;

import br.com.twsoftware.alfred.object.Objeto;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
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
        pattern = Objeto.isBlank(pattern) ? "dd/MM/yyyy" : pattern;
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
        List<Integer> lista = new ArrayList();
        Integer aux = Objeto.isBlank(semestreType) ? 1 : semestreType.getCodigo();
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
        List<Integer> lista = new ArrayList();
        Integer aux = Objeto.isBlank(trimestreType) ? 1 : trimestreType.getCodigo();
        for (int i = (aux * 3) - 2; i <= (aux * 3); i++) {
            lista.add(i);
        }
        return lista;
    }

    /**
     * Este método retorna a representação do dia utilizado o mês
     *
     * @param mes
     * @return Integer - valor representando o dia do mês informado
     */
    public Integer recuperarDiasMes(MesType mes) {
        
        Month month = Month.valueOf(mes.getMesUS());
        return month.length(LocalDate.now().isLeapYear());
    }

    /**
     * Este método retorna a representação númerica do mês informado.
     *
     * @param mes
     * @return Integer - valor representando o mês númerico
     */
    public Integer recuperarMesNumerico(MesType mes) {
        return Month.valueOf(mes.getMesUS()).getValue();
    }

    private void initMapMes() {
        mapa = new HashMap<>();
        Integer i = 1;
        for (MesType mesType : MesType.values()) {
            mapa.put(i++, mesType.getValor());
        }
    }
    
}
