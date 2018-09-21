package com.mercadolibre.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by Pablo Costanzo on 20/9/2018.
 * Class to document our weather API
 */

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class WeatherConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/weathers/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Weather Prediction Challenge.",
                "Mercadolibre entrance exam.",
                "1.0",
                "https://www.mercadolibre.com.ar/ayuda/Politicas-de-privacidad_1129",
                new Contact("Pablo Costanzo","https://github.com/costanzopa","costanzopa@gmail.com"),
                "MercadoLibre",
                "https://www.mercadolibre.com.ar/",
                Collections.emptyList()
        );
    }
}
