package es.ux.mogndodb.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import es.ux.mogndodb.ws.model.Actividad;
import es.ux.mogndodb.ws.repository.ActivityRepository;
import es.ux.mogndodb.ws.service.ActivityService;

/**
 * The Class InterventionServiceImpl.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
	static final Logger logger = Logger.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityRepository mongodDBRepository;

	
	public List<Actividad> getAllActivities() { 
		logger.info("BEGIN - getAllInterventions:");
		DBCursor inteventionList = null;
		DBObject interventionMongodb = null;
		List<Actividad> interventionRResultList = new ArrayList<Actividad>();
		try {
			inteventionList = mongodDBRepository.findAllInterventions();
			while (inteventionList.hasNext()) {
				interventionMongodb = inteventionList.next();
				Actividad intervention = new Actividad((String) interventionMongodb.get("aplicacion"),(String) interventionMongodb.get("tiempo")
						, (String) interventionMongodb.get("fecha"), (String) interventionMongodb.get("error")
						, (String) interventionMongodb.get("camino"), (String) interventionMongodb.get("nombreActividad"));
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
	
	
	public void insertObject(DBObject dbObject ) {
		logger.info("BEGIN - insertObject: ");
		try {
			mongodDBRepository.insertObject(dbObject);
		}catch (Exception exception){
			logger.error(exception);
		}
		logger.info("END - insertObject. ");
	}

}
