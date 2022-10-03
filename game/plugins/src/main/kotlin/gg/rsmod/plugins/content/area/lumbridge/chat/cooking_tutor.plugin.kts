package gg.rsmod.plugins.content.area.lumbridge.chat

on_npc_option(Npcs.COOKING_TUTOR, option = "talk-to") { player.queue { dialog() } }

suspend fun QueueTask.dialog() {
    chatPlayer("Hello.")
    chatNpc("Hello there! Are you interested in hearing all about<br><br>cooking?")
    when (options("How can I train my cooking?", "What kinds of things can I cook?", "No, Thank you.")) {
        1 -> trainCooking()
        2 -> canICook()
        3 -> noThanks()
    }
}

suspend fun QueueTask.dialog2() {
    when (options("What kinds of things can I cook?", "No, thank you.")) {
        1 -> canICook()
        2 -> noThanks()
    }
}

suspend fun QueueTask.trainCooking(){
    chatPlayer("How can I train my cooking?")
    if (player.getSkills().getCurrentLevel(Skills.COOKING) >= 99) {
        chatNpc("It seems we have a real master chef in are mists.<br><br>Maybe you should be the one giving me cooking advise.")
        chatNpc("If you feel up to the task, you could try your hand at<br>making pizza. A pizza is comprised of flour with water.<br>Put some tomato on there, sprinkle some cheese<br>then cook it. You might consider adding a topping too.")
        chatNpc("Potatoes are anther great food, but I won't go into<br><br>much detail about those I'm afraid.")
        chatNpc("Is there anything else you want to know?")
    }
    else if (player.getSkills().getCurrentLevel(Skills.COOKING) >= 36) {
        chatNpc("Now you have gained some experience in cooking, you<br><br>can look forward to creating many more dishes.")
        chatNpc("If you feel up to the task, you could try your hand at<br>making pizza. A pizza is comprised of flour with water.<br>Put some tomato on there, sprinkle on some cheese<br>then cook it. You might consider adding a topping too.")
        chatNpc("Potatos are another great food, you can put all sorts<br>of toppings on them if you so desire. Such as eggs and<br>tomato.")
        chatNpc("But if you are looking for something with a bit of a<br><br>kick, I suggest curry.")
        chatNpc("Is there anything else you want to know?")
    }
    else if (player.getSkills().getCurrentLevel(Skills.COOKING) >= 26) {
        chatNpc("Using a range cuts down the possibility of burning the<br>food. In fact, the range in Lumbridge Castle is<br>particularly good for some foods, I hear.")
        chatNpc("The river north of here has an abundance of fish you<br>could fish for, if you have the required fishing level to<br>catch them. Alternatively, you could make stews.")
        chatNpc("As you increase your cooking skill you will gain access<br>to making more complicated dishes. The dishes may<br>require more then two different ingredients to make,<br>they could even require a new way of cooking them.")
        chatNpc("Those foods may heal you for more in return though.<br><br>Stews are a good option.")
        chatNpc("To make a stew you will need a bowl of water, a patato<br>and some cooked meat. You can find all these things in<br>Lumbridge. Then use them on the bowl of water and<br>cook it!")
        chatNpc("Is there anything else you want to know?")
    }
    else {
        chatNpc("The simplest thing to cook is raw meat or fish. Shrimp<br>can be caught south of here, to the east of Lumbridge<br>Swamp. You could ask the fishing tutor for a net if you<br>have not got one.")
        chatNpc("Alternatively, you could acquire some raw beer or<br>chicken. You can find cows and chicken north of here.<br>Go over the bridge then follow the path north, you can't<br>miss them!")
        itemMessageBox("When you have a full inventory of meat or fish, find a<br><br>range. Look for this icon on your minimap.", item = 5090, amountOrZoom = 400)
        chatNpc("You could use my range here if you like.")
        chatNpc("Alternatively, you can use your own fire, but it's not as<br>effective and the food will burn more frequently. To<br>make a fire, use a tinderbox on some logs.")
        chatNpc("Once you've found your range or fire, use your raw<br>food on it. This will bring up a menu of the food you<br>can cook. Then select the food you want.")
        chatNpc("When you have a full inventory of cooked food, drop<br><br>the useless burnt food and find a bank.")
        itemMessageBox("Look for this symbol on your minimap after climbing the<br>stairs of the Lumbridge Castle to the top. There are<br>numerous banks around the world, all makrded with that<br>symbol.", item = 5080, amountOrZoom = 400)
        chatNpc("Is there anything else you want to know?")
    }
    dialog2()
}

suspend fun QueueTask.canICook() {
    chatPlayer("What kinds of things can I cook?")
    chatNpc("Many things! You can cook anything from fish to<br>poultry. You could try your hand at making baked<br>potatoes or even brew some of the good stuff.")
    chatNpc("What would you like to hear about?")
    foodStuffs()
}

suspend fun QueueTask.foodStuffs() {
    when (options("Tell me about Fish and Meat.", "Tell me about Brewing.", "Tell me about Vegetables.", "Tell me about Pies and Pizzas.")) {
        1 -> fish_Meat()
        2 -> brewing()
        3 -> vegetables()
        4 -> pie_Pizza()
    }
}

