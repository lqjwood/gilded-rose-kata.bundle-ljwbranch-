package com.gildedrose.item;

public class ConjuredItem extends StandardItem {
	/*Conjured item degrades in quality 2x as fast as normal items.*/
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public int decreasingValueOverZeroDaysToSell() {
        return 2;
    }
}