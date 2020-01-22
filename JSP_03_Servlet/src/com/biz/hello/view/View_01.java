package com.biz.hello.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View_01
 */

/*
 * /view/01 : URI, Java Web에서는 path라고 한다
 * /view : view path, /01은 view path router라고 한다
 */
@WebServlet("/view/01")
public class View_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String strName = request.getParameter("strName");
		
		// response.setStatus(404);
		/*
		 * httpCode
		 * server와 webBrowser간에 데이터를 보내기 전에
		 * 현재 서버의 상태가 어떠한지 숫자 값으로 전송해서 네트워크의 성능을 높이는 용도로 사용한다
		 * 2xx : 정상 데이터를 추출중이니 기다리라는 뜻
		 * 3xx : 이전 상태와 유사, 동일하니 요청자에게 줄 것이 없다는 뜻
		 * 4xx : 요청 사항이 잘못 전달되었다
		 *  	404 : Not Found
		 *  	400 : Query 데이터를 request.getParameter()로 받았는데 문제가 있음
		 * 5xx : 서버 App이 작동되는 과정에서 Exception이 발생했다는 뜻  
		 */
		
		PrintWriter pw = response.getWriter();
		pw.println("<p>나는 view 01 입니다</p>");
		pw.println("<p>나는 " + strName + " 입니다</p>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
