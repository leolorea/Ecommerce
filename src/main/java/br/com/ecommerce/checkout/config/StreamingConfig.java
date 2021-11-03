package br.com.ecommerce.checkout.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import br.com.ecommerce.checkout.streaming.CheckedCreatedSource;

@Configuration
@EnableBinding(value= {CheckedCreatedSource.class})
public class StreamingConfig {

}
