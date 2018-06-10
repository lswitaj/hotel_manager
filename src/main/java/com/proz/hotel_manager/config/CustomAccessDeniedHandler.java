//http://www.baeldung.com/spring-security-custom-access-denied-page
//package com.proz.hotel_manager.config;
//
//import java.io.IOException;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
////@Configuration
//public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//
//	public static final LogManager LOG = LogManager.getLogger(CustomAccessDeniedHandler.class);
//
//	@Override
//	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc) throws IOException, ServletException {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null) {
//			LOG.warning("User: " + auth.getName() + " attempted to access the protected URL: " + request.getRequestURI());
//		}
//		response.sendRedirect(request.getContextPath() + "/accessDenied");
//	}
//}