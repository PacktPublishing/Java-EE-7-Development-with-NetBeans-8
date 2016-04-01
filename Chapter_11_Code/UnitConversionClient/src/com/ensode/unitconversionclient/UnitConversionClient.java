package com.ensode.unitconversionclient;

public class UnitConversionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Result = " + inchesToCentimeters(1));
    }
    
    private static double inchesToCentimeters(double inches) {
        com.ensode.unitconversionclient.UnitConversion_Service service
                = new com.ensode.unitconversionclient.UnitConversion_Service();
        com.ensode.unitconversionclient.UnitConversion port
                = service.getUnitConversionPort();
        return port.inchesToCentimeters(inches);
    }
    
}
