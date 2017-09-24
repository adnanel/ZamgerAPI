package zamgerapi.types

import org.json.JSONObject

public class Person(json : JSONObject) {
    val Id : Int = json.getInt("studentIdNr")
    val Surname : String = json.getString("surname")
    val Name : String = json.getString("name")
    val TitlesPre : String = json.getString("titlesPre")
    val Login : String = json.getString("login")
    val TitlesPost : String = json.getString("titlesPost")

    public class Details {

    }
}