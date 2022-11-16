package gg.rsmod.plugins.content.inter.quest.quests

/**
 * TODO:
 * need to fix for when closing interface 277 starts chat
 * Need to fix chat from varp set 1 need to exit chat
 * Need to add in if player doesn't have item to replace from voes
 * Need to fix multi chat from one npc
 * Need to fix hiding or unspawning npc at lumbridge
 * Need to fix orb to do hot cold and not pull location
 */

on_npc_option(Npcs.VEOS_8484, option = "talk-to") {
    player.queue {
        if (player.getVarp(2111) == 0) { // NOT STARTED
            chatNpc("Hello there.")
            questStart()
        }
        if (player.getVarp(2111) <= 4) { // STARTED
            chatNpc("Hello there.")
            chatPlayer("Hello Veos.")
            aboutQuest()
        }
        if (player.getVarp(2111) == 5) { // CLUES FINISHED
            chatNpc("Hello there.")
            chatPlayer("Hello Veos.")
            questFinish()
        }
        if ((player.getVarp(2111) == 8) and (!player.isInterfaceVisible(277))) { // COMPLETED
            chatNpc("Hello there.")
            chatPlayer("Hello Veos.")
            afterQuestDialogue()
        }
    }
}

on_item_option(23067, "read") {
    player.openInterface(203, InterfaceDestination.MAIN_SCREEN)
    player.setComponentText(interfaceId = 203, component = 2, text = "Within the town of Lumbridge lives<br>a man named Bob. He walks<br>out of his door and takes 1 step<br>east, 7 steps north, 5 steps<br>west and 1 step south. Once<br>he arrives, he digs a hole and<br>buries his treasure.")
}

on_item_option(23068, "read") {
    player.openInterface(267, InterfaceDestination.MAIN_SCREEN)
}

on_item_option(item = 23069, option = "feel") {
    val tile = Tile(3108, 3264)
    val pos = player.tile
    val direction : String = when {
        pos.z > tile.z && pos.x - 1 > tile.x -> "south-west"
        pos.x < tile.x && pos.z > tile.z -> "south-east"
        pos.x > tile.x + 1 && pos.z < tile.z -> "north-west"
        pos.x < tile.x && pos.z < tile.z -> "north-east"
        pos.z < tile.z -> "north"
        pos.z > tile.z -> "south"
        pos.x < tile.x + 1 -> "east"
        pos.x > tile.x + 1 -> "west"
        else -> "feels close by"
    }
    player.message("The orb pulls towards the $direction.")
}

on_item_option(23070, "read") {
    player.openInterface(203, InterfaceDestination.MAIN_SCREEN)
    player.setComponentText(interfaceId = 203, component = 2, text = "The cipher reveals<br>where to dig next:<br><br>ESBZOPS QJH QFO")
}

on_item_option(23071, "open") {
    player.queue { chatPlayer("I don't think Veos would want me to open his treasure.<br>I should take it to him. If I remember right, it's docked<br>at the northernmost pier in Port Sarim.") }
}

suspend fun QueueTask.questStart() {
    when (options("Who are you?", "I'm looking for a quest.", "I have to go.")) {
        1 -> {
            chatPlayer("Who are you?")
            chatNpc("The name's Veos. I'm a treasure hunter from the<br>wonderous Kingdom of Great Kourend.")
            greatKourend()
            when (options("Can I help?", "Well good luck with it.")) {
                1 -> {
                    chatPlayer("Can I help?")
                    chatNpc("Hmmm. Maybe you can. You probably know this area<br>better than I do. You might be able to work the scroll<br>out. I'll be able to reward you if you help.")
                    when (options("Sounds good, what should I do?", "I'm good thanks.")) {
                        1 -> soundsGood()
                        2 -> goodLuck()
                    }
                }
                2 -> chatPlayer("Well good luck with it.")
            }
        }
        2 -> {
            chatPlayer("I'm looking for a quest.")
            chatNpc("Hmmm. Well now that you mention it, I could do with<br>some help. The name's Veos. I'm a treasure hunter<br>from the wonderous Kingdom of Great Kourend.")
            greatKourend()
            when (options("Sounds good, what should I do?", "I'm good thanks.")){
                1 -> soundsGood()
                2 -> goodLuck()
            }
        }
        3 -> chatPlayer("I have to go.")
    }
}

