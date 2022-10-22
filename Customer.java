package sprint2.assignment;

public class Customer {
    private String social;
    private String name;
    private String dateOfRegistry;

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfRegistry() {
        return dateOfRegistry;
    }

    public void setDateOfRegistry(String dateOfRegistry) {
        this.dateOfRegistry = dateOfRegistry;
    }

    public Customer(String social, String name, String dateOfRegistry) {
        this.social = social;
        this.name = name;
        this.dateOfRegistry = dateOfRegistry;
    }

    @Override
    public String toString() {
        return "social: " + social +
                ", name: " + name +
                ", dateOfRegistry: " + dateOfRegistry;
    }
}
