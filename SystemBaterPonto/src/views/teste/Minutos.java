package views.teste;

import java.util.logging.Level;
import java.util.logging.Logger;
import views.intuUsuario;

public class Minutos implements Runnable {

    @Override
    public void run() {

        int i = Integer.parseInt(intuUsuario.txtMin1.getText());
        for (;;) {
            intuUsuario.txtMin1.setText(i + "");
            i++;
            if (i == 59) {
                i = 0;
            }
            try {
                Thread.sleep(60000);
            } catch (Exception e) {

            }
        }

    }

}
