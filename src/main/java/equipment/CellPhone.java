package equipment;

public class CellPhone extends Equipment{

    private   String simCard;
   private  int cameraSize;

    public CellPhone(String producer,  int batteryCapacity, String simCard, int cameraSize) {
        super(producer, batteryCapacity);
        this.simCard = simCard;
        this.cameraSize = cameraSize;
    }

    public String getSimCard() {
        return simCard;
    }

    public int getCameraSize() {
        return cameraSize;
    }

    @Override
    public String sendSMS(String sms) {
        if (simCard != null) {
            return "Your cellphone is sending " + sms;
        } else {
            return "Cant send. No sim card";
        }
    }
}
