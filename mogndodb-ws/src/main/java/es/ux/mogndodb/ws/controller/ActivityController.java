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

import es.ux.mogndodb.ws.model.Actividad;
import es.ux.mogndodb.ws.service.InterventionService;

/**
 * The Class InterventionController.
 */
@RestController
public class InterventionController {
	static final Logger logger = Logger.getLogger(InterventionController.class);

	/** The intervention servie. */
	@Autowired
	private InterventionService mongoDBServie;

	/**
	 * get all interventions.
	 * 
	 * @return the List<Intervention>
	 */
	@RequestMapping("/intervention/")
	@ResponseBody
	List<Actividad> getAllInterventions() {
		return mongoDBServie.getAllActivities();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @RequestBody String actividad) {
		logger.info("BEGIN - create: ");
		DBObject dbObject = (DBObject) JSON.parse(actividad);
		try {
			mongoDBServie.insertObject(dbObject);
		} catch (Exception exception) {
			logger.error(exception);
		}

		logger.info("END - create: ");
		return "TODO OK";
	}

	/*
	 * @RequestMapping(value = "/create", method = RequestMethod.POST) public
	 * ResponseEntity<User> create(@Valid @RequestBody User user) { User userCreated
	 * = userService.create(user); return new ResponseEntity(userCreated,
	 * HttpStatus.CREATED); }
	 */
}
