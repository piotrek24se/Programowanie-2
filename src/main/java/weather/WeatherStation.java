package weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherStation {

    private String temp20cm;
    private String temp2m;
    private String temp0m;
    private String temp5cm;
    private String wind_dir;
    private String wind_speed;
    private String precipitation;
    private String measure_time;

// nie uzywamy w przypadku jacksona konstruktorow niedomyslnych; jckson musi miec konstruktor domyslny

//    public WeatherStation(String temp20cm, String temp2m, String temp0m, String temp5cm, String wind_dir, String wind_speed, String precipitation, String measure_time) {
//        this.temp20cm = temp20cm;
//        this.temp2m = temp2m;
//        this.temp0m = temp0m;
//        this.temp5cm = temp5cm;
//        this.wind_dir = wind_dir;
//        this.wind_speed = wind_speed;
//        this.precipitation = precipitation;
//        this.measure_time = measure_time;
//    }

    public String getTemp20cm() {
        return temp20cm;
    }

    public void setTemp20cm(String temp20cm) {
        this.temp20cm = temp20cm;
    }

    public String getTemp2m() {
        return temp2m;
    }

    public void setTemp2m(String temp2m) {
        this.temp2m = temp2m;
    }

    public String getTemp0m() {
        return temp0m;
    }

    public void setTemp0m(String temp0m) {
        this.temp0m = temp0m;
    }

    public String getTemp5cm() {
        return temp5cm;
    }

    public void setTemp5cm(String temp5cm) {
        this.temp5cm = temp5cm;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getMeasure_time() {
        return measure_time;
    }

    public void setMeasure_time(String measure_time) {
        this.measure_time = measure_time;
    }

    @Override
    public String toString() {
        return "WeatherStation{" +
                "temp20cm='" + temp20cm + '\'' +
                ", temp2m='" + temp2m + '\'' +
                ", temp0m='" + temp0m + '\'' +
                ", temp5cm='" + temp5cm + '\'' +
                ", wind_dir='" + wind_dir + '\'' +
                ", wind_speed='" + wind_speed + '\'' +
                ", precipitation='" + precipitation + '\'' +
                ", measure_time='" + measure_time + '\'' +
                '}';
    }
}
