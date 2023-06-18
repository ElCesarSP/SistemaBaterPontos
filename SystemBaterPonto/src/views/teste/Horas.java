
package views.teste;

import java.util.logging.Level;
import java.util.logging.Logger;
import views.intuUsuario;

public class Horas implements Runnable{

    @Override
    public void run() {
    
        int i = Integer.parseInt(intuUsuario.txtHor1.getText());
        for (;;){
            intuUsuario.txtHor1.setText(i + "");
            i++;
            if (i == 24)
                i=0;
            try {
                Thread.sleep(3600000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Horas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
