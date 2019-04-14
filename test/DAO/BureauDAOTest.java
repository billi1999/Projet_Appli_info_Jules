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
        
    }

    /**
     * Test of create method, of class BureauDAO.
     */
    @Test
    public void testCreate() throws Exception {
        
        System.out.println("create");
       Bureau obj=new Bureau(0,"F0","000000000","Test");
       BureauDAO instance=new BureauDAO();
       instance.setConnection(dbConnect);
       Bureau expResult=new Bureau(0,"F0","000000000","Test");
   
       Bureau result=instance.create(obj);
        System.out.println("Valeur de l'id expresult : "+expResult.getIdbur());
        System.out.println("Valeur de l'id result :"+result.getIdbur());
       assertEquals("idbur différents",expResult.getIdbur(),result.getIdbur());
       assertEquals("Sigles différents",expResult.getSigle(),result.getSigle());
       assertEquals("Tel différents",expResult.getTel(),result.getTel());
       assertEquals("Descriptions différentes",expResult.getDescription(),result.getDescription());
       instance.delete(result);
       instance.delete(obj);
       
    }

    /**
     * Test of update method, of class BureauDAO.
     */
    @Test
    public void testUpdate() throws Exception {
       
    }

    /**
     * Test of delete method, of class BureauDAO.
     */
    @Test
    public void testDelete() throws Exception {
       
    }

    /**
     * Test of read method, of class BureauDAO.
     */
    @Test
    public void testRead() throws Exception {
        
    }

    /**
     * Test of rechDescription method, of class BureauDAO.
     */
    @Test
    public void testRechDescription() throws Exception {
       
    }
    
}
