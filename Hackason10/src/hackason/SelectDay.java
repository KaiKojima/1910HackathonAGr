package hackason;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample01
 */
public class SelectDay extends HttpServlet{
private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDay() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String year  = request.getParameter("year");
        String month = request.getParameter("month");
        String day   = request.getParameter("day");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>SelectDay</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + year + "年");
        out.println(month+ "月");
        out.println(day+ "日</h1>");
        out.println("<br/><h1>本日のタスク</h1><br/>");
        out.println("<form action=\"TaskAdd\" method=\"get\">");
        out.println("<input type=\"submit\" id=\"ok\" name=\"ok\" value=\"タスクの追加\"/>");
        out.println("<input type=\"hidden\" name = \"year\" id = \"year\" value=\"" + year + "\">");
        out.println("<input type=\"hidden\" name = \"month\" id = \"month\" value=\"" + month + "\">");
        out.println("<input type=\"hidden\" name = \"day\" id = \"day\" value=\"" + day + "\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}