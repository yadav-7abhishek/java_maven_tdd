package org.agileguru.baby;

import com.alacritysys.frameworks.logging.elf.LogMetdata;

public class BabyAppLogMetaData implements LogMetdata {

    @Override
    public String getName() {
        return "BabyService";
    }

    @Override
    public String getType() {
        return LogMetdata.WEBSERVICE;
    }

}
