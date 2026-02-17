import java.util.*;

public class car {
    //fields
    private int currPer;
    private int maxPer;
    private int currStat;
    private int endStat;
    private int dir;
    private ArrayList<person> people;

    //constructor
    public car(int currStat, int endStat){
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
}
