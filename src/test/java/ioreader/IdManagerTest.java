package ioreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdManagerTest {

    @Test
    void testReadIdsFromFile() {
        IdManager idManager = new IdManager();
        idManager.readIdsFromFile("idnumbers.txt");
        assertEquals("2548358", idManager.getIds().get(0));
        assertEquals(3, idManager.getIds().size());

    }

}