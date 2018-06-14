package com.huseyinkarabakla.n26.config;

import com.huseyinkarabakla.n26.storage.InMemoryStorage;
import com.huseyinkarabakla.n26.storage.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("inMemory")
public class StorageConfig
{
    @Bean
    public Storage storage()
    {
        return new InMemoryStorage();
    }
}
