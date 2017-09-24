package zamgerapi

import org.json.JSONObject
import utility.WebUtils
import zamgerapi.types.Person

class PersonApi(private val zctx : ZamgerContext) {
    fun GetCurrentPerson() : Person? {
        TODO()
    }

    fun GetPersonById(id : Int) : Person? {
        val login = JSONObject(WebUtils.getHTML("https://zamger.etf.unsa.ba/api_v5/person/$id", WebUtils.UrlParam("SESSION_ID", "" + zctx.sessionId)))

        // TODO Check for success

        return Person(login)
    }

    fun SearchPersonbyUser(user : String) : Person? {
        TODO()
    }

    fun SearchPersons(query : String) : List<Person> {
        TODO()
    }

    fun GetPersonDetails(id : Int) : Person.Details {
        TODO()
    }
}