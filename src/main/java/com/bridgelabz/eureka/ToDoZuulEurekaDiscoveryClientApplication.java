package com.bridgelabz.eureka;

/*******************************************************************************************
 * Created By:Medini P.D
 * Date:- 10/08/2018
 * Purpose: ZuulEurekaToDoApplication main class
 *****************************************************************************************/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ToDoZuulEurekaDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoZuulEurekaDiscoveryClientApplication.class, args);
	}
}
