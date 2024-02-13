package weekly.week3;

import weekly.week3.contact.BusinessContact;
import weekly.week3.contact.Contact;
import weekly.week3.contact.PersonalContact;
import weekly.week3.enumType.ContactType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static weekly.week3.enumType.ContactType.*;

public class AddressBook {
    private final List<Contact> contacts = new ArrayList<>();

    public void open() {
        dummyDataPush();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println(
                        """
                                =============================
                                         AddressBook
                                =============================
                                    1. 비즈니스 연락처 추가
                                    2. 개인 연락처 추가
                                    3. 연락처 출력
                                    4. 연락처 검색
                                    5. 종료
                                =============================
                                    
                                    메뉴를 선택해주세요: ↵
                                """
                );

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addBusinessContact(sc);
                    case 2 -> addPersonalContact(sc);
                    case 3 -> displayContacts();
                    case 4 -> searchContact(sc);
                    case 5 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            }
        }
    }

    private void addBusinessContact(Scanner sc) {
        addContact(BUSINESS,sc);
    }

    private void addPersonalContact(Scanner sc) {
        addContact(PERSONAL,sc);
    }

    private void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("연락처가 비어있습니다.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private void searchContact(Scanner sc) {
        System.out.println("검색할 이름을 입력하세요: ");

        String name = sc.nextLine();

        boolean isNameFound = false;
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                System.out.println(c);
                isNameFound = true;
            }
        }

        if (!isNameFound) {
            System.out.println("연락처를 찾을 수 없습니다.");
        }
    }

    private void addContact(ContactType type, Scanner sc) {
        System.out.println("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("전화번호를 입력하세요: ");
        String rawPhoneNumber = sc.nextLine();

        String digits = rawPhoneNumber.replaceAll("\\D", "");
        String formattedPhoneNumber = formatPhoneNumber(digits);

        if (type == BUSINESS) {
            System.out.println("회사명을 입력하세요: ");
            String companyName = sc.nextLine();
            contacts.add(new BusinessContact(name, formattedPhoneNumber, companyName));
        } else if (type == PERSONAL) {
            System.out.println("관계를 입력하세요: ");
            String relationship = sc.nextLine();
            contacts.add(new PersonalContact(name, formattedPhoneNumber, relationship));
        }
    }

    private String formatPhoneNumber(String digits) {
        if (digits.length() != 11) {
            return digits;
        }
        return digits.substring(0, 3) + "-" + digits.substring(3, 7) + "-" + digits.substring(7);
    }

    private void dummyDataPush() {
        BusinessContact businessDummy1 = new BusinessContact("Kim", "010-2345-6789", "Acme Corp");
        BusinessContact businessDummy2 = new BusinessContact("Smith", "010-3456-7890", "Globex Inc");
        BusinessContact businessDummy3 = new BusinessContact("Lee", "010-4567-8901", "Initech LLC");

        PersonalContact personalDummy1 = new PersonalContact("Kim", "010-5678-9012", "College Friend");
        PersonalContact personalDummy2 = new PersonalContact("Martinez", "010-6789-0123", "Cousin");
        PersonalContact personalDummy3 = new PersonalContact("Brown", "010-7890-1234", "Gym Buddy");

        contacts.add(businessDummy1);
        contacts.add(businessDummy2);
        contacts.add(businessDummy3);
        contacts.add(personalDummy1);
        contacts.add(personalDummy2);
        contacts.add(personalDummy3);
    }
}