suspend fun QueueTask.foodStuffs2() {
    when (options("Tell me about Brewing.", "Tell me about vegetables.", "Tell me about Pies and Pizzas.", "Not right now.")) {
        1 -> brewing()
        2 -> vegetables()
        3 -> pie_Pizza()
        4 -> notRightNow()
    }
}

suspend fun QueueTask.foodStuffs3() {
    when (options("Tell me about Fish and Meat.", "Tell me about vegetables.", "Tell me about Pies and Pizzas.", "Not right now.")) {
        1 -> fish_Meat()
        2 -> vegetables()
        3 -> pie_Pizza()
        4 -> notRightNow()
    }
}

suspend fun QueueTask.foodStuffs4() {
    when (options("Tell me about Fish and Meat.", "Tell me about Brewing.", "Tell me about Pies and Pizzas.", "Not right now.")) {
        1 -> fish_Meat()
        2 -> brewing()
        3 -> pie_Pizza()
        4 -> notRightNow()
    }
}

suspend fun QueueTask.foodStuffs5() {
    when (options("Tell me about Fish and Meat.", "Tell me about Brewing.", "Tell me about Vegetables.", "Not right now.")) {
        1 -> fish_Meat()
        2 -> brewing()
        3 -> vegetables()
        4 -> notRightNow()
    }
}

suspend fun QueueTask.fish_Meat() {
    chatPlayer("Tell me about Fish and Meat.")
    doubleItemMessageBox("Fish and meat of most varieties can be cooked very<br>simply on either a fire or range, experiment which one<br>works for you.", item1 = Items.RAW_BEEF, item2 = Items.COOKED_MEAT, amount1 = 400, amount2 = 400)
    chatNpc("You might find that when killing monsters, they drop<br><br>some raw meat for you to cook.")
    chatNpc("Some of them might have hidden properties. Such as<br>anglerfish, but you will find it hard getting hold of any<br>of them at this time.")
    chatNpc("Most of the time, cooking meat and fish requires<br>nothing else but a range or fire. More complicated<br>dishes might require specialized equipment.")
    chatNpc("Would you lke to hear about anything else I<br><br>mentioned?")
    foodStuffs2()
}

suspend fun QueueTask.brewing() {
    chatPlayer("Tell me about Brewing.")
    doubleItemMessageBox("You can brew your own beers using the fermenting<br><br>vats in either Keldagrim or Port Phasmatys.", item1 = Items.DRAGON_BITTER, item2 = Items.BEER, amount1 = 400, amount2 = 400)
    chatNpc("You might find it hard getting to these places but you<br>can always buy beer at any pub. Some pubs sell unique<br>beers too.")
    chatNpc("Would you like to hear about anything else I<br><br>mentioned?")
    foodStuffs3()
}

suspend fun QueueTask.vegetables() {
    chatPlayer("Tell me about Vegetables.")
    itemMessageBox("Baked potatoes are a more advances food and are<br><br>healthy too!", item = Items.TUNA_POTATO, amountOrZoom = 400)
    chatNpc("They require many different ingredients to make, such<br>as butter and vegetables, but you will find it hard to<br>acquire the ingredients needed.")
    chatNpc("Would you like to hear about anything else I<br><br>mentioned?")
    foodStuffs4()
}

suspend fun QueueTask.pie_Pizza() {
    chatPlayer("Tell me about Pies and Pizzas.")
    doubleItemMessageBox("Use a pot of flour with a bucket of water. You will then<br><br>need to make some pastry dough.", item1 = Items.BUCKET_OF_WATER, item2 = Items.POT_OF_FLOUR, amount1 = 400, amount2 = 400)
    doubleItemMessageBox("Use the pastry dough with a pie dish to get a pie shell,<br>then add your choice of filling such as apples or red<br>berries.", item1 = Items.PIE_SHELL, item2 = Items.PASTRY_DOUGH, amount1 = 400, amount2 = 400)
    chatNpc("Finally cook your pie by using the unbaked pie on a<br><br>cooking range. Mmmm...pie.")
    chatNpc("Next, we have pizza. You will fist need to make<br>yourself a pizza base, use a pot of flour with a bucket<br>of water and make a pizza base.")
    doubleItemMessageBox("Now you will need to get yourself a tomato and some<br>cheese. Use the tomato on the pizza base and then use<br>the cheese. Cook the uncooked pizza base and there you<br>have yourself a plain pizza.", item1 = Items.TOMATO, item2 = Items.CHEESE, amount1 = 400, amount2 = 400)
    chatNpc("If you want to, you could add yourself a topping to the<br><br>pizza too. Why not try some anchovies?")
    chatNpc("Would you like to hear about anything else I<br>mentioned?")
    foodStuffs5()
}

suspend fun QueueTask.notRightNow() {
    chatPlayer("Not right now.")
    chatNpc("Is there anything else you want to know?")
    when (options("How can I train my cooking?", "No, thank you.")) {
        1 -> trainCooking()
        2 -> noThanks()
    }
}

suspend fun QueueTask.noThanks() {
    chatPlayer("No, Thank you.")
    chatNpc("Well, just come back any time you want to know how<br><br>to cook up a storm!")
}
