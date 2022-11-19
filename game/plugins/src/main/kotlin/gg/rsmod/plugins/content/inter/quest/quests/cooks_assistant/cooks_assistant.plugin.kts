package gg.rsmod.plugins.content.inter.quest.quests.cooks_assistant

var asked = 0
var takenItems = 0
var takenFlour = 0
var takenMilk = 0
var takenEgg = 0

on_npc_option(4626, option = "talk-to") {
    player.queue {
        if (player.getVarp(29) == 0) { // NOT STARTED
            chatNpc("What am I to do?")
            askForQuest()
        }

        if (player.getVarp(29) == 1) { checkItems() }// STARTED

        if ((player.getVarp(29) == 2) and (!player.isInterfaceVisible(277))) { afterQuestDialogue() }// COMPLETED
    }
}

suspend fun QueueTask.askForQuest() {
    when (options("What's wrong?","Can you make me a cake?","You don't look very happy.","Nice hat!")) {
        1 -> whatIsWrong()
        2 -> {
            chatPlayer("You're a cook, why don't you bake me a cake?")
            chatNpc("*sniff* Don't talk to me about cakes...")
            whatIsWrong()
        }
        3 -> {
            chatPlayer("You don't look very happy.")
            chatNpc("No, I'm not. The world is caving in around me - I am<br><br>overcome by dark feelings of impending doom.")
            when (options("What's wrong?","I'd take the rest of the day off if I were you.")) {
                1 -> whatIsWrong()
                2 -> {
                    chatPlayer("I'd take the rest of the day off if I were you.")
                    chatNpc("No, that's the worst thing I could do. I'd get in terrible<br><br> trouble.")
                    chatPlayer("Well maybe you need to take a holiday...")
                    chatNpc("That would be nice, but the Duke doesn't allow holidays<br><br>for core staff.")
                    chatPlayer("Hmm, why not run away to the sea and start a new<br><br>life as a Pirate?")
                    chatNpc("My wife gets sea sick, and I have an irrational fear of<br><br>eyepatches. I don't see it working myself.")
                    chatPlayer("I'm afraid I've run out of ideas.")
                    chatNpc("I know I'm doomed.")
                    whatIsWrong()
                }
            }
        }
        4 -> {
            chatPlayer("Nice hat!")
            chatNpc("Err thank you. It's a pretty ordinary cooks hat really.")
            chatPlayer("Still, suits you. The trousers are pretty special too.")
            chatNpc("Its all standard cook's issue uniform....")
            chatPlayer("The whole hat, apron, stripey trousers ensemble - it<br><br>works. It make you look like a real cook.")
            chatNpc("I am a real cook! I haven't got time to be chatting<br><br>about Culinary Fashion. I am in desperate need of help!")
            whatIsWrong()
        }
    }
}

suspend fun QueueTask.whatIsWrong() {
    chatPlayer("What's wrong?")
    chatNpc("Oh dear, oh dear, oh dear, I'm in a terrible terrible mess! It's the Duke's birthday today, and I should be making him a lovely big birthday cake.")
    chatNpc("I've forgotten to buy the ingredients. I'll never get them in time now. He'll sack me! What will I do? I have four children and a goat to look after. Would you help me? Please?")
    when (options("I'm always happy to help a cook in distress.","I can't right now, Maybe later.")) {
        1 -> {
            chatPlayer("Yes, I'll help you.")
            player.setVarp(29, 1)
            chatNpc("Oh thank you, thank you. I need milk, an egg and<br><br>flour. I'd be very grateful if you can get them for me.")
            chatPlayer("So where do I find these ingredients then?")
            whereToFind()
        }
        2 -> {
            chatPlayer("No, I don't feel like it. Maybe later.")
            chatNpc("Fine. I always knew you Adventurer types were callous<br><br>beasts. Go on your merry way!")
        }
    }
}

