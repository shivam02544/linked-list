package linkedList;

import java.util.Scanner;

class UserModel {
    private int id;
    private String name;
    UserModel next;

    public UserModel() {

    }

    public UserModel(int id, String name) {
        this.id = id;
        this.name = name;
        this.next = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

public class SinglyLinkedList {
    static Scanner in = new Scanner(System.in);
    static UserModel startNode;
    static UserModel lastNode;
    static UserModel nextNode;
    static UserModel tempNode;

    public void showMenu() {
        System.out.println("=".repeat(98));
        System.out.println("Press 1 for insert at begin: ");
        System.out.println("Press 2 for insert at end: ");
        System.out.println("Press 3 for insert at position: ");
        System.out.println("Press 4 for delete at begin: ");
        System.out.println("Press 5 for delete at end: ");
        System.out.println("Press 6 for delete at position: ");
        System.out.println("Press 7 for display: ");
        System.out.println("Press 8 for number of data(s): ");
        System.out.println("Press 9 for search: ");
        System.out.println("Press 10 for update: ");
        System.out.println("Press 11 for exit: ");
        System.out.println("=".repeat(98));
    }

    public UserModel insertUserData() {
        System.out.println("Enter your id:");
        int id = in.nextInt();
        System.out.println("Enter your name:");
        in.nextLine();
        String name = in.nextLine();
        UserModel userModel = new UserModel(id, name);
        return userModel;
    }

    public void insertAtBegin() {
        UserModel user = insertUserData();
        if (startNode == null)
            startNode = lastNode = user;
        else {
            user.next = startNode;
            startNode = user;
        }
        System.out.println("Data inserted...!");
    }

    public void insertAtEnd() {
        if (startNode == null)
            insertAtBegin();
        else {
            UserModel user = insertUserData();
            lastNode.next = user;
            lastNode = user;
        }
        System.out.println("Data Inserted....");
    }

    public void insertAtPosition() {
        int i = 1;
        System.out.println("Enter Your Position :");
        int pos = in.nextInt();
        if (pos == 1)
            insertAtBegin();
        else {
            nextNode = startNode;
            while (i < pos && nextNode != null) {
                tempNode = nextNode;
                nextNode = nextNode.next;
                i++;
            }
            if (i == pos) {
                UserModel user = insertUserData();
                tempNode.next = user;
                user.next = nextNode;
            } else {
                System.out.println("sorry you have only " + i + " node that's why you don't insert on that posiition ");
            }
        }
    }

    public void display() {
        UserModel itr = startNode;
        while (itr != null) {
            System.out.println("Id: " + itr.getId() + " Name: " + itr.getName() + "\n");
            itr = itr.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        String choice;
        do {
            sll.showMenu();
            System.out.println("Enter your option: ");
            int opt = in.nextInt();
            switch (opt) {
                case 1:
                    sll.insertAtBegin();
                    break;
                case 2:
                    sll.insertAtEnd();
                    break;
                case 3:
                    sll.insertAtPosition();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    sll.display();
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
            System.out.println("Show menu [Y] or press any key for exit");
            choice = in.next();
        } while (choice.equalsIgnoreCase("y"));
    }

}
