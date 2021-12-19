package com.yadoodle.YaDoodle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

import java.util.Map;
import java.util.WeakHashMap;

@SpringBootApplication
@EnableMapRepositories(mapType = WeakHashMap.class)
public class YaDoodleApplication {


	public static void main(String[] args) {
		SpringApplication.run(YaDoodleApplication.class, args);
	}

}
