package net.stackoverflow.blog.web.interceptor;

import net.stackoverflow.blog.pojo.po.VisitPO;
import net.stackoverflow.blog.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 访问量拦截器
 *
 * @author 凉衫薄
 */
public class VisitInterceptor implements HandlerInterceptor {

    @Autowired
    private VisitService visitService;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String uri = request.getRequestURL().toString();
        String param = request.getQueryString();
        Integer status = response.getStatus();
        String ip = request.getRemoteAddr();
        String agent = request.getHeader("User-Agent");
        String referer = request.getHeader("Referer");
        Date date = new Date();
        String url = param == null ? uri : uri + "?" + param;
        VisitPO visit = new VisitPO(null, url, status, ip, agent, referer, date);
        visitService.insert(visit);
    }
}
