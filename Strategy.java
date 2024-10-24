// Strategy Pattern with external condition example
public class Strategy {

    public static void main(String[] args) {
        // Simulating external input, e.g., from a network request
        String kind = getExternalInput(); 

        // Creating context for calling animals
        AnimalContext context = new AnimalContext();

        // Dynamically setting strategy based on external condition
        if (kind.equals("dog")) {
            context.setStrategy(new DogStrategy());
        } else if (kind.equals("cat")) {
            context.setStrategy(new CatStrategy());
        } else {
            System.out.println("Unknown animal kind");
            return;
        }

        // Now the context can execute the appropriate strategy
        context.callAnimal();
    }

    // Simulating external input source, for example, from a network request
    public static String getExternalInput() {
        // For this example, we'll just return a hardcoded value
        return "dog"; // Could be "cat", "dog", or any other condition
    }
}

// Context class that uses a strategy
class AnimalContext {
    private CallStrategy strategy;

    // Method to set the strategy at runtime based on external condition
    public void setStrategy(CallStrategy strategy) {
        this.strategy = strategy;
    }

    // Delegate the call to the strategy
    public void callAnimal() {
        strategy.call();
    }
}

// Strategy interface
interface CallStrategy {
    void call();
}

// Concrete strategy for Dog
class DogStrategy implements CallStrategy {
    public void call() {
        System.out.println("Hakh hakh");
    }
}

// Concrete strategy for Cat
class CatStrategy implements CallStrategy {
    public void call() {
        System.out.println("pchpchch");
    }
}
