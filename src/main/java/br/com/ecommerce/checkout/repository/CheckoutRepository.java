package br.com.ecommerce.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.checkout.model.CheckoutEntity;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {

}
