package inheritanceconstructor.classrooms;

public class ClassRoomChild extends ClassRoom {

    public ClassRoomChild(String location, int capacity, Facility facility) {
        super(location, capacity, facility);
    }

    // Válasz:
    // Az osztály nem fordul le, amíg nem generálunk neki paraméteres konstruktort,
    // mert a paraméter nélküli implicit konstruktort nem közvetlenül az Object oszt-ból hívja,
    // hanem a ClassRoom-ból - de ott nincs ilyen, mert deklaráltunk paramétereset.


}
