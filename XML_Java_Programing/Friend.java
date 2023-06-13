import java.util.ArrayList;

class Friend {
    private int id;
    private String name;
    private int age;
    private String description;
    private ArrayList<String> phoneNumber;

    public Friend(int id, String name, int age, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.phoneNumber = new ArrayList<>();
    }

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumber.add(phoneNumber);
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Description: " + description);
        System.out.println("Phone Numbers:");
        for (int i = 0; i < phoneNumber.size(); i++) {
            System.out.println("PhoneNumber[" + i + "]: " + phoneNumber.get(i));
        }
    }
}
