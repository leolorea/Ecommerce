package br.com.ecommerce.checkout.service;

import java.util.Optional;

import br.com.ecommerce.checkout.controller.resource.CheckoutRequest;
import br.com.ecommerce.checkout.model.CheckoutEntity;



public interface CheckoutService{
	 
Optional<CheckoutEntity> create(CheckoutRequest checkout);
	
	

}
