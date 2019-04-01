package com.gildedrose.item;

import java.util.HashMap;
import java.util.Map;

public class CustomizedItemFactory {

    private final static Map<String, CustomizedItem> ITEM_TYPES_LIST = new HashMap<>();
    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to TAFKAL80ETC concert";
    public final static String CONJURED_ITEM = "Conjured";

    public CustomizedItemFactory(Item item) {
        ITEM_TYPES_LIST.put(SULFURAS, new Sulfuras());
        ITEM_TYPES_LIST.put(BRIE, new AgedBrie(item));
        ITEM_TYPES_LIST.put(BACKSTAGE_PASSES_ITEM, new BackstagePassesItem(item));
        ITEM_TYPES_LIST.put(CONJURED_ITEM, new ConjuredItem(item));
    }

    public CustomizedItem customizeItem(Item item) {
        if (isStandardItem(item)) {
            return new StandardItem(item);
        }
        return ITEM_TYPES_LIST.get(item.name);
    }

    private boolean isStandardItem(Item item) {
        return !ITEM_TYPES_LIST.keySet().contains(item.name);
    }
}