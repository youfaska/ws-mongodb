package es.ux.mogndodb.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import es.ux.mogndodb.ws.model.Activity;
import es.ux.mogndodb.ws.service.ActivityService;
import es.ux.mongodb.ws.common.Constant;

/**
 * The Class InterventionController. 
 * Copyright (C) 2018 Youssef Oufaska - Universidad Intenacional de la Rioja
 * Trabajo Fin de Grado en Ingeniría Informática
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
	public List<Activity> search(@Valid @RequestBody String actividad) {
		logger.info("BEGIN - search: ");
		List<Activity> results = new ArrayList<Activity>();
		try {
			BasicDBObject basicDBObject = (BasicDBObject) JSON.parse(actividad);
			results = mongoDBServie.searchActivities(basicDBObject);
		} catch (Exception exception) {
			logger.error(exception);
		}

		logger.info("END - search. ");
		return results;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @RequestBody String actividad) {
		logger.info("BEGIN - create: ");
		try {
			DBObject dbObject = (DBObject) JSON.parse(actividad);
			mongoDBServie.insertObject(dbObject);
			logger.info("END - create. ");
		} catch (Exception exception) {
			logger.error(exception);
			return Constant.ERROR_RECORDING_ACTIVITY;
		}
		return Constant.ACTIVITY_RECORDED;
	}

}
