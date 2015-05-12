package pl.edu.agh.planner.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pl.edu.agh.planner.shared.User;

@RemoteServiceRelativePath("LoginService")
public interface LoginService extends RemoteService{
    public static class Util {
        private static LoginServiceAsync instance;
        public static LoginServiceAsync getInstance(){
            if (instance == null){
                instance = GWT.create(LoginService.class);
            }
            return instance;
        }
    }

    User loginServer(String name, String password);

    User loginFromSessionServer();

    boolean changePassword(String name, String newPassword);

    void logout();
}
