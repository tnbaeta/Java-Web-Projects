package lab.illfact.simplewebapp.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import lab.illfact.simplewebapp.beans.UserAccount;
import lab.illfact.simplewebapp.utils.DBUtils;
import lab.illfact.simplewebapp.utils.MyUtils;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
	
	private static final String COOKIE = "COOKIE_CHECKED";  

	public CookieFilter() {
   // document why this constructor is empty
 }

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		
   //  document why this method is empty
 }

	@Override
	public void destroy() {
   //  document why this method is empty
 }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		UserAccount userInSession = MyUtils.getLoginedUser(session);
		// 
		if (userInSession != null) {
			session.setAttribute(COOKIE, "CHECKED");
			chain.doFilter(request, response);
			return;
		}

		// Connection was created in JDBCFilter.
		Connection conn = MyUtils.getStoredConnection(request);

		// Flag check cookie
		String checked = (String) session.getAttribute(COOKIE);
		if (checked == null && conn != null) {
			String userName = MyUtils.getUserNameInCookie(req);
			try {
				UserAccount user = DBUtils.findUser(conn, userName);
				MyUtils.storeLoginedUser(session, user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// Mark checked Cookies.
			session.setAttribute(COOKIE, "CHECKED");
		}

		chain.doFilter(request, response);
	}

}
