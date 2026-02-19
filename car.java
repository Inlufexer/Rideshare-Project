import java.util.*;

public class Car {
    //fields
    private int maxPer;
    private int currStat;
    private int endStat;
    private int dir;
    private ArrayList<Person> people;

    //constructor
    public Car(int currStat, int endStat){
        maxPer = 3;
        this.currStat = currStat;
        this.endStat = endStat;
        people = new ArrayList<Person>();
        if(endStat > currStat){
            dir = 1;
        }
        else{
            dir = -1;
        }
    }

    //methods
    public void move(){
        currStat += dir;
    }

    public void addPassenger(ArrayList<Person> people){
        people.addAll(people);
    }

    public ArrayList<Person> dropPassenger(int station){
        ArrayList<Person> droppedOff = new ArrayList<Person>();
        if(station == endStat){
            return people;
        }
        else{
            for(int i = people.size() - 1; i > -1; i++){
                if(currStat == people.get(i).getStation()){
                    droppedOff.add(people.get(i));
                    people.remove(i);
                }
            }
        }
        return droppedOff;
    }

    public ArrayList<Person> passengerHandle(int station, ArrayList<Person> people){
        ArrayList<Person> droppedOff = new ArrayList<Person>();
        addPassenger(people);
        droppedOff = dropPassenger(station);
        return droppedOff;
    }

    public boolean full(){
        return people.size() == maxPer;
    }

}
