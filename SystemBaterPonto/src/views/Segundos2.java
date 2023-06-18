package views;

import views.intuUsuario;

public class Segundos2 implements Runnable {

    @Override
    public void run() {

        int i = Integer.parseInt(intuUsuario.txtSeg2.getText());
        for (;;) {
            intuUsuario.txtSeg2.setText(i + "");
            i++;
            if (i == 59) {
                i = 0;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }

}
