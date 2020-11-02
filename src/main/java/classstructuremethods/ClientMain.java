package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();

        client.setName("Dömdödöm");
        System.out.println("Name: " + client.getName());

        client.setYearOfBirth(1983);
        System.out.println("Birth: " + client.getYearOfBirth());

        client.setAddress("Négyszögletű Kerekerdő");
        System.out.println("Address: " + client.getAddress());

        client.changeAddress("Óperenciás tengeren is túl");
        System.out.println("Migrate: " + client.getAddress());
    }
}
