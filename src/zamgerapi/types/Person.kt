package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getSafely
import zamgerapi.utility.getStringOrInt

public class Person(json : JSONObject) {
    val Id : String = json.getStringOrInt("studentIdNr")
    val Surname : String = json.getSafely("surname", "")!!
    val Name : String = json.getSafely("name", "")!!
    val TitlesPre : String = json.getSafely("titlesPre", "")?: ""
    val Login : String = json.getSafely("login", "")!!
    val TitlesPost : String = json.getSafely("titlesPost", "")?: ""

    public class Details {

    }

    override fun toString(): String {
        var res = StringBuilder()
        if ( TitlesPre.length > 0 ) {
            res.append(TitlesPre).append(" ")
        }
        if ( Name.length > 0 ) {
            res.append(Name).append(" ")
        }
        if ( Surname.length > 0 ) {
            res.append(Surname).append(" ")
        }
        if ( TitlesPost.length > 0 ) {
            res.append(TitlesPost)
        }
        res.append("\n")
        if ( Id.length > 0 ) {
            res.append("Indeks: ").append(Id).append("\n")
        }
        if (Login.length > 0 ) {
            res.append("Username: ").append(Login)
        }
        return res.toString()
    }


}