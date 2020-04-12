package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
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
                String id = input.askStr("Enter an id of editing item: ");
                String name = input.askStr("Enter a new name of item: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("An item edited successfully:");
                    System.out.println(item);
                } else {
                    System.out.println("An item editing was failed.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete an item ====");
                String id = input.askStr("Enter an id of deleting item: ");
                if (tracker.delete(id)) {
                    System.out.println("An item deleted successfully.");
                } else {
                    System.out.println("An item deleting was failed.");
                }
            } else if (select == 4) {
                System.out.println("=== Find an item by id ====");
                String id = input.askStr("Enter an id of searching item: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("No item was founded.");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                String name = input.askStr("Enter a name of searching items: ");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}