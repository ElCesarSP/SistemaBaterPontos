package views;

import views.intuUsuario;

public class Minutos2 implements Runnable {

    @Override
    public void run() {

        int i = Integer.parseInt(intuUsuario.txtMin2.getText());
        for (;;) {
            intuUsuario.txtMin2.setText(i + "");
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
