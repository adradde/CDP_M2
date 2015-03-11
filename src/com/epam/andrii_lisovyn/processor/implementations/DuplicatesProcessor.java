package com.epam.andrii_lisovyn.processor.implementations;

import com.epam.andrii_lisovyn.processor.Processor;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public class DuplicatesProcessor implements Processor {

    private LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

    @Override
    public boolean isPairResult() {
        return false;
    }

    @Override
    public Map<String, Integer> process(File file, boolean isParallel) {

        Path path = Paths.get(file.toURI());
        if (isParallel) {

        } else {

        }

        return map;
    }

    private void addToResult(String s) {
        if (map.containsKey(s)) {
            int value =  map.get(s);
            value++;
            map.put(s, value);
        }else {
            map.put(s, 1);
        }
    }
}
