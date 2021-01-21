package ioreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolRecordsManagerTest {

    private SchoolRecordsManager srm = new SchoolRecordsManager();

    @Test
    void testReadGradesFromFile() {
        srm.readGradesFromFile("grades.txt");

        assertEquals("Szabó Attila", srm.getStudent().getName());
        assertEquals(4, srm.getStudent().getMarks().get(0));
        assertEquals(6, srm.getStudent().getMarks().size());

    }

}