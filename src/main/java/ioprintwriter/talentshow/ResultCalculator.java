package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions = new ArrayList<>();

    private List<Vote> votes = new ArrayList<>();

    public void readTalents(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)){            // fájl pufferelt beolvasása soronként
            String line;
            while ((line = reader.readLine())  != null) {
                String[] temp = line.split(" ");                              // beolvasott sor vágása szóköz mentén String tömbbe
                Production p = new Production(Long.parseLong(temp[0]), temp[1]);    // új production obj létrehozása: tómb elemeivel
                productions.add(p);                                                 // production lista feltöltése
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

//    public void calculateVotes(Path file) {
//        try (BufferedReader reader = Files.newBufferedReader(file)){
//            String line;
//            while ((line = reader.readLine())  != null) {
//                votes.add(new Vote(line.indexOf(line+1), Integer.parseInt(line)));
//            }
//        } catch (IOException e) {
//            throw new IllegalArgumentException("Can not read file.", e);
//        }
//    }

    public void calculateVotes(Path file) {                                 // fájl pufferelt beolvasása soronként
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                int actVote = Integer.parseInt(line);                       // beolvasott sor számmá konvertálása = production id = vote id
                addVote(actVote);                                           // megfelelő előadó szavazatainak növelése eggyel
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }


    public void writeResultToFile(Path file) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(file))) { // fájlba ír kül. tipusú karaktereket
            for (Vote v : votes) {
                Production p = findProductionById(v.getId());   // akt. v-hez tartozó id alapján megkeresi megfelelő production obj-t productions listában
                pw.print(v.getId() + " ");                      // akt. v-hez tartozó id
                pw.print(p.getName() + " ");                    // akt. v-hez tartozó production obj name attr-a
                pw.print(v.getNumber());                        // akt. v-hez tartozó össz szavazat
                pw.println();                                   // sortörés
            }
            pw.print("Winner: " + findWinner().getName());      // az utolsó sorban a győztes neve, megf formátumban
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file", e);
        }
    }


    private Production findWinner() {
        int max = votes.get(0).getNumber();     // max keresés
        long maxId = votes.get(0).getId();
        for (Vote v : votes) {
            if (v.getNumber() > max) {
                max = v.getNumber();
                maxId = v.getId();              // id of max
            }
        }

        for (Production p : productions) {      // id-hez tartozó production obj. keresése
            if (maxId == p.getId()) {
                return p;
            }
        }
        return null;

    }

    private Production findProductionById(long id) {   // id alapján keres a productions listában
        for (Production p : productions) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private void addVote(int id) {              // beolvasott id alapján
        boolean exist = false;
        for (Vote v : votes) {                  // Votes tipusú v iterál a votes listán
            if (v.getId() == id) {              // ha akt. v-hez tartozó id megegyezik a met-nak átadott id-vel
                v.incNum();                     // akkor akt. v-hez tartozó number-t (szavazatot) növeli 1-el
                exist = true;
            }
        }
        if (!exist) {                           // ha nem talált a listában id egyezést
            votes.add(new Vote(id, 1));  // adjon hozzá egy új Vote obj-ot, megadott id-vel, 1 szavazattal
        }
    }

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
