package zamgerapi

import org.json.JSONObject
import zamgerapi.types.Course
import zamgerapi.types.CourseInstance
import zamgerapi.types.RequestHistoryEntry
import zamgerapi.utility.WebUtils

public class CourseAPI(private val zctx : ZamgerContext) {
    init {

    }

    companion object {
        val PROGRAMME_RI = 2
        val PROGRAMME_AE = 3
        val PROGRAMME_EE = 4
        val PROGRAMME_TK = 5

    }

    // ay - -1 for current academic year
    public fun GetCourseById(id : Int, ay : Int = -1, forceHardReload : Boolean = false) : Course {
        var url = "https://zamger.etf.unsa.ba/api_v5/course/$id"
        if ( ay > 0 ) {
            url += "/$ay"
        }

        val json = JSONObject(WebUtils.getHTML(url, forceHardReload,
                WebUtils.UrlParam("SESSION_ID", "" + zctx.sessionId)))

        return Course(json)
    }

    public fun GetProgrammeForSemester(programme : Int, sem : Int, forceHardReload : Boolean = false) : List<CourseInstance> {
        val res = ArrayList<CourseInstance>()

        val json = JSONObject(WebUtils.getHTML("https://zamger.etf.unsa.ba/api_v5/course/programme/$programme/$sem",
                forceHardReload,
                WebUtils.UrlParam("SESSION_ID", "" + zctx.sessionId)))

        val arr = json.getJSONArray("results")
        arr.forEach {
            res += CourseInstance(it as JSONObject)
        }

        return res
    }

    public fun GetCoursesByTeacher(teacher : Int) : List<Course> {
        TODO()
    }

    public fun GetCoursesForStudent(student : Int) : List<Course> {
        TODO()
    }


}