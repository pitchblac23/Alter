package gg.rsmod.plugins.content.inter.quest.quests.sheep_shearer

/**
 * Thanks to bmyte for loads of help making things work and the info
 * Thanks to Hunter for the working of check balls of wool
 */

spawn_item(item = Items.SHEARS, amount = 1, x = 3192, z = 3272)

//FOR TESTING
on_command("q17") {
    player.setVarp(179, 0)
    player.setVarp(101, player.getVarp(Varps.QUEST_POINTS)-1)
    player.setVarbit(6347, player.getVarbit(Varbits.QUESTS_COMPLETED)-1)
    player.inventory.add(Items.BALL_OF_WOOL, 20)
}

on_npc_option(Npcs.FRED_THE_FARMER, option = "Talk-to") {
    player.queue {
        when (player.getVarp(179)) {
            0 -> {
                chatNpc("What are you doing on my land? You're not the one<br>who keeps leaving all my gates open and letting out all<br>my sheep, are you?", ANGRY_3)
                when (options("I'm looking for a quest.", "I'm looking for something to kill.", "I'm lost.")) {
                    1 -> lookingForQuest()
                    2 -> something_to_kill()
                    3 -> lost()
                }
            }
            in 1..20 -> {
                chatNpc("What are you doing on my land?")
                chatPlayer("I need to talk to you about shearing these sheep!")
                chatNpc("Oh, How are you doing getting those balls of wool?")
                checkWool()
            }
            21 -> afterQuestDialogue()
        }
    }
}

suspend fun QueueTask.lookingForQuest() {
    chatPlayer("I'm looking for a quest.", HAPPY)
    chatNpc("You're after a quest, you say? Actually, I could do with<br><br>a bit of help.", CALM)
    chatNpc("My sheep are getting mighty woolly. I'd be much<br>obliged if you could shear them. And while you're at it,<br>spin the wool for me too.", CALM_CONTINUED)
    chatNpc("Yes, that's it. Bring me 20 balls of wool. And I'm sure<br>I could sort out some sort of payment. Of course,<br>there's the small matter of The Thing.", 569)
    chatPlayer("What do you mean, The Thing?", NEUTRAL_DIALOGEXPR)
    chatNpc("Well now, no one has ever seen The Thing. That's why<br>we call it The Thing, 'cos we don't know what it is.", EVIL_CONTINUED)
    chatNpc("Some say it's a black hearted shapeshifter, hungering for<br>the souls of hard working decent folk like me. Others<br>say it's just a sheep.", 598)
    chatNpc("Well I don't have all day to stand around and gossip.<br><br>Are you going to shear my sheep or what!", ANGRY_2)
    when (options("Yes.", "No.")) {
        1 -> {
            chatPlayer("Yes, okay. I can do that.", 567)
            player.setVarp(179, 1)
            player.message("You've started a new quest: <col=081190>Sheep Shearer</col>")
            chatNpc("Good! Now one more thing, do you actually know how<br><br>to shear a sheep?", CALM)
            chatPlayer("Err. No, I don't know actually.", HAPPY)
            chatNpc("Well, first things first, you need a pair of shears. I've<br><br>got some here you can use.", CALM)
            player.inventory.add(Items.SHEARS, 1)
            itemMessageBox("Fred gives you a set of sharp shears.", Items.SHEARS, 400)
            chatNpc("You just need to go and use them on the sheep out in<br><br>my field.", CALM)
            chatPlayer("Sounds easy!", 567)
            chatNpc("That's what they all say!", LAUGHING)
            chatNpc("Some of the sheep don't like it too much... Persistence<br><br>is the key.", CALM)
            chatNpc("Once you've collected some wool you can spin it into<br><br>balls.", HAPPY)
            chatNpc("Do you know how to spin wool?", HAPPY)
            chatPlayer("I don't know how to spin wool, sorry.", HAPPY)
            chatNpc("Don't worry, it's quite simple!", HAPPY)
            chatNpc("The nearest Spinning Wheel can be found on the first<br><br>floor of Lumbridge Castle.", CALM)
            chatNpc("To get to Lumbridge Castle just follow the road east.", HAPPY)
            itemMessageBox("This icon denotes a Spinning Wheel on the world map.", 7670, 400)
            chatPlayer("Thank you!", 567)
        }
        2 -> chatPlayer("Need more info.", 576) //TODO: need more info
    }
}

suspend fun QueueTask.checkWool() {
    val sheepShearer = player.getVarp(179)
    val neededWool = 21 - sheepShearer
    val woolRemoved = player.inventory.remove(Items.BALL_OF_WOOL, neededWool).completed
    val totalTurnedIn = sheepShearer + woolRemoved

    player.queue {
        if (player.inventory.contains(Items.BALL_OF_WOOL)) {
            chatPlayer("I have some.", 567)
            chatNpc("Give 'em here then.", HAPPY)
            messageBox("You gave Fred ${woolRemoved} ball of wool.")
            woolRemoved
            player.setVarp(179, totalTurnedIn)
            wait(1)
            if (totalTurnedIn <= 20) {
                chatPlayer("That's all I've got so far.", HAPPY)
                chatNpc("I need ${21 - player.getVarp(179)} more before I can pay you.", HAPPY)
                chatPlayer("Ok I'll work on it.", HAPPY)
            } else {
                chatPlayer("That's the last of them.", 567)
                chatNpc("I guess I'd better pay you then.", SLIGHTLY_SAD)
                questCompleted()
            }
        } else {
            player.message("you need a ball of wool to continue.") //TODO: need more info
        }
    }
}

suspend fun QueueTask.something_to_kill() {
    chatPlayer("I'm looking for something to kill.", 567)
    chatNpc("What, on my land? Leave my livestock alone you<br>scoundrel!", ANGRY_2)
}

suspend fun QueueTask.lost() {
    chatPlayer("I'm lost.", SLIGHTLY_SAD)
    chatNpc("How can you be lost? Just follow the road east and<br>south. You'll end up in Lumbridge fairly quickly.", RAISED_EYEBROW)
}

suspend fun QueueTask.questCompleted() {
    player.playJingle(154)
    player.setVarp(179, 21)
    player.setVarp(101, player.getVarp(101) +1)
    player.setVarbit(6347, player.getVarbit(6347)+1)
    player.message("Congratulations, you've completed a quest: <col=081190>Sheep Shearer</col>")
    wait(1)
    player.openInterface(153, dest = InterfaceDestination.MAIN_SCREEN)
    player.setComponentText(153, 4, "You have completed Sheep Shearer!")
    player.setComponentItem(153, 5, 1735, 400)
    player.setComponentText(153, 9, "1 Quest Point")
    player.setComponentText(153, 10, "150 Crafting XP")
    player.setComponentText(153, 11, "60 Coins")
    player.setComponentText(153, 12, "")
    player.setComponentText(153, 13, "")
    player.setComponentText(153, 14, "")
    player.setComponentText(153, 15, "")
    player.addXp(Skills.CRAFTING, 150.0)
    player.inventory.add(Items.COINS_995, 60)
}

suspend fun QueueTask.afterQuestDialogue() {
    chatNpc("What are you doing on my land?", ANGRY_1)
    when (options("I'm looking for something to kill.", "I'm lost.")) {
        1 -> something_to_kill()
        2 -> lost()
    }
}