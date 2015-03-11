package com.epam.andrii_lisovyn.task;

import com.epam.andrii_lisovyn.bundle.BundleFactory;

import java.util.ResourceBundle;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public class TaskErrors {
    private static final ResourceBundle textBundle = BundleFactory.getTextBundle();

    public static final String WRONG_PARAMETERS = textBundle.getString("error.wrongParameters");

    public static final String WRONG_FILE = textBundle.getString("error.wrongPath");

    public static final String WRONG_TASK = textBundle.getString("error.wrongTask");

    public static final String WRONG_COMMAND = textBundle.getString("error.wrongCommand");

    public static final String UNKNOWN_ERROR = textBundle.getString("error.unknownError");

}
