package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete an item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter an id of deleting item: ");
        if (tracker.delete(id)) {
            System.out.println("An item deleted successfully.");
        } else {
            System.out.println("An item deleting was failed.");
        }
        return true;
    }
}
