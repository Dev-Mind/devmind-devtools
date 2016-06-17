package com.devmind.devtools.web;

import java.util.List;

import com.devmind.devtools.model.Session;
import com.devmind.devtools.model.Speaker;
import com.devmind.devtools.service.SessionService;
import com.devmind.devtools.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;


    @RequestMapping
    @ResponseBody
    public List<Speaker> getAllSeakers() {
        return speakerService.findAll();
    }

}
