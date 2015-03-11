package com.epam.andrii_lisovyn.processor;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public class ProcessorFactory {

    public Processor getProcessor(String name) {
        for (Processors processor : Processors.values()) {
            if (processor.name().equalsIgnoreCase(name)) {
                return processor.getProcessor();
            }
        }
        return null;
    }

}
