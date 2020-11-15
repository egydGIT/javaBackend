package attributes.person;

import javax.crypto.AEADBadTagException;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Kacskovics Renáta", "AE55846");
        Address address = new Address("HU", "Budapest", "Visegrádi u 5.", "1132");

        System.out.println(person.personToString());
        System.out.println(address.addressToString());

        address.coorectData("HU", "Eger", "Csalogány 106.", "3300");
        System.out.println(address.getCity());
        System.out.println(address.getStreetAndNumber());
        System.out.println(address.getZipCode());

        System.out.println(person.personToString());
        System.out.println(address.addressToString());


    }
}
