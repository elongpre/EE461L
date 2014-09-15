package examresult;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

import javax.servlet.http.*;

import examresult.dao.ExamResultDAO;
import examresult.entity.*;

public class ExamResultServlet extends HttpServlet{
	
	
	private static final Logger _logger = Logger.getLogger(ExamResultServlet.class.getName());
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{   //extract the input parameters   
		String idNumber = req.getParameter("idnumber");   
		_logger.info("Received a requst for id number: " + idNumber);
		try{    
			if(idNumber == null) throw new Exception("Must provide id number!");    
			if(!idNumber.isEmpty()){ 							//retrieve the results (currently just chuck back some dummy results)     
				ExamResult dummyResult = ExamResultDAO.INSTANCE.getExamResult(idNumber);  
				req.getSession().setAttribute("result", dummyResult);     
				resp.sendRedirect("results.jsp");
			} else throw new Exception("Must provide id number!");   
		}
		catch (Exception e) {    String logMsg = "Exception in processing request: " + e.getMessage();
			_logger.log(Level.INFO, logMsg);
			throw new IOException(logMsg);   
		}
	}
}
