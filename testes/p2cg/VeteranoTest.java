package p2cg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VeteranoTest {
	
	public Usuario user;
	
	@Before
	public void setUp() throws Exception {
		user = new Veterano("Tiberio", "tiberio.gadelha");
	}
	
	@Test 
	public void testConstrutor() {
		assertEquals("Tiberio", user.getNomeUsuario());
		assertEquals("tiberio.gadelha", user.getNomeLogin());
		assertEquals(1000, user.getX2p());
	}
	
	@Test
	public void testCompraJogo() throws Exception {
		Jogo jogo = new RPG("Dota", 200);
		Jogo jogo2 = new Luta("The King of Fight", 1000);

		user.creditaConta(500);
		assertEquals(1000, user.getX2p());
		assertFalse(user.compraJogo(jogo2));
		assertEquals(500, user.getSaldo());
		assertTrue(user.compraJogo(jogo));
		assertEquals(340, user.getSaldo());
		assertEquals(4000, user.getX2p());
		
	}


}
