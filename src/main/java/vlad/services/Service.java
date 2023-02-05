package vlad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vlad.dao.DAO;
import vlad.entities.TransportType;

import java.util.List;

@Component
public class Service {
    @Autowired
    public DAO<TransportType> dao;

    public List<TransportType> getAllTranportTypes() {
        List<TransportType> result = dao.getAll();
        return result;
    }

    public TransportType getTransportTypeById(long id) {
        TransportType result = dao.getById(id);
        return result;
    }

    public void save(TransportType transportType) {
        dao.saveOrUpdate(transportType);
    }

    public void delete(long id) {
        dao.delete(id);
    }
}
