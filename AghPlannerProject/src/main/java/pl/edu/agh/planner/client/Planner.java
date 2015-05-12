package pl.edu.agh.planner.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import pl.edu.agh.planner.client.applayout.RootPanelPlanner;
import pl.edu.agh.planner.client.applayout.loginpanel.LoginPanelPlanner;
import pl.edu.agh.planner.shared.User;

public class Planner implements EntryPoint {

    public void onModuleLoad(){

        String sid = Cookies.getCookie("sid");
        if (sid == null){
            displayLoginWindow();
        } else{
            checkWithServerIfSessionIdIsStillLegal();
        }
    }

    private void checkWithServerIfSessionIdIsStillLegal(){
        LoginService.Util.getInstance().loginFromSessionServer(new AsyncCallback<User>(){
            @Override
            public void onFailure(Throwable caught){
                displayLoginWindow();
            }

            @Override
            public void onSuccess(User result){
                if (result == null){
                    displayLoginWindow();
                } else{
                    if(result.isLoggedIn()){
                        RootPanelPlanner.getInstance();
                    }
                    else{
                        displayLoginWindow();
                    }
                }
            }
        });
    }

    private void displayLoginWindow(){
        RootPanel.get().add(LoginPanelPlanner.getInstance());
    }

}
