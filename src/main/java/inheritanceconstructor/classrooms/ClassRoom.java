package inheritanceconstructor.classrooms;

public class ClassRoom extends Room {

    private  Facility facility;

    public ClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity);
        this.facility = facility;
    }

    public boolean isSuitable(Course course) {
        return course.getParticipants() <= getCapacity() && course.getFacilityNeeded() == getFacility();
    }

    public Facility getFacility() {
        return facility;
    }



    public static void main(String[] args) {
        ClassRoom classRoom1 = new ClassRoom("104",45, Facility.COMPUTERS);
        ClassRoom classRoom2 = new ClassRoom("105",20, Facility.CHALKBOARD);

        Course course = new Course(15, Facility.COMPUTERS);

        System.out.println(classRoom2.isSuitable(course));
        System.out.println(classRoom1.isSuitable(course));


    }
}
