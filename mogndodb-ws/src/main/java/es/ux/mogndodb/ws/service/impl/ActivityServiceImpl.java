package es.ux.mogndodb.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import es.ux.mogndodb.ws.model.Activity;
import es.ux.mogndodb.ws.repository.ActivityRepository;
import es.ux.mogndodb.ws.service.ActivityService;
import es.ux.mongodb.ws.common.Constant;

/**
 * The Class InterventionServiceImpl.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
	static final Logger logger = Logger.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityRepository mongodDBRepository;

	public List<Activity> getAllActivities() {
		logger.info("BEGIN - getAllInterventions:");
		DBCursor inteventionList = null;
		DBObject interventionMongodb = null;
		List<Activity> interventionRResultList = new ArrayList<Activity>();
		try {
			inteventionList = mongodDBRepository.findAllInterventions();
			while (inteventionList.hasNext()) {
				interventionMongodb = inteventionList.next();
				Activity intervention = new Activity((String) interventionMongodb.get("aplicacion"),
						(String) interventionMongodb.get("tiempo"), (String) interventionMongodb.get("fecha"),
						(String) interventionMongodb.get("error"), (String) interventionMongodb.get("camino"),
						(String) interventionMongodb.get("nombreActividad"));
				interventionRResultList.add(intervention);
			}
			logger.info("conversion from DBObjet to Intervention  process complete.");
			logger.debug(interventionRResultList);
		} catch (Exception exception) {
			logger.error(exception);
		}
		logger.info("END - getAllInterventions.");
		return interventionRResultList;
	}

	public void insertObject(DBObject dbObject) {
		logger.info("BEGIN - insertObject: ");
		try {
			mongodDBRepository.insertObject(dbObject);
		} catch (Exception exception) {
			logger.error(exception);
		}
		logger.info("END - insertObject. ");
	}

	public List<Activity> searchActivities(BasicDBObject basicDBObject) {
		logger.info("BEGIN - searchActivities: ");
		List<Activity> results = new ArrayList<Activity>();
		DBObject activityMongodb = null;
		try {
			basicDBObject.put("tiempo", "5");
			DBCursor elementsList = mongodDBRepository.searchActivities(basicDBObject);
			while (elementsList.hasNext()) {
				activityMongodb = elementsList.next();
				Activity activity = new Activity((String) activityMongodb.get("aplicacion"),
						(String) activityMongodb.get("tiempo"), (String) activityMongodb.get("fecha"),
						(String) activityMongodb.get("error"), (String) activityMongodb.get("camino"),
						(String) activityMongodb.get("nombreActividad"));
				results.add(activity);
				logger.debug("numero--> " + results.size());
			}
			logger.info("Total elements retrieved: " + elementsList.size());

		} catch (Exception exception) {
			logger.error(exception);
		}
		logger.info("END - searchActivities. ");
		return results;
	}

}
