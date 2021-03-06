package br.com.carlospovoa.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

public class PhaseListenerPovoa implements PhaseListener {

    // antes da fase
    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Antes da fase: " + fase.getPhaseId());
        
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequesteSession(session);
        }
    }

    // depois da fase
    @Override
    public void beforePhase(PhaseEvent fase) {
        System.out.println("Despois da fase: " + fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
            Session session = FacesContextUtil.getRequesteSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()){
                    session.getTransaction().rollback();
                }
            } finally{
                session.close();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
