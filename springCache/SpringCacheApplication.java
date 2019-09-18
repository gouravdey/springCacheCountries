package com.example.springCache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableCaching
public class SpringCacheApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringCacheApplication.class);
		CountryService countryService = applicationContext.getBean(CountryService.class);

		System.out.println("Fetching the results...");
		System.out.println(countryService.getCountry(1));
		System.out.println(countryService.getCountry(1));
		System.out.println(countryService.getCountry(3));
		System.out.println(countryService.getCountry(2));
		System.out.println(countryService.getCountry(3));
		System.out.println(countryService.getCountry(1));
		System.out.println(countryService.getCountry(3));
		System.out.println(countryService.getCountry(2));
		System.out.println(countryService.getCountry(3));
		System.out.println(countryService.getCountry(1));
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("countries");
	}
}