suspend fun QueueTask.whereToFind() {
    if (asked == 0) {
        when (options("Where do I find some flour?", "How about milk?", "And eggs? Where are they found?", "Actually, I know where to find this stuff.")) {
            1 -> flour()
            2 -> milk()
            3 -> egg()
            4 -> {
                chatPlayer("Actually, I know where to find this stuff.")
                asked = 0
                player.interfaces.close(162, child = CHATBOX_CHILD)
                player.resetInteractions()
            }
        }
    }
    if (asked >= 1) {
        when (options("Where do I find some flour?", "How about milk?", "And eggs? Where are they found?", "I've got all the information I need. Thanks.")) {
            1 -> flour()
            2 -> milk()
            3 -> egg()
            4 -> {
                chatPlayer("I've got all the information I need. Thanks.")
                asked = 0
                player.interfaces.close(162, child = CHATBOX_CHILD)
                player.resetInteractions()
            }
        }
    }
}

suspend fun QueueTask.flour() {
    asked++
    chatNpc("There is a cattle field on the other side of the river,<br><br>just across the road from the Groats' Farm.")
    chatNpc("Talk to Gillie Groats, she looks after the Dairy cows - she'll tell you everything you need to know about milking cows!")
    chatNpc("You'll need an empty bucket for the milk itself. The<br>general store just north of the castle will sell you one<br>for a couple of coins.")
    whereToFind()
}
suspend fun QueueTask.milk() {
    asked++
    chatNpc("There is a Mill fairly close, go North and then West. Mill Lane Mill is just off the road to Draynor. I usually get my flour from there.")
    chatNpc("Talk to Millie, she'll help, she's a lovely girl and a fine<br>Miller. Make sure you take a pot with you for the flour<br>though, there should be one on the table in here.")
    whereToFind()
}
suspend fun QueueTask.egg() {
    asked++
    chatNpc("I normally get my eggs from the Groats' Farm, on the<br><br>other side of the river.")
    chatNpc("But any chicken should lay eggs.")
    whereToFind()
}

suspend fun QueueTask.checkItems() {
    chatNpc("How are you getting on with finding the ingredients?")
    if (player.inventory.contains(Items.POT_OF_FLOUR) and (takenFlour == 0)) {
        player.inventory.remove(Items.POT_OF_FLOUR)
        chatPlayer("Here's a pot of flour.")
        takenFlour++
        takenItems++
    }
    if (player.inventory.contains(Items.BUCKET_OF_MILK) and (takenMilk == 0)) {
        player.inventory.remove(Items.BUCKET_OF_MILK)
        chatPlayer("Here's a bucket of milk.")
        takenMilk++
        takenItems++
    }
    if (player.inventory.contains(Items.EGG) and (takenEgg == 0)) {
        player.inventory.remove(Items.EGG)
        chatPlayer("Here's a fresh egg.")
        takenEgg++
        takenItems++
    }

    if (takenItems == 0) {
        chatPlayer("I haven't got any of them yet, I'm still looking.")
        chatNpc("Please get the ingredients quickly. I'm running out of<br><br>time! The Duke will throw me into the streets!")
        messageBox("You still need to get:<br>A bucket of milk. A pot of flour. An egg.")
        aftercheck()
    }

    if (takenItems == 1) {
        chatNpc("Thanks for the ingredients you have got so far, please get the rest quickly. I'm running out of time! The Duke will throw me into the streets!")
        if (takenFlour == 1) { messageBox("You still need to get:<br>A bucket of milk. An egg.") }
        if (takenMilk == 1) { messageBox("You still need to get:<br>A pot of flour. An egg.") }
        if (takenEgg == 1) { messageBox("You still need to get:<br>A bucket of milk. A pot of flour.") }
        aftercheck()
    }

    if (takenItems == 2) {
        chatNpc("Thanks for the ingredients you have got so far, please get the rest quickly. I'm running out of time! The Duke will throw me into the streets!")
        if (takenFlour == 1 && takenMilk == 1) { messageBox("You still need to get:<br>An egg.") }
        if (takenFlour == 1 && takenEgg == 1) { messageBox("You still need to get:<br>A bucket of milk.") }
        if (takenMilk == 1 && takenFlour == 1) { messageBox("You still need to get:<br>An egg.") }
        if (takenMilk == 1 && takenEgg == 1) { messageBox("You still need to get:<br>A pot of flour.") }
        if (takenEgg == 1 && takenFlour == 1) { messageBox("You still need to get:<br>A bucket of milk.") }
        if (takenEgg == 1 && takenMilk == 1) { messageBox("You still need to get:<br>A pot of flour.") }
        aftercheck()
    }

    if (takenItems == 3) {
        chatNpc("You've brought me everything I need! I am saved!<br><br>Thank you!")
        chatPlayer("So do I get to go to the Duke's Party?")
        chatNpc("I'm afraid not, only the big cheeses get to dine with the<br><br>Duke.")
        chatPlayer("Well, maybe one day I'll be important enough to sit on<br><br>the Duke's table.")
        chatNpc("Maybe, but I won't be holding my breath.")
        questCompleted()
    }
}

