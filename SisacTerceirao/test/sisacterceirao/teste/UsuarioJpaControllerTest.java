package sisacterceirao.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import sisacterceirao.UsuarioJpaController;
import sisacterceirao.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sisacterceirao.expection.NonexistentEntityException;

/**
 *
 * @author mentr
 */
public class UsuarioJpaControllerTest {
    
    public UsuarioJpaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EntityManagerFactory factory;
    
    @Before
    public void setUp() {
        factory = Persistence.createEntityManagerFactory("lojavirutalPU");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculeAreaQuadrado method, of class UsuarioJpaController.
     */
    @Test
    public void testCalculeAreaQuadrado() {
        System.out.println("calculeAreaQuadrado");
        double x = 3;
        UsuarioJpaController instance = new UsuarioJpaController(null);
        double expResult = 9.0;
        double result = instance.calculeAreaQuadrado(x);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityManager method, of class UsuarioJpaController.
     */
    @Test
    public void testGetEntityManager() {
        /*System.out.println("getEntityManager");
        UsuarioJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of create method, of class UsuarioJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Usuario usuario = new Usuario();
        usuario.setNome("Simão!!!");
        UsuarioJpaController instance = new UsuarioJpaController(factory);
        instance.create(usuario);
        assertNotNull("testes", usuario.getId());
        //instance.destroy(cnt);
        
        
    }

    /**
     * Test of edit method, of class UsuarioJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Usuario usuario = new Usuario();
        usuario.setNome("Ellyda");
        usuario.setSenha("123");
        UsuarioJpaController instance = new UsuarioJpaController(factory);
        instance.create(usuario);
        
        Usuario elyudaBD = instance.findUsuario(usuario.getId());
        elyudaBD.setSenha("678");
        instance.edit(elyudaBD);
       
        Usuario ElydaUpdateBD = instance.findUsuario(usuario.getId());
        assertEquals(elyudaBD.getSenha(), ElydaUpdateBD.getSenha());
    }
    
    /**
     * Test of edit method, of class UsuarioJpaController.
     */
    @Test
    public void testEditNonexistentEntityException() throws Exception {
        System.out.println("edit");
        UsuarioJpaController instance = new UsuarioJpaController(factory);
        try{
        instance.edit(null);
            fail("Deve lançar exceção NoExitEntityExeption");
        }catch(NonexistentEntityException exp){
            assert(true);
        } catch(Exception exp){
            
        }
    }

    /**
     * Test of destroy method, of class UsuarioJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        
        Usuario usuario = new Usuario();
        usuario.setNome("Ellyda");
        usuario.setSenha("123");
        UsuarioJpaController instance = new UsuarioJpaController(factory);
        instance.create(usuario);
        instance.destroy(usuario.getId());
        Usuario ret = instance.findUsuario(usuario.getId());
        assertNull(ret);
    }

    /**
     * Test of findUsuarioEntities method, of class UsuarioJpaController.
     */
    @Test
    public void testFindUsuarioEntities_0args() {
        /* cria um usuario no banco de dados */
        Usuario usuario = new Usuario();
        usuario.setNome("Ellyda");
        usuario.setSenha("123");
        UsuarioJpaController instance = new UsuarioJpaController(factory);
        instance.create(usuario);
        
        // pesquisou pelo id
        Usuario novo = instance.findUsuario(usuario.getId());
        //comparando se são iguais!!!
        assertEquals(usuario, novo);
        
        
        /*System.out.println("findUsuarioEntities");
        UsuarioJpaController instance = null;
        List<Usuario> expResult = null;
        List<Usuario> result = instance.findUsuarioEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of findUsuarioEntities method, of class UsuarioJpaController.
     */
    @Test
    public void testFindUsuarioEntities_int_int() {
        /*System.out.println("findUsuarioEntities");
        int maxResults = 0;
        int firstResult = 0;
        UsuarioJpaController instance = null;
        List<Usuario> expResult = null;
        List<Usuario> result = instance.findUsuarioEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of findUsuario method, of class UsuarioJpaController.
     */
    @Test
    public void testFindUsuario() {
        /*System.out.println("findUsuario");
        Integer id = null;
        UsuarioJpaController instance = null;
        Usuario expResult = null;
        Usuario result = instance.findUsuario(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of getUsuarioCount method, of class UsuarioJpaController.
     */
    @Test
    public void testGetUsuarioCount() {
        /*System.out.println("getUsuarioCount");
        UsuarioJpaController instance = null;
        int expResult = 0;
        int result = instance.getUsuarioCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
}
