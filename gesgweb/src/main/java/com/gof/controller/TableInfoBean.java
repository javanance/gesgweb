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
package com.gof.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.PrimeFaces;

import com.gof.dao.MetaDao;
import com.gof.dao.MstDao;
import com.gof.entity.MetaInfo;
import com.gof.entity.MstRunset;
import com.gof.qualifier.H2Database;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://www.cdi-spec.org/faq/#accordion6
//@Model

//@ViewScoped
@Named
@Getter
@Setter
@Slf4j
public class TableInfoBean<T> implements Serializable{

	@Inject
	private FacesContext faceCtx;
	
    @Inject
    @H2Database
    private EntityManager em;
    
    private List<T> modelList;
    
    @Inject
    private Map<String, List<MetaInfo>> metaInfo;
    
    @PostConstruct
    public void initNewMember() {
    	metaInfo.get("GMV_MST_GOC").forEach(s-> log.info("zzzzzzz : {},{}", s.getColumnName(), s.getColumnProperty()));
    	
    }
    
    public void setup(String tableName) {
    	modelList = em.createQuery("from "+tableName).getResultList();
    }

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);
 
        MstRunset car = (MstRunset) value;
        return car.getCoaId().name().toLowerCase().contains(filterText)
                || car.getRunsetId().toLowerCase().contains(filterText)
                ;
           
    }

	 public void clearTableState() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    String viewId = context.getViewRoot().getViewId();
	    PrimeFaces.current().multiViewState().clearAll(viewId, true, (clientId) -> {
	        showMessage(clientId);
	    });
	}

	private int getInteger(String string) {
	        try {
	            return Integer.valueOf(string);
	        }
	        catch (NumberFormatException ex) {
	            return 0;
	        }
	    }
	 private void showMessage(String clientId) {
	        FacesContext.getCurrentInstance()
	                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
	    }
}
