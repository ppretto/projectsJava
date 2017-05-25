package com.climbing.stairs.rest;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Pp
 * 
 *  class information from input to calculate solution
 */
public class StairwellBean {
	
	
	private List<Integer> listSteps = new ArrayList<Integer>();
	
	private int stepsStrides;

	public List<Integer> getListSteps() {
		return listSteps;
	}

	public void setListSteps(List<Integer> listSteps) {
		this.listSteps = listSteps;
	}

	public int getStepsStrides() {
		return stepsStrides;
	}

	public void setStepsStrides(int stepsStrides) {
		this.stepsStrides = stepsStrides;
	}
	

}
