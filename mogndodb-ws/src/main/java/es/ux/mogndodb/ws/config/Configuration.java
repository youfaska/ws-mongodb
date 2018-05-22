package es.ux.mogndodb.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class Configuration.
 */
@ConfigurationProperties
@Component
public class Configuration {
	
	/** The host. */
	@Value("${server.url}")
	private String host;
	
	/** The port. */
	@Value("${port.remote}")
	private String port;

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Sets the host.
	 *
	 * @param host the new host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	

}
