package com.example.BugTrackingApp.daoImpl;

import com.example.BugTrackingApp.dao.IApplicationDAO;
import com.example.BugTrackingApp.entity.Application;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ApplicationDAOImpl implements IApplicationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addApplication(Application app) {

        entityManager.persist(app);
    }

    @Override
    public boolean applicationExists(String name, String owner) {

        String jpql = " from Application as APP WHERE APP.name = ?1 and APP.owner = ?2";
        int count = entityManager.createQuery(jpql).setParameter(1, name)
                .setParameter(2, owner).getResultList().size();
        return count > 0;
    }
}
