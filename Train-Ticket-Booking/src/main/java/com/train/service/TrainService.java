package com.train.service;


import java.util.Date;
import java.util.List;

import com.train.entity.Train;

public interface TrainService {

	List<Train> searchBySourceOrDestAndDate(String source, String dest, Date newDate);

}
