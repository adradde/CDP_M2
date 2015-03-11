package com.epam.andrii_lisovyn.processor.implementations;

import com.epam.andrii_lisovyn.processor.Processor;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public class FrequencyProcessor implements Processor {

    @Override
    public boolean isPairResult() {
        return true;
    }

    @Override
    public Map<String, Integer> process(File file, boolean isParallel) {

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Frequency", 1);
        return map;
    }
}
