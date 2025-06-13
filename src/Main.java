import service.ApplicationService;
import service.ApplicationServiceImp;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationService app = new ApplicationServiceImp();
        app.start();
    }
}