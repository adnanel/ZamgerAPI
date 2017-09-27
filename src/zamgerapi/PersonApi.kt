package zamgerapi

import org.json.JSONObject
import zamgerapi.utility.WebUtils
import zamgerapi.types.Person
import java.io.FileNotFoundException

class PersonApi(private val zctx : ZamgerContext) {
    fun GetCurrentPerson() : Person? {
        TODO()
    }

    fun GetPersonById(id : Int, forceHardReload : Boolean = false) : Person? {
        val login = JSONObject(WebUtils.getHTML("https://zamger.etf.unsa.ba/api_v5/person/$id",
                forceHardReload,
                WebUtils.UrlParam("SESSION_ID", "" + zctx.sessionId)))

        // TODO Check for success

        return Person(login)
    }

    fun SearchPersonbyUser(user : String, forceHardReload : Boolean = false) : Person? {
        return try {
            val res = JSONObject(WebUtils.getHTML("https://zamger.etf.unsa.ba/api_v5/person/byLogin",
                    forceHardReload,
                    WebUtils.UrlParam("SESSION_ID", "" + zctx.sessionId),
                    WebUtils.UrlParam("login", user)))

            Person(res)
        } catch ( ex : FileNotFoundException ) {
            // user not found
            null
        }
    }

    fun SearchPersons(query : String) : List<Person> {
        TODO()
    }

    fun GetPersonDetails(id : Int) : Person.Details {
        TODO()
    }
}