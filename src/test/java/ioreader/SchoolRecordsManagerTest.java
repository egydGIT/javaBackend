package ioreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolRecordsManagerTest {

    private SchoolRecordsManager srm = new SchoolRecordsManager();

    @Test
    void testReadGradesFromFile() {
        srm.readGradesFromFileMy("src/main/resources/grades.txt");

        assertEquals("Szabó Attila", srm.getStudent().getName());
        assertEquals(4, srm.getStudent().getMarks().get(0));
        assertEquals(6, srm.getStudent().getMarks().size());

    }

    private SchoolRecordsManager schoolRecordsManager = new SchoolRecordsManager();

    @Test
    public void readFromFiletest() {
        schoolRecordsManager.readGradesFromFile("grades2.txt");

        assertEquals(4, schoolRecordsManager.getStudentClass().size());
        assertEquals(3, schoolRecordsManager.getStudentClass().get(2).getMarks().get(1).longValue());
        assertEquals("Jason_Butler", schoolRecordsManager.getStudentClass().get(3).getName());
        assertEquals(4.0, schoolRecordsManager.getStudentClass().get(2).average(), 0.000001);

    }


    @Test
    public void classAverageTest() {
        schoolRecordsManager.readGradesFromFile("grades2.txt");

        assertEquals(3.542, schoolRecordsManager.classAverage(), 0.001);
    }


}