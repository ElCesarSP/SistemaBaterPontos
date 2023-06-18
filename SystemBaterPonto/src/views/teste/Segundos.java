package views.teste;

import views.intuUsuario;

public class Segundos implements Runnable {

    @Override
    public void run() {
        int i = Integer.parseInt(intuUsuario.txtSeg1.getText());
        for (;;) {
            intuUsuario.txtSeg1.setText(i + "");
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
