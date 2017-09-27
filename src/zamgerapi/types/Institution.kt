package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt

public class Institution( json : JSONObject) {
    val ID = json.getStringOrInt("id")
    val Name = json.getString("name")
    val Abbreviation = json.getString("abbrev")
}