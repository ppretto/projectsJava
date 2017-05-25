package com.climbing.stairs.test;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.climbing.stairs.rest.SolutionClimbingStairs;
import com.climbing.stairs.rest.StairwellBean;

public class SolutionClimbingStairsTest {


	@Before
	public void setUp() throws UnsupportedEncodingException {
		System.out.println("Starting test class==>>SolutionClimbingStairsTest");
	}



	@Test
	public void test() {		

		SolutionClimbingStairs solutionClimbingStairs = new SolutionClimbingStairs();
		StairwellBean stairwellBean = new StairwellBean();
		/////////////////////////////////////////////
		//Input: {17}, StepsPerStride: 3, Returns: 6
		/////////////////////////////////////////////

		System.out.println("Starting Solution 1");

		stairwellBean.setStepsStrides(3);		
		List<Integer> listSteps = new ArrayList<Integer>();						
		listSteps.add(17);	
		stairwellBean.setListSteps(listSteps);

		assertNotNull("Exist", stairwellBean);
		assertNotNull("Exist Value StepsStrides",stairwellBean.getStepsStrides());

		try {
			int result = solutionClimbingStairs.solutionMinimumNumberStrides(stairwellBean);			
			System.out.println("Result Solution 1:  " + result);
		} catch (Exception e) {			
			e.printStackTrace();			
		}
		/////////////////////////////////////////////////
		//Input: {17, 17}, StepsPerStride: 3, Returns: 14
		/////////////////////////////////////////////////

		System.out.println("Starting Solution 2");

		stairwellBean = new StairwellBean();

		stairwellBean.setStepsStrides(3);		
		listSteps = new ArrayList<Integer>();						
		listSteps.add(17);	
		listSteps.add(17);	
		stairwellBean.setListSteps(listSteps);

		assertNotNull("Exist", stairwellBean);
		assertNotNull("Exist Value StepsStrides",stairwellBean.getStepsStrides());

		try {
			int result = solutionClimbingStairs.solutionMinimumNumberStrides(stairwellBean);			
			System.out.println("Result Solution 2:  " + result);
		} catch (Exception e) {			
			e.printStackTrace();			
		}

		///////////////////////////////////////////////////////////
		//Input: {4,9,8,11,7,20,14}, StepsPerStride: 2, Returns: 50		
		///////////////////////////////////////////////////////////
		System.out.println("Starting Solution 3");

		stairwellBean = new StairwellBean();

		stairwellBean.setStepsStrides(2);		
		listSteps = new ArrayList<Integer>();						
		listSteps.add(4);	
		listSteps.add(9);	
		listSteps.add(8);	
		listSteps.add(11);
		listSteps.add(7);	
		listSteps.add(20);
		listSteps.add(14);
		stairwellBean.setListSteps(listSteps);

		assertNotNull("Exist", stairwellBean);
		assertNotNull("Exist Value StepsStrides",stairwellBean.getStepsStrides());

		try {
			int result = solutionClimbingStairs.solutionMinimumNumberStrides(stairwellBean);			
			System.out.println("Result Solution 3:  " + result);
		} catch (Exception e) {			
			e.printStackTrace();
			
		}

	}
	

	@After
	public void cleanUp() {
		System.out.println("End test class==>>SolutionClimbingStairsTest");
	}
}
