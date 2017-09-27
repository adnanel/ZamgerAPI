package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getSafely
import zamgerapi.utility.getStringOrInt

public class Programme( json : JSONObject ) {
    val ID = json.getStringOrInt("id")
    val Name = json.getSafely("name", "")
    val NameEnglish = json.getSafely("nameEn", "")
    val Abbreviation = json.getSafely("abbrev", "")
    val Institution = Institution(json.getJSONObject("Institution"))
    val AcceptsStudents = json.getBoolean("acceptsStudents")
    //todo programme type? ša je to
}