suspend fun QueueTask.aftercheck () {
    when (options("I'll get right on it.", "Can you remind me how to find these things again?")) {
        1 -> chatPlayer("I'll get right on it.")
        2 -> {
            chatPlayer("So where do I find these ingredients then?")
            whereToFind()
        }
    }
}

suspend fun QueueTask.questCompleted() {
    player.setVarp(29, 2)
    player.setVarp(101, player.getVarp(101)+1)
    player.message("Congratulations! Quest complete!")
    player.openInterface(277, dest = InterfaceDestination.MAIN_SCREEN)
    player.setComponentText(277, 1, "Congratulations!")
    player.setComponentText(277, 2, "You have completed the Cook's Assistant Quest!")
    player.setComponentItem(277, 3, 1891, 185)
    player.setComponentText(277, 4, "Quest Points: ${player.getVarp(101)}")
    player.setComponentText(277, 5, "")
    player.setComponentText(277, 7, "You are awarded:")
    player.setComponentText(277, 8, "1 Quest Point")
    player.setComponentText(277, 9, "300 Cooking XP")
    player.setComponentText(277, 10, "")
    player.setComponentText(277, 11, "")
    player.setComponentText(277, 12, "")
    player.setComponentText(277, 13, "")
    player.setComponentText(277, 14, "")
    player.addXp(Skills.COOKING, 300.0)
}

suspend fun QueueTask.afterQuestDialogue() {
    chatNpc("Hello friend, how is the adventuring going?")
    when (options("I am getting strong and mighty.","I keep on dying","Can I use your range?")) {
        1 -> {
            chatPlayer("I am getting strong and mighty. Grrr")
            chatNpc("Glad to hear it.")
        }
        2 -> {
            chatPlayer("I keep on dying.")
            chatNpc("Ah well, at least you keep coming back to life!")
        }
        3 -> {
            chatPlayer("Can I use your range?")
            chatNpc("Go ahead - it's a very good range. It's easier to use<br><br>than most other ranges.")
            chatNpc("Its called the Cook-o-matic 100. It uses a combination of<br><br>state of the art temperature regulation and magic.")
            chatPlayer("Will it mean my food will burn less often?")
            chatNpc("Well, that's what the salesman told us anyway...")
            chatPlayer("Thanks?")
        }
    }
}

//FOR TESTING
on_command("q2") {
    player.setVarp(29, 0)
    player.setVarp(101, player.getVarp(101)-1)
    player.inventory.add(Items.EGG)
    player.inventory.add(Items.POT_OF_FLOUR)
    player.inventory.add(Items.BUCKET_OF_MILK)
    asked = 0
    takenItems = 0
    takenFlour = 0
    takenMilk = 0
    takenEgg = 0
}