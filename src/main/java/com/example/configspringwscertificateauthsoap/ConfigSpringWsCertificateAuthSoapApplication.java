package com.example.configspringwscertificateauthsoap;

import com.example.configspringwscertificateauthsoap.client.CountryClient;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ConfigSpringWsCertificateAuthSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSpringWsCertificateAuthSoapApplication.class, args);
    }

    @Bean
    @Profile("client")
    CommandLineRunner lookup(CountryClient quoteClient) {
        return args -> {
            String country = "Poland";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = quoteClient.getCountry(country);
            System.err.println(response.getCountry().getCurrency());
            System.err.print(response.getCountry().getPopulation());
        };
    }


}
