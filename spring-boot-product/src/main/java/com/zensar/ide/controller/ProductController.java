package com.zensar.ide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.ide.dto.CouponDto;
import com.zensar.ide.dto.ProductDto;
import com.zensar.ide.restclient.CouponRestClient;
import com.zensar.ide.service.ProductService;

@RestController
/*
 * @RequestMapping(value = "/product-api", produces = {
 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes
 * = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
 */
@RequestMapping("/product-api")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CouponRestClient restClient;

	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {
		return new ResponseEntity<ProductDto>(productService.getProduct(productId), HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "productId") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "DESC") Direction dir) {
		// return new
		// ResponseEntity<List<ProductDto>>(productService.getProducts(pageNumber,pageSize),
		// HttpStatus.OK);
		return new ResponseEntity<List<ProductDto>>(productService.getProducts(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<ProductDto> insert(@RequestBody ProductDto productDto) {

		//restClient.getCoupon(productDto.get)
		CouponDto couponDto = restClient.getCoupon(productDto.getCouponCode());
		productDto.setProductPrice(productDto.getProductPrice() - couponDto.getDiscount());

		//return productService.insert(productDto);
		return new ResponseEntity<ProductDto>(productService.insert(productDto), HttpStatus.CREATED);
	} // connects with coupon service to access couponCode

	@PutMapping("/products/{productId}")
	public ResponseEntity<String> update(@PathVariable("productId") int productId, @RequestBody ProductDto product) {
		productService.update(productId, product);
		return new ResponseEntity<String>("Product updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> delete(@PathVariable("productId") int productId) {
		productService.delete(productId);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/products/name/{productName}")
	public ResponseEntity<List<ProductDto>> getByProductName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productService.getByProductName(productName), HttpStatus.OK);
	}

	@GetMapping("/products/{productName}/{productPrice}")
	public ResponseEntity<List<ProductDto>> getByProductNameAndProductPrice(
			@PathVariable("productName") String productName, @PathVariable("productPrice") int productPrice) {
		return new ResponseEntity<List<ProductDto>>(
				productService.getByProductNameAndProductPrice(productName, productPrice), HttpStatus.OK);
	}

	@GetMapping("/products/or/{productName}/{productPrice}")
	public ResponseEntity<List<ProductDto>> getByProductNameOrProductPrice(
			@PathVariable("productName") String productName, @PathVariable("productPrice") int productPrice) {
		return new ResponseEntity<List<ProductDto>>(
				productService.getByProductNameOrProductPrice(productName, productPrice), HttpStatus.OK);
	}

	
}
