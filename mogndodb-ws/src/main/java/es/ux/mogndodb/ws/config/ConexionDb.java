package es.ux.mogndodb.ws.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import es.ux.mongodb.ws.common.Constant;

/**
 * The Class Connexion. Copyright (C) 2018 Youssef Oufaska
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
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
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient(configuration.getHost(), new Integer(configuration.getPort()));
			logger.info(mongoClient.getConnectPoint());
		} catch (Exception exception) {
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
