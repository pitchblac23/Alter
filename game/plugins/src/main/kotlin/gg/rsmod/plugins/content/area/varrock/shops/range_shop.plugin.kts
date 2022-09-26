package gg.rsmod.plugins.content.area.varrock.shops

import gg.rsmod.plugins.content.mechanics.shops.CoinCurrency

create_shop("Lowe's Archery Emporium", CoinCurrency(), purchasePolicy = PurchasePolicy.BUY_STOCK) {
    items[0] = ShopItem(Items.BRONZE_ARROW, 2000)
    items[1] = ShopItem(Items.IRON_ARROW, 1500)
    items[2] = ShopItem(Items.STEEL_ARROW, 1000)
    items[3] = ShopItem(Items.MITHRIL_ARROW, 800)
    items[4] = ShopItem(Items.ADAMANT_ARROW, 600)
    items[5] = ShopItem(Items.BRONZE_BOLTS, 1500)
    items[6] = ShopItem(Items.SHORTBOW, 4)
    items[7] = ShopItem(Items.LONGBOW, 4)
    items[8] = ShopItem(Items.OAK_SHORTBOW, 3)
    items[9] = ShopItem(Items.OAK_LONGBOW, 3)
    items[10] = ShopItem(Items.WILLOW_LONGBOW, 2)
    items[11] = ShopItem(Items.WILLOW_LONGBOW, 2)
    items[12] = ShopItem(Items.MAPLE_SHORTBOW, 1)
    items[13] = ShopItem(Items.MAPLE_LONGBOW, 1)
    items[14] = ShopItem(Items.CROSSBOW, 2)
}