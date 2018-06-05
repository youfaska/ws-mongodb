package es.ux.mogndodb.ws.repository.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

import es.ux.mogndodb.ws.config.ConexionDb;
import es.ux.mogndodb.ws.repository.ActivityRepository;
import es.ux.mongodb.ws.common.Constant;

/**
 * The Class InterventionRepositoryImpl.
 */
@Repository
public class ActivityRepositoryImpl implements ActivityRepository{
	
	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(ActivityRepositoryImpl.class);

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

	
	public DBCursor searchActivities(BasicDBObject basicDBObject) {
		logger.info("BEGIN - findAllInterventions: ");
		DBCursor elementsList = null;
		try {
			DBCollection dbCollection  = conexionBd.getMongoDbCollection(Constant.COLLECTION_INTERVENTION);
			elementsList = dbCollection.find(basicDBObject);
			if (elementsList!=null){
				logger.info("Total elemente retrieved: "+elementsList.size());
				logger.debug(elementsList);
			}else{
				logger.error("An error has occured during intervention retrieving process...");
			}
		}catch (Exception exception){
			logger.error(exception);
		}
		logger.info("END - findAllInterventions. ");
		return elementsList;
	}
	
	

}
