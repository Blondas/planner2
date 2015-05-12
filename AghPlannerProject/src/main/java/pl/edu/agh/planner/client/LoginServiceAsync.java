package pl.edu.agh.planner.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.edu.agh.planner.shared.User;

public interface LoginServiceAsync {
    void loginServer(String name, String password, AsyncCallback<User> async);

    void loginFromSessionServer(AsyncCallback<User> async);

    void changePassword(String name, String newPassword, AsyncCallback<Boolean> async);

    void logout(AsyncCallback<Void> async);
}
