/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gof.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.gof.entity.MapJournalRollFwd;
import com.gof.qualifier.H2Database;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
//@Named
//@Stateless
public class MapDao {

	@Inject
//	@OracleDatabase
	@H2Database
    private EntityManager em;

//    public final static ResourceBundle bundle = ResourceBundle.getBundle("message");
    
	public MapDao() {
		System.out.println("Construction MapDao");
	}

//	@Inject
//    public MapDao(@OracleDatabase EntityManager em) {
//		System.out.println("Construction MemberRepository1");
//		this.em = em;
//	}

	public MapJournalRollFwd findById(String id) {
        return em.find(MapJournalRollFwd.class, id);
    }

    public MapJournalRollFwd findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MapJournalRollFwd> criteria = cb.createQuery(MapJournalRollFwd.class);
        Root<MapJournalRollFwd> member = criteria.from(MapJournalRollFwd.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(member).where(cb.equal(member.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<MapJournalRollFwd> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MapJournalRollFwd> criteria = cb.createQuery(MapJournalRollFwd.class);
        Root<MapJournalRollFwd> member = criteria.from(MapJournalRollFwd.class);
        
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
//        criteria.select(member).orderBy(cb.asc(member.get("name")));
        log.info("Find All Order : {}");
        
        return em.createQuery(criteria).getResultList();
    }
    
    public List<MapJournalRollFwd> getAllList() {
//        String query = "from MapJournalRollFwd a order by a.rollFwdSeq.order";
        String query = "from MapJournalRollFwd ";
        
        Query q = em.createQuery(query, MapJournalRollFwd.class);

        return q.getResultList();
    }
}
