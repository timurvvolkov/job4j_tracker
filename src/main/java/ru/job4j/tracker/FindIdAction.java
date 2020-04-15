package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find an item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter an id of searching item: ");
        Item item = tracker.findById(id);
        System.out.println(item);
        return true;
    }
}
