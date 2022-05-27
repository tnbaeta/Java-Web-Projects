package lab.illfact.simplewebapp.testbeans;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import lab.illfact.simplewebapp.beans.Product;

public class ProductTest {
	
	private final Product product = new Product("P666", "Marofa", 100);
	
	@Test
	void grpupedAssertions() {
		assertAll("product", 
				() -> assertEquals("P666", product.getCode()),
				() -> assertEquals("Marofa", product.getName()),
				() -> assertEquals(100, product.getPrice())
		);
	}
}
