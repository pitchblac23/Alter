package gg.rsmod.plugins.content.area.varrock.shops

import gg.rsmod.plugins.content.mechanics.shops.CoinCurrency

create_shop("Horvik's Armour Shop.", CoinCurrency(), purchasePolicy = PurchasePolicy.BUY_STOCK) {
    items[0] = ShopItem(Items.BRONZE_SWORD, 5)
    items[1] = ShopItem(Items.IRON_SWORD, 4)
    items[2] = ShopItem(Items.STEEL_SWORD, 4)
    items[3] = ShopItem(Items.BLACK_SWORD, 3)
    items[4] = ShopItem(Items.MITHRIL_SWORD, 3)
    items[5] = ShopItem(Items.ADAMANT_SWORD, 2)
    items[6] = ShopItem(Items.BRONZE_LONGSWORD, 4)
    items[7] = ShopItem(Items.IRON_LONGSWORD, 3)
    items[8] = ShopItem(Items.STEEL_LONGSWORD, 3)
    items[9] = ShopItem(Items.BLACK_LONGSWORD, 2)
    items[10] = ShopItem(Items.MITHRIL_LONGSWORD, 2)
    items[11] = ShopItem(Items.ADAMANT_LONGSWORD, 1)
    items[12] = ShopItem(Items.BRONZE_DAGGER, 10)
    items[13] = ShopItem(Items.IRON_DAGGER, 6)
    items[14] = ShopItem(Items.STEEL_DAGGER, 5)
    items[15] = ShopItem(Items.BLACK_DAGGER, 4)
    items[16] = ShopItem(Items.MITHRIL_DAGGER, 3)
    items[17] = ShopItem(Items.ADAMANT_DAGGER, 2)
}