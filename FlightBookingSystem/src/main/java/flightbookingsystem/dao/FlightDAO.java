package flightbookingsystem.dao;

import flightbookingsystem.entity.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FlightDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Flight> getAllFlights() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Flight", Flight.class)
                .getResultList();
    }

    @Transactional
    public void saveFlight(Flight flight) {
        sessionFactory.getCurrentSession().save(flight);
    }

    @Transactional
    public Flight getFlightById(Long id) {
        return sessionFactory.getCurrentSession().get(Flight.class, id);
    }

    @Transactional
    public void updateFlight(Flight flight) {
        sessionFactory.getCurrentSession().update(flight);
    }

    @Transactional
    public void deleteFlight(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Flight flight = session.get(Flight.class, id);
        if (flight != null) {
            session.delete(flight);
        }
    }
}
