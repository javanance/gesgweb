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

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.gof.dao.MapDao;
import com.gof.entity.MapJournalRollFwd;
import com.gof.enums.ECoa;
import com.gof.enums.ERollFwdType;

import lombok.Getter;
import lombok.Setter;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://www.cdi-spec.org/faq/#accordion6
//@Model

@ViewScoped
@Named
@Getter
@Setter
public class MapJournalBean implements Serializable{

//    @Inject
//    private FacesContext facesContext;

    @Inject
    private MapDao	dao;
    
    private List<MapJournalRollFwd> mapJournalList ;
//    private Map<ERollFwdType, Map<String, MapJournalRollFwd>> mapJournalMap ;
    private Map<ERollFwdType, Map<ECoa, MapJournalRollFwd>> mapJournalMap ;
    private List<MapJournalRollFwd> filteredMapJournalList ;
    private MapJournalRollFwd selected;
    
    @PostConstruct
    public void initNewMember() {
    	System.out.println("InitNewMember PostConstruct");
    	mapJournalList = dao.getAllList().stream().sorted(Comparator.comparingInt(MapJournalRollFwd::getRollFwdSeq)).collect(toList());
    	
//    	mapJournalMap =mapJournalList.stream().collect(groupingBy(MapJournalRollFwd::getRollFwdType, toMap(MapJournalRollFwd::getCalcId, Function.identity(), (s,u)->s)));
    	
    	mapJournalMap =mapJournalList.stream().collect(groupingBy(MapJournalRollFwd::getRollFwdType, toMap(MapJournalRollFwd::getDebitCoa, Function.identity(), (s,u)->s)));
    }
    
	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
	        if (filterText == null || filterText.equals("")) {
	            return true;
	        }
	        int filterInt = getInteger(filterText);
	 
	        MapJournalRollFwd car = (MapJournalRollFwd) value;
	        return car.getRollFwdType().name().toLowerCase().contains(filterText)
	                || car.getMstCalc().getCalcId().toLowerCase().contains(filterText)
	                || car.getDebitCoa().name().toLowerCase().contains(filterText)
	                || car.getCreditCoa().name().toLowerCase().contains(filterText)
	                
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
