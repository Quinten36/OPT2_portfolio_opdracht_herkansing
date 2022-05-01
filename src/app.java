import controller2.loginController;
import controller2.menuController;
import controller2.profileController;
import factories2.clientFactory;
import factories2.gerechtFactory;
import factories2.userFactory;
import factories2.weekplannerFactory;

public class app {
    public static app mainApp;
//todo: askUser methode maken met de string om te zeggen meegeef

    public void init() {
        //start factories for preset data
        //like clients, food, premade schedules

        clientFactory.start();
        userFactory.start();
        gerechtFactory.start();
        weekplannerFactory.start();

        loginController.logincontroller = new loginController();
        menuController.menucontroller = new menuController();
        profileController.profilecontroller = new profileController();
    }

    public void start() {
        loginController.logincontroller.start();
    }
}
