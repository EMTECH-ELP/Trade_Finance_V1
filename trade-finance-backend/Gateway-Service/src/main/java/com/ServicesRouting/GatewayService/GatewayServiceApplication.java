package com.ServicesRouting.GatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}
/*
Sure, let's demonstrate how to test the endpoints using the provided URLs.

Assuming the Customer Microservice and Product Microservice are running and registered with Eureka as specified in the project, we can test the endpoints through the Gateway Service.

1. **Testing Customer Microservice Endpoints**:
   - To get a customer by ID: `http://localhost:9090/CustomerMicroservice/api/customers/1`
   - To get all customers: `http://localhost:9090/CustomerMicroservice/api/customers`
   - To create a new customer: `POST` request to `http://localhost:9090/CustomerMicroservice/api/customers` with a JSON payload containing customer data.

2. **Testing Product Microservice Endpoints**:
   - To get a product by ID: `http://localhost:9090/ProductMicroservice/api/products/1`
   - To get all products: `http://localhost:9090/ProductMicroservice/api/products`
   - To create a new product: `POST` request to `http://localhost:9090/ProductMicroservice/api/products` with a JSON payload containing product data.

Here are some example requests using cURL:

- Get customer by ID:
  ```bash
  curl -X GET http://localhost:9090/CustomerMicroservice/api/customers/1
  ```

- Get all customers:
  ```bash
  curl -X GET http://localhost:9090/CustomerMicroservice/api/customers
  ```

- Create a new customer:
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"name":"John Doe","email":"john@example.com","phoneNumber":"1234567890"}' http://localhost:9090/CustomerMicroservice/api/customers
  ```

- Get product by ID:
  ```bash
  curl -X GET http://localhost:9090/ProductMicroservice/api/products/1
  ```

- Get all products:
  ```bash
  curl -X GET http://localhost:9090/ProductMicroservice/api/products
  ```

- Create a new product:
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"name":"Product 1","price":10.99}' http://localhost:9090/ProductMicroservice/api/products
  ```

Replace the IDs and data in the JSON payloads with actual values for testing. These requests should route through the Zuul gateway to the respective microservices and return the expected responses.
 */
//
//To test the gateway routing in the browser, you can use the following URLs for each endpoint:
//
//Gateway URL for Customer Microservice:
//Base URL: http://localhost:9090/CustomerMicroservice
//Endpoint to get a customer by ID: /api/customers/{id}
//Endpoint to get all customers: /api/customers
//Endpoint to create a new customer: /api/customers
//Gateway URL for Product Microservice:
//Base URL: http://localhost:9090/ProductMicroservice
//Endpoint to get a product by ID: /api/products/{id}
//Endpoint to get all products: /api/products
//Endpoint to create a new product: /api/products
//Replace {id} with the actual ID when testing the endpoints to get a specific resource.
//
//For example:
//
//To get a customer with ID 1, use: http://localhost:9090/CustomerMicroservice/api/customers/1
//To get all products, use: http://localhost:9090/ProductMicroservice/api/products
//Make sure that both Customer Microservice and Product Microservice are registered with Eureka and are running on ports 9095 and 9096 respectively, as specified in the project.