suspend fun QueueTask.soundsGood() {
    player.setVarp(2111, 1)
    chatPlayer("Sounds good, what should I do?")
    chatNpc("Take this scroll. It should lead you to the treasure I<br>seek. Once you've found it, meet me at my ship. It's<br>docked at the northernmost pier in Port Sarim.")
    player.inventory.add(Items.TREASURE_SCROLL, 1)
    itemMessageBox("Veos has given you a scroll.", item = 23067, amountOrZoom = 400)
    chatPlayer("Awesome. Anything else I should know?")
    chatNpc("You'll probably want a spade, I find they're pretty<br>much always needed when it comes to hunting treasure.<br>Check the general store if you don't have one. If you<br>need any extra help, just let me know.")
    when (options("Okay, thanks Veos.", "Tell me more about Great Kourend.")){
        1 -> {
                chatPlayer("Okay, thanks Veos.")
                chatNpc("Good luck.")
        }
        2 -> {
            tellmore()
            chatPlayer("Sounds like a fascinating place. Anyway, I'd better get<br>started with this treasure hunt.")
            chatNpc("Good luck.")
        }
    }
}

suspend fun QueueTask.greatKourend() {
    chatPlayer("Great Kourend? Where's that?")
    chatNpc("Across the sea to the far west. It is a truly magnificent<br>place.")
    chatPlayer("Interesting. So what brings you to Lumbridge?")
    chatNpc("I am here on a bit of a hunt. The hunt for treasure.<br>Back in my home of Great Kourend, I came across a<br>scroll. I believe it will lead me to something of great<br>value.")
    chatNpc("Alas, I've hit a bit of a blocker. The scroll has led me<br>here but as I don't really know the area, I'm not sure<br>what to do next.")
    return
}

suspend fun QueueTask.goodLuck() {
    chatPlayer("I'm good thanks.")
    chatNpc("Fair enough. I'll be here if you change your mind.")
    return
}

suspend fun QueueTask.tellmore() {
    chatPlayer("Tell me more about Great Kourend.")
    chatNpc("Great Kourend is a magnificent kingdom comprising of<br>five cities. They are the cities of Arceuus, Lovakengj,<br>Shayzien, Piscarilius and Hosidius. Each city is ruled<br>by one of the five houses of Kourend.")
    chatNpc("At one time, the kingdom as a whole was ruled over by<br>a king or queen that the five houses answered to.")
    chatNpc("However, since our last King died 20 years ago, the<br>kingdom has instead been ruled by an elected council.")
    return
}

suspend fun QueueTask.aboutQuest() {
    when (options("Tell me more about Great Kourend.", "Let's talk about my quest.", "Goodbye.")){
        1 -> {
            tellmore()
            when (options("Let's talk about my quest.", "Goodbye.")){
                1 -> {
                    chatPlayer("Let's talk about my quest.")
                    chatNpc("How's the treasure hunt going?")
                    when (options("I could do with some extra help.", "I'm still working on it.")){
                        1 -> extraHelp()
                        2 -> {
                            chatPlayer("I'm still working on it.")
                            chatNpc("Well keep at it. Once you've found the treasure, meet<br>me at my ship. It's docked at the northernmost pier in<br>Port Sarim.")
                        }
                    }
                }
                2 -> chatPlayer("Goodbye.")
            }
        }
        2 -> {
            chatPlayer("Let's talk about my quest.")
            chatNpc("How's the treasure hunt going?")
            when (options("I could do with some extra help.", "I'm still working on it.")){
                1 -> extraHelp()
                2 -> {
                    chatPlayer("I'm still working on it.")
                    chatNpc("Well keep at it. Once you've found the treasure, meet<br>me at my ship. It's docked at the northernmost pier in<br>Port Sarim.")
                }
            }
        }
        3 -> chatPlayer("Goodbye.")
    }
}

