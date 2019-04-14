/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Creation_Objet.Bureau;
import java.sql.SQLException;
import myconnections.DBConnection;

/**
 *
 * @author Jules
 */
public class BureauDAOTest {

    static Connection dbConnect;

    public BureauDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of readSigle method, of class BureauDAO.
     */
    @Test
    public void testReadSigle() throws Exception {
        try {
    
        System.out.println("read");
        
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau obj = new Bureau(0, "F0", "000000000", "Test");
        Bureau expResult = instance.create(obj);
        
        Bureau res = instance.readSigle(expResult.getSigle());

        assertEquals("Sigle différents", expResult.getSigle(), res.getSigle());
        assertEquals("Tel différents", expResult.getTel(), res.getTel());
        assertEquals("Description différentes", expResult.getDescription(), res.getDescription());

        assertEquals("idbur différents", expResult.getIdbur(), res.getIdbur());
        
        instance.delete(res);
        }catch (SQLException e) {
            fail("Exception dans testRead :" + e);
        }
    }

    /**
     * Test of create method, of class BureauDAO.
     */
    @Test
    public void testCreate() {
        try {
            System.out.println("create");
            Bureau obj = new Bureau(0, "F0", "000000000", "Test");
            BureauDAO instance = new BureauDAO();
            instance.setConnection(dbConnect);
            Bureau expResult = new Bureau(0, "F0", "000000000", "Test");

            Bureau result = instance.create(obj);
            System.out.println("Valeur de l'id expresult : " + expResult.getIdbur());
            System.out.println("Valeur de l'id result :" + result.getIdbur());
            //assertEquals("idbur différents", expResult.getIdbur(), result.getIdbur());
            assertEquals("Sigles différents", expResult.getSigle(), result.getSigle());
            assertEquals("Tel différents", expResult.getTel(), result.getTel());
            assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());

            instance.delete(result);
            //instance.delete(obj);
        } catch (SQLException e) {
            fail("Exception :" + e);
        }

    }

    /**
     * Test of update method, of class BureauDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        try {
        System.out.println("update");
        Bureau obj = new Bureau(0, "F0", "000000000", "Test");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setSigle("F02");
        obj.setTel("1");
        obj.setDescription("Test2");
        Bureau expResult = obj;
        Bureau result = instance.update(obj);
        assertEquals("Sigle différents", expResult.getSigle(), result.getSigle());
        assertEquals("Tel différents", expResult.getTel(), result.getTel());
        assertEquals("Description différentes", expResult.getDescription(), result.getDescription());
        instance.delete(result);
        } catch (SQLException e) {
            fail("Exception :" + e);
        }
    }

    /**
     * Test of delete method, of class BureauDAO.
     */
    @Test
    public void testDelete() throws Exception {
        try {
    
        System.out.println("delete");
        Bureau obj = new Bureau(0, "F0", "000000000", "Test");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdbur());
            fail("exception de record introuvable non générée");
            //si la suppression est bien effectuée
        } catch (SQLException e) {
        }
        }catch (SQLException e) {
            fail("Exception :" + e);
        }

    }

    /**
     * Test of read method, of class BureauDAO.
     */
    @Test
    public void testRead() throws Exception {
        try {
    
        System.out.println("read");
        int idbur = 0;
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau obj = new Bureau(0, "F0", "000000000", "Test");
        Bureau expResult = instance.create(obj);
        idbur = expResult.getIdbur();
        Bureau res = instance.read(idbur);

        assertEquals("Sigle différents", expResult.getSigle(), res.getSigle());
        assertEquals("Tel différents", expResult.getTel(), res.getTel());
        assertEquals("Description différentes", expResult.getDescription(), res.getDescription());

        assertEquals("idbur différents", expResult.getIdbur(), res.getIdbur());
        try {
            res = instance.read(0);
            fail("exception d'id inconnu non générée");

        } catch (SQLException e) {
            
        }
        instance.delete(res);
        }catch (SQLException e) {
            fail("Exception dans testRead :" + e);
        }
    }

    /**
     * Test of rechDescription method, of class BureauDAO.
     */
    @Test
    public void testRechDescription() throws Exception {
        try {
    
        System.out.println("RechDescription");
        Bureau obj1 = new Bureau(0, "F0", "000000000", "Test");
        Bureau obj2 = new Bureau(0, "F15", "456789787", "Test");
        String desc = "Test";
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        obj2 = instance.create(obj2);

        List<Bureau> res = instance.rechDescription(desc);
        if (res.indexOf(obj1) < 0) {
            fail("record introuvable " + obj1+"dans "+res);//return -1 when doesn't found
        }
        if (res.indexOf(obj2) < 0) {
            fail("record introuvable" + obj2);
        }
        instance.delete(obj1);
        instance.delete(obj2);
        }catch(SQLException e){
            fail("Exception :" + e);
            
        }

    }

}
