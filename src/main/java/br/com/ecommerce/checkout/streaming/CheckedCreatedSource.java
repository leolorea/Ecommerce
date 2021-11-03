package br.com.ecommerce.checkout.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CheckedCreatedSource {
	
	String OUTPUT = "checked-created-output";
	
	@Output(OUTPUT)
	MessageChannel output();

}
