package sit.int202.simple.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.simple.entities.Subject;
import sit.int202.simple.repositories.SubjectRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubjectListServlet", value = "/SubjectList")
public class SubjectListServlet extends HttpServlet {
    private long startTime;
    @Override
    public void init() throws ServletException {
        startTime = System.currentTimeMillis();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Subject> subjects = new SubjectRepository().findAll();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/subject_listing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("This servlet life time is " +
                (System.currentTimeMillis() - startTime) + " millisecond");
    }
}