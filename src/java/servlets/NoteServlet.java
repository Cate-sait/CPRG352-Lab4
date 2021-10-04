package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Ya-Yun Huang
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {

    String path;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // read note.txt and set attributes for request object
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String contents = br.readLine();
        
        Note n = new Note(title, contents);
        request.setAttribute("note", n);
        
        String queryString = request.getQueryString();

        // Why cannot use queryString.equals("edit")?
        if ("edit".equals(queryString)) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        } 
        else 
        {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // capture the parameters coming in from the POST request
        try (PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(path, false)))) 
        {
            // capture the parameters coming in from the POST request
            String title = "";
            String contents = "";
            
            title = request.getParameter("in_title");
            contents = request.getParameter("in_contents");
            
            w.println(title);
            w.println(contents);
            w.close();
            doGet(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
