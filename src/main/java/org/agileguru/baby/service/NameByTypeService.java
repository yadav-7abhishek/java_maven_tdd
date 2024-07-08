package org.agileguru.baby.service;

import java.util.HashMap;
import java.util.Map;

import org.agileguru.baby.Constants;
import org.springframework.stereotype.Service;

@Service
public class NameByTypeService {
    private Map<String, String> data = new HashMap<>();
    
    public NameByTypeService() {
        data.put(Constants.DAD_MAPPING, Constants.DAD_NAME);
        data.put(Constants.MOM_MAPPING, Constants.MOM_NAME);
        data.put(Constants.WORK_MAPPING, Constants.WORK);
    }

    public String getByType(String type) {
        if ( this.data.containsKey(type)) {
            return this.data.get(type);
        }
        throw new NullPointerException(type + " related data not found");
    }
}
