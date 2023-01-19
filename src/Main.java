public class Main {
    public static void main(String[] args) {

        Train[] trains = new Train[5];
        Train train1 = new Train("Warsaw", 24, 21, 10);
        trains[0] = train1;
        Train train2 = new Train("Budapest", 25, 19, 40);
        trains[1] = train2;
        Train train3 = new Train("Amsterdam", 26, 5, 5);
        trains[2] = train3;
        Train train4 = new Train("Warsaw", 27, 21, 5);
        trains[3] = train4;
        Train train5 = new Train("Warsaw", 28, 21, 30);
        trains[4] = train5;

        System.out.println();
        System.out.println();
        System.out.println();

        int trainNumberSearch = 24;

        findTrainByNumber(trains, trainNumberSearch);
        System.out.println();

        for(int i = 0; i < 5; i++){
            trains[i].showInfo();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        sortByDeparture(trains);

        for(int i = 0; i < 5; i++){
            trains[i].showInfo();
            System.out.println();
        }
    }

    private static void sortByTime(Train[] trains){

        Train temp;
        boolean isSorted = false;
        int sum1;
        int sum2;

        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < trains.length - 1; i++){
                sum1 = trains[i].getHourOfDeparture()*60 + trains[i].getMinuteOfDeparture();
                sum2 = trains[i+1].getHourOfDeparture()*60 + trains[i+1].getMinuteOfDeparture();

                if(sum1 > sum2 && (trains[i].getDestination().compareTo(trains[i+1].getDestination()) == 0)){
                    isSorted = false;

                    temp = trains[i];
                    trains[i] = trains[i+1];
                    trains[i+1] = temp;
                }
            }
        }
    }

    private static void sortByDeparture(Train[] trains){
        int pos;
        Train temp = new Train();

        for(int i = 0; i < trains.length; i++){
            pos = i;
            for(int j = i + 1; j < trains.length; j++){
                if(trains[j].getDestination().compareTo(trains[pos].getDestination()) < 0){
                    pos = j;
                }
            }
            temp = trains[pos];
            trains[pos] = trains[i];
            trains[i] = temp;
        }
        sortByTime(trains);
    }

    private static void findTrainByNumber(Train[] trains, int number){
        boolean isExist = true;
        for(Train train : trains){
            if(train.getTrainNumber() == number){
                train.getInfoByTrainNumber(number);
                isExist = false;
            }
        }

        if(isExist){
            System.out.println("Train with this number doesn't exist.");
        }
    }
}