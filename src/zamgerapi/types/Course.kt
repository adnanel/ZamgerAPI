package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt


class Course(json : JSONObject) {
    val CourseUnit = CourseUnit( json.getJSONObject("CourseUnit") )
    val AcademicYear = AcademicYear(json.getJSONObject("AcademicYear"))
    var Scoring = Scoring(json.getJSONObject("Scoring"))
    val CourseOfferings = ArrayList<CourseOffering>()
    val Staff = ArrayList<Person>()
    //todo, nekad kasnije val Activities :

    init {
        json.getJSONArray("courseOfferings").forEach {
            CourseOfferings += CourseOffering(it as JSONObject)
        }

        json.getJSONArray("staff").forEach {
            Staff += Person((it as JSONObject).getJSONObject("Person"))
        }
    }
}