package json;

public class Producer {
    private final String name;

    public Producer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Producer{"
                + "name='" + name + '\''
                + '}';
    }
}
