import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class CalculatorServer {
    public static void main(String[] args)  {
        try {
            Calculator calculator = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.bind("CalculatorService", calculator);
            System.out.println("Server started.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
