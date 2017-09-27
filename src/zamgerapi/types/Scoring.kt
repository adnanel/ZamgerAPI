package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getSafely
import zamgerapi.utility.getStringOrInt

public class Scoring( json : JSONObject ) {
    val ID = json.getStringOrInt("id")
    val Name = json.getSafely("name", "")
    val Elements = ArrayList<ScoringElement>()

    init {
        json.getJSONArray("elements").forEach {
            Elements += ScoringElement(it as JSONObject)
        }
    }

    public class ScoringElement( json : JSONObject ) {
        val ID = json.getStringOrInt("id")
        val ClassName = json.getSafely("className", "")
    }
}