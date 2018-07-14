package es.ux.mogndodb.ws.service;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import es.ux.mogndodb.ws.model.Activity;

/**
 * The Interface InterventionService. 
 * Copyright (C) 2018 Youssef Oufaska - Universidad Internacional de la Rioja
 * 
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
public interface ActivityService {

	/**
	 * Gets the all interventions.
	 *
	 * @return the all interventions
	 */
	List<Activity> getAllActivities();

	/**
	 * Add new element.
	 * 
	 * @param dbObject
	 */
	void insertObject(DBObject dbObject);

	/**
	 * searchActivities.
	 * 
	 * @param basicDBObject
	 * @return
	 */
	List<Activity> searchActivities(BasicDBObject basicDBObject);

}
