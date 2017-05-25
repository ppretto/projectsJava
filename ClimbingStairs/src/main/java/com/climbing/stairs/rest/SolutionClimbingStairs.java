package com.climbing.stairs.rest;

/**
 * 
 * @author Pp
 *
 *  Class to calculate solution 
 */
public class SolutionClimbingStairs {

	private static int NUMBER_ONE = 1;

	private static int NUMBER_TWO = 2;

	private static int NUMBER_THREE = 3;

	private static int NUMBER_FOUR = 4;

	private static int NUMBER_FIVE= 5;

	private static int NUMBER_SIX= 6;

	/**
	 * 
	 * @param stairwellBean
	 * @return
	 * @throws Exception
	 * 
	 * Method to calculate result
	 */

	public int solutionMinimumNumberStrides(StairwellBean stairwellBean)throws Exception{

		int result          = 0;		
		int sumSteps        = sumSteps(stairwellBean);
		int quantityFlights = getQuantityFlights(stairwellBean);
		int quantityStrides = getQuantityStrides(quantityFlights);
		int stepsPerStride  = stairwellBean.getStepsStrides();


		if(quantityStrides == NUMBER_ONE && quantityFlights == NUMBER_ONE){
			return result = sumSteps / stepsPerStride + quantityStrides;
		}

		if(quantityStrides == NUMBER_ONE && quantityFlights > NUMBER_ONE && quantityFlights <= NUMBER_TWO){
			return result = sumSteps / stepsPerStride + stepsPerStride;
		}

		if(quantityStrides >= NUMBER_TWO){
			int numRes = quantityStrides * quantityFlights;
			return result = sumSteps / stepsPerStride + numRes;
		}



		return result;

	}

	/**
	 * 
	 * @param quantityFlights
	 * @return
	 * 
	 * Method to get quantity strides
	 */

	private static int getQuantityStrides(int quantityFlights){


		if(quantityFlights <= 5){
			return NUMBER_ONE;
		}

		if(quantityFlights >= 6 && quantityFlights <= 10){
			return NUMBER_TWO;
		}

		if(quantityFlights >= 11 && quantityFlights <= 15){
			return NUMBER_THREE;
		}

		if(quantityFlights >= 16 && quantityFlights <= 20){
			return NUMBER_FOUR;
		}

		if(quantityFlights >= 21 && quantityFlights <= 25){
			return NUMBER_FIVE; 
		}

		if(quantityFlights >= 26 && quantityFlights <= 30){
			return NUMBER_SIX;
		}

		return 0;

	}
	
	/**
	 * 
	 * @param stairwellBean
	 * @return
	 * 
	 * Method to get Quantity Flights
	 */

	private int getQuantityFlights(StairwellBean stairwellBean){

		int quantity = 0;

		for(Integer  steps : stairwellBean.getListSteps()){
			if(steps != null && steps > 0) {
				quantity++;
			}

		}

		return quantity;

	}

	/**
	 * 
	 * @param stairwellBean
	 * @return
	 */
	private int sumSteps(StairwellBean stairwellBean){
		int sumSteps = 0;

		try{
			for(Integer  steps : stairwellBean.getListSteps()){
				if(steps != null && steps > 0) {
					sumSteps += steps.intValue();			
				}			
			}

		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return sumSteps;
	}



}

/**
 * Examples:
Input: {17}, StepsPerStride: 3, Returns: 6
A stairwell with a single flight of with 17 steps. In 5 strides, you've climbed 15 steps. You’ve two steps left to
reach top, which you can cover in 1 stride.

(17 / 3) 5 + 1 = 6

Input: {17, 17}, StepsPerStride: 3, Returns: 14
somar quantidade 1 +1

(17 = 17) 34 / 3 =  11 + 2 + 1 (numero de quant maxima 1` a 5) = 14

A similar stairwell, but with 2 flights separated by a landing. 6 strides to the landing, 2 strides to turn, and 6
more strides to get to the top.


Input: {4,9,8,11,7,20,14}, StepsPerStride: 2, Returns: 50


73 / 2= 36 (2 * 7)=14 ====> 36 + 14 = 50

 **/

