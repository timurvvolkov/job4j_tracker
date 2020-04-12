package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("A new item was created:");
                System.out.println(item);
            } else if (select == 1) {
                System.out.println("=== List of all items ====");
                Item[] items = tracker.findAll();
                showItems(items);
            } else if (select == 2) {
                System.out.println("=== Edit an item ====");
                System.out.print("Enter an id of editing item: ");
                String id = scanner.nextLine();
                System.out.print("Enter a new name of item: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("An item edited successfully:");
                    System.out.println(item);
                } else {
                    System.out.println("An item editing was failed.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete an item ====");
                System.out.print("Enter an id of deleting item: ");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("An item deleted successfully.");
                } else {
                    System.out.println("An item deleting was failed.");
                }
            } else if (select == 4) {
                System.out.println("=== Find an item by id ====");
                System.out.print("Enter an id of searching item:");
                String id = scanner.nextLine();
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("No item was founded.");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter a name of searching items:");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                showItems(items);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    private void showItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}