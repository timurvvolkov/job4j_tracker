package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter a name of searching items: ");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            System.out.println(item);
        }
        return true;
    }
}
