package me.nik.serverstuff.Locations;

import org.bukkit.Location;
import java.util.HashMap;

public class LoadLocations {

    static HashMap<String, Location> spawnLocs = new HashMap<>();

    public void setLocations() {
        spawnLocs.put("DR_Alaran ruins",        LocationsList.getAlaranRuinsLocation());
        spawnLocs.put("DR_Alien facility",      LocationsList.getAlienFacilityLocation());
        spawnLocs.put("DR_Castle",              LocationsList.getCastleLocation());
        spawnLocs.put("DR_Cave",                LocationsList.getCaveLocation());
        spawnLocs.put("DR_Caverns",             LocationsList.getCavernsLocation());
        spawnLocs.put("DR_Crystal night",       LocationsList.getCrystalNightLocation());
        spawnLocs.put("DR_Elements",            LocationsList.getElementsLocation());
        spawnLocs.put("DR_Enchanted lagoon",    LocationsList.getELLocation());
        spawnLocs.put("DR_Expelliarmus",        LocationsList.getExpelliarmusLocation());
        spawnLocs.put("DR_Gravity",             LocationsList.getGravityLocation());
        spawnLocs.put("DR_High city",           LocationsList.getHighCityLocation());
        spawnLocs.put("DR_Higher dimensions",   LocationsList.getHigherDimensionsLocation());
        spawnLocs.put("DR_Ice",                 LocationsList.getIceLocation());
        spawnLocs.put("DR_Ilvery",              LocationsList.getIlveryLocation());
        spawnLocs.put("DR_Interstellar",        LocationsList.getInterstellarLocation());
        spawnLocs.put("DR_Jade coast",          LocationsList.getJadeCoastLocation());
        spawnLocs.put("DR_Jungle base",         LocationsList.getJungleBaseLocation());
        spawnLocs.put("DR_Legacy",              LocationsList.getLegacyLocation());
        spawnLocs.put("DR_Mine",                LocationsList.getMineLocation());
        spawnLocs.put("DR_Prison",              LocationsList.getPrisonLocation());
        spawnLocs.put("DR_Riviera",             LocationsList.getRivieraLocation());
        spawnLocs.put("DR_Safary valley",       LocationsList.getSafariValleyLocation());
        spawnLocs.put("DR_School",              LocationsList.getSchoolLocation());
        spawnLocs.put("DR_Seasons",             LocationsList.getSeasonsLocation());
        spawnLocs.put("DR_Skylands",            LocationsList.getSkyLandsLocation());
        spawnLocs.put("DR_Snowfall",            LocationsList.getSnowfallLocation());
        spawnLocs.put("DR_Sonic",               LocationsList.getSonicLocation());
        spawnLocs.put("DR_Starbase",            LocationsList.getStarbaseLocation());
        spawnLocs.put("DR_Sweettooth",          LocationsList.getSweetToothLocation());
        spawnLocs.put("DR_Temple",              LocationsList.getTempleLocation());
        spawnLocs.put("DR_Throwback",           LocationsList.getThrowbackLocation());
        spawnLocs.put("DR_2bee or !2bee",       LocationsList.getToBeeLocation());
        spawnLocs.put("DR_Toxic factory",       LocationsList.getToxicLocation());
        spawnLocs.put("DR_Vahltir",             LocationsList.getVahltirLocation());
        spawnLocs.put("DR_Venice",              LocationsList.getVeniceLocation());
        spawnLocs.put("DR_Viaduct",             LocationsList.getViaductLocation());
        spawnLocs.put("DR_Wahoo",               LocationsList.getWahooLocation());
        spawnLocs.put("DR_Western",             LocationsList.getWesternLocation());
        spawnLocs.put("DR_Windfall",            LocationsList.getWindfallLocation());
        spawnLocs.put("DR_Yagrium",             LocationsList.getYagriumLocation());
        spawnLocs.put("DR_Zoo",                 LocationsList.getZooLocation());
    }

    public Location getLocationFromList(String worldName) {
        return spawnLocs.get(worldName);
    }

}
