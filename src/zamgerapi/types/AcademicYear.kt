package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt

public class AcademicYear( json : JSONObject ) {
    val ID = json.getStringOrInt("id")
    val Name = json.getString("name")
    val IsCurrent = json.getBoolean("isCurrent")
}