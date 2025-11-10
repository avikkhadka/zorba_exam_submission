package flightbookingsystem.dao;

import flightbookingsystem.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Role getRoleByName(String roleName) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Role where roleName = :roleName", Role.class)
                .setParameter("roleName", roleName)
                .uniqueResult();
    }

    @Transactional
    public void saveRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }
}
