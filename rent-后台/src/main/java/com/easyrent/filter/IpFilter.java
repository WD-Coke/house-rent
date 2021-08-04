package com.easyrent.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 过滤IP
 */
public class IpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ip;
        boolean passp = true;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        ip = httpServletRequest.getHeader("x-forwarded-for") != null ? httpServletRequest.getHeader("x-forwarded-for") : httpServletRequest.getRemoteAddr();
        if (((HttpServletRequest) servletRequest).getRequestURI().indexOf("/image") > 0)
            filterChain.doFilter(servletRequest, servletResponse);
        else {

                File file1 = new File("./ban.txt");
                if(!file1.exists())file1.createNewFile();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
                String line="";
                while ((line=bufferedReader.readLine())!=null) {
                    if (ip.equals(line)){
                        passp = false;
                        break;
                    }
                }
                if (passp) {
                    File file = new File("./filter.txt");
                    if (!file.exists()) file.createNewFile();
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                    bufferedWriter.write(ip + "\n");
                    bufferedWriter.close();
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    Map<String, String> result = new HashMap();
                    result.put("code", "407");
                    result.put("msg", "ip被禁");
                    out.write(new ObjectMapper().writeValueAsString(result));
                }
        }
    }
    @Override
    public void destroy() {

    }
}
