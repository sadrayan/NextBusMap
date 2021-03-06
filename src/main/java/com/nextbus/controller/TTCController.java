package com.nextbus.controller;


import com.nextbus.model.Agent;
import com.nextbus.model.Direction;
import com.nextbus.model.Route;
import com.nextbus.model.Stop;
import com.nextbus.service.NextBusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class TTCController {

	@Autowired
	private NextBusService nextBusService;

	private static final Logger logger = LoggerFactory.getLogger(TTCController.class);

	@RequestMapping(value = "/agentList")
	List<Agent> getAgentList () {
		logger.info("API-AGENT-START: " + System.currentTimeMillis());
		List<Agent> agentList = nextBusService.getAgentList();
		logger.info("API-AGENT-END: " + System.currentTimeMillis());
		return agentList;
	}

	@RequestMapping(value = "/routeList")
	List  <Route>  getRouteList (@RequestParam(value="agentTag") String agentTag) {
		logger.info("API-ROUTE-START: " + System.currentTimeMillis());
		List  <Route> routeList = nextBusService.getRouteList(agentTag);
		logger.info("API-ROUTE-START: " + System.currentTimeMillis());
		return routeList;
	}

	@RequestMapping(value = "/stopList")
	List <Stop> getStopList (@RequestParam(value="agentTag") String agentTag,
							 @RequestParam(value="routeTag") String routeTag) {
		logger.info("API-STOP-START: " + System.currentTimeMillis());
		List <Stop> stopList = nextBusService.getStopList(agentTag, routeTag);
		logger.info("API-STOP-START: " + System.currentTimeMillis());
		return stopList;
	}

    @RequestMapping(value = "/directionList")
	List <Direction> getDirectionist (@RequestParam(value="agentTag") String agentTag,
									  @RequestParam(value="routeTag") String routeTag) {
		logger.info("API-DIRECTION-STOP-START: " + System.currentTimeMillis());
		List <Direction> directionList = nextBusService.getRouteDirectList(agentTag, routeTag);
		logger.info("API-DIRECTION-STOP-START: " + System.currentTimeMillis());
		return directionList;
	}

	@RequestMapping(value = "/directionStopList")
	List <Stop> getDirectionStopist (@RequestParam(value="agentTag") String agentTag,
                                     @RequestParam(value="routeTag") String routeTag,
									 @RequestParam(value = "directionTag") String directionTag) {
		List <Stop> stopnList = nextBusService.getRoutePredictionList(agentTag, routeTag, directionTag);
		return stopnList;
	}


}
