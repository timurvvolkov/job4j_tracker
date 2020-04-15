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
        tracker.replace(id, item);
        return true;
    }
}
