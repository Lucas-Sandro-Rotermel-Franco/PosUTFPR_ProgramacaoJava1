package br.com.ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import jakarta.jms.TextMessage;

/**
 *
 * @author lucassandro
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java/Fila"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class MdbEnviaResultado implements MessageListener {
    
    @EJB
    EjbCalculadora ejbJogo;
    
    @Override
    public void onMessage(Message msg) {
        try {
            if (msg instanceof ObjectMessage) {
                String texto = ((ObjectMessage) msg).getObject().toString();
                System.out.println("Quadrado: " + texto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
