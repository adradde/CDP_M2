package com.epam.andrii_lisovyn.bundle;

import java.util.ResourceBundle;

/**
 * Created by Andrii_Lisovyn on 11.03.2015.
 */
public class BundleFactory {
    private static ResourceBundle textBundle = ResourceBundle.getBundle("textBundle");

    public static ResourceBundle getTextBundle() {
        return textBundle;
    }
}
