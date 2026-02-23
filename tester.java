public class Tester {
    public static void main(String[] args) {
        Road r = new Road();
        r.populatePeople(10);
        r.populateCars(2);

        for(int i = 0; i < 4; i++){
            System.out.println(r.toString());
            r.runRoad();
        }
        
        System.out.println(r.toString());
    }
}
