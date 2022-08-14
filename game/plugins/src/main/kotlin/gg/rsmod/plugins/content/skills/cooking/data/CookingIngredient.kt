package gg.rsmod.plugins.content.skills.cooking.data

import gg.rsmod.plugins.api.cfg.Items

/**TODO:
 * 3 item ingredients
 * 4 item ingredients
 */

enum class CookingIngredient(val item1: Int, val item2: Int, val usedItem1: Int, val usedItem2: Int, val result: Int, val minLevel: Int, val xp: Double) {

    BREAD_DOUGH(Items.POT_OF_FLOUR, Items.BUCKET_OF_WATER, Items.POT, Items.EMPTY_BUCKET, Items.BREAD_DOUGH, 1,0.0),
    BREAD_DOUGH_BOWL(Items.POT_OF_FLOUR, Items.BOWL_OF_WATER, Items.POT, Items.BOWL, Items.BREAD_DOUGH, 1,0.0),
    BREAD_DOUGH_JUG(Items.POT_OF_FLOUR, Items.JUG_OF_WATER, Items.POT, Items.JUG, Items.BREAD_DOUGH, 1,0.0),

    PITTA_DOUGH(Items.POT_OF_FLOUR, Items.BUCKET_OF_WATER, Items.POT, Items.EMPTY_BUCKET, Items.PITTA_DOUGH, 58,1.0),

    PASTRY_DOUGH(Items.POT_OF_FLOUR, Items.BUCKET_OF_WATER, Items.POT, Items.EMPTY_BUCKET, Items.PASTRY_DOUGH, 1, 0.0),
    PASTRY_DOUGH_BOWL(Items.POT_OF_FLOUR, Items.BOWL_OF_WATER, Items.POT, Items.BOWL, Items.PASTRY_DOUGH, 1,0.0),
    PASTRY_DOUGH_JUG(Items.POT_OF_FLOUR, Items.JUG_OF_WATER, Items.POT, Items.JUG, Items.PASTRY_DOUGH, 1,0.0),

    PIE_SHELL(Items.PASTRY_DOUGH, Items.PIE_DISH, -1, -1, Items.PIE_SHELL, 20, 0.0),
    UNCOOKED_BERRY_PIE(Items.REDBERRIES, Items.PIE_SHELL, -1, -1, Items.UNCOOKED_BERRY_PIE, 10, 0.0),
    UNCOOKED_MEAT_PIE(Items.COOKED_MEAT, Items.PIE_SHELL, -1, -1, Items.UNCOOKED_MEAT_PIE, 20, 0.0),

    PIZZA_BASE(Items.POT_OF_FLOUR, Items.BUCKET_OF_WATER, Items.POT, Items.EMPTY_BUCKET, Items.PIZZA_BASE, 35, 0.0),

    INCOMPLETE_STEW(Items.BOWL_OF_WATER, Items.POTATO, -1, -1, Items.INCOMPLETE_STEW, 25, 0.0),
    INCOMPLETE_STEW2(Items.BOWL_OF_WATER, Items.COOKED_MEAT, -1, -1, Items.INCOMPLETE_STEW_1999, 25, 0.0),
    INCOMPLETE_STEW3(Items.BOWL_OF_WATER, Items.COOKED_CHICKEN, -1, -1, Items.INCOMPLETE_STEW_1999, 25, 0.0),

    UNCOOKED_STEW(Items.INCOMPLETE_STEW, Items.COOKED_MEAT, -1, -1, Items.UNCOOKED_STEW, 25, 0.0),
    UNCOOKED_STEW2(Items.INCOMPLETE_STEW, Items.COOKED_CHICKEN, -1, -1, Items.UNCOOKED_STEW, 25, 0.0),
    UNCOOKED_STEW3(Items.INCOMPLETE_STEW_1999, Items.POTATO, -1, -1, Items.UNCOOKED_STEW, 25, 0.0),

    POTATO_BUTTER(Items.BAKED_POTATO, Items.PAT_OF_BUTTER, -1, -1, Items.POTATO_WITH_BUTTER, 39, 40.0),
    POTATO_CHEESE(Items.POTATO_WITH_BUTTER, Items.CHEESE, -1, -1, Items.POTATO_WITH_CHEESE, 39, 40.0),

    CHOCOLATE_CAKE_BAR(Items.CAKE, Items.CHOCOLATE_DUST, -1, -1, Items.CHOCOLATE_CAKE, 50, 30.0),
    CHOCOLATE_CAKE_DUST(Items.CAKE, Items.CHOCOLATE_BAR, -1, -1, Items.CHOCOLATE_CAKE, 50, 30.0),

