package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Covid19DAO;
import dao.Covid19DAOImp;
import utility.Covid19;


@WebServlet("/Covid19")
public class Covid19Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Covid19DAO covid19DAO;
    RequestDispatcher dispatcher;
    
    public Covid19Controller() {
       covid19DAO = new Covid19DAOImp();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Covid19> listStates = covid19DAO.getAllStatesCovid19();
		List<Covid19> GlobalCovid = covid19DAO.getGlobalCovid19();
		List<Covid19> IndiaCovid = covid19DAO.getIndiaCovid19();
		
		request.setAttribute("IndiaCovid", IndiaCovid);
		request.setAttribute("covidGlobal", GlobalCovid);
		request.setAttribute("listCovidStates", listStates);
		
		dispatcher = request.getRequestDispatcher("views/covid19.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
