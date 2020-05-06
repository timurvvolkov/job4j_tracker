package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortItemTest {
    @Test
    public void SortById() {
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        Item item4 = new Item("fourth");
        item1.setId("1");
        item2.setId("2");
        item3.setId("3");
        item4.setId("4");
        List<Item> items = Arrays.asList(item3, item1, item2, item4);
        Collections.sort(items, new SortByIdItem());
        List<Item> result = Arrays.asList(item1, item2, item3, item4);
        assertThat(result, is(items));
    }

    @Test
    public void SortReverseById() {
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        Item item4 = new Item("fourth");
        item1.setId("1");
        item2.setId("2");
        item3.setId("3");
        item4.setId("4");
        List<Item> items = Arrays.asList(item3, item1, item2, item4);
        Collections.sort(items, new SortReverseByIdItem());
        List<Item> result = Arrays.asList(item4, item3, item2, item1);
        assertThat(result, is(items));
    }

    @Test
    public void SortByName() {
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        Item item4 = new Item("fourth");
        item1.setId("1");
        item2.setId("2");
        item3.setId("3");
        item4.setId("4");
        List<Item> items = Arrays.asList(item3, item1, item2, item4);
        Collections.sort(items, new SortByNameItem());
        List<Item> result = Arrays.asList(item1, item4, item2, item3);
        assertThat(result, is(items));
    }

    @Test
    public void SortReverseByName() {
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        Item item4 = new Item("fourth");
        item1.setId("1");
        item2.setId("2");
        item3.setId("3");
        item4.setId("4");
        List<Item> items = Arrays.asList(item3, item1, item2, item4);
        Collections.sort(items, new SortReverseByNameItem());
        List<Item> result = Arrays.asList(item3, item2, item4, item1);
        assertThat(result, is(items));
    }
}
