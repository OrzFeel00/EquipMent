package com.yc.tc.equipment.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		   String uri = request.getRequestURI();
//	        if (uri.endsWith("js")||uri.endsWith("css")||uri.endsWith("jpg")||uri.endsWith("svg")||uri.endsWith("gif")){
//	            return true ;
//	        }
		
		HttpSession session = request.getSession(true);
//      得到对象
      Object admin = session.getAttribute("adlogined");
//      判断对象是否存在
      if(admin!=null){
          return true;
      }else{
//          不存在则跳转到登录页
    	  response.sendRedirect(request.getContextPath()+"/toadlogin");//toadlogin
          return false;
      }
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}


	
	
}
