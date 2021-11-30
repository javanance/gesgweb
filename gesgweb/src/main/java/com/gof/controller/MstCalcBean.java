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

import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationCase;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.gof.dao.MstDao;
import com.gof.entity.MstCalc;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://www.cdi-spec.org/faq/#accordion6
//@Model

@ViewScoped
@Named
@Getter
@Setter
@Slf4j
public class MstCalcBean implements Serializable{

	@Inject
	private FacesContext faceCtx;
	
    @Inject
    private MstDao repo;
    
    private List<MstCalc> mstCalcList ;
    private List<MstCalc> filteredMstCalcList ;
    private MstCalc selected;
    
    @PostConstruct
    public void initNewMember() {
    	log.info("Context in MstCalcBean : {},{}", faceCtx.getViewRoot().getViewId());
    	 ConfigurableNavigationHandler navigationHandler = (ConfigurableNavigationHandler) faceCtx.getApplication().getNavigationHandler();

//    	 NavigationCase  navCase  =navigationHandler.getNavigationCase(faceCtx, null, "/index");
//    	 String toViewId = navCase.getToViewId(faceCtx);
    	 
//    	 faceCtx.getApplication().getViewHandler().getViews(faceCtx, "views").forEach(s->log.info("zzzz : {}", s));
//    	 faceCtx.getApplication().getViewHandler().getViews(faceCtx, "WEB-INF").forEach(s->log.info("zzzz : {}", s));
    	 
    	 
//    	 log.info("aaaa : {},{}", toViewId);
//    	 
//    	 NavigationCase  navCase2  =navigationHandler.getNavigationCase(faceCtx, null, "detailResult");
//    	 String toViewId2 = navCase2.getToViewId(faceCtx);
//    	 
//    	 log.info("aaaa : {},{}", toViewId2);
//    	 
//    	 NavigationCase  navCase1  =navigationHandler.getNavigationCase(faceCtx, null, "views/mstCalc");
//    	 if(navCase1!= null) {
//    		log.info("aaaaaa1 : {},{},{}", navCase1.toString())  ;
//    	 }
//
//    	 NavigationCase  navCase11  =navigationHandler.getNavigationCase(faceCtx, null, "../views/mstCalc");
//    	 if(navCase11!= null) {
//    	 log.info("aaaaaa11 : {},{},{}", navCase11.toString());
//    	 }
//    	 
//    	 NavigationCase  navCase12  =navigationHandler.getNavigationCase(faceCtx, null, "/views/mstCalc");
//    	 if(navCase12!= null) {
//    		 log.info("aaaaaa12 : {},{},{}", navCase12.toString());
//    		 
//    	 }
    	 
//    	 NavigationCase  navCase1  =navigationHandler.getNavigationCase(faceCtx, null, "views/mstCal");
//    	 if(navCase1!= null) {
//    		log.info("aaaaaa1 : {},{},{}", navCase1.toString())  ;
//    	 }
//
//    	 NavigationCase  navCase11  =navigationHandler.getNavigationCase(faceCtx, null, "views/mstCal.xhmtl");
//    	 if(navCase11!= null) {
//    	 log.info("aaaaaa11 : {},{},{}", navCase11.toString());
//    	 }
//    	 
//    	 NavigationCase  navCase12  =navigationHandler.getNavigationCase(faceCtx, null, "views/mstCal");
//    	 if(navCase12!= null) {
//    		 log.info("aaaaaa12 : {},{},{}", navCase12.toString());
//    		 
//    	 }
    	 
//    	 String toViewId1 = navCase1.getToViewId(faceCtx);
//    	 log.info("bbbb : {},{}", toViewId1);
    	 
    	mstCalcList = repo.getMstCalcList();
    
    }

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
	        if (filterText == null || filterText.equals("")) {
	            return true;
	        }
	        int filterInt = getInteger(filterText);
	 
	        MstCalc car = (MstCalc) value;
	        return car.toString().toLowerCase().contains(filterText)   ;
	           
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
