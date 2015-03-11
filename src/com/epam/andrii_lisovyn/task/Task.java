package com.epam.andrii_lisovyn.task;

import com.epam.andrii_lisovyn.bundle.BundleFactory;
import com.epam.andrii_lisovyn.processor.Processor;

import java.io.File;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public class Task {

    private File file;
    private Processor processor;
    private String errorDescription;
    private boolean isParallel = false;
    private boolean isError = false;
    private boolean isCalledHelp = false;

    public Task() {
    }

    public String getHelp() {
        return BundleFactory.getTextBundle().getString("help");
    }

    public Map<String, Integer> execute() {
        if (getProcessor() == null) {
            return Collections.EMPTY_MAP;
        }
        return getProcessor().process(getFile(), isParallel());
    }

    public boolean isCalledHelp() {
        return isCalledHelp;
    }

    public void setCalledHelp(boolean isCalledHelp) {
        this.isCalledHelp = isCalledHelp;
    }

    public boolean hasError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public boolean isParallel() {
        return isParallel;
    }

    public void setParallel(boolean isParallel) {
        this.isParallel = isParallel;
    }

}
