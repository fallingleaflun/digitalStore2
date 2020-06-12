package store.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.domain.User;

/**
 * Servlet Filter implementation class ClientPrivilegeFilter
 */
@WebFilter(filterName="ClientPrivilegeFilter", urlPatterns = {
		"/client/myAccount.jsp",
		"/client/cart.jsp",
		"/client/modifyuserinfo.jsp"
		})
public class ClientPrivilegeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ClientPrivilegeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		// 1 强制转换
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// 2判断是否具有权限
		User user = (User) req.getSession().getAttribute("user");

		if (user != null) {
			// 3.放行
			chain.doFilter(request, response);
			return;
		}
		res.sendRedirect(req.getContextPath() + "/client/login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
