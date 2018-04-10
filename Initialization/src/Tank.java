public class Tank {
    static int counter;
    int id = counter++;
    boolean full;

    public Tank() {
        System.out.println("Tank " + id + " created");
        full = true;
    }

    public void empty() {
        full = false;
    }

    protected void finalize() {
        if (full)
            System.out.println("Error: tank " + id + " must be empty at cleanup");
        else
            System.out.println("Tank " + id + " cleaned up OK");
    }

    public String toString() {
        return "Tank " + id;
    }
}
