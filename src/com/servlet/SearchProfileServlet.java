package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProfileDao;
import com.dao.ProfileDaoImpl;
import com.servlet.dto.ProfileDTO;

@WebServlet("/searchProfile")
public class SearchProfileServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search=req.getParameter("search");
		 ProfileDao profileDao=new ProfileDaoImpl();
		  List<ProfileDTO> profileDTOs=profileDao.searchProfiles(search);
		   //adding profileDTO object inside request scope with namemagic
		   req.setAttribute("profileDTOs", profileDTOs);
		   
		   req.setAttribute("listoptions", profileDao.findAllQualification());
		   req.getRequestDispatcher("profiles.jsp").forward(req, resp);
	}	

}
