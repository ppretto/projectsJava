package com.climbing.stairs.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/climbing")
public class ClimbingStairsService {

	private static int STATUS_OK = 200;

	private static int STATUS_NO_CONTENT = 204;

	private static int STATUS_CONFLICT = 409;
	
	StairwellBean stairwellBean;

	@GET
	@Path("/{strValue}")
	public Response getMsg(@PathParam("strValue") String str) {

		String test = "Message: " + str;

		return Response.status(STATUS_OK).entity(test).build();

	}


	@POST
	@Path ("/calc")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response solutionClimbingStairs(String jsonNode) throws JsonProcessingException{

		int result=0;

		try {
		
			setStairwell(jsonNode);
			
			SolutionClimbingStairs solutionClimbingStairs = new SolutionClimbingStairs();
			result = solutionClimbingStairs.solutionMinimumNumberStrides(stairwellBean);

		} catch (Exception e) {		
			e.printStackTrace();
			return Response.status(STATUS_CONFLICT).entity(null).build();
		}

	
		if(result > 0){
			ResultBean resultBean = new ResultBean();
			resultBean.setTotal(Integer.toString(result));   
			return Response.status(STATUS_OK).entity(resultBean).build();			
		}

		return Response.status(STATUS_NO_CONTENT).entity(null).build();

	}   

   /**
    * 
    * @param jsonNode
    */

	private void setStairwell(String jsonNode) {

		List<Integer> listSteps = new ArrayList<Integer>();	
		ObjectMapper mapper = new ObjectMapper();
		this.stairwellBean =  new StairwellBean();

		JsonNode rootNode=null;
		try {
			rootNode = mapper.readTree(jsonNode);
			JsonNode stepsStridesNode = rootNode.path("stepsStrides");

			if(stepsStridesNode.asText() != null && !stepsStridesNode.asText().equals("")){
			  this.stairwellBean.setStepsStrides(Integer.parseInt(stepsStridesNode.asText()));
			}
			 

			JsonNode stepsNode = rootNode.get("steps");
			if (stepsNode.isArray()) {
				listSteps = new ArrayList<Integer>();
				for (final JsonNode steps : stepsNode) {					
					listSteps.add(steps.asInt());					
				}
				this.stairwellBean.setListSteps(listSteps);
			}


		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	

}