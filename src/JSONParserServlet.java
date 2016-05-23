import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

public class JSONParserServlet extends HttpServlet {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String URL = "/index.jsp";
	private static final String JSONurl = "http://interviews.starmobileinc.com/";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 try {
			List<HTMLElement> list = JSONParserUtil.parseJSONFromUrl(JSONurl);
			if (list != null){
				 request.setAttribute("list", list);
			 }
		 } catch (JSONException e) {
			e.printStackTrace();
		}
		 
		  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URL);
		  dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
