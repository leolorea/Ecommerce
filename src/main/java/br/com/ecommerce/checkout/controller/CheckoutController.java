package br.com.ecommerce.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.checkout.controller.resource.CheckoutRequest;
import br.com.ecommerce.checkout.controller.resource.CheckoutResponse;
import br.com.ecommerce.checkout.controller.streaming.CheckoutCreatedSource;
import br.com.ecommerce.checkout.model.CheckoutEntity;
import br.com.ecommerce.checkout.service.CheckoutService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/checkout")

public class CheckoutController {
	

	@Autowired
	private CheckoutService service;
	
	@PostMapping
	public ResponseEntity<CheckoutResponse> create (@RequestBody CheckoutRequest checkout){
		service.create(checkout);
		final CheckoutEntity checkoutEntity = service.create(checkout).orElseThrow();
		final CheckoutResponse response = CheckoutResponse.builder()
				.code(checkoutEntity.getCode())
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
		
	}

}
