package br.com.ecommerce.checkout.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.com.ecommerce.checkout.controller.resource.CheckoutRequest;
import br.com.ecommerce.checkout.controller.streaming.CheckoutCreatedSource;
import br.com.ecommerce.checkout.model.CheckoutEntity;
import br.com.ecommerce.checkout.repository.CheckoutRepository;
import br.com.ecommerce.checkout.streaming.CheckedCreatedSource;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

	private final CheckoutRepository repository;
	private final CheckedCreatedSource source;
	
	@Override
	public Optional<CheckoutEntity> create(CheckoutRequest checkout) {
		final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
				.code(UUID.randomUUID().toString())
				.status(CheckoutEntity.Status.CREATED)
				.build();
		final CheckoutEntity checkoutSalvo = repository.save(checkoutEntity);
		
		final CheckoutCreatedEvent event = CheckoutCreatedEvent.newBuilder.build();
		source.output().send(MessageBuilder.withPayload(null).build());
		
		return Optional.of(checkoutSalvo);
	}
	
	

}
