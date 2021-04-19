package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {


    public void saveShoppingListMy(OutputStream os, List<String> list) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new BufferedOutputStream(os))) {
            for (String s : list) {
                osw.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> loadShoppingListMy(InputStream is) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader isr = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = isr.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void saveShoppingList(OutputStream os, List<String> shoppingList) {            // Solution
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            for (String str : shoppingList) {
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);                      // Solution
        }
    }

    public List<String> loadShoppingList(InputStream is) {
        List<String> shoppingList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                shoppingList.add(line);
            }
            return shoppingList;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}
