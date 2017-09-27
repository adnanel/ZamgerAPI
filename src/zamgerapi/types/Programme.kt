package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt

public class Programme( json : JSONObject ) {
    val ID = json.getStringOrInt("id")
    val Name = json.getString("name")
    val NameEnglish = json.getString("nameEn")
    val Abbreviation = json.getString("abbrev")
    val Institution = Institution(json.getJSONObject("Institution"))
    val AcceptsStudents = json.getBoolean("acceptsStudents")
    //todo programme type? ša je to
}