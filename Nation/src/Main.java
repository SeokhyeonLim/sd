import Nation.Nation;

public class Main {
    public static void main(String[] args) {
        for (Nation nation : Nation.nations) {
            System.out.println(nation);
        }
    }
}
