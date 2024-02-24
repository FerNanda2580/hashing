package hashing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.junit.*;

public class TestHashingAberto {
    

    private HashingEncadeamentoAberto ha;
    private HashingComPorao hp;

    @Before
    public void configurar(){
        ha = new HashingEncadeamentoAberto();
        hp = new HashingComPorao();

        ha.insert(10);
        hp.insert(10);

        Random r = new Random();
        Set<Integer>set = new LinkedHashSet<Integer>();

        set.add(10);
        for (int i = 0; i < 1000; i++) {
            int data = r.nextInt(2000);
            set.add(data);
        }

        for (Integer data : set) {
            ha.insert(data);
            hp.insert(data);
        }
    }

    @Test
    public void testSearchHashingAberto(){
        assertFalse(ha.search(20100));
        assertTrue(ha.search(10));
    }

    @Test
    public void testDeleteHashingAberto(){
        assertTrue(ha.search(10));
        ha.delete(10);
        assertTrue(ha.search(10));
    }

    @Test
    public void testSearchHashingComPorao(){
        assertFalse(hp.search(20100));
        assertTrue(hp.search(10));
    }

    @Test
    public void testDeleteHashingComPorao(){
        assertTrue(hp.search(10));
        hp.delete(10);
        assertTrue(hp.search(10));
    }
}
