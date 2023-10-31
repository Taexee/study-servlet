package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        // 스프링이 스트림을 편리하게 사용할 수 있게 StreamUtils 제공
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // 꺼낼때 인코딩 설정해줘야함

        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
