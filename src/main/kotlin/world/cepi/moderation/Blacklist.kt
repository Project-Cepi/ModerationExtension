package world.cepi.moderation

import org.json.JSONArray
import java.io.File
import java.io.FileWriter

object Blacklist {
    private val blacklistFile = File("./banned-players.json")
    var blacklist: JSONArray
    init {
        blacklist = if (blacklistFile.exists()) JSONArray(blacklistFile.readText()) else JSONArray()
    }

    fun add(id: String) {
        blacklist.put(id)
        blacklist.write(FileWriter(blacklistFile))
    }
}