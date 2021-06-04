package com.atibusinessgroup.bukutamu.security;

//import com.agrodana.oa.util.NotificationUtil;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomizeLogoutSuccessHandler extends
        SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

	//@Autowired
	//private NotificationUtil notif;
	

  @Override
  public void onLogoutSuccess(
    HttpServletRequest request,
    HttpServletResponse response,
    Authentication authentication)
    throws IOException, ServletException {

//	  notif.notifyAdmin("User "+authentication.getName()+" successfully logout");
      super.onLogoutSuccess(request, response, authentication);
  }
}