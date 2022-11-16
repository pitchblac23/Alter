package gg.rsmod.plugins.content.inter.quest.quests

/**
 * Thanks to bmyte for loads of help making things work and the info
 */

var ballsNeeded = 20

spawn_item(item = Items.SHEARS, amount = 1, x = 3192, z = 3272)

on_npc_option(732, option = "talk-to") {
    player.queue {
        if (player.getVarp(179) == 0) { // NOT STARTED
            chatNpc("What are you doing on my land? You're not the one<br>who keeps leaving all my gates open and letting out all<br>my sheep are you?")
            askForQuest()
        }

        if (player.getVarp(179) == 1) { // STARTED
            chatNpc("What are you doing on my land?")
            checkItems()
        }

        if ((player.getVarp(179) == 2) and (!player.isInterfaceVisible(277))) { afterQuestDialogue() } // COMPLETED
    }
}

suspend fun QueueTask.askForQuest() {
    when (options("I'm looking for a quest.", "I'm looking for something to kill.", "I'm lost.")) {
        1 -> lookingForQuest()
        2 -> {
            chatPlayer("I'm looking for something to kill.")
            chatNpc("What, on my land? Leave my livestock alone you<br>scoundrel!")
        }
        3 -> {
            chatPlayer("I'm lost.")
            chatNpc("How can you be lost? Just follow the road east and<br>south. You'll end up in Lumbridge fairly quickly.")
        }
    }
}

suspend fun QueueTask.lookingForQuest() {
    chatPlayer("I'm looking for a quest.")
    chatNpc("You're after a quest, you say? Actually I could do with<br>a bit of help.")
    chatNpc("My sheep are getting mighty woolly. I'd be much<br>obliged if you could shear them. And while you're at it<br>spin the wool for me too.")
    chatNpc("Yes, that's it. Bring me 20 balls of wool. And I'm sure<br>I could sort out some sort of payment. Of course,<br>there's the small matter of The Thing.")
    when (options("Yes okay. I can do that.", "That doesn't sound a very exciting quest.", "What do you mean, The Thing?")) {
        1 -> CanDoThat()
        2 -> {
            chatPlayer("That doesn't sound a very exciting quest.")
            chatNpc("Well what do you expect if you ask a farmer for a<br>quest? Now are you going to help me or not?")
            when (options("Yes okay. I can do that.", "No I'll give it a miss.")) {
                1 -> CanDoThat()
                2 -> chatPlayer("No I'll give it a miss.")
            }
        }
        3 -> {
            chatPlayer("What do you mean, The Thing?")
            chatNpc("Well now, no one has ever seen The Thing. That's<br>why we call it The Thing, 'cos we don't know what it is.")
            chatNpc("Some say it's a black hearted shapeshifter, hungering for<br>the souls of hard working decent folk like me. Others<br>say it's just a sheep.")
            chatNpc("Well I don't have all day to stand around and gossip. <br>Are you going to shear my sheep or what!")
            when (options("Yes okay. I can do that.", "Erm I'm a bit worried about this Thing.")) {
                1 -> CanDoThat()
                2 -> {
                    chatPlayer("Erm I'm a bit worried about this Thing.")
                    chatNpc("I'm sure it's nothing to worry about. Just because my<br>last shearer was seen bolting out of the field screaming<br>for his life doesn't mean anything.")
                    chatPlayer("I'm not convinced.")
                }
            }
        }
    }
}

suspend fun QueueTask.CanDoThat() {
    chatPlayer("Yes okay. I can do that.")
    chatNpc("Good! Now one more thing, do you actually know how<br>to shear a sheep?")
    player.setVarp(179, 1)
    when (options("Of course!","Err. No, I don't know actually.")) {
        1 -> {
            chatPlayer("Of Course!")
            chatNpc("And you know how to spin wool into balls?")
            when (options("I'm something of an expert actually!","I don't know how to spin wool, sorry.")) {
                1 -> {
                    chatPlayer("I'm something of an expert actually!")
                    chatNpc("Well you can stop grinning and get to work then.")
                    chatNpc("I'm not paying you by the hour!")
                }
                2 -> {
                    chatPlayer("I don't know how to spin wool, sorry.")
                    chatNpc("Don't worry, it's quite simple!")
                    chatNpc("The nearest Spinning Wheel can be found on the first<br>floor of Lumbridge Castle.")
                    chatNpc("To get to Lumbridge Castle just follow the road east.")
                    itemMessageBox("This icon denotes a Spinning Wheel on the world map.", item = 7670, amountOrZoom = 400)
                    chatPlayer("Thank you!")
                }
            }
        }
        2 -> {
            chatPlayer("Err. No, I don't know actually.")
            chatNpc("Well, first things first, you need a pair of shears, there's<br>a pair in the house on the table.")
            chatNpc("Or you could buy your own pair from the General<br>Store in Lumbridge.")
            chatNpc("To get to Lumbridge travel east on the road outside.")
            itemMessageBox("General Stores are marked on the map by this symbol.", item = 5094, amountOrZoom = 400)
            chatNpc("Once you get some shears use them on the sheep in<br>my field.")
            chatPlayer("Sounds easy!")
            chatNpc("That's what they all say!")
            chatNpc("Some of the sheep don't like it and will run away from<br>you.  Persistence is the key.")
            chatNpc("Once you've collected some wool you can spin it into<br>balls.")
            chatNpc("Do you know how to spin wool?")
            when (options("I don't know how to spin wool, sorry.","I'm something of an expert actually!")) {
                1 -> {
                    chatPlayer("I don't know how to spin wool, sorry.")
                    chatNpc("Don't worry, it's quite simple!")
                    chatNpc("The nearest Spinning Wheel can be found on the first<br>floor of Lumbridge Castle.")
                    chatNpc("To get to Lumbridge Castle just follow the road east.")
                    itemMessageBox("This icon denotes a Spinning Wheel on the world map.", item = 7670, amountOrZoom = 400)
                    chatPlayer("Thank you!")
                }
                2 -> {
                    chatPlayer("I'm something of an expert actually!")
                    chatNpc("Well you can stop grinning and get to work then.")
                    chatNpc("I'm not paying you by the hour!")
                }
            }
        }
    }
}

