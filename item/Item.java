package com.gildedrose.item;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    /*Display sell-in of time and the quality. */
    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}