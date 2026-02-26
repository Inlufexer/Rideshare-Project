public class Tester {
    public static void main(String[] args) {
        Road r = new Road(32);
        

        int repeats = 1000;
        int totalCompleted20 = 0;
        int totalCompleted40 = 0;

        for(int i = 0; i < repeats; i++){
            r.populatePeople(50);
            r.populateCars(20);
            
            for(int j = 0; j < r.stationCount(); j++){
                System.out.println(r.toString());
                r.runRoad();
            }

            System.out.println(r.toString());
            totalCompleted20 += r.resetRoad();
        }
        System.out.println("_________________\nNew Sim\n_________________");

        for(int i = 0; i < repeats; i++){
            r.populatePeople(50);
            r.populateCars(40);
            
            for(int j = 0; j < r.stationCount(); j++){
                System.out.println(r.toString());
                r.runRoad();
            }

            System.out.println(r.toString());
            totalCompleted40 += r.resetRoad();
        }
        

        System.out.println("20 Car Sim Passenger Completion Rate: " + (double) totalCompleted20/(repeats*50));
        System.out.println("40 Car Sim Passenger Completion Rate: " + (double) totalCompleted40/(repeats*50));
    }
}
