package hackason;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OnedayServlet
 */
public class OnedayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnedayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private static Connection getConnection() {
		Connection conn = null;
		//db.propertiesファイルの読込み
		ResourceBundle resourceBundle = ResourceBundle.getBundle("hackasondb");
		try {
			conn = (Connection) DriverManager.getConnection(
					resourceBundle.getString("jdbcUrl"),
					resourceBundle.getString("dbUser"),
					resourceBundle.getString("dbPassword"));
		} catch (SQLException e) {
			System.out.println("データベース接続エラーが発生しました");
		}
		return conn;
	}

}
