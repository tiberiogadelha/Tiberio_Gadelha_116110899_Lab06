package p2cg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LutaTest {
	public Jogo jogo;
	
	@Before
	public void setUp() {
		jogo = new Luta("Mortal Kombat", 250);
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Mortal Kombat", jogo.getNomeJogo());
		assertEquals(250,jogo.getPreco(),0.0001);
	}
	
	@Test
	public void testRegistroInvalido() {
		try {
			jogo.registraJogada(-20, true);
		} catch (Exception e) {
			assertEquals("O score nao pode ser menor que zerou ou maior que 100 mil.", e.getMessage());
		}
	}
	@Test
	public void testRegistraJogada() throws Exception  {
		assertEquals(1, jogo.registraJogada(1000, false));
		assertEquals(1, jogo.getQtdJogado());
		assertEquals(0, jogo.getQtdZerado());
		assertEquals(1000, jogo.getBestScore());
		assertEquals(0, jogo.registraJogada(50, true));
		assertEquals(1000, jogo.getBestScore());
		assertEquals(1, jogo.getQtdZerado());
		assertEquals(2, jogo.getQtdJogado());
		assertEquals(4, jogo.registraJogada(4000, false));
	}

}
