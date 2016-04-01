package com.ensode.webservices;

import com.ensode.ejb.WeightUnitConversion;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WeightUnitConversionService")
@Stateless()
public class WeightUnitConversionService {
    @EJB
    private WeightUnitConversion ejbRef;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "kilosToPounds")
    public double kilosToPounds(@WebParam(name = "kilos") double kilos) {
        return ejbRef.kilosToPounds(kilos);
    }

    @WebMethod(operationName = "poundsToKilos")
    public double poundsToKilos(@WebParam(name = "pounds") double pounds) {
        return ejbRef.poundsToKilos(pounds);
    }
    
}
