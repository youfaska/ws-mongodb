package es.ux.mogndodb.ws.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import es.ux.mongodb.ws.common.Constant;


/**
 * The Class Connexion.
 */
@Component
public class ConexionDb {

	static final Logger logger = Logger.getLogger(ConexionDb.class);

	/** The configuration. */
	@Autowired
	private Configuration configuration;

	/**
	 * Gets the configuration.
	 *
	 * @return the configuration
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * Sets the configuration.
	 *
	 * @param configuration
	 *            the new configuration
	 */
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * Get the mongo data base cliente.
	 * 
	 * @return MongoClient
	 */
	public MongoClient getMongoClient() {
		logger.info("BEGIN - getMongoClient: ");
		MongoClient mongoClient = null ;
		try {
			mongoClient = new MongoClient(configuration.getHost(), new Integer(configuration.getPort()));
			logger.info( mongoClient.getConnectPoint() );
		}
		catch (Exception exception) {
			logger.error(exception);
		}
		logger.info("END - getMongoClient ");
		return mongoClient;
	}

	/**
	 * Get the mongo collection.
	 * 
	 * @return MongoClient
	 */
	public DBCollection getMongoDbCollection(String collectionName) {
		DB mongoDb;
		DBCollection dbCollection = null;
		if (getMongoClient() != null) {
			mongoDb = (DB) (getMongoClient()).getDB(Constant.ASSET_FLEET_MONGO_DB);
			if (mongoDb != null) {
				dbCollection = mongoDb.getCollection(collectionName);
			}
		}
		return dbCollection;
	}

}
