public class Tester {
    public static void main(String[] args) {
        Road r = new Road(32);
        

        int repeats = 20;
        int totalCompleted = 0;

        for(int i = 0; i < repeats; i++){
            r.populatePeople(50);
            r.populateCars(20);
            
            for(int j = 0; j < r.stationCount(); j++){
                System.out.println(r.toString());
                r.runRoad();
            }
            System.out.println(r.toString());
            totalCompleted += r.resetRoad();
        }
        

        System.out.println(totalCompleted);
    }
}
