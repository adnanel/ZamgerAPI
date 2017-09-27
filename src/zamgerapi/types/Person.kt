package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getSafely
import zamgerapi.utility.getStringOrInt

public class Person(json : JSONObject) {
    val Id : String = json.getStringOrInt("studentIdNr")
    val Surname : String = json.getSafely("surname", "")
    val Name : String = json.getSafely("name", "")
    val TitlesPre : String = json.getSafely("titlesPre", "")
    val Login : String = json.getSafely("login", "")
    val TitlesPost : String = json.getSafely("titlesPost", "")

    public class Details {

    }
}