package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit an item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter an id of editing item: ");
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("An item edited successfully:");
            System.out.println(item);
        } else {
            System.out.println("An item editing was failed.");
        }
        return true;
    }
}
