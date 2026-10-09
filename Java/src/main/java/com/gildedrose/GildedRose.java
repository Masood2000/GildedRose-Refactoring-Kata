package com.gildedrose;

class GildedRose {

    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASSES_TO_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS_RAGNAROS = "Sulfuras, Hand of Ragnaros";


    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            //if item name is aged brie
            if(items[i].name.equals(AGED_BRIE)) itemIsAgedBrie(i);
            else if(items[i].name.equals(BACKSTAGE_PASSES_TO_CONCERT)) itemIsBackstageConcert(i);
            else {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(SULFURAS_RAGNAROS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }

          /*  if (!items[i].name.equals(AGED_BRIE) && !items[i].name.equals(BACKSTAGE_PASSES_TO_CONCERT)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(SULFURAS_RAGNAROS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }
            else {
                if (items[i].quality < 50) {
                    increaseQualityIfLessThen50(i);

                    if (items[i].name.equals(BACKSTAGE_PASSES_TO_CONCERT)) itemIsBackstageConcert(i);

                }
            }*/

            if (!items[i].name.equals(SULFURAS_RAGNAROS) && !items[i].name.equals(AGED_BRIE)) items[i].sellIn = items[i].sellIn - 1;

            if (items[i].sellIn < 0) itemSellInLessThanZero(i);


        }



    }

    void itemSellInLessThanZero(int i) {

        if (!items[i].name.equals(AGED_BRIE)) {
            if (!items[i].name.equals(BACKSTAGE_PASSES_TO_CONCERT)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(SULFURAS_RAGNAROS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }
            else {
                items[i].quality = items[i].quality - items[i].quality;
            }
        }
        else {
            //increaseQualityIfLessThen50(i);
        }

    }

    void itemIsAgedBrie(int i) {

        increaseQualityIfLessThen50(i);

        items[i].sellIn = items[i].sellIn - 1;

        if (items[i].sellIn < 0) increaseQualityIfLessThen50(i);



    }

    void itemIsBackstageConcert(int i) {

        increaseQualityIfLessThen50(i);

        if (items[i].quality < 50) {

            if (items[i].sellIn < 11) {
                increaseQualityIfLessThen50(i);
            }

            if (items[i].sellIn < 6) {
                increaseQualityIfLessThen50(i);
            }

        }


    }

    void increaseQualityIfLessThen50(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

}



