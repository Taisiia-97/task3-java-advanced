package task3;

abstract public  class Equipment {
private  String producer;
private  boolean isWiFi;
private  int batteryCapacity;



    public Equipment(String producer, int batteryCapacity) {
        this.producer = producer;
        this.batteryCapacity = batteryCapacity;
    }
    abstract public  String sendSMS(String sms);
    public double maxWorkTime(int consumptionPerHour){
        return batteryCapacity/consumptionPerHour;
    }
    public void setWiFi(boolean wiFi){
        this.isWiFi = wiFi;
    }

    public String getProducer() {
        return producer;
    }

    public boolean isWifi() {
        return isWiFi;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }
}
