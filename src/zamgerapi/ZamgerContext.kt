package zamgerapi

import org.json.JSONObject
import zamgerapi.utility.WebUtils
import zamgerapi.utility.getSafely

public class ZamgerContext(username : String, password : String, keepAlive : Boolean = true) {
    private val courseApi : CourseAPI = CourseAPI(this)

    val PersonApi : PersonApi = PersonApi(this)
    val ClassApi : ClassApi = ClassApi(this)
    val ExamApi : ExamApi = ExamApi(this)
    val CommentApi : CommentApi = CommentApi(this)
    val CurriculumApi : CurriculumApi = CurriculumApi(this)
    val EnrollmentApi : EnrollmentApi = EnrollmentApi(this)
    val GroupApi : GroupApi = GroupApi(this)
    val HomeworkApi : HomeworkApi = HomeworkApi(this)
    val CourseAPI : CourseAPI = CourseAPI(this)

    val sessionId : String
    val personId : Int


    init {
        val login = JSONObject(WebUtils.getHTML("https://zamger.etf.unsa.ba/api_v5/auth",
                true,
                WebUtils.UrlParam("login", username),
                WebUtils.UrlParam("pass", password), requestMethod = "POST" ))

        if ( !login.getBoolean("success") ) {
            throw Exception("Failed to login to zamger")
        }

        sessionId = login.getSafely("sid", "")!!
        personId = login.getInt("userid")

        if ( keepAlive ) {
            object : Thread() {
                override fun run() {
                    super.run()

                    //svake 2 minute uradimo neki API request da sesija ostane ziva
                    //todo: while (true) je ugly
                    while ( true ) {
                        val me = PersonApi.SearchPersonbyUser(username, true)
                        Thread.sleep(1000 * 60 * 2)
                    }
                }
            }
        }
    }
}