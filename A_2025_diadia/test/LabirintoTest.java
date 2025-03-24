import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

	private Labirinto labirinto;
	
	private Stanza stanza1;
	private Stanza stanza2;
	
	@Before
	public void setUp(){
		this.labirinto = new Labirinto();
		this.stanza1 = this.labirinto.getStanzaIniziale();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
