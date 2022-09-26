package gg.rsmod.plugins.content.area.varrock.shops

import gg.rsmod.plugins.content.mechanics.shops.CoinCurrency

create_shop("Horvik's Armour Shop.", CoinCurrency(), purchasePolicy = PurchasePolicy.BUY_STOCK) {
    items[0] = ShopItem(Items.BRONZE_CHAINBODY, 5)
    items[1] = ShopItem(Items.IRON_CHAINBODY, 3)
    items[2] = ShopItem(Items.STEEL_CHAINBODY, 3)
    items[3] = ShopItem(Items.MITHRIL_CHAINBODY, 1)
    items[4] = ShopItem(Items.BRONZE_PLATEBODY, 3)
    items[5] = ShopItem(Items.IRON_PLATEBODY, 1)
    items[6] = ShopItem(Items.STEEL_PLATEBODY, 1)
    items[7] = ShopItem(Items.BLACK_PLATEBODY, 1)
    items[8] = ShopItem(Items.MITHRIL_PLATEBODY, 1)
    items[9] = ShopItem(Items.IRON_PLATELEGS, 1)
    items[10] = ShopItem(Items.STUDDED_BODY, 1)
    items[11] = ShopItem(Items.STUDDED_CHAPS, 1)
}