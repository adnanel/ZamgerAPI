package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt

public class Person(json : JSONObject) {
    val Id : String = json.getStringOrInt("studentIdNr")
    val Surname : String = json.getString("surname")
    val Name : String = json.getString("name")
    val TitlesPre : String = json.getString("titlesPre")
    val Login : String = json.getString("login")
    val TitlesPost : String = json.getString("titlesPost")

    public class Details {

    }
}