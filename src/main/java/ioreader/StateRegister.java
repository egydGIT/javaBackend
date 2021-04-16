package ioreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private List<State> states = new ArrayList<>();

    public void readStatesFromFile(String fileName) {
        Path file = Path.of("src/main/resources/" + fileName);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split("-");
                State s = new State(temp[0], temp[1]);
                states.add(s);
            }
        } catch (IOException e) {
            // throw new IllegalStateException("Can not read file." + e);
            throw new IllegalStateException("Can't read file!",e);
        }
    }

    public String findCapitalByStateName(String stateName) {
        for (State s : states) {
            if (s.getStateName().equals(stateName)) {
                return s.getCapital();
            }
        }
        // throw new IllegalStateException("Dont find this statename: " + stateName);
        throw new IllegalArgumentException("No state with this name!");
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }
}
