package lab.illfact.simplewebapp.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName = "encodingFilter", urlPatterns = { "/*" })
public class EncodingFilter implements Filter {

  public EncodingFilter() {
    //  document why this constructor is empty
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
      request.setCharacterEncoding("UTF-8");

      chain.doFilter(request, response);
  }

}
