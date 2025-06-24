package com.my.sts;

import com.my.sts.controller.ApiController;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableCaching
@SpringBootApplication
public class Sts35Application {

    private final ApiController apiController;

    Sts35Application(ApiController apiController) {
        this.apiController = apiController;
    }

	public static void main(String[] args) {
		SpringApplication.run(Sts35Application.class, args);
	}
	
	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration defaults = RedisCacheConfiguration.defaultCacheConfig()
	            .serializeKeysWith(
	            RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer())
	            )
	            .serializeValuesWith(
	            		RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())
	            );
//				.entryTtl(Duration.ofMinutes(5))
//	            .enableTimeToIdle();

        return RedisCacheManager.builder(connectionFactory)
            .cacheDefaults(defaults)
            .build();
	}

}
