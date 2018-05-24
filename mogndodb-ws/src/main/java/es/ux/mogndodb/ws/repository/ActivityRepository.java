package es.ux.mogndodb.ws.repository;

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
	
	void insertObject(DBObject dbObject );
}