suspend fun QueueTask.extraHelp() {
    chatPlayer("I could do with some extra help.")
    if (player.inventory.contains(23067)) {
        itemMessageBox("You show the scroll to Veos.", item = 23070)
        chatNpc("This is the scroll I gave you. I don't know how to solve<br>it I'm afraid. Maybe look for someone called Bob?")
    }
    if (player.inventory.contains(23068)) {
        itemMessageBox("You show the scroll to Veos.", item = 23070)
        chatNpc("Looks like a map to me. I'd assume the X marks where<br>you need to go.")
    }
    if (player.inventory.contains(23069)) {
        itemMessageBox("You show the orb to Veos.", item = 23069)
        chatNpc("Interesting, these are quite rare. They work using<br>temperature. The closer you are, the hotter the orb.")
    }
    if (player.inventory.contains(23070)) {
        itemMessageBox("You show the scroll to Veos.", item = 23070)
        chatNpc("Ah a cipher, I've seen these before. Try shifting the<br>letters one to the left or right. That normally works.")
    }
}

suspend fun QueueTask.questFinish() {
    chatNpc("How's the treasure hunt going?")
    chatPlayer("I found the treasure!")
    chatNpc("Excellent. I'll take it off your hands now.")
    player.inventory.remove(Items.ANCIENT_CASKET, 1)
    itemMessageBox("You give Veos the Ancient Casket.", item = 23071)
    chatNpc("Brilliant. This is just what I was looking for. Thank you<br>so much for your help.")
    chatPlayer("No problem. So what is this treasure anyway?")
    chatNpc("Oh err... Nothing important. Just something that might<br>be of use to me back in Great Kourend.")
    chatPlayer("If you say so...")
    chatNpc("Anyway, as promised, a reward for you.")
    questCompleted()
}

suspend fun QueueTask.questCompleted() {
    player.setVarp(2111, 8)
    player.setVarp(101, player.getVarp(101) + 1)
    player.message("Congratulations! Quest complete!")
    player.openInterface(277, dest = InterfaceDestination.MAIN_SCREEN)
    player.setComponentText(interfaceId = 277, component = 1, text = "Congratulations!")
    player.setComponentText(interfaceId = 277, component = 2, text = "You have completed X Marks the Spot!")
    player.setComponentItem(interfaceId = 277, component = 3, item = 23071, amountOrZoom = 250)
    player.setComponentText(interfaceId = 277, component = 4, text = "")
    player.setComponentText(interfaceId = 277, component = 5, text = "")
    player.setComponentText(interfaceId = 277, component = 6, text = "1 Quest Point")
    player.setComponentText(interfaceId = 277, component = 7, text = "An Antique Lamp")
    player.setComponentText(interfaceId = 277, component = 8, text = "200 Coins")
    player.setComponentText(interfaceId = 277, component = 9, text = "A beginner clue scroll")
    player.setComponentText(interfaceId = 277, component = 10, text = "")
    player.setComponentText(interfaceId = 277, component = 11, text = "")
    player.setComponentText(interfaceId = 277, component = 12, text = "")
    player.setComponentText(interfaceId = 277, component = 13, text = "")
    player.setComponentText(interfaceId = 277, component = 14, text = "")
    player.inventory.add(Items.COINS_995, 200)
    player.inventory.add(Items.CLUE_SCROLL_BEGINNER, 1)
    player.inventory.add(Items.ANTIQUE_LAMP_23072, 1)//interface 134
    chatNpc("Anyway, I'd best be getting back to Great Kourend.<br>I'm sure I'll be back here before long though, there's<br>always more treasure to be found.")
    chatNpc("If you ever fancy visiting the kingdom, come find me<br>here. I'm more than happy to take you there. Consider<br>it an extra thank you for your help.")
    chatPlayer("Sounds great, thanks Veos.")
    }

suspend fun QueueTask.afterQuestDialogue() {
    when (options("Can you take me to Great Kourend?", "Tell me more about Great Kourend.", "Nothing.")){
        1 -> {
            chatPlayer("Can you take me to Great Kourend?")
            chatNpc("Unfortunately it seems that you're not quite ready to<br>visit Great Kourend yet. Come back when you are and<br>I'll happily take you there.")
        }
        2 -> {
            tellmore()
            when (options("That's great, can you take me there please?", "Goodbye.")){
                1 -> {
                    chatPlayer("That's great, can you take me there please?")
                    chatNpc("Unfortunately it seems that you're not quite ready to<br>visit Great Kourend yet. Come back when you are and<br>I'll happily take you there.")
                }
                2 -> chatPlayer("Goodbye.")
            }
        }
        3 -> chatPlayer("Nothing.")
    }
}

//FOR TESTING
on_command("q21") {
    player.setVarp(2111, 0)
    player.setVarp(101, player.getVarp(101)-1)
}