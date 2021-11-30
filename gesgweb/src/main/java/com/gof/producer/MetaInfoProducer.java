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
package com.gof.producer;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.gof.dao.MetaDao;
import com.gof.entity.MetaInfo;
import com.gof.entity.MstCoa;

import lombok.extern.slf4j.Slf4j;


@ApplicationScoped
@Slf4j
public class MetaInfoProducer {
	
    @Inject
    private MetaDao	metaDao;

    private Map<String, List<MetaInfo>> metaInfoMap;

    @Produces
    @Named
    @ApplicationScoped
    public Map<String, List<MetaInfo>> metaInfoMap() {
    	System.out.println("in Producer method");
        return metaInfoMap;
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final MstCoa member) {
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
    	log.info("aaAAAA : {}");
//    	metaInfoMap = metaDao.getMetaInfo().stream().collect(groupingBy(MetaInfo::getTableName, mapping(MetaInfo::getColumnName, toList())));
//    	metaInfoMap = metaDao.getMetaInfo().stream().collect(groupingBy(MetaInfo::getTableName, mapping(MetaInfo::getColumnProperty, toList())));
    	metaInfoMap = metaDao.getMetaInfo().stream().collect(groupingBy(MetaInfo::getTableName, toList()));
    }
}
