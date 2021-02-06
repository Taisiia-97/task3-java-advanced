package equipment;

public class Laptop extends Equipment{
    private String dvdDrive;
    private int powerSupply;

    public Laptop(String producer, int batteryCapacity, String dvdDrive, int powerSupply) {
        super(producer, batteryCapacity);
        this.dvdDrive=dvdDrive;
        this.powerSupply=powerSupply;
    }

    public String getDvdDrive() {
        return dvdDrive;
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    @Override
    public String sendSMS(String sms) {
        if (isWifi()){
            return "Your laptop is sending " + sms;
        } else {
            return "Cant send. Turn on Wifi";
        }
    }
}
