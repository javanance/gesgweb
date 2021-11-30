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
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gof.entity.MstCalc;
import com.gof.entity.MstCoa;
import com.gof.entity.MstGoc;
import com.gof.entity.MstRunset;
import com.gof.qualifier.H2Database;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
@Named
public class MstDao {

	@Inject
	@H2Database
    private EntityManager em;

//    public final static ResourceBundle bundle = ResourceBundle.getBundle("message");
    
	public MstDao() {
		log.info("Construction MstDao");
	}

//	@Inject
//    public MemberRepository(@OracleDatabase EntityManager em) {
//		System.out.println("Construction MemberRepository1");
//		this.em = em;
//	}

//	public MstCoa findById(String id) {
//        return em.find(MstCoa.class, id);
//    }
//
//    public MstCoa findByEmail(String email) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<MstCoa> criteria = cb.createQuery(MstCoa.class);
//        Root<MstCoa> member = criteria.from(MstCoa.class);
//        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
//        // feature in JPA 2.0
//        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
//        criteria.select(member).where(cb.equal(member.get("email"), email));
//        return em.createQuery(criteria).getSingleResult();
//    }

    public List<MstCalc> getMstCalcList() {
    	 String query = "from MstCalc ";
         
         Query q = em.createQuery(query, MstCalc.class);

         return q.getResultList();
    }
    
    public List<MstGoc> getMstGocList() {
   	 	String query = "from MstGoc ";
        
        Query q = em.createQuery(query, MstGoc.class);

        return q.getResultList();
   }
    
    public List<MstCoa> getMstCoaList() {
   	 	String query = "from MstCoa ";
        
        Query q = em.createQuery(query, MstCoa.class);

        return q.getResultList();
   }
   
   
   public List<MstRunset> getMstRunsetList() {
   	 	String query = "from MstRunset ";
        
        Query q = em.createQuery(query, MstRunset.class);

        return q.getResultList();
   }
}
