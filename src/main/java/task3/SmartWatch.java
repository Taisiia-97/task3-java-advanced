package task3;

public class SmartWatch extends Equipment {
    private String strapColor;


    public SmartWatch(String producer,  int batteryCapacity, String strapColor) {
        super(producer, batteryCapacity);
        this.strapColor=strapColor;
    }

    public String getStrapColor() {
        return strapColor;
    }

    @Override
    public String sendSMS(String sms) {
        if (isWifi()){
            return "Your smartwatch is Sending " + sms;
        } else {
            return "Cant send. Turn on Wifi";
        }
    }
}
