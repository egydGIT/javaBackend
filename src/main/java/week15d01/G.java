/*
Junior
Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben.
A map kulcsa az x koordináta értéke pedig az y koordináta. Döntsük el, hogy a kapott pontok küzül,
hol van a függvénynek maximum helye és ott mennyi az értéke.
 */
package week15d01;

import java.util.HashMap;
import java.util.Map;

public class G {

    public Map<Double, Double> maxEntry(Map<Double, Double> graphOfFunction) {  // Map-ben max értéket keres
        if (graphOfFunction.size() == 0 ) {
            throw new IllegalArgumentException("Wrong param.");
        }
        Map.Entry<Double, Double> foundResult = findFirstBiggest(graphOfFunction);
        Map<Double, Double> foundResults = findEveryBiggest(foundResult, graphOfFunction);
        return foundResults;
    }

    public Map<Double, Double> findEveryBiggest(Map.Entry<Double, Double> foundResult, Map<Double, Double> graphOfFunction) { // Összes legnagyobbat
        Map<Double, Double> results = new HashMap<>();
        for ( Map.Entry<Double, Double> entry : graphOfFunction.entrySet()) {
            if (foundResult.getValue().equals(entry.getValue())) {
                results.put(entry.getKey(), entry.getValue());
            }
        }
        return results;
    }

    public Map.Entry<Double, Double> findFirstBiggest(Map<Double, Double> graphOfFunction) {
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


    public static void main(String[] args) {
        G g = new G();
        Map<Double, Double> testGraph = new HashMap<>();
        testGraph.put(-2.0, 9.0);   // <-
        testGraph.put( -1.0, 2.0);
        testGraph.put(0.0, -4.0);
        testGraph.put(1.0, 9.0);   // <-
        testGraph.put(2.0, 3.0);
        testGraph.put(2.0, 9.0);   // <-

//        Map.Entry<Double, Double> found = g.findFirstBiggest(testGraph);            // -2.0=9.0
//        System.out.println(found);
//
//        Map<Double, Double> foundEvery = g.findEveryBiggest(found, testGraph);      // {-2.0=9.0, 1.0=9.0, 2.0=9.0}
//        System.out.println(foundEvery);

        System.out.println(g.maxEntry(testGraph));                                  // {-2.0=9.0, 1.0=9.0, 2.0=9.0}
    }
}

