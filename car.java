import java.util.*;

public class Car {
    //fields
    private int currPer;
    private int maxPer;
    private int currStat;
    private int endStat;
    private int dir;
    private ArrayList<Person> people;

    //constructor
    public Car(int currStat, int endStat){
        currPer = 0;
        maxPer = 3;
        this.currStat = currStat;
        this.endStat = endStat;
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

    public void addPassenger(Person person){

    }

    public boolean full(){
        return currPer == maxPer;
    }
}
