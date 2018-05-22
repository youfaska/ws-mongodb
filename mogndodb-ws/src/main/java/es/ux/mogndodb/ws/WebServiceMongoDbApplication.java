

package es.ux.mogndodb.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The Class SampleSimpleApplication.
 * @author youssef.oufaska
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebServiceMongoDbApplication  {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebServiceMongoDbApplication.class, args);
	}

}
