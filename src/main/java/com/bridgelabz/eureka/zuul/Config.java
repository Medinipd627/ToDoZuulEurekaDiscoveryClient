/**
 * 
 */
package com.bridgelabz.eureka.zuul;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***************************************************************************************************
 * Created By:Medini P.D
 * Date:- 10/08/2018
 * Purpose:Config filtr class for the filter operation
 ***************************************************************************************************/
@Configuration
public class Config {
	@Bean
	  public SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	  }
}
