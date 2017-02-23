package org.openshift.springboot;

import org.openshift.springboot.entity.Participant;
import org.openshift.springboot.entity.ParticipantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dbagayau on 23/02/2017.
 */
@RestController
public class MyRestController {

    @Value("${application.name}")
    private String applicationName;

    @Autowired
    private ParticipantDao participantDao;

    @RequestMapping("/")
    public String hello() {
        return "Hello world " + applicationName + "!";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Participant insertParticipant(
            @RequestBody // will fillup all the fields of the pojo that matches the json body
                    Participant participant) {
        Participant result = participantDao.save(participant);
        return  result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public Iterable<Participant> getAllParticipant() {
        return participantDao.findAll();
    }

}
