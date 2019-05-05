package com.weather.forecast.util;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public enum MeasurementUnitType {
    None(0),
    Celsius(1), // Celsius
    Fahrenheit(2); // Fahrenheit

    private int unitId;

    MeasurementUnitType(int unitId) {
        this.unitId = unitId;
    }

    public Integer getValue() {
        return this.unitId;
    }

    public static MeasurementUnitType getTypeFromValue(int unitId) {
        for (MeasurementUnitType e : MeasurementUnitType.values()) {
            if (unitId == e.unitId) return e;
        }
        return MeasurementUnitType.None; //or null
    }

    public String getSymbol() {
        switch (this) {
            case Celsius:
                return "°";
            case Fahrenheit:
                return "°";
            default:
                return "";
        }
    }
}
