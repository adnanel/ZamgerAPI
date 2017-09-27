package zamgerapi.types

import org.json.JSONObject
import zamgerapi.utility.getSafely
import zamgerapi.utility.getStringOrInt

public class CourseUnit( json : JSONObject ) {
    val ID = json.getStringOrInt("id")
    val Code = json.getSafely("code", "")
    val Name = json.getSafely("name", "")
    val Abbreviation = json.getSafely("abbrev", "")
    val ECTS = json.getDouble("ects")
    val Institution = Institution(json.getJSONObject("Institution"))
    val LectureHours = json.getDouble("lectureHours")
    val TutorialHours = json.getDouble("tutorialHours")
    val PracticeHours = json.getDouble("practiceHours")
}