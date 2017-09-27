package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt

public class CourseOffering(json : JSONObject) {
    val ID : String = json.getStringOrInt("id")
    val CourseUnit = CourseUnit(json.getJSONObject("CourseUnit"))
    val AcademicYear = AcademicYear(json.getJSONObject("AcademicYear"))
    val Programme = Programme(json.getJSONObject("Programme"))
    val Semester = json.getStringOrInt("semester")
    val Mandatory = json.getBoolean("mandatory")
}