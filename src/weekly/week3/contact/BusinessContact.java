package weekly.week3.contact;

public class BusinessContact extends Contact {
    private String company;

    public BusinessContact(String name, String phoneNumber, String company) {
        super(name, phoneNumber);
        this.company = company;
    }

    @Override
    public String toString() {
        return String.format("""
                             이름: %s, 전화번호: %s, 회사명: %s
                             """, name, phoneNumber, company);
    }
}