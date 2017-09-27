package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getSafely
import zamgerapi.utility.getStringOrInt

public class Institution( json : JSONObject) {
    val ID = json.getStringOrInt("id")
    val Name = json.getSafely("name", "")
    val Abbreviation = json.getSafely("abbrev", "")
}