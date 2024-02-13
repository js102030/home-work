package weekly.week3.contact;

public abstract class Contact {
    protected String name;
    protected String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
}