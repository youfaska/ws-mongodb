package es.ux.mogndodb.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import es.ux.mogndodb.ws.model.Activity;
import es.ux.mogndodb.ws.repository.ActivityRepository;
import es.ux.mogndodb.ws.service.ActivityService;

/**
 * The Class InterventionServiceImpl. 
 * Copyright (C) 2018 Youssef Oufaska - Universidad Internacional de la Rioja
 * Trabajo Fin de Grado en Ingeniría Informática.
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
@Service
public class ActivityServiceImpl implements ActivityService {
	static final Logger logger = Logger.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityRepository mongodDBRepository;

	public List<Activity> getAllActivities() {
		logger.info("BEGIN - getAllActivities:");
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
			logger.info("conversion from DBObjet to activity process complete.");
			logger.debug(interventionRResultList);
		} catch (Exception exception) {
			logger.error(exception);
		}
		logger.info("END - getAllActivities.");
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
		BasicDBObject basicDBObject2 = new BasicDBObject();
		try {
			// basicDBObject2.put("tiempo", "5");
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
