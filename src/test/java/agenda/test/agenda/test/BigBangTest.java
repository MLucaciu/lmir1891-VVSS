package agenda.test;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactMock;
import agenda.model.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mircea on 5/7/2018.
 */
public class BigBangTest {
    private Contact con;
    private RepositoryContact rep;

    @Before
    public void setUp() throws Exception {
        rep = new RepositoryContactMock();
    }

    @Test
    public void testCase1()
    {
        try {
            con = new Contact("name", "address1", "+4071122334455");
        } catch (InvalidFormatException e) {
            assertTrue(false);
        }
        //int n = rep.count();
        rep.addContact(con);
        for(Contact c : rep.getContacts())
            if (c.equals(con))
            {
                assertTrue(true);
                break;
            }
        //assertTrue(n+1 == rep.count());
    }
}
