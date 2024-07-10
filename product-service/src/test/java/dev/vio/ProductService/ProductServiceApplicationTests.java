package dev.vio.ProductService;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vio.ProductService.dao.ProductRepository;
import dev.vio.ProductService.dto.ProductRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	static final MySQLContainer MY_SQL_CONTAINER;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ObjectMapper objectMapper;

	static {MY_SQL_CONTAINER = new MySQLContainer("mysql:latest");
			MY_SQL_CONTAINER.start();}

	@DynamicPropertySource
	static void configureTestProperties(DynamicPropertyRegistry registry){
		registry.add("spring.datasource.url",() -> MY_SQL_CONTAINER.getJdbcUrl());
		registry.add("spring.datasource.username",() -> MY_SQL_CONTAINER.getUsername());
		registry.add("spring.datasource.password",() -> MY_SQL_CONTAINER.getPassword());
		registry.add("spring.jpa.hibernate.ddl-auto",() -> "create");
	}



	@Test
	void createProduct() throws Exception {

		ProductRequest productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
					.contentType(MediaType.APPLICATION_JSON)
					.content(productRequestString))
				.andExpect(status().isCreated());
		Assertions.assertTrue(productRepository.findAll().size() == 1);
	}

	private ProductRequest getProductRequest() {

		return ProductRequest.builder()
				.name("Samsung Fold5")
				.description("Samsung Fold5, 1TB, 16GB RAM")
				.price(950.60)
				.build();

	}


}
