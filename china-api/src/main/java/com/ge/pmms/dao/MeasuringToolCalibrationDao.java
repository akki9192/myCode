package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.entity.MeasuringToolCalibration;

public interface MeasuringToolCalibrationDao {

	List<MeasuringToolCalibration> getCalibrationScheme();

	List<MeasuringToolCalibration> searchCalibrationScheme(String data);

}
