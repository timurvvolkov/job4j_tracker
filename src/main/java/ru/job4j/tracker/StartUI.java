package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
//    public void init(Input input, Tracker tracker, UserAction[] actions) {
//        boolean run = true;
//        while (run) {
//            this.showMenu(actions);
//            int select = input.askInt("Select: ", actions.length);
//            UserAction action = actions[select];
//            run = action.execute(input, tracker);
//        }
//    }
//
//    private void showMenu(UserAction[] actions) {
//        System.out.println("Menu.");
//        for (int index = 0; index < actions.length; index++) {
//            System.out.println(index + ". " + actions[index].name());
//        }
//    }
//
//    public static void main(String[] args) {
//        Input input = new ConsoleInput();
//        Input validate = new ValidateInput(input);
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(), new FindAllAction(), new ReplaceAction(), new DeleteAction(),
//                new FindIdAction(), new FindByNameAction(), new ExitAction()
//        };
//        new StartUI().init(validate, tracker, actions);
//    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new FindAllAction());
        actions.add(new ReplaceAction());
        actions.add(new DeleteAction());
        actions.add(new FindIdAction());
        actions.add(new FindByNameAction());
        actions.add(new ExitAction());
        new StartUI().init(validate, tracker, actions);
    }
}