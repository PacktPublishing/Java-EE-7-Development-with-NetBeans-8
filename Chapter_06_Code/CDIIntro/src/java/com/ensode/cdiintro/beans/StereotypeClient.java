package com.ensode.cdiintro.beans;

import com.ensode.cdiintro.stereotype.NamedSessionScoped;
import java.io.Serializable;

@NamedSessionScoped
public class StereotypeClient implements Serializable {

    private String property1;
    private String property2;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }
}
