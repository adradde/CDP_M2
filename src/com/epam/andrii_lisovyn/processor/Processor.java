package com.epam.andrii_lisovyn.processor;

import java.io.File;
import java.util.Map;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public interface Processor {
    boolean isPairResult();

    Map<String, Integer> process(File file, boolean isParallel);
}
