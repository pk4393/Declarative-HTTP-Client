package com.example.springboot_4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
// 1. REGISTER the client and assign it to the "placeholder" group
@ImportHttpServices(group = "placeholder", types = TodoClient.class)
public class ClientConfig {

    // Note: No manual @Bean definition needed for TodoClient!
    // @ImportHttpServices creates it for you.

    // 2. CONFIGURE the "placeholder" group
    @Bean
    public RestClientHttpServiceGroupConfigurer placeholderConfigurer() {
        return groups -> {
            groups.filterByName("placeholder")
                    .forEachClient((group, clientBuilder) -> {
                        // Applies to TodoClient and any other client we add to this group
                        clientBuilder.baseUrl("https://jsonplaceholder.typicode.com");
                        clientBuilder.defaultHeader("User-Agent", "Spring-Boot-4-App");
                    });
        };
    }
}
