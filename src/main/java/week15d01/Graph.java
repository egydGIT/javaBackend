/*
Junior
Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben.
A map kulcsa az x koordináta értéke pedig az y koordináta. Döntsük el, hogy a kapott pontok küzül,
hol van a függvénynek maximum helye és ott mennyi az értéke.
 */
package week15d01;

import java.util.Map;

public class Graph {

    public Map.Entry<Double, Double> maxEntry(Map<Double, Double> graphOfFunction) {  // Map-ben max értéket keres
        if (graphOfFunction.size() == 0 ) {
            throw new IllegalArgumentException("Wrong param.");
        }
        Map.Entry<Double, Double> result = null;
        // double max = Double.MIN_VALUE;
        for ( Map.Entry<Double, Double> entry : graphOfFunction.entrySet() ) {
            if (result == null || result.getValue() < entry.getValue()) {        // első legnagyobbat adja vissza
                result = entry;
                // max = entry.getValue();
            }
        }
        return result;
    }


    // utólsó:  <=
    // több max érték:   List<Map.Entry<Double, Double>>  ami tulképp: Map<Double, Double>
    //  - két met: egyik megkeresi a max-ot
    //  - következő az ezzel megegyező elemeket Map-be írja


}
