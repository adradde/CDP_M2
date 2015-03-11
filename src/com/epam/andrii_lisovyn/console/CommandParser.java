package com.epam.andrii_lisovyn.console;


import com.epam.andrii_lisovyn.processor.Processor;
import com.epam.andrii_lisovyn.processor.ProcessorFactory;
import com.epam.andrii_lisovyn.task.Task;
import com.epam.andrii_lisovyn.task.TaskErrors;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public class CommandParser {
    private static final String INPUT = "-i";
    private static final String TASK = "-t";
    private static final String PARALLEL = "-p";
    private static final String HELP = "-h";
    private static final String DELIMITER_PATTERN = " ";

    private Scanner scanner;
    private ProcessorFactory processorFactory = new ProcessorFactory();
    private String command;
    private String argument;
    private Task task;

    public Task parse(String parameters) {
        task = new Task();
        if (parameters.contains(HELP)) {
            task.setCalledHelp(true);
            return task;
        }
        try {
            scanner = new Scanner(parameters);
            scanner.useDelimiter(DELIMITER_PATTERN);
            while (scanner.hasNext()) {
                command = scanner.next();
                if (!checkArgument()) {
                    return task;
                }
                argument = scanner.next();
                switch (command) {
                    case INPUT:
                        File file = new File(argument);
                        if (!checkFile(file)) {
                            setWrongFile();
                            return task;
                        }
                        task.setFile(file);
                        break;
                    case TASK:
                        Processor processor = processorFactory.getProcessor(argument);
                        if (processor == null) {
                            setWrongTask();
                            return task;
                        }
                        task.setProcessor(processor);
                        break;
                    case PARALLEL:
                        boolean isParallel = Boolean.parseBoolean(argument);
                        task.setParallel(isParallel);
                        break;
                    default:
                        setWrongCommand(command);
                }
            }
        } catch (Exception e) {
            setUnknownError();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return task;
    }

    private void setUnknownError() {
        task.setError(true);
        task.setErrorDescription(TaskErrors.UNKNOWN_ERROR);
    }

    private void setWrongCommand(String command) {
        task.setError(true);
        task.setErrorDescription(String.format(TaskErrors.WRONG_COMMAND, command));
    }

    private boolean checkArgument() {
        if (!scanner.hasNext()) {
            setWrongParameters();
            return false;
        }
        return true;
    }


    private void setWrongTask() {
        task.setError(true);
        task.setErrorDescription(TaskErrors.WRONG_TASK);
    }

    private void setWrongFile() {
        task.setError(true);
        task.setErrorDescription(TaskErrors.WRONG_FILE);
    }

    private boolean checkFile(File file) {
        return file.exists() && file.isFile();
    }

    private void setWrongParameters() {
        task.setError(true);
        task.setErrorDescription(TaskErrors.WRONG_PARAMETERS);
    }

}
