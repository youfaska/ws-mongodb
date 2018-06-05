package es.ux.mogndodb.ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import es.ux.mogndodb.ws.model.Activity;
import es.ux.mogndodb.ws.service.ActivityService;

/**
 * The Class InterventionController.
 */
@RestController
public class ActivityController {
	static final Logger logger = Logger.getLogger(ActivityController.class);

	/** The intervention servie. */
	@Autowired
	private ActivityService mongoDBServie;

	/**
	 * get all interventions.
	 * 
	 * @return the List<Intervention>
	 */
	@RequestMapping("/activities/")
	@ResponseBody
	List<Activity> getAllInterventions() {
		return mongoDBServie.getAllActivities();
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST) 
	public List<Activity>  search(@Valid @RequestBody String actividad) {
		logger.info("BEGIN - search: ");
		try {
			DBObject dbObject = (DBObject) JSON.parse(actividad);
			//mongoDBServie.searchDocument(dbObject);
		} catch (Exception exception) {
			logger.error(exception);
		}

		logger.info("END - search. ");
		return null;
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @RequestBody String actividad) {
		logger.info("BEGIN - create: ");
		try {
			DBObject dbObject = (DBObject) JSON.parse(actividad);
			mongoDBServie.insertObject(dbObject);
		} catch (Exception exception) {
			logger.error(exception);
		}

		logger.info("END - create. ");
		return "TODO OK";
	}


}
