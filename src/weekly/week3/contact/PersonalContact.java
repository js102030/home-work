package weekly.week3.contact;

public class PersonalContact extends Contact {
    private String relationship;

    public PersonalContact(String name, String phoneNumber,String relationship) {
        super(name, phoneNumber);
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return String.format("""
                             이름: %s, 전화번호: %s, 관계: %s
                             """, name, phoneNumber, relationship);
    }
}