suspend fun QueueTask.checkItems() {
    when (options("I'm back!", "Fred! Fred! I've seen The Thing!")) {
        1 -> {
            chatPlayer("I'm back!")
            chatNpc("How are you doing getting those balls of wool?")
            if (player.hasItem(Items.WOOL)) {
                chatPlayer("Well I've got some wool. I've not managed to make it<br>into a ball though.", animation = 589)
                chatNpc("Well go find a spinning wheel then. You can find one<br>on the first floor of Lumbridge Castle, just walk east on<br>the road outside my house and you'll find Lumbridge.", animation = 590)
            }
            if (player.inventory.contains(Items.BALL_OF_WOOL) and (ballsNeeded >= 0)) {
                chatPlayer("I have some.")
                chatNpc("Give 'em here then.")
                val currentlyHaz = player.inventory.getItemCount(Items.BALL_OF_WOOL)
                ballsNeeded -= currentlyHaz
                player.inventory.remove(item = Items.BALL_OF_WOOL, amount = currentlyHaz)
            }
            if (ballsNeeded > 0) {
                chatPlayer("How many more do I need to give you?")
                chatNpc("You need to collect $ballsNeeded more balls of wool.")
                chatPlayer("I haven't got any at the moment.")
                chatNpc("Ah well at least you haven't been eaten.")
            }
            if (ballsNeeded <= 0) {
                chatPlayer("That's the last of them.")
                chatNpc("I guess I'd better pay you then.")
                questCompleted()
            }
        }
        2 -> {
            chatPlayer("Fred! Fred! I've seen The Thing!")
            chatNpc("You ... you actually saw it?")
            chatNpc("Run for the hills! ${player.username} grab as many chickens<br><br> as you can! We have to...")
            chatPlayer("Fred!")
            chatNpc("... flee! Oh, woe is me! The shapeshifter is coming!<br><br>We're all ...")
            chatPlayer("FRED!")
            chatNpc("... doomed. What!")
            chatPlayer("It's not a shapeshifter or any other kind of monster!")
            chatNpc("Well then what is it boy?")
            chatPlayer("Well ... it's two Penguins; Penguins disguised as a<br><br>sheep.")
            chatNpc("...")
            chatNpc("Have you been out in the sun to long?")
        }
    }
}

suspend fun QueueTask.questCompleted() {
    player.setVarp(179, 21)
    player.setVarp(101, player.getVarp(101)+1)
    player.message("Congratulations! Quest complete!")
    player.openInterface(277, dest = InterfaceDestination.MAIN_SCREEN)
    player.setComponentText(277, 1, "Congratulations!")
    player.setComponentText(277, 2, "You have completed the Sheep Shearer Quest!")
    player.setComponentItem(277, 3, 1891, 185)
    player.setComponentText(277, 4, "Quest Points: ${player.getVarp(101)}")
    player.setComponentText(277, 5, "")
    player.setComponentText(277, 7, "You are awarded:")
    player.setComponentText(277, 8, "1 Quest Point")
    player.setComponentText(277, 9, "150 Crafting XP")
    player.setComponentText(277, 10, "60 coins")
    player.setComponentText(277, 11, "")
    player.setComponentText(277, 12, "")
    player.setComponentText(277, 13, "")
    player.setComponentText(277, 14, "")
    player.addXp(Skills.CRAFTING, 150.0)
    player.inventory.add(Items.COINS_995, 60)
}

suspend fun QueueTask.afterQuestDialogue() {
    chatNpc("What are you doing on my land?")
    when (options("I'm looking for something to kill.", "I'm lost.")) {
        1 -> {
            chatPlayer("I'm looking for something to kill.")
            chatNpc("What, on my land? Leave my livestock alone you<br>scoundrel!")
        }
        2 -> {
            chatPlayer("I'm lost.")
            chatNpc("How can you be lost? Just follow the road east and<br>south. You'll end up in Lumbridge fairly quickly.")
        }
    }
}

//FOR TESTING
on_command("q17") {
    player.setVarp(179, 0)
    player.setVarp(101, player.getVarp(101)-1)
    player.inventory.add(Items.BALL_OF_WOOL, 20)
}
