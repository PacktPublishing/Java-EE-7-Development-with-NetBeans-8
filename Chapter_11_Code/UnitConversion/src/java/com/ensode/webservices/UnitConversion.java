package com.ensode.webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "UnitConversion")
public class UnitConversion {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "inchesToCentimeters")
    public double inchesToCentimeters(@WebParam(name = "inches") double inches) {
        return inches * 2.54;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "centimetersToInches")
    public double centimetersToInches(@WebParam(name = "centimeters") double centimeters) {
        return centimeters / 2.54;
    }
}
