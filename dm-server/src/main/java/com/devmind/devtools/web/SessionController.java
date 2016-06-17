package com.devmind.devtools.web;

import java.util.List;

import com.devmind.devtools.model.Session;
import com.devmind.devtools.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;


    @RequestMapping
    @ResponseBody
    public List<Session> getAllSessions() {
        return sessionService.findAll();
    }

}
