package es.ux.mogndodb.ws.service;

import java.util.List;

import com.mongodb.DBObject;

import es.ux.mogndodb.ws.model.Activity;

/**
 * The Interface InterventionService.
 */
public interface ActivityService {
	 
 	/**
 	 * Gets the all interventions.
 	 *
 	 * @return the all interventions
 	 */
 	List<Activity>  getAllActivities ();

 	/**
 	 * Add new element.
 	 * @param dbObject
 	 */
 	void insertObject(DBObject dbObject );
}
