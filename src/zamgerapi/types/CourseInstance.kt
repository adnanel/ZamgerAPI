package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt

/**
 * CourseInstance predstavlja jednu izvedbu kursa, npr MLTI za RI u ak. 2015/16 godini, dok je Course "template" kursa
 */
class CourseInstance(json : JSONObject) {
    val ID : String = json.getStringOrInt("id")
    val CourseID : String = json.getJSONObject("CourseUnit").getStringOrInt("id")
    val AcademicYearID : String = json.getJSONObject("AcademicYear").getStringOrInt("id")
    val ProgrammeID : String = json.getJSONObject("Programme").getStringOrInt("id")
    val SemesterID : String = json.getStringOrInt("semester")
    val Mandatory : Boolean = json.getBoolean("mandatory")
}