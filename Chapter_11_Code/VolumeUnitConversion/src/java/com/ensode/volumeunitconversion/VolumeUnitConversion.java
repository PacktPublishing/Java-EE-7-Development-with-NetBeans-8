package com.ensode.volumeunitconversion;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "VolumeUnitConversion")
@Stateless()
public class VolumeUnitConversion {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "litersToGallons")
    public double litersToGallons(@WebParam(name = "liters") double liters) {
        return liters * 0.26417;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "gallonsToLiters")
    public double gallonsToLiters(@WebParam(name = "gallons") double gallons) {
        return gallons * 3.7854;
    }
}
