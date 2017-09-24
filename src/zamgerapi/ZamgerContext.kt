package zamgerapi

import org.json.JSONObject
import utility.WebUtils
import utility.log

public class ZamgerContext(username : String, password : String) {
    private val courseApi : CourseAPI = CourseAPI(this)

    val PersonApi : PersonApi = PersonApi(this)
    val ClassApi : ClassApi = ClassApi(this)
    val ExamApi : ExamApi = ExamApi(this)
    val CommentApi : CommentApi = CommentApi(this)
    val CurriculumApi : CurriculumApi = CurriculumApi(this)
    val EnrollmentApi : EnrollmentApi = EnrollmentApi(this)
    val GroupApi : GroupApi = GroupApi(this)
    val HomeworkApi : HomeworkApi = HomeworkApi(this)

    val sessionId : String
    val personId : Int


    init {
        val login = JSONObject(WebUtils.getHTML("https://zamger.etf.unsa.ba/api_v5/auth",
                WebUtils.UrlParam("login", username),
                WebUtils.UrlParam("pass", password), requestMethod = "POST" ))

        if ( !login.getBoolean("success") ) {
            throw Exception("Failed to login to zamger")
        }

        sessionId = login.getString("sid")
        personId = login.getInt("userid")

    }
}