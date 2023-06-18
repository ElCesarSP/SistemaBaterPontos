package views;

import views.intuUsuario;

public class Hora2 implements Runnable{

    @Override
    public void run() {
   
                int h = Integer.parseInt(intuUsuario.txtHor2.getText());
        for (;;) {
            intuUsuario.txtHor2.setText(h + "");
            h++;
            if (h == 24) {
                h = 0;
            }
            try {
                Thread.sleep(3600000);
            } catch (Exception e) {

            }
        }
        
        
    }
    
}
