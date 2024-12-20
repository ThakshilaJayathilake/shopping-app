//package com.tnj.microservices.order;
//
//import com.tnj.microservices.order.client.InventoryClient;
//import com.tnj.microservices.order.stubs.InventoryClientStub;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
//import org.springframework.context.annotation.Import;
//import org.testcontainers.containers.MySQLContainer;
//import io.restassured.RestAssured;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//
//
//@Import(TestcontainersConfiguration.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWiremock(port = 0)
//class OrderServiceApplicationTests {
//
//	@ServiceConnection
//	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
//	@LocalServerPort
//	private Integer port;
//
//	@BeforeEach
//	void setUp() {
//		RestAssured.baseURI = "http//localhost";
//		RestAssured.port = port;
//	}
//
//	static {
//		mySQLContainer.start();
//	}
//
//	@Test
//	void shouldSubmitOrder() {
//		String submitOrderJson = """
//				{
//				    "skuCode":"iphone13",
//				    "price":1200,
//				    "quantity": 1
//				}
//				""";
//
//		InventoryClientStub.stubInventoryCall("iphone_15", 1);
//
//		var responseBodyString = RestAssured.given()
//				.contentType("application/json")
//				.body(submitOrderJson)
//				.when()
//				.post("/api/order")
//				.then()
//				.log().all()
//				.statusCode(201)
//				.extract()
//				.body().asString();
//
//		assertThat(responseBodyString, Matchers.is("Order Palced Successfully"));
//	}
//}
