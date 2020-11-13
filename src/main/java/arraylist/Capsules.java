package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    List<String> arrayList = new ArrayList<>();

    public void addLast(String colour) {
        arrayList.add(colour);
        // return arrayList;
    }

    public void addFirst(String colour) {
        arrayList.add(0, colour);
        // return arrayList;
    }

    public void removeFirst() {
        arrayList.remove(0);
        // return arrayList;
    }

    public void removeLast() {
        int size = arrayList.size();
        arrayList.remove(size-1);
        // return arrayList;
    }

    List<String> getColours() {
        return arrayList;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();

        capsules.addLast("green");
        capsules.addLast("yellow");
        capsules.addLast("white");
        capsules.addLast("red");
        capsules.addLast("blue");
        System.out.println("Add last: " + capsules.getColours());
        capsules.addFirst("pink");
        System.out.println("Add first: " + capsules.getColours());
        capsules.removeFirst();
        System.out.println("Remove first: " + capsules.getColours());
        capsules.removeLast();
        System.out.println("Remove last: " + capsules.getColours());
    }

}
