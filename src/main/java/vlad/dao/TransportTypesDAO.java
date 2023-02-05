package vlad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vlad.entities.TransportType;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class TransportTypesDAO implements DAO<TransportType> {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<TransportType> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<TransportType> query = session.createQuery("from TransportType");
        List<TransportType> result = query.getResultList();
        return result;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        TransportType transportType = session.get(TransportType.class, id);
        session.delete(transportType);
    }

    @Transactional
    @Override
    public void saveOrUpdate(TransportType transportType) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(transportType);
    }

    @Transactional
    @Override
    public TransportType getById(long transportId) {
        Session session = sessionFactory.getCurrentSession();
        Query<TransportType> query = session.createQuery("from TransportType where id=:transportId");
        query.setParameter("transportId", transportId);
        TransportType result = query.getSingleResult();
        return result;
    }
}
