package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getStringOrInt

public class CourseUnit( json : JSONObject ) {
    val ID = json.getStringOrInt("id")
    val Code = json.getString("code")
    val Name = json.getString("name")
    val Abbreviation = json.getString("abbrev")
    val ECTS = json.getDouble("ects")
    val Institution = Institution(json.getJSONObject("Institution"))
    val LectureHours = json.getDouble("lectureHours")
    val TutorialHours = json.getDouble("tutorialHours")
    val PracticeHours = json.getDouble("practiceHours")
}