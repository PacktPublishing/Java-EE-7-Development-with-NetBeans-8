package com.ensode.jsf.resourcelibrarycontracts.namedbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ThemeSelector {
    private String themeName = "normal";

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
