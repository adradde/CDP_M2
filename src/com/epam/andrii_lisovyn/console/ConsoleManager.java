package com.epam.andrii_lisovyn.console;

import com.epam.andrii_lisovyn.task.Task;

import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public class ConsoleManager {

    private static final String ERROR_DELIMITER = "##############################################################################";
    private static final String HELP_DELIMITER = "******************************************************************************";
    private static final String RESULT_DELIMITER = "------------------------------------------------------------------------------";
    private static final String WELCOME_MESSAGE = "Java 8 Console Worker 1.0\nProduct of \"EPAM Systems Company\"\nDeveloped by Andrii Lisovyn\nAll rights reserved.\n\nType your command:\n\n";
    private static final String ERROR_MESSAGE = "Sorry! Some error was happened...";
    private static final int PAUSE_TIME = 50;
    private static final String INCEPTION = "\t>> ";
    private static final String QUIT = "-q";
    private Scanner scanner;
    private String query;
    private CommandParser commandParser;
    private Map<String, Object> result;
    private boolean isInterrupted = false;

    public void run() {
        try {
            scanner = new Scanner(System.in);
            commandParser = new CommandParser();
            printWelcomeMessage();
            while (!isInterrupted) {
                printLineInception();
                processInputLine();
            }
            printByeMessage();
        } catch (Exception e) {
            out.println(ERROR_MESSAGE);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private void printByeMessage() {
        out.println("\nBye, bye!");
    }

    private void processInputLine() {
        Task task;
        query = scanner.nextLine();
        if (checkQuit(query)) {
            isInterrupted = true;
            return;
        }
        task = commandParser.parse(query);
        if (task.isCalledHelp()) {
            printHelp(task);
            return;
        }
        if (task.hasError()) {
            printError(task);
            return;
        }
        result = task.execute();
        printResult(result, task.getProcessor().isPairResult());
    }

    private boolean checkQuit(String query) {
        return QUIT.equalsIgnoreCase(query);
    }

    private void printLineInception() {
        out.print(INCEPTION);
    }

    private void printWelcomeMessage() {
        int length = WELCOME_MESSAGE.length();
        for (int i = 0; i < length; i++) {
            out.print(WELCOME_MESSAGE.charAt(i));
            try {
                Thread.sleep(PAUSE_TIME);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void printResult(Map<String, Object> result, boolean isPair) {
        out.println();
        out.println(RESULT_DELIMITER);
        if (result.size() > 0) {
            for (Map.Entry<String, Object> entry : result.entrySet()) {
                out.print(" >> ");
                out.print(entry.getKey());
                Object value = entry.getValue();
                if (isPair) {
                    out.print(" -> ");
                    out.print(value);
                }
                out.println();
            }
        } else {
            out.println("Ooops! nothing to show...");
        }
        out.println(RESULT_DELIMITER);
        out.println();
    }

    private void printHelp(Task task) {
        out.println();
        out.println(HELP_DELIMITER);
        out.println(task.getHelp());
        out.println(HELP_DELIMITER);
        out.println();
    }


    private void printError(Task task) {
        out.println();
        out.println(ERROR_DELIMITER);
        out.println(task.getErrorDescription());
        out.println(ERROR_DELIMITER);
        out.println();
    }
}
