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
        for(int i = carsWaiting.size() - 1; i > -1; i--){
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

    public void sendPassengers(){
        for(int i = 0; i < carsWaiting.size(); i++){
            ArrayList<Person> loading = new ArrayList<Person>();
            int loadAmount;
            if(carsWaiting.get(i).getDir() == 1 && !peopleWaitingRight.isEmpty()){
                loadAmount = Math.min(peopleWaitingRight.size(), carsWaiting.get(i).getLoad());
                for(int j = 0; j < loadAmount; j++){
                    loading.add(peopleWaitingRight.get(j));
                }
                for(int j = 0; j < loadAmount; j++){
                    peopleWaitingRight.remove(0);
                }
            }

            else if(carsWaiting.get(i).getDir() == -1 && !peopleWaitingLeft.isEmpty()){
                loadAmount = Math.min(peopleWaitingLeft.size(), carsWaiting.get(i).getLoad());
                for(int j = 0; j < loadAmount; j++){
                    loading.add(peopleWaitingLeft.get(j));
                }
                for(int j = 0; j < loadAmount; j++){
                    peopleWaitingLeft.remove(0);
                }
            }
            carsWaiting.get(i).addPassenger(loading);
            carsWaiting.get(i).move();
        }
    }

    public ArrayList<Car> sendCars(){
        ArrayList<Car> sentCars = (ArrayList) carsWaiting.clone();
        carsWaiting.clear();
        return sentCars;
    }

    public void takeCars(ArrayList<Car> incCars){
        carsWaiting.clear();
        carsWaiting.addAll(incCars);
    }

    public void takeCar(Car car){
        carsWaiting.add(car);
    }

    public void addPassenger(Person person){
        if(person.getStation() - myId > 0){
            peopleWaitingRight.add(person);
            }
        else{
            peopleWaitingLeft.add(person);
            }
    }

    public String toString(){
        String s = "Station: " + myId + "\nPeople Waiting Left:";
        for(Person p : peopleWaitingLeft){
            s += "(" + p + ")";
        }

        s += "\nPeople Waiting Right: ";
        for(Person p : peopleWaitingRight){
            s += "(" + p + ")";
        }
        s += "\nPeople Finished: ";
        for(Person p : peopleCompleted){
            s += "(" + p + ")";
        }

        s += "\nCars Waiting: ";
        for(Car c : carsWaiting){
            s += "(" + c + ")";
        }

        s += "\nCars Finished: ";
        for(Car c : carsCompleted){
            s += "(" + c + ")";
        }

        return s;
    }
}

    