    CUP_OF_TEA(Items.NETTLE_TEA, Items.EMPTY_CUP, Items.BOWL, -1, Items.CUP_OF_TEA_4242, 20, 42.0);//4243 milk tea

    companion object {
        val values = enumValues<CookingIngredient>()
    }
}

/*
    UNCOOKED_BERRY_PIE(Items.PIE_SHELL,Items.REDBERRIES,10, 0.0 ,intArrayOf(Items.UNCOOKED_BERRY_PIE),false),
    UNCOOKED_MEAT_PIE(Items.PIE_SHELL,Items.COOKED_MEAT,20, 0.0 ,intArrayOf(Items.UNCOOKED_MEAT_PIE),false),
    UNCOOKED_APPLE_PIE(Items.PIE_SHELL,Items.COOKING_APPLE,30, 0.0 ,intArrayOf(Items.UNCOOKED_APPLE_PIE),false),
    UNCOOKED_BOTANICAL_PIE(Items.PIE_SHELL,Items.GOLOVANOVA_FRUIT_TOP,52, 0.0 ,intArrayOf(Items.UNCOOKED_BOTANICAL_PIE),false),
    UNCOOKED_MUSHROOM_PIE(Items.PIE_SHELL,Items.SULLIUSCEP_CAP,60, 0.0 ,intArrayOf(Items.UNCOOKED_MUSHROOM_PIE),false),
    UNCOOKED_DRAGONFRUIT_PIE(Items.PIE_SHELL,Items.DRAGONFRUIT,73, 0.0 ,intArrayOf(Items.UNCOOKED_DRAGONFRUIT_PIE),false),

    PART_GARDEN_1(Items.PIE_SHELL,Items.TOMATO,34, 0.0 ,intArrayOf(Items.PART_GARDEN_PIE),false),
    PART_GARDEN_2(Items.PART_GARDEN_PIE,Items.ONION,34, 0.0 ,intArrayOf(Items.PART_GARDEN_PIE_7174),false),
    RAW_GARDEN_PIE(Items.PART_GARDEN_PIE_7174,Items.CABBAGE,34, 0.0 ,intArrayOf(Items.RAW_GARDEN_PIE),false),

    PART_FISH_1(Items.PIE_SHELL,Items.TROUT,47, 0.0 ,intArrayOf(Items.PART_FISH_PIE),false),
    PART_FISH_2(Items.PART_FISH_PIE,Items.COD,47, 0.0 ,intArrayOf(Items.PART_FISH_PIE_7184),false),
    RAW_FISH_PIE(Items.PART_FISH_PIE_7184,Items.POTATO,47, 0.0 ,intArrayOf(Items.RAW_FISH_PIE),false),
    //ADMIRAL PIE
    PART_ADMIRAL_1(Items.PIE_SHELL,Items.SALMON,70, 0.0 ,intArrayOf(Items.PART_ADMIRAL_PIE),false),
    PART_ADMIRAL_2(Items.PART_ADMIRAL_PIE,Items.TUNA,70, 0.0 ,intArrayOf(Items.PART_ADMIRAL_PIE_7194),false),
    RAW_ADMIRAL_PIE(Items.PART_ADMIRAL_PIE_7194,Items.POTATO,70, 0.0 ,intArrayOf(Items.RAW_ADMIRAL_PIE),false),

    PART_WILD_1(Items.PIE_SHELL,Items.RAW_BEAR_MEAT,85, 0.0 ,intArrayOf(Items.PART_WILD_PIE),false),
    PART_WILD_2(Items.PART_FISH_PIE,Items.RAW_CHOMPY,85, 0.0 ,intArrayOf(Items.PART_WILD_PIE_7204),false),
    RAW_WILD_PIE(Items.PART_WILD_PIE_7204,Items.RAW_RABBIT,85, 0.0 ,intArrayOf(Items.RAW_WILD_PIE),false),

    PART_SUMMER_1(Items.PIE_SHELL,Items.STRAWBERRY,95, 0.0 ,intArrayOf(Items.PART_SUMMER_PIE),false),
    PART_SUMMER_2(Items.PART_SUMMER_PIE,Items.WATERMELON,95, 0.0 ,intArrayOf(Items.PART_SUMMER_PIE_7214),false),
    RAW_SUMMER_PIE(Items.PART_SUMMER_PIE_7214,Items.COOKING_APPLE,95, 0.0 ,intArrayOf(Items.RAW_SUMMER_PIE),false);
 */