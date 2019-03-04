package com.adamenko.springbootreact.web;

import com.adamenko.springbootreact.model.CommandHolder;
import com.adamenko.springbootreact.model.Robot;
import com.adamenko.springbootreact.service.RobotSimulationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class RobotController {

    @Autowired
    RobotSimulationService robotSimulationService;

    private final Logger log = LoggerFactory.getLogger(RobotController.class);

    @PostMapping(value = "/calculateNewPosition", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    ResponseEntity<Robot> calculateNewPosition(@RequestBody String script) {
        log.info("Request to calculate new robot position: {}");
        return ResponseEntity.ok().body(robotSimulationService.process(script));
    }

}
