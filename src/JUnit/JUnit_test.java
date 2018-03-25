package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import service.Encode;

public class JUnit_test {

	
	@Test
	public void test() {
		String res =  "d38739ae66fe0aa0c873ba93eed7b6df";
		String out = null ;
		String get1 = "parolatest";
		
		out = Encode.encode(get1);
		assertEquals(out,res);
		
	}

}
