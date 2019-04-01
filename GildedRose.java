package com.gildedrose;

import com.gildedrose.item.CustomizedItem;
import com.gildedrose.item.Item;
import com.gildedrose.item.CustomizedItemFactory;
import com.gildedrose.item.QualityValues;

class GildedRose {

    private static final int LOWEST_QUALITY_VALUE_POSSIBLE = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
		/* Update Quality of items. */
    public void updateQuality() {
        for (Item item : items) {
            customizedItem(item).updateState();
            if (hasReachedLowestQualityValue(item)) {
                item.quality = LOWEST_QUALITY_VALUE_POSSIBLE;
            } else if (hasReachedHighestQualityValue(item)) {
                item.quality = QualityValues.highestValuePossible(item);
            }
        }
    }

    private CustomizedItem customizedItem(Item item) {
        return new CustomizedItemFactory(item).customizeItem(item);
    }

    private boolean hasReachedLowestQualityValue(Item item) {
        return item.quality < LOWEST_QUALITY_VALUE_POSSIBLE;
    }

    private boolean hasReachedHighestQualityValue(Item item) {
        return item.quality > QualityValues.highestValuePossible(item);
    }
}