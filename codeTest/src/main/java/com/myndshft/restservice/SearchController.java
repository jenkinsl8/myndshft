package com.myndshft.restservice;


import com.myndshft.restservice.db.mongodb.PatientRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/* service API */

@RestController
public class SearchController {

    private static final Log log = LogFactory.getLog(SearchController.class);

    @Autowired
    private PatientRepository repository;

    /* finders */
    @RequestMapping(value = "/search", params = "first_name", method = RequestMethod.GET)
    @ResponseBody
    List<Patient> findByFirstName(@RequestParam String first_name) {
        return repository.findByFirstName(first_name);
    }

    @RequestMapping(value = "/search", params = "gender", method = RequestMethod.GET)
    @ResponseBody
    List<Patient> findByGender(@RequestParam String gender)   {
        return repository.findByGender(gender);

    }

    @RequestMapping(value = "/search", params = "last_name", method = RequestMethod.GET)
    @ResponseBody
    List<Patient> findByLastName(@RequestParam String last_name)   {
        return repository.findByLastName(last_name);

    }

}
