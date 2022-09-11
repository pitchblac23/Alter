package gg.rsmod.plugins.content.area.port_sarim.fishing

import gg.rsmod.plugins.content.skills.fishing.data.FishingLocation
import gg.rsmod.plugins.content.skills.fishing.data.FishingSpot
import gg.rsmod.plugins.content.skills.fishing.data.FishingSpots

val net_spots = FishingLocation()
net_spots.spots.add(FishingSpot(FishingSpots.NET, Tile(2996, 3158, 0)))//should be 1523?
net_spots.spots.add(FishingSpot(FishingSpots.NET, Tile(2990, 3169, 0)))//should be 1523?
net_spots.numberOfFishingSpots = 2
net_spots.register()