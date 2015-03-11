package com.epam.andrii_lisovyn.processor;

import com.epam.andrii_lisovyn.processor.implementations.DuplicatesProcessor;
import com.epam.andrii_lisovyn.processor.implementations.FrequencyProcessor;
import com.epam.andrii_lisovyn.processor.implementations.LengthProcessor;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public enum Processors {
    FREQUENCY(new FrequencyProcessor()), DUPLICATES(new DuplicatesProcessor()), LENGTH(new LengthProcessor());

    private Processor processor;

    private Processors(Processor processor) {
        this.processor = processor;
    }

    public Processor getProcessor() {
        return processor;
    }
}
