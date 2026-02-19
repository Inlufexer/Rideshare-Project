import java.util.*;

public class Station {
    //fields
    private ArrayList<Person> peopleWaitingRight;
    private ArrayList<Person> peopleWaitingLeft;
    private ArrayList<Person> peopleCompleted;
    private ArrayList<Car> carsWaiting;
    private ArrayList<Car> carsCompleted;
    private static int id = 0;
    private int myId;

    //constructor
    
    public Station(){
        peopleWaitingRight = new ArrayList<Person>();
        peopleWaitingLeft = new ArrayList<Person>();
        peopleCompleted = new ArrayList<Person>();
        carsWaiting = new ArrayList<Car>();
        carsCompleted = new ArrayList<Car>();
        myId = id;
        id++;
    }

    //methods
    public void takePassengers(){
        ArrayList<Person> arrivals;
        for(int i = carsWaiting.size(); i > -1; i--){
            arrivals = carsWaiting.get(i).dropPassenger();
            for(int j = 0; j < arrivals.size(); j++){
                if(arrivals.get(j).getStation() == myId){
                    peopleCompleted.add(arrivals.get(j));
                }
                else{
                    if(arrivals.get(j).getStation() - myId > 0){
                        peopleWaitingRight.add(arrivals.get(j));
                    }
                    else{
                        peopleWaitingLeft.add(arrivals.get(j));
                    }
                }
            }
            if(carsWaiting.get(i).getEndStat() == myId){
                carsCompleted.add(carsWaiting.get(i));
                carsWaiting.remove(i);
            }
        }
    }

    public void sendPassenders(){
        for(int i = 0; i < carsWaiting.size() - 1; i++){
            ArrayList<Person> loading = new ArrayList<Person>();
            if(carsWaiting.get(i).getDir() == 1){
                for(int j = 2; j > carsWaiting.get(i).getLoad(); j--){
                    loading.add(peopleWaitingRight.get(j));
                    peopleWaitingRight.remove(j);
                }
            }
            else{
                for(int j = 2; j > carsWaiting.get(i).getLoad(); j--){
                    loading.add(peopleWaitingLeft.get(j));
                    peopleWaitingLeft.remove(j);
                }
            }
            carsWaiting.get(i).addPassenger(loading);
        }
    }
}

    


