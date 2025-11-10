package flightbookingsystem.dao;

import flightbookingsystem.entity.Passenger;
import flightbookingsystem.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PassengerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Passenger> getAllPassengers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Passenger", Passenger.class)
                .getResultList();
    }

    @Transactional
    public void savePassenger(Passenger passenger) {
        sessionFactory.getCurrentSession().save(passenger);
    }

    @Transactional
    public Passenger getPassengerById(Long id) {
        return sessionFactory.getCurrentSession().get(Passenger.class, id);
    }

    @Transactional
    public void updatePassenger(Passenger passenger) {
        sessionFactory.getCurrentSession().update(passenger);
    }

    @Transactional
    public void deletePassenger(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Passenger passenger = session.get(Passenger.class, id);
        if (passenger != null) {
            session.delete(passenger);
        }
    }

    @Transactional
    public Passenger getPassengerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                        "from Passenger p where p.passengerUsername = :username", Passenger.class)
                .setParameter("username", username)
                .uniqueResult();
    }

    // Optional: method to assign roles (if needed)
    @Transactional
    public void addRoleToPassenger(Passenger passenger, Role role) {
        passenger.getRoles().add(role);
        sessionFactory.getCurrentSession().update(passenger);
    }
}
