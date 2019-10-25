package hackason;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalenderAccess
 */

public class CalenderAccess extends HttpServlet{
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    int year;
    int month;
    public CalenderAccess() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        prepData(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Calender.jsp");
        //  フォワードによるページ遷移
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    //  送信用のデータの作成
    private void prepData(HttpServletRequest request){
       setAttributeYearMonth(request);

       year  = Integer.parseInt(request.getAttribute("year").toString());
       month = Integer.parseInt(request.getAttribute("month").toString());

       setAttributeCalenderHTML(request);
       setAttributeSelectYearMonthHTML(request);
       setAttributeSelectDayHTML(request);

       return;
    }


    public void setAttributeYearMonth(HttpServletRequest request){
    	 Calendar cal = Calendar.getInstance();
         //  年が設定されていれば、その値を取得。そうでなければ、今年の年号を入れる
         if(request.getParameter("year")==null){
             request.setAttribute("year", cal.get(Calendar.YEAR));   //  現在の年
         }else{
             request.setAttribute("year", request.getParameter("year")); // 選択した年
         }
         if(request.getParameter("month")==null){
             request.setAttribute("month", cal.get(Calendar.MONTH)+1);   //  現在の月
         }else{
             request.setAttribute("month", request.getParameter("month"));   //  与えられた月
         }
    }


    public void setAttributeCalenderHTML(HttpServletRequest request){
    	int startday;
        int lastday;
        //  カレンダーの取得
        Calendar cal = Calendar.getInstance();

        // 月初めの曜日(日-> 1)
        cal.set(year, month - 1, 1);
        startday = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        lastday = cal.get(Calendar.DATE);

        int date = 1;
        int maxday = 6 * 7;
        StringBuilder sb = new StringBuilder();

        sb.append("<table>");
        sb.append("<tr>");
        sb.append("<th style=\"color:red;\">日</th>");
        sb.append("<th>月</th><th>火</th><th>水</th><th>木</th><th>金</th>");
        sb.append("<th style=\"color:blue;\">土</th>");
        sb.append("</tr>");
        sb.append("<tr>");

        for (int num = 1; num <= maxday; num++) {
            if(num < startday || num > lastday + startday - 1){
                sb.append("<td></td>");
            }else{
                sb.append("<td>"+date+"</td>");
                date++;
            }
            if(num % 7 == 0){
                sb.append("</tr>");
                if(num > startday + lastday - 1){
                    break;
                }
                if(date < lastday){
                    sb.append("<tr>");
                }else{
                    break;
                }
            }
        }
        sb.append("</table>\n");

        request.setAttribute("calender", sb);
    }

    public void setAttributeSelectDayHTML(HttpServletRequest request){
    	StringBuilder sb = new StringBuilder();
        int lastday;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        lastday = cal.get(Calendar.DATE);

        sb.append("<form action=\"SelectDay\" method=\"get\">");

        sb.append("<select id=\"day\" name=\"day\">\n");

        for(int i = 1; i <= lastday ; i++) {
        	sb.append("<option value = \"" + i + "\"");
        	if(i == 1)sb.append("selected");
        	sb.append(">" + i + "日" + "</option>\n");
        }
        sb.append("</select><br/><br/>");
        sb.append("<input type=\"submit\" id=\"ok\" name=\"ok\" value=\"送信\"/>");
        sb.append("<input type=\"hidden\" name = \"year\" id = \"year\" value=\"" + year + "\">");
        sb.append("<input type=\"hidden\" name = \"month\" id = \"month\" value=\"" + month + "\">");
        sb.append("</form>");
        request.setAttribute("selectDay", sb);
    }

    public void setAttributeSelectYearMonthHTML(HttpServletRequest request){
    	StringBuilder sb = new StringBuilder();

//    	formタグ
    	sb.append("<form action=\"CalenderAccess\" method=\"get\">");
//    	セレクトタグ
    	sb.append("<select id=\"year\" name=\"year\">");
//    	選択肢を追加現在の年を選択
    	for(int i = 0; i <= year+1; i++){
	    	sb.append("<option value=\"" + i + "\"");
	    	if(i == year){
	    		sb.append("selected");
	    	}
	    	sb.append(">" + i + "年</option>");
    	}
    	sb.append("</select>");
    	sb.append("<select id=\"month\" name=\"month\"");
    	for(int i = 1;i<=12;i++){
    		sb.append("<option value=\"" + i + "\"");
    		if(i==month){
    			sb.append("selected");
    		}
    		sb.append(">" + i + "月</option>");
    	}
    	sb.append("</select><br/><br/>");
    	sb.append("<input type=\"submit\" id=\"ok\" name=\"ok\" value=\"送信\"/>");
    	sb.append("</form>");
    	request.setAttribute("selectYearMonth", sb);
    }
}



