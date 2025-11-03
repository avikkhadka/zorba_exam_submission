package flightbookingsystem.dao;

import flightbookingsystem.entity.Passenger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PassengerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void savePassenger(Passenger passenger) {
        sessionFactory.getCurrentSession().save(passenger);
    }
}
