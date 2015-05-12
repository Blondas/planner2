package pl.edu.agh.planner.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pl.edu.agh.planner.client.LoginService;
import pl.edu.agh.planner.shared.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
    private static final long serialVersionUID = 4456105400553118785L;

    @Override
    public User loginServer(String name, String password){
        //validate username and password

        //store the user/session id
        User user = new User();
        user.setLogin(name);
        user.setPassword(password);
        user.setLoggedIn(true);
        //TODO baza danych sprawdzic haslo

        storeUserInSession(user);

        return user;
    }

    @Override
    public User loginFromSessionServer(){
        return getUserAlreadyFromSession();
    }

    @Override
    public void logout(){
        deleteUserFromSession();
    }

    @Override
    public boolean changePassword(String name, String newPassword){
        // change password logic
        return false;
    }

    private User getUserAlreadyFromSession(){
        User user = null;
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();

        HttpSession session = httpServletRequest.getSession(false);
        if(session == null){
            session = httpServletRequest.getSession();
        }

        Object userObj = session.getAttribute("user");
        if (userObj != null && userObj instanceof User){
            user = (User) userObj;
        }

        return user;
    }

    private void storeUserInSession(User user){
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
        HttpSession session = httpServletRequest.getSession(true);
        user.setSessionId(session.getId());
        session.setAttribute("user", user);
    }

    private void deleteUserFromSession(){
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
        HttpServletResponse httpServletResponse = this.getThreadLocalResponse();
        HttpSession session = httpServletRequest.getSession(false);

        if(session == null){
            return;
        }
        Cookie[] cookies = httpServletRequest.getCookies();
        Cookie sidCookie = null;
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("sid")){
                    sidCookie = cookie;
                    break;
                }
            }
        }

        if(sidCookie != null){
            sidCookie.setMaxAge(0);
            httpServletResponse.addCookie(sidCookie);
        }
        session.removeAttribute("user");
        session.invalidate();
    }

}