package com.sevasetu.need_service.service;

import java.util.List;

import com.sevasetu.need_service.entity.Need;

public interface ServiceNeed {
	Need createNeed(Need need);
	List<Need> getAllNeeds();
	void deleteNeed(Long id);
	Need updateNeed(Long id, Need need);
	Need getNeedById(Long id);

}
