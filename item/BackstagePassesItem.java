package com.gildedrose.item;

public class BackstagePassesItem implements CustomizedItem {

    private final Item item;

    public BackstagePassesItem(Item item) {
        this.item = item;
    }
	/*Backstage Passes increase in quality as sell-in value approaches. */
	/* Quality increases by 2 when 10 days or <*/
	/* Quality increases by 3 when 5 days or <*/
	/* Quality drops to 0 after concert*/
	
    public void updateState() {
        decreaseSellByDayValueByOne();
        if (sellByDayValueIsOver(10)) {
            increaseQualityBy(1);
        } else if (sellByDayValueIsOver(5)) {
            increaseQualityBy(2);
        } else if (sellByDayValueIsOver(0)) {
            increaseQualityBy(3);
        } else {
            dropQualityToZero();
        }
    }

    private void decreaseSellByDayValueByOne() {
        item.sellIn -= 1;
    }

    private boolean sellByDayValueIsOver(int dayNumber) {
        return item.sellIn > dayNumber;
    }

    private void increaseQualityBy(int qualityValue) {
        item.quality += qualityValue;
    }

    private void dropQualityToZero() {
        item.quality = 0;
    }
}