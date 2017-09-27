package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt


class Course(json : JSONObject) {
    val CourseUnit = CourseUnit( json.getJSONObject("CourseUnit") )
    val AcademicYear = AcademicYear(json.getJSONObject("AcademicYear"))
    var Scoring = Scoring(json.getJSONObject("Scoring"))
    val CourseOfferings : List<CourseOffering>
    val Staff : List<Person>
    //todo, nekad kasnije val Activities :

    init {

    }
}