public class Train {

    private String destination;
    private int trainNumber;
    private int hourOfDeparture;
    private int minuteOfDeparture;

    public Train(){

    }
    public Train(String destination, int trainNumber, int hourOfDeparture, int minuteOfDeparture) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        if(hourOfDeparture >= 24 && hourOfDeparture < 0){
            this.hourOfDeparture = 0;
        }else{
            this.hourOfDeparture = hourOfDeparture;
        }
        if(minuteOfDeparture >= 60 && minuteOfDeparture < 0){
            this.minuteOfDeparture = 0;
        }else{
            this.minuteOfDeparture = minuteOfDeparture;
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getHourOfDeparture() {
        return hourOfDeparture;
    }

    public void setHourOfDeparture(int hourOfDeparture) {
        if(hourOfDeparture >= 24 && hourOfDeparture < 0){
            this.hourOfDeparture = 0;
        }else{
            this.hourOfDeparture = hourOfDeparture;
        }
    }

    public int getMinuteOfDeparture() {
        return minuteOfDeparture;
    }

    public void setMinuteOfDeparture(int minuteOfDeparture) {
        if(minuteOfDeparture >= 60 && minuteOfDeparture < 0){
            this.minuteOfDeparture = 0;
        }else{
            this.minuteOfDeparture = hourOfDeparture;
        }
    }

    public void printTime(){
        System.out.print("Departure time: ");
        if(getHourOfDeparture() < 10){
            System.out.print("0" + getHourOfDeparture() + ":");
        }else{
            System.out.print(getHourOfDeparture() + ":");
        }

        if(getMinuteOfDeparture() < 10){
            System.out.println("0" + getMinuteOfDeparture());
        }else{
            System.out.println(getMinuteOfDeparture());
        }
    }

    public void getInfoByTrainNumber(int trainNumber){
        System.out.println("Info about Train number " + getTrainNumber() + ":");
        System.out.println("Destination: " + getDestination());
        printTime();
    }

    public void showInfo(){
        System.out.println("Train number: " + getTrainNumber());
        System.out.println("Destination: " + getDestination());
        printTime();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Train train)) {
            return false;
        }

        if (getTrainNumber() != train.getTrainNumber()) {
            return false;
        }
        if (getHourOfDeparture() != train.getHourOfDeparture()) {
            return false;
        }
        if (getMinuteOfDeparture() != train.getMinuteOfDeparture()) {
            return false;
        }
        return getDestination() != null ? getDestination().equals(train.getDestination()) : train.getDestination() == null;
    }

    @Override
    public int hashCode() {
        int result = getDestination() != null ? getDestination().hashCode() : 0;
        result = 31 * result + getTrainNumber();
        result = 31 * result + getHourOfDeparture();
        result = 31 * result + getMinuteOfDeparture();
        return result;
    }
}
