/**
 * 
 */
package org.rusl.ethpaura.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.rusl.ethpaura.entity.DataSet;
import org.rusl.ethpaura.entity.HealthDataEntity;
import org.rusl.ethpaura.entity.PositionEntity;

/**
 * @author Rumesha
 * 
 */

public class DataSetSeperator {

	public static DataSet getDataSet(String data) {

		data = data.substring(1, data.indexOf("}"));

		String[] array = data.split(",");

		DataSet dataset = new DataSet();

		HealthDataEntity healthDataEntity = new HealthDataEntity();
		PositionEntity positionEntity = new PositionEntity();

		Timestamp sqlTime = new Timestamp(Long.parseLong(array[1]));
		
		System.out.println("originallllllll*"+sqlTime);

		
		// Format the Date to a String
		DateFormat df = new SimpleDateFormat("dd-MM-YY hh:mm:ss.SSSSSSSSS");
		String t = df.format(sqlTime);

		healthDataEntity.setTime(t);
		
		System.out.println("stringggggggg*"+t);

		healthDataEntity.setBloodpressure(array[4]);
		healthDataEntity.setHeartbeat(array[5]);
		healthDataEntity.setBodytemp(array[6]);
		healthDataEntity.setHelephantId(Integer.parseInt(array[0]));

		positionEntity.setDate(t);
		positionEntity.setLatitude(array[2]);
		positionEntity.setLogitute(array[3]);
		positionEntity.setPoelephantId(1);

		dataset.setHealthDataEntity(healthDataEntity);
		dataset.setPositionEntity(positionEntity);

		return dataset;

	}
}
