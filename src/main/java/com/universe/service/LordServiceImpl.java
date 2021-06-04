package com.universe.service;


import com.universe.models.Lord;

import com.universe.repository.LordRepository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import javax.persistence.criteria.CriteriaBuilder;

import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

import java.util.List;


@Service
public class LordServiceImpl implements LordService {

    @PersistenceContext
    private EntityManager em;

    private LordRepository lordRepository;

    public LordServiceImpl(LordRepository repository) {
        this.lordRepository = repository;
    }

    @Override
    public List<Lord> getAllLords() {
        return lordRepository.findAll();
    }

    @Override
    public void createNewLord(Lord lord) {
        lordRepository.save(lord);
    }

    @Override
    public void deleteLord(Lord lord) {
        lordRepository.delete(lord);
    }

    @Override
    public List<Lord> getTopTenJunLords() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Lord> lord = criteriaQuery.from(Lord.class);
        criteriaQuery.select(lord);
        criteriaQuery.orderBy(criteriaBuilder.asc(lord.get("age")));
        Query query = em.createQuery(criteriaQuery).setMaxResults(10);
        return query.getResultList();
    }

    @Override
    public List<Lord> getIdlerLords() {
        Query q = em.createQuery("SELECT l1 from Lord l1 left join  Planet p1 on l1.pid = p1.lord.pid " +
                "where (SELECT count(p2) FROM Planet p2 where l1.pid = p2.lord.pid) = 0");

        return q.getResultList();
    }

    @Override
    public Lord findByName(String name) {
        return lordRepository.findByName(name);
    }

}
