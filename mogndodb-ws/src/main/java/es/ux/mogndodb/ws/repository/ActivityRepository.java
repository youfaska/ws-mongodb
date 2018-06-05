package es.ux.mogndodb.ws.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


/**
 * The Interface InterventionRepository.
 * @author youssef.oufaska
 */
public interface ActivityRepository {
	
	/**
	 * Find all interventions.
	 *
	 * @return the Collection<DBObject>
	 */
	DBCursor findAllInterventions();
	
	/**
	 * insertObject
	 * @param dbObject
	 */
	void insertObject(DBObject dbObject );
	/**
	 * searchActivities
	 * @param basicDBObject
	 * @return
	 */
	DBCursor searchActivities(BasicDBObject basicDBObject);
}
