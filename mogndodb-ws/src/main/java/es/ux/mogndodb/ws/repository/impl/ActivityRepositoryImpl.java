package es.ux.mogndodb.ws.repository.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

import es.ux.mogndodb.ws.config.ConexionDb;
import es.ux.mogndodb.ws.repository.InterventionRepository;
import es.ux.mongodb.ws.common.Constant;

/**
 * The Class InterventionRepositoryImpl.
 */
@Repository
public class InterventionRepositoryImpl implements InterventionRepository{
	
	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(InterventionRepositoryImpl.class);

	/** The conexion bd. */
	@Autowired
	private ConexionDb conexionBd;
	
	public void insertObject(DBObject dbObject ) {
		logger.info("BEGIN - insertObject: ");
		
		DBCollection dbCollection  = conexionBd.getMongoDbCollection(Constant.COLLECTION_INTERVENTION);
		
		try {
			WriteResult writeResult = 	dbCollection.insert(dbObject);
			logger.debug("writeResult" + writeResult.getUpsertedId());
		}catch (Exception exception){
			logger.error(exception);
		}
		logger.info("END - insertObject. ");
	}
	
	
	

	public DBCursor findAllInterventions() {
		logger.info("BEGIN - findAllInterventions: ");
		DBCursor elementList = null;
		DBCollection dbCollection  = conexionBd.getMongoDbCollection(Constant.COLLECTION_INTERVENTION);
		
		try {
			elementList =  dbCollection.find();
			if (elementList!=null){
				logger.info("Total elemente retrieved: "+elementList.size());
				logger.debug(elementList);
			}else{
				logger.error("An error has occured during intervention retrieving process...");
			}
		}catch (Exception exception){
			logger.error(exception);
		}
		logger.info("END - findAllInterventions. ");
		return elementList;
	}

	